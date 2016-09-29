package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMultimap$EntryCollection<K, V>
  extends ImmutableCollection<Map.Entry<K, V>>
{
  private static final long serialVersionUID = 0L;
  final ImmutableMultimap<K, V> multimap;
  
  static
  {
    JniLib.a(EntryCollection.class, 479);
  }
  
  ImmutableMultimap$EntryCollection(ImmutableMultimap<K, V> paramImmutableMultimap)
  {
    this.multimap = paramImmutableMultimap;
  }
  
  public native boolean contains(Object paramObject);
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<Map.Entry<K, V>> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultimap$EntryCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */