package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;

class Suppliers$ThreadSafeSupplier<T>
  implements Supplier<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Supplier<T> delegate;
  
  static
  {
    JniLib.a(ThreadSafeSupplier.class, 324);
  }
  
  Suppliers$ThreadSafeSupplier(Supplier<T> paramSupplier)
  {
    this.delegate = paramSupplier;
  }
  
  public native T get();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Suppliers$ThreadSafeSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */