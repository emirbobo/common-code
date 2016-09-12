package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

class Maps$FilteredEntryMap$KeySet
  extends AbstractSet<K>
{
  static
  {
    JniLib.a(KeySet.class, 627);
  }
  
  private Maps$FilteredEntryMap$KeySet(Maps.FilteredEntryMap paramFilteredEntryMap) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<K> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$FilteredEntryMap$KeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */