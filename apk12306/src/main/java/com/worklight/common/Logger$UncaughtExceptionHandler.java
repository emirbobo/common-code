package com.worklight.common;

import com.bangcle.andjni.JniLib;

class Logger$UncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private final Thread.UncaughtExceptionHandler defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
  
  static
  {
    JniLib.a(UncaughtExceptionHandler.class, 1255);
  }
  
  public final native void uncaughtException(Thread paramThread, Throwable paramThrowable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\Logger$UncaughtExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */