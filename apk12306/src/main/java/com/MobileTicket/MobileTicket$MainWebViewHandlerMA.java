package com.MobileTicket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bangcle.andjni.JniLib;

class MobileTicket$MainWebViewHandlerMA
  extends Handler
{
  static
  {
    JniLib.a(MainWebViewHandlerMA.class, 8);
  }
  
  public MobileTicket$MainWebViewHandlerMA(MobileTicket paramMobileTicket) {}
  
  public MobileTicket$MainWebViewHandlerMA(MobileTicket paramMobileTicket, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public native void handleMessage(Message paramMessage);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\MobileTicket$MainWebViewHandlerMA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */