package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public final class Callables
{
  static
  {
    JniLib.a(Callables.class, 887);
  }
  
  public static native <T> Callable<T> returning(@Nullable T paramT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Callables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */