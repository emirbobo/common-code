package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class LinkedListMultimap$MultisetView
  extends AbstractCollection<K>
  implements Multiset<K>
{
  static
  {
    JniLib.a(MultisetView.class, 569);
  }
  
  private LinkedListMultimap$MultisetView(LinkedListMultimap paramLinkedListMultimap) {}
  
  public native int add(@Nullable K paramK, int paramInt);
  
  public native int count(@Nullable Object paramObject);
  
  public native Set<K> elementSet();
  
  public native Set<Multiset.Entry<K>> entrySet();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native Iterator<K> iterator();
  
  public native int remove(@Nullable Object paramObject, int paramInt);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int setCount(K paramK, int paramInt);
  
  public native boolean setCount(K paramK, int paramInt1, int paramInt2);
  
  public native int size();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedListMultimap$MultisetView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */