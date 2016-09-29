package com.tl.uic.http;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

public class TLHttpRequestInterceptor
  implements HttpRequestInterceptor
{
  private final String sessionId;
  private String url;
  
  static
  {
    JniLib.a(TLHttpRequestInterceptor.class, 1090);
  }
  
  public TLHttpRequestInterceptor()
  {
    this.sessionId = null;
  }
  
  public TLHttpRequestInterceptor(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public final native String getUrl();
  
  public final native void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws HttpException, IOException;
  
  public final native void setUrl(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\http\TLHttpRequestInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */