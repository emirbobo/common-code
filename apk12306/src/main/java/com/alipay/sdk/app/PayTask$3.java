package com.alipay.sdk.app;

import com.alipay.sdk.util.FileDownloader.IDownloadProgress;
import com.alipay.sdk.widget.Loading;
import com.bangcle.andjni.JniLib;

class PayTask$3
  implements FileDownloader.IDownloadProgress
{
  static
  {
    JniLib.a(3.class, 63);
  }
  
  PayTask$3(PayTask paramPayTask, Loading paramLoading) {}
  
  public native void a();
  
  public native void a(float paramFloat);
  
  public native void b();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\PayTask$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */