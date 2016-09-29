package com.alipay.sdk.util;

import com.bangcle.andjni.JniLib;

class FileDownloader$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 129);
  }
  
  FileDownloader$1(FileDownloader paramFileDownloader, FileDownloader.ProgressOutput paramProgressOutput) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\FileDownloader$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */