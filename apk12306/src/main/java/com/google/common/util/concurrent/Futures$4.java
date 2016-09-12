package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;

final class Futures$4
  implements Function<I, ListenableFuture<O>>
{
  static
  {
    JniLib.a(4.class, 894);
  }
  
  Futures$4(Function paramFunction) {}
  
  public native ListenableFuture<O> apply(I paramI);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */