package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractBiMap$EntrySet
  extends ForwardingSet<Map.Entry<K, V>>
{
  final Set<Map.Entry<K, V>> esDelegate = AbstractBiMap.access$200(this.this$0).entrySet();
  
  static
  {
    JniLib.a(EntrySet.class, 330);
  }
  
  private AbstractBiMap$EntrySet(AbstractBiMap paramAbstractBiMap) {}
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  protected native Set<Map.Entry<K, V>> delegate();
  
  public native Iterator<Map.Entry<K, V>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractBiMap$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */