package com.lidroid.xutils.http;

import com.bangcle.andjni.JniLib;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

final class HttpHandler$NotUseApacheRedirectHandler
  implements RedirectHandler
{
  static
  {
    JniLib.a(NotUseApacheRedirectHandler.class, 982);
  }
  
  public native URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws ProtocolException;
  
  public native boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\HttpHandler$NotUseApacheRedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */