// Copyright 2012 Google Inc. All Rights Reserved.
package octopus;

/**
 * @author kodologist@gmail.com
 */
public interface ServiceListener {
  void serviceAdded(Service service);
  void serviceRemoved(Service service);
  void serviceResolved(ServiceDescriptor serviceDescriptor);
}
