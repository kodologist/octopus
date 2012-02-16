// Copyright 2012 Google Inc. All Rights Reserved.
package octopus;

import com.google.common.collect.ImmutableSet;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author kodologist@gmail.com
 */
public interface Hub {
  enum State {NEW, INITIALIZING, READY, SHUTTING_DOWN, SHUT_DOWN}
  interface Listener {
    void hubStateChanged(State state);
  }

  public void addHubListener(Listener hubListener);
  public void removeHubListener(Listener hubListener);

  State getState();

  /**
   * Return the HostName associated with this JmDNS instance. Note: May not be the same as what
   * started. The host name is subject to negotiation.
   */
  String getHostName();

  /**
   * Return the address of the interface to which this {@link Hub} is bound.
   */
  InetAddress getInterface();

  void requestServiceDescriptor(Service service, long timeoutInMilliseconds);

  /**
   * Register a service. The service is registered for access by other jmdns clients. The name of
   * the service may be changed to make it unique.
   */
  void registerService(ServiceDescriptor serviceDescriptor) throws IOException;

  /**
   * Unregister a service. The service should have been registered.
   */
  void unregisterService(ServiceDescriptor serviceDescriptor);

  /**
   * Unregister all services.
   */
  void unregisterAllServices();

  /**
   * Register a service type. If this service type was not already known, all service listeners
   * will be notified of the new service type. Service types are automatically registered as they
   * are discovered.
   */
  void registerServiceType(ServiceType type);

  void start();

  /**
   * Shuts down this {@link Hub}, releasing all resources and unregistering all services.
   */
  void shutdown();

  /**
   * Returns a set of known {@link ServiceDescriptor}s of the specified type.
   *
   * @param type Service type name, such as {@code _http._tcp.local.}.
   */
  ImmutableSet<ServiceDescriptor> getServices(ServiceType type);

  void addServiceTypeListener(ServiceTypeListener serviceTypeListener);

  void removeServiceTypeListener(ServiceTypeListener listener);

  /**
   * Adds a {@link ServiceListener listener} for services of a given type.
   * The type has to be a fully qualified type name such as {@code _http._tcp.local.}
   *
   * @param type full qualified service type, such as {@code _http._tcp.local.}
   * @param serviceListener the {@link ServiceListener listener} to add
   */
  void addServiceListener(ServiceType type, ServiceListener serviceListener);

  /**
   * Removes a previously added {@link ServiceListener listener} for services of a given type.
   * The type has to be a fully qualified type name such as {@code _http._tcp.local.}
   *
   * @param type full qualified service type, such as {@code _http._tcp.local.}
   * @param serviceListener the {@link ServiceListener listener} to remove
   */
  void removeServiceListener(ServiceType type, ServiceListener serviceListener);
}
