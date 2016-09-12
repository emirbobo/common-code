package com.worklight.common;

import android.util.Log;
import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.params.HttpParams;

public class WLSSLSocketFactory
  implements LayeredSocketFactory
{
  private static final String CLIENT_AGREEMENT = "TLS";
  private SSLContext sslContext;
  
  static
  {
    JniLib.a(WLSSLSocketFactory.class, 1265);
  }
  
  public WLSSLSocketFactory(SSLConfig paramSSLConfig)
  {
    try
    {
      this.sslContext = SSLContext.getInstance("TLS");
      paramSSLConfig = this.sslContext;
      WLX509TrustManager localWLX509TrustManager = new com/worklight/common/WLX509TrustManager;
      localWLX509TrustManager.<init>(null);
      paramSSLConfig.init(null, new TrustManager[] { localWLX509TrustManager }, null);
      return;
    }
    catch (Exception paramSSLConfig)
    {
      for (;;)
      {
        Log.e("SSL", paramSSLConfig.getMessage());
      }
    }
  }
  
  public native Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
    throws IOException, UnknownHostException, ConnectTimeoutException;
  
  public native Socket createSocket()
    throws IOException;
  
  public native Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException;
  
  public native boolean equals(Object paramObject);
  
  public native int hashCode();
  
  public native boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\WLSSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */