package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Logger;

public final class UncaughtExceptionHandlers
{
  static
  {
    JniLib.a(UncaughtExceptionHandlers.class, 913);
  }
  
  public static native Thread.UncaughtExceptionHandler systemExit();
  
  @VisibleForTesting
  static final class Exiter
    implements Thread.UncaughtExceptionHandler
  {
    private static final Logger logger = Logger.getLogger(Exiter.class.getName());
    private final Runtime runtime;
    
    static
    {
      JniLib.a(Exiter.class, 912);
    }
    
    Exiter(Runtime paramRuntime)
    {
      this.runtime = paramRuntime;
    }
    
    public native void uncaughtException(Thread paramThread, Throwable paramThrowable);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\UncaughtExceptionHandlers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */