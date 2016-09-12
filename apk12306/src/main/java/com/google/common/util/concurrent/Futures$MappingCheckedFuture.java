package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

class Futures$MappingCheckedFuture<V, X extends Exception>
  extends AbstractCheckedFuture<V, X>
{
  final Function<Exception, X> mapper;
  
  static
  {
    JniLib.a(MappingCheckedFuture.class, 900);
  }
  
  Futures$MappingCheckedFuture(ListenableFuture<V> paramListenableFuture, Function<Exception, X> paramFunction)
  {
    super(paramListenableFuture);
    this.mapper = ((Function)Preconditions.checkNotNull(paramFunction));
  }
  
  protected native X mapException(Exception paramException);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures$MappingCheckedFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */