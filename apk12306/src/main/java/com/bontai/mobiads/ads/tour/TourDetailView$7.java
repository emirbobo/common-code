package com.bontai.mobiads.ads.tour;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bangcle.andjni.JniLib;

class TourDetailView$7
  extends WebViewClient
{
  static
  {
    JniLib.a(7.class, 234);
  }
  
  TourDetailView$7(TourDetailView paramTourDetailView) {}
  
  public native void onLoadResource(WebView paramWebView, String paramString);
  
  public native void onPageFinished(WebView paramWebView, String paramString);
  
  public native void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public native boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\tour\TourDetailView$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */