package com.customized.webviewclient;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.IceCreamCordovaWebViewClient;
import org.apache.cordova.api.CordovaInterface;

public class MyIceCreamCordovaWebViewClient
  extends IceCreamCordovaWebViewClient
{
  static
  {
    JniLib.a(MyIceCreamCordovaWebViewClient.class, 252);
  }
  
  public MyIceCreamCordovaWebViewClient(CordovaInterface paramCordovaInterface)
  {
    super(paramCordovaInterface);
  }
  
  public MyIceCreamCordovaWebViewClient(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    super(paramCordovaInterface, paramCordovaWebView);
  }
  
  public native void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\customized\webviewclient\MyIceCreamCordovaWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */