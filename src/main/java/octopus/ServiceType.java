// Copyright 2012 Google Inc. All Rights Reserved.
package octopus;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

/**
 * @author kodologist@gmail.com
 */
public final class ServiceType {
  private final String type;

  ServiceType(String type) {
    this.type = checkNotNull(type, "type").toLowerCase();
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("type", type)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ServiceType)) {
      return false;
    }

    ServiceType that = (ServiceType) o;

    return Objects.equal(this.type, that.type);
  }

  @Override
  public int hashCode() {
    return type.hashCode();
  }


}
