package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import javax.annotation.Nullable;

@Beta
public final class SettableFuture<V>
  extends AbstractListenableFuture<V>
{
  static
  {
    JniLib.a(SettableFuture.class, 906);
  }
  
  public static native <V> SettableFuture<V> create();
  
  public native boolean cancel(boolean paramBoolean);
  
  public native boolean set(@Nullable V paramV);
  
  public native boolean setException(Throwable paramThrowable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\SettableFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */