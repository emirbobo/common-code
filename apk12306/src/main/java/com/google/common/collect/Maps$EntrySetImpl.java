package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Maps$EntrySetImpl<K, V>
  extends AbstractSet<Map.Entry<K, V>>
{
  private final Supplier<Iterator<Map.Entry<K, V>>> entryIteratorSupplier;
  private final Map<K, V> map;
  
  static
  {
    JniLib.a(EntrySetImpl.class, 622);
  }
  
  Maps$EntrySetImpl(Map<K, V> paramMap, Supplier<Iterator<Map.Entry<K, V>>> paramSupplier)
  {
    this.map = ((Map)Preconditions.checkNotNull(paramMap));
    this.entryIteratorSupplier = ((Supplier)Preconditions.checkNotNull(paramSupplier));
  }
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native Iterator<Map.Entry<K, V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$EntrySetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */