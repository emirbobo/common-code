package com.tl.uic.http;

import com.bangcle.andjni.JniLib;
import com.tl.uic.TLFCache;
import java.io.IOException;
import java.util.Date;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

public class TLHttpResponseInterceptor
  implements HttpResponseInterceptor
{
  private final long initTime;
  private final Date startTime;
  private final TLHttpRequestInterceptor tlHttpRequestInterceptor;
  
  static
  {
    JniLib.a(TLHttpResponseInterceptor.class, 1091);
  }
  
  public TLHttpResponseInterceptor(TLHttpRequestInterceptor paramTLHttpRequestInterceptor)
  {
    this.tlHttpRequestInterceptor = paramTLHttpRequestInterceptor;
    this.startTime = new Date();
    this.initTime = TLFCache.timestampFromSession();
  }
  
  public final native void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws HttpException, IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\http\TLHttpResponseInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */