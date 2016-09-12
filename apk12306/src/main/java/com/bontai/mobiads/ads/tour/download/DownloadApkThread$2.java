package com.bontai.mobiads.ads.tour.download;

import com.bangcle.andjni.JniLib;

class DownloadApkThread$2
  implements DownloadFileCallback
{
  static
  {
    JniLib.a(2.class, 248);
  }
  
  DownloadApkThread$2(DownloadApkThread paramDownloadApkThread) {}
  
  public native void downloadError(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\tour\download\DownloadApkThread$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */