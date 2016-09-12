package com.alipay.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bangcle.andjni.JniLib;
import java.lang.ref.WeakReference;

class FileDownloader$ProgressOutput
  extends Handler
{
  WeakReference a;
  private boolean b = false;
  
  static
  {
    JniLib.a(ProgressOutput.class, 130);
  }
  
  private FileDownloader$ProgressOutput(Looper paramLooper, FileDownloader paramFileDownloader)
  {
    super(paramLooper);
    this.a = new WeakReference(paramFileDownloader);
  }
  
  public native void handleMessage(Message paramMessage);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\FileDownloader$ProgressOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */