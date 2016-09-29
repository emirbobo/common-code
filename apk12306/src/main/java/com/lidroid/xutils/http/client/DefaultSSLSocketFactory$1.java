package com.lidroid.xutils.http.client;

import com.bangcle.andjni.JniLib;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class DefaultSSLSocketFactory$1
  implements X509TrustManager
{
  static
  {
    JniLib.a(1.class, 991);
  }
  
  DefaultSSLSocketFactory$1(DefaultSSLSocketFactory paramDefaultSSLSocketFactory) {}
  
  public native void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException;
  
  public native void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException;
  
  public native X509Certificate[] getAcceptedIssuers();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\DefaultSSLSocketFactory$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */