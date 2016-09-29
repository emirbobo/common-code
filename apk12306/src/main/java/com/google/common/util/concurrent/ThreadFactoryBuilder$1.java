package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class ThreadFactoryBuilder$1
  implements ThreadFactory
{
  static
  {
    JniLib.a(1.class, 910);
  }
  
  ThreadFactoryBuilder$1(ThreadFactory paramThreadFactory, String paramString, AtomicLong paramAtomicLong, Boolean paramBoolean, Integer paramInteger, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  public native Thread newThread(Runnable paramRunnable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\ThreadFactoryBuilder$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */