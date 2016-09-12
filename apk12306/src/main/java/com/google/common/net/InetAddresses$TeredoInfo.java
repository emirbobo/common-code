package com.google.common.net;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.net.Inet4Address;
import javax.annotation.Nullable;

@Beta
public final class InetAddresses$TeredoInfo
{
  private final Inet4Address client;
  private final int flags;
  private final int port;
  private final Inet4Address server;
  
  static
  {
    JniLib.a(TeredoInfo.class, 853);
  }
  
  public InetAddresses$TeredoInfo(@Nullable Inet4Address paramInet4Address1, @Nullable Inet4Address paramInet4Address2, int paramInt1, int paramInt2)
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
    for (this.client = paramInet4Address2;; this.client = InetAddresses.access$000())
    {
      this.port = paramInt1;
      this.flags = paramInt2;
      return;
      bool = false;
      break;
      bool = false;
      break label50;
      this.server = InetAddresses.access$000();
      break label78;
    }
  }
  
  public native Inet4Address getClient();
  
  public native int getFlags();
  
  public native int getPort();
  
  public native Inet4Address getServer();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\net\InetAddresses$TeredoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */