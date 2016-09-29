package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

@Beta
public final class EvictionListeners
{
  static
  {
    JniLib.a(EvictionListeners.class, 444);
  }
  
  public static native <K, V> MapEvictionListener<K, V> asynchronous(MapEvictionListener<K, V> paramMapEvictionListener, Executor paramExecutor);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EvictionListeners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */