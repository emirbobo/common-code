package com.worklight.common;

import com.bangcle.andjni.JniLib;

final class Logger$2
  implements Runnable
{
  static
  {
    JniLib.a(2.class, 1246);
  }
  
  Logger$2(Logger.LEVEL paramLEVEL) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\Logger$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */