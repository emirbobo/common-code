package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class LinkedHashMultimap$SetDecorator
  extends ForwardingSet<V>
{
  final Set<V> delegate;
  final K key;
  
  static
  {
    JniLib.a(SetDecorator.class, 550);
  }
  
  LinkedHashMultimap$SetDecorator(@Nullable K paramK, Set<V> paramSet)
  {
    Set localSet;
    this.delegate = localSet;
    this.key = paramSet;
  }
  
  public native boolean add(@Nullable V paramV);
  
  public native boolean addAll(Collection<? extends V> paramCollection);
  
  public native void clear();
  
  native <E> Collection<Map.Entry<K, E>> createEntries(Collection<E> paramCollection);
  
  native <E> Map.Entry<K, E> createEntry(@Nullable E paramE);
  
  protected native Set<V> delegate();
  
  public native Iterator<V> iterator();
  
  public native boolean remove(@Nullable Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\LinkedHashMultimap$SetDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */