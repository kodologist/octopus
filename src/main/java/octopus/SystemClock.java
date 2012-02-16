// Copyright 2012 Google Inc. All Rights Reserved.
package octopus;

/**
 * @author lemarchand@google.com (Olivier Lemarchand)
 */
public class SystemClock implements Clock {
  @Override
  public long currentTimeMillis() {
    return System.currentTimeMillis();
  }
}
