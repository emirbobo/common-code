package com.lidroid.xutils;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

class HttpUtils$2
  implements HttpResponseInterceptor
{
  static
  {
    JniLib.a(2.class, 920);
  }
  
  HttpUtils$2(HttpUtils paramHttpUtils) {}
  
  public native void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws HttpException, IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\HttpUtils$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */