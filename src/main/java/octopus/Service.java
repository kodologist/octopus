// Copyright 2012 Google Inc. All Rights Reserved.
package octopus;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

/**
 * @author kodologist@gmail.com
 */
public final class Service {
  private final ServiceType type;
  private final String name;

  public Service(ServiceType type, String name) {
    this.type = checkNotNull(type, "type");
    this.name = checkNotNull(name, "name");
  }

  public ServiceType getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("type", type)
        .add("name", name)
        .toString();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Service)) {
      return false;
    }
    Service that = (Service) other;
    return Objects.equal(this.type, that.type)
        && Objects.equal(this.name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(type, name);
  }
}
