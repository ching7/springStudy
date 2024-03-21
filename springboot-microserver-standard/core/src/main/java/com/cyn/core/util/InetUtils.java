package com.cyn.core.util;

/**
 * @ClassName InetUtils
 * @Description
 * @Author ynchen
 * @Date 2024/3/21 16:55
 * @Version V1.0.0
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetUtils {
  public static final boolean PREFER_IPV6_ADDRESSES = Boolean.parseBoolean(System.getProperty("java.net.preferIPv6Addresses"));

  public static InetAddress findFirstNonLoopbackAddress() {
    InetAddress result = null;
    try {
      int lowest = Integer.MAX_VALUE;
      Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces();
      while (nics.hasMoreElements()) {
        NetworkInterface ifc = nics.nextElement();
        if (ifc.isUp()) {
            if (ifc.getIndex() < lowest || result == null) {
              lowest = ifc.getIndex();
              for (Enumeration<InetAddress> addrs = ifc.getInetAddresses(); addrs.hasMoreElements(); ) {
                InetAddress address = addrs.nextElement();
                boolean isLegalIpVersion = PREFER_IPV6_ADDRESSES ? (address instanceof java.net.Inet6Address) : (address instanceof java.net.Inet4Address);
                if (isLegalIpVersion && !address.isLoopbackAddress()) {
                    result = address;
                }
              }
            }
        }
      }
    } catch (IOException ignored) {}
    if (result != null) {
        return result;
    }
    try {
      return InetAddress.getLocalHost();
    } catch (UnknownHostException unknownHostException) {
      return null;
    }
  }
}
