package com.lidroid.xutils.http.callback;

import com.bangcle.andjni.JniLib;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

public class DefaultHttpRedirectHandler
  implements HttpRedirectHandler
{
  static
  {
    JniLib.a(DefaultHttpRedirectHandler.class, 988);
  }
  
  public native HttpRequestBase getDirectRequest(HttpResponse paramHttpResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\callback\DefaultHttpRedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */