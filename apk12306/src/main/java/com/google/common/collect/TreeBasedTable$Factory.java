package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeMap;

class TreeBasedTable$Factory<C, V>
  implements Supplier<TreeMap<C, V>>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Comparator<? super C> comparator;
  
  static
  {
    JniLib.a(Factory.class, 805);
  }
  
  TreeBasedTable$Factory(Comparator<? super C> paramComparator)
  {
    this.comparator = paramComparator;
  }
  
  public native TreeMap<C, V> get();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TreeBasedTable$Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */