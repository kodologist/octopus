// Copyright 2012 Google Inc. All Rights Reserved.
package octopus;

import com.google.common.base.Optional;

import java.net.InetAddress;
import java.util.Map;

/**
 * @author kodologist@gmail.com
 */
public interface ServiceDescriptor {
  Service getService();
  String getServer();
  int getPort();
  int getWeight();
  int getPriority();
  byte[] getText();
  Map<String, Optional<byte[]>> getProps();
  InetAddress getAddress();
}
