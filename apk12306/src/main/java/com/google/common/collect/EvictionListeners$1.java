package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class EvictionListeners$1
  implements MapEvictionListener<K, V>
{
  static
  {
    JniLib.a(1.class, 443);
  }
  
  EvictionListeners$1(Executor paramExecutor, MapEvictionListener paramMapEvictionListener) {}
  
  public native void onEviction(@Nullable K paramK, @Nullable V paramV);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EvictionListeners$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */