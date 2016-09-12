package com.customized.webviewclient;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.api.CordovaInterface;

public class MyCordovaWebViewClient
  extends CordovaWebViewClient
{
  static
  {
    JniLib.a(MyCordovaWebViewClient.class, 251);
  }
  
  public MyCordovaWebViewClient(CordovaInterface paramCordovaInterface)
  {
    super(paramCordovaInterface);
  }
  
  public MyCordovaWebViewClient(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    super(paramCordovaInterface, paramCordovaWebView);
  }
  
  public native void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\customized\webviewclient\MyCordovaWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */