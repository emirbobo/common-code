package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.Collection;

final class Collections2$1
  implements Function<Object, Object>
{
  static
  {
    JniLib.a(1.class, 366);
  }
  
  Collections2$1(Collection paramCollection) {}
  
  public native Object apply(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Collections2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */