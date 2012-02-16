// Copyright 2012 Google Inc. All Rights Reserved.
package octopus;

/**
 * @author kodologist@gmail.com
 */
public final class ServiceTypes {

  public static final ServiceType HTTP = forType("_http._tcp.local.");
  public static final ServiceType FTP = forType("_ftp._tcp.local.");
  public static final ServiceType TFTP = forType("_tftp._tcp.local.");
  public static final ServiceType SSH = forType("_ssh._tcp.local.");
  public static final ServiceType SMB = forType("_smb._tcp.local.");
  public static final ServiceType PRINTER = forType("_printer._tcp.local.");
  public static final ServiceType AIRPORT = forType("_airport._tcp.local.");

  private ServiceTypes() {
  }

  public static ServiceType forType(String type) {
    return new ServiceType(type);
  }
}
