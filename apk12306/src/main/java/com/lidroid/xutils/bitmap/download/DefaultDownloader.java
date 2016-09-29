package com.lidroid.xutils.bitmap.download;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.BitmapUtils.BitmapLoadTask;
import java.io.OutputStream;

public class DefaultDownloader
  extends Downloader
{
  static
  {
    JniLib.a(DefaultDownloader.class, 935);
  }
  
  public native long downloadToStream(String paramString, OutputStream paramOutputStream, BitmapUtils.BitmapLoadTask<?> paramBitmapLoadTask);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\download\DefaultDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */