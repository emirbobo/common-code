package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;

@VisibleForTesting
class Suppliers$MemoizingSupplier<T>
  implements Supplier<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Supplier<T> delegate;
  volatile transient boolean initialized;
  transient T value;
  
  static
  {
    JniLib.a(MemoizingSupplier.class, 321);
  }
  
  Suppliers$MemoizingSupplier(Supplier<T> paramSupplier)
  {
    this.delegate = paramSupplier;
  }
  
  public native T get();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Suppliers$MemoizingSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */