package com.alipay.sdk.net;

import com.bangcle.andjni.JniLib;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public final class MspHttpClient
{
  public static final String a = "msp";
  private static MspHttpClient b;
  private final DefaultHttpClient c;
  
  static
  {
    JniLib.a(MspHttpClient.class, 114);
  }
  
  private MspHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    this.c = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams);
  }
  
  private MspHttpClient(HttpParams paramHttpParams)
  {
    this.c = new DefaultHttpClient(paramHttpParams);
  }
  
  public static native MspHttpClient a();
  
  public static native void a(MspHttpClient paramMspHttpClient);
  
  public static native MspHttpClient b();
  
  public native Object a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler)
    throws Exception;
  
  public native Object a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext)
    throws Exception;
  
  public native Object a(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler)
    throws Exception;
  
  public native Object a(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext)
    throws Exception;
  
  public native HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
    throws Exception;
  
  public native HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws Exception;
  
  public native HttpResponse a(HttpUriRequest paramHttpUriRequest)
    throws Exception;
  
  public native HttpResponse a(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
    throws Exception;
  
  public native void c();
  
  public native void d();
  
  public native HttpParams e();
  
  public native ClientConnectionManager f();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\net\MspHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */