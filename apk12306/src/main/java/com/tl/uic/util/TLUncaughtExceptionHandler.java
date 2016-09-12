package com.tl.uic.util;

import com.bangcle.andjni.JniLib;

public class TLUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private final Thread.UncaughtExceptionHandler defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
  
  static
  {
    JniLib.a(TLUncaughtExceptionHandler.class, 1126);
  }
  
  public final native void setDefaultUncaughtExceptionHandler();
  
  public final native void uncaughtException(Thread paramThread, Throwable paramThrowable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\TLUncaughtExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */