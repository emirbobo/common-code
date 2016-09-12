package com.alipay.sdk.app;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bangcle.andjni.JniLib;

class H5PayActivity$MyWebViewClient
  extends WebViewClient
{
  static
  {
    JniLib.a(MyWebViewClient.class, 57);
  }
  
  private H5PayActivity$MyWebViewClient(H5PayActivity paramH5PayActivity) {}
  
  public native void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2);
  
  public native void onLoadResource(WebView paramWebView, String paramString);
  
  public native void onPageFinished(WebView paramWebView, String paramString);
  
  public native void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public native void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public native void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);
  
  public native boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\H5PayActivity$MyWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */