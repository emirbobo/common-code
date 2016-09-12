package com.alipay.sdk.auth;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bangcle.andjni.JniLib;

class AuthActivity$7
  extends WebViewClient
{
  static
  {
    JniLib.a(7.class, 88);
  }
  
  AuthActivity$7(AuthActivity paramAuthActivity) {}
  
  public native void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);
  
  public native boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\auth\AuthActivity$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */