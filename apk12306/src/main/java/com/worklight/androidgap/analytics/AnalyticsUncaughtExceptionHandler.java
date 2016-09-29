package com.worklight.androidgap.analytics;

import com.bangcle.andjni.JniLib;
import com.worklight.common.WLConfig;

public class AnalyticsUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private final Thread.UncaughtExceptionHandler defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
  private final WLConfig wlConfig;
  
  static
  {
    JniLib.a(AnalyticsUncaughtExceptionHandler.class, 1150);
  }
  
  public AnalyticsUncaughtExceptionHandler(WLConfig paramWLConfig)
  {
    this.wlConfig = paramWLConfig;
  }
  
  public native void setDefaultUncaughtExceptionHandler();
  
  public native void uncaughtException(Thread paramThread, Throwable paramThrowable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\analytics\AnalyticsUncaughtExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */