package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
class Suppliers$ExpiringMemoizingSupplier<T>
  implements Supplier<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Supplier<T> delegate;
  final long durationNanos;
  volatile transient long expirationNanos;
  volatile transient T value;
  
  static
  {
    JniLib.a(ExpiringMemoizingSupplier.class, 320);
  }
  
  Suppliers$ExpiringMemoizingSupplier(Supplier<T> paramSupplier, long paramLong, TimeUnit paramTimeUnit)
  {
    this.delegate = ((Supplier)Preconditions.checkNotNull(paramSupplier));
    this.durationNanos = paramTimeUnit.toNanos(paramLong);
    if (paramLong > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }
  
  public native T get();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Suppliers$ExpiringMemoizingSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */