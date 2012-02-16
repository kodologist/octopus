// Copyright 2012 Google Inc. All Rights Reserved.
package octopus;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author kodologist@gmail.com
 */
public class RealHub implements Hub {

  private State currentState = State.NEW;
  private final Set<Listener> hubListeners;
  private final Set<ServiceTypeListener> serviceTypeListeners;
  private final SetMultimap<ServiceType, ServiceListener> serviceListenersByType;
  private final InetAddress address;

  public RealHub(InetAddress address) {
    this.address = checkNotNull(address, "address");
    this.hubListeners = new CopyOnWriteArraySet<Listener>();
    this.serviceTypeListeners = new CopyOnWriteArraySet<ServiceTypeListener>();
    this.serviceListenersByType = Multimaps.synchronizedSetMultimap(
        LinkedHashMultimap.<ServiceType, ServiceListener>create());
  }

  @Override
  public void start() {
    checkState(this.currentState == State.NEW, "Hub cannot be started when in state %s", currentState);
    // TODO: implement start
  }

  @Override
  public void shutdown() {
    checkState(this.currentState == State.READY, "Hub cannot be shut down when in state %s", currentState);
    // TODO: implement shutdown
  }



  @Override
  public State getState() {
    return currentState;
  }

  @Override
  public InetAddress getInterface() {
    return address;
  }

  @Override
  public String getHostName() {
    return address.getHostName();
  }

  private void fireHubStateChanged(State newState) {
    for (Listener hubListener : hubListeners) {
      hubListener.hubStateChanged(newState);
    }
  }

  @Override
  public void addHubListener(Listener hubListener) {
    this.hubListeners.add(hubListener);
  }

  @Override
  public void removeHubListener(Listener hubListener) {
    this.hubListeners.remove(hubListener);
  }

  @Override
  public void addServiceTypeListener(ServiceTypeListener serviceTypeListener) {
    this.serviceTypeListeners.add(serviceTypeListener);
  }

  @Override
  public void removeServiceTypeListener(ServiceTypeListener listener) {
    this.serviceTypeListeners.remove(listener);
  }

  @Override
  public void addServiceListener(ServiceType type, ServiceListener serviceListener) {
    this.serviceListenersByType.put(type, serviceListener);
  }

  @Override
  public void removeServiceListener(ServiceType type, ServiceListener serviceListener) {
    this.serviceListenersByType.remove(type, serviceListener);
  }



}
