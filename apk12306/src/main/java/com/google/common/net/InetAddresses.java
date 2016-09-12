package com.google.common.net;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.annotation.Nullable;

@Beta
public final class InetAddresses
{
  private static final Inet4Address ANY4 = (Inet4Address)forString("0.0.0.0");
  private static final int IPV4_PART_COUNT = 4;
  private static final int IPV6_PART_COUNT = 8;
  private static final Inet4Address LOOPBACK4;
  
  static
  {
    JniLib.a(InetAddresses.class, 854);
    LOOPBACK4 = (Inet4Address)forString("127.0.0.1");
  }
  
  public static native int coerceToInteger(InetAddress paramInetAddress);
  
  private static native String convertDottedQuadToHex(String paramString);
  
  private static native byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native InetAddress forString(String paramString);
  
  public static native InetAddress forUriString(String paramString);
  
  public static native Inet4Address fromInteger(int paramInt);
  
  public static native InetAddress fromLittleEndianByteArray(byte[] paramArrayOfByte)
    throws UnknownHostException;
  
  public static native Inet4Address get6to4IPv4Address(Inet6Address paramInet6Address);
  
  public static native Inet4Address getCoercedIPv4Address(InetAddress paramInetAddress);
  
  public static native Inet4Address getCompatIPv4Address(Inet6Address paramInet6Address);
  
  public static native Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address);
  
  private static native Inet4Address getInet4Address(byte[] paramArrayOfByte);
  
  public static native Inet4Address getIsatapIPv4Address(Inet6Address paramInet6Address);
  
  public static native TeredoInfo getTeredoInfo(Inet6Address paramInet6Address);
  
  public static native boolean hasEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address);
  
  @VisibleForTesting
  static native int hash64To32(long paramLong);
  
  public static native boolean is6to4Address(Inet6Address paramInet6Address);
  
  public static native boolean isCompatIPv4Address(Inet6Address paramInet6Address);
  
  public static native boolean isInetAddress(String paramString);
  
  public static native boolean isIsatapAddress(Inet6Address paramInet6Address);
  
  public static native boolean isTeredoAddress(Inet6Address paramInet6Address);
  
  public static native boolean isUriInetAddress(String paramString);
  
  private static native byte[] textToNumericFormatV4(String paramString);
  
  private static native byte[] textToNumericFormatV6(String paramString);
  
  public static native String toUriString(InetAddress paramInetAddress);
  
  @Beta
  public static final class TeredoInfo
  {
    private final Inet4Address client;
    private final int flags;
    private final int port;
    private final Inet4Address server;
    
    static
    {
      JniLib.a(TeredoInfo.class, 853);
    }
    
    public TeredoInfo(@Nullable Inet4Address paramInet4Address1, @Nullable Inet4Address paramInet4Address2, int paramInt1, int paramInt2)
    {
      boolean bool;
      if ((paramInt1 >= 0) && (paramInt1 <= 65535))
      {
        bool = true;
        Preconditions.checkArgument(bool, "port '%d' is out of range (0 <= port <= 0xffff)", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt2 < 0) || (paramInt2 > 65535)) {
          break label105;
        }
        bool = true;
        label50:
        Preconditions.checkArgument(bool, "flags '%d' is out of range (0 <= flags <= 0xffff)", new Object[] { Integer.valueOf(paramInt2) });
        if (paramInet4Address1 == null) {
          break label111;
        }
        this.server = paramInet4Address1;
        label78:
        if (paramInet4Address2 == null) {
          break label121;
        }
      }
      label105:
      label111:
      label121:
      for (this.client = paramInet4Address2;; this.client = InetAddresses.ANY4)
      {
        this.port = paramInt1;
        this.flags = paramInt2;
        return;
        bool = false;
        break;
        bool = false;
        break label50;
        this.server = InetAddresses.ANY4;
        break label78;
      }
    }
    
    public native Inet4Address getClient();
    
    public native int getFlags();
    
    public native int getPort();
    
    public native Inet4Address getServer();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\net\InetAddresses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */