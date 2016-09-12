package com.lidroid.xutils;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class HttpUtils$1
  implements HttpRequestInterceptor
{
  static
  {
    JniLib.a(1.class, 919);
  }
  
  HttpUtils$1(HttpUtils paramHttpUtils) {}
  
  public native void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws HttpException, IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\HttpUtils$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */