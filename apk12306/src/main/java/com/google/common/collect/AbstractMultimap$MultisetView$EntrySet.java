package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;

class AbstractMultimap$MultisetView$EntrySet
  extends AbstractSet<Multiset.Entry<K>>
{
  static
  {
    JniLib.a(EntrySet.class, 353);
  }
  
  private AbstractMultimap$MultisetView$EntrySet(AbstractMultimap.MultisetView paramMultisetView) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<Multiset.Entry<K>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$MultisetView$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */