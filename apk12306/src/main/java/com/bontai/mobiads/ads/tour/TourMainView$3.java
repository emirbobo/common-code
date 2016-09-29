package com.bontai.mobiads.ads.tour;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bangcle.andjni.JniLib;

class TourMainView$3
  extends WebViewClient
{
  static
  {
    JniLib.a(3.class, 243);
  }
  
  TourMainView$3(TourMainView paramTourMainView) {}
  
  public native void onPageFinished(WebView paramWebView, String paramString);
  
  public native void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public native void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public native boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\tour\TourMainView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */