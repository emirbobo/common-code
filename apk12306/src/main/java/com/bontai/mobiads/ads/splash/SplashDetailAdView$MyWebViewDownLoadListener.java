package com.bontai.mobiads.ads.splash;

import android.webkit.DownloadListener;
import com.bangcle.andjni.JniLib;

class SplashDetailAdView$MyWebViewDownLoadListener
  implements DownloadListener
{
  static
  {
    JniLib.a(MyWebViewDownLoadListener.class, 224);
  }
  
  private SplashDetailAdView$MyWebViewDownLoadListener(SplashDetailAdView paramSplashDetailAdView) {}
  
  public native void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\splash\SplashDetailAdView$MyWebViewDownLoadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */