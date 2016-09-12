package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;

class Suppliers$SupplierComposition<F, T>
  implements Supplier<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Function<? super F, T> function;
  final Supplier<F> supplier;
  
  static
  {
    JniLib.a(SupplierComposition.class, 322);
  }
  
  Suppliers$SupplierComposition(Function<? super F, T> paramFunction, Supplier<F> paramSupplier)
  {
    this.function = paramFunction;
    this.supplier = paramSupplier;
  }
  
  public native T get();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Suppliers$SupplierComposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */