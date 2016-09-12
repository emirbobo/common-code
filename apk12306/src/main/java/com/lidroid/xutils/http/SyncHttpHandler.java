package com.lidroid.xutils.http;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.callback.HttpRedirectHandler;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class SyncHttpHandler
{
  private String charset;
  private final AbstractHttpClient client;
  private final HttpContext context;
  private long expiry = HttpCache.getDefaultExpiryTime();
  private HttpRedirectHandler httpRedirectHandler;
  private String requestMethod;
  private String requestUrl;
  private int retriedTimes = 0;
  
  static
  {
    JniLib.a(SyncHttpHandler.class, 987);
  }
  
  public SyncHttpHandler(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, String paramString)
  {
    this.client = paramAbstractHttpClient;
    this.context = paramHttpContext;
    this.charset = paramString;
  }
  
  private native ResponseStream handleResponse(HttpResponse paramHttpResponse)
    throws HttpException, IOException;
  
  public native ResponseStream sendRequest(HttpRequestBase paramHttpRequestBase)
    throws HttpException;
  
  public native void setExpiry(long paramLong);
  
  public native void setHttpRedirectHandler(HttpRedirectHandler paramHttpRedirectHandler);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\SyncHttpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */