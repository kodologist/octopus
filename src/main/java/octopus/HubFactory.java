// Copyright 2012 Google Inc. All Rights Reserved.
package octopus;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Set;

/**
 * @author kodologist@gmail.com
 */
public final class HubFactory {

  public static Hub create() throws IOException {
    return create(InetAddress.getLocalHost());
  }

  private static Hub create(InetAddress address) {
    return new RealHub(address);
  }
}
