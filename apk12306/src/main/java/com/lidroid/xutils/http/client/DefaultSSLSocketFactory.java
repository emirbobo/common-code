package com.lidroid.xutils.http.client;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.util.LogUtils;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class DefaultSSLSocketFactory
  extends SSLSocketFactory
{
  private static DefaultSSLSocketFactory instance;
  private static KeyStore trustStore;
  private SSLContext sslContext = SSLContext.getInstance("TLS");
  
  static
  {
    JniLib.a(DefaultSSLSocketFactory.class, 992);
    try
    {
      trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
      trustStore.load(null, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LogUtils.e(localThrowable.getMessage(), localThrowable);
      }
    }
  }
  
  private DefaultSSLSocketFactory()
    throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException
  {
    super(trustStore);
    X509TrustManager local1 = new X509TrustManager()
    {
      static
      {
        JniLib.a(1.class, 991);
      }
      
      public native void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException;
      
      public native void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException;
      
      public native X509Certificate[] getAcceptedIssuers();
    };
    this.sslContext.init(null, new TrustManager[] { local1 }, null);
    setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
  }
  
  public static native DefaultSSLSocketFactory getSocketFactory();
  
  public native Socket createSocket()
    throws IOException;
  
  public native Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\DefaultSSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */