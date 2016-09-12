package com.alipay.sdk.authjs;

import com.bangcle.andjni.JniLib;
import java.util.TimerTask;

class JsBridge$2
  extends TimerTask
{
  static
  {
    JniLib.a(2.class, 95);
  }
  
  JsBridge$2(JsBridge paramJsBridge, CallInfo paramCallInfo) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\authjs\JsBridge$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */