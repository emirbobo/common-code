package com.bontai.mobiads.ads.tour;

import android.webkit.DownloadListener;
import com.bangcle.andjni.JniLib;

class TourDetailView$MyWebViewDownLoadListener
  implements DownloadListener
{
  static
  {
    JniLib.a(MyWebViewDownLoadListener.class, 236);
  }
  
  private TourDetailView$MyWebViewDownLoadListener(TourDetailView paramTourDetailView) {}
  
  public native void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\tour\TourDetailView$MyWebViewDownLoadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */