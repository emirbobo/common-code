package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Collection;

class Collections2$FilteredCollection$1
  implements Predicate<E>
{
  static
  {
    JniLib.a(1.class, 367);
  }
  
  Collections2$FilteredCollection$1(Collections2.FilteredCollection paramFilteredCollection, Collection paramCollection) {}
  
  public native boolean apply(E paramE);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Collections2$FilteredCollection$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */