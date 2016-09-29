package com.lidroid.xutils.http.client;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class RetryHandler
  implements HttpRequestRetryHandler
{
  private static final int RETRY_SLEEP_INTERVAL = 500;
  private static HashSet<Class<?>> exceptionBlackList;
  private static HashSet<Class<?>> exceptionWhiteList;
  private final int maxRetries;
  
  static
  {
    JniLib.a(RetryHandler.class, 994);
    exceptionWhiteList = new HashSet();
    exceptionBlackList = new HashSet();
    exceptionWhiteList.add(NoHttpResponseException.class);
    exceptionWhiteList.add(UnknownHostException.class);
    exceptionWhiteList.add(SocketException.class);
    exceptionBlackList.add(InterruptedIOException.class);
    exceptionBlackList.add(SSLHandshakeException.class);
  }
  
  public RetryHandler(int paramInt)
  {
    this.maxRetries = paramInt;
  }
  
  public native boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\RetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */