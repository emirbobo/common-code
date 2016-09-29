package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import javax.annotation.Nullable;

class Suppliers$SupplierOfInstance<T>
  implements Supplier<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  final T instance;
  
  static
  {
    JniLib.a(SupplierOfInstance.class, 323);
  }
  
  Suppliers$SupplierOfInstance(@Nullable T paramT)
  {
    this.instance = paramT;
  }
  
  public native T get();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Suppliers$SupplierOfInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */