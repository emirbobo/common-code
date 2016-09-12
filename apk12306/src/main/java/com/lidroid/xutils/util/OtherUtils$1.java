package com.lidroid.xutils.util;

import com.bangcle.andjni.JniLib;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class OtherUtils$1
  implements X509TrustManager
{
  static
  {
    JniLib.a(1.class, 1025);
  }
  
  public native void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString);
  
  public native void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString);
  
  public native X509Certificate[] getAcceptedIssuers();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\util\OtherUtils$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */