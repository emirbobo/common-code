package com.bontai.mobiads.ads.splash;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bangcle.andjni.JniLib;

class SplashDetailAdView$1
  extends WebViewClient
{
  static
  {
    JniLib.a(1.class, 223);
  }
  
  SplashDetailAdView$1(SplashDetailAdView paramSplashDetailAdView) {}
  
  public native void onPageFinished(WebView paramWebView, String paramString);
  
  public native void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public native boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\splash\SplashDetailAdView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */