package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Map;

class HashBasedTable$Factory<C, V>
  implements Supplier<Map<C, V>>, Serializable
{
  private static final long serialVersionUID = 0L;
  final int expectedSize;
  
  static
  {
    JniLib.a(Factory.class, 448);
  }
  
  HashBasedTable$Factory(int paramInt)
  {
    this.expectedSize = paramInt;
  }
  
  public native Map<C, V> get();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\HashBasedTable$Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */