package com.bontai.mobiads.ads.tour;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;

public class TourMainView$xWebChromeClient
  extends WebChromeClient
{
  static
  {
    JniLib.a(xWebChromeClient.class, 244);
  }
  
  public TourMainView$xWebChromeClient(TourMainView paramTourMainView) {}
  
  public native void onProgressChanged(WebView paramWebView, int paramInt);
  
  public native void onReceivedTitle(WebView paramWebView, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\tour\TourMainView$xWebChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */