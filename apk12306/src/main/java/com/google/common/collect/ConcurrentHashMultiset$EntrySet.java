package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;

class ConcurrentHashMultiset$EntrySet
  extends AbstractSet<Multiset.Entry<E>>
{
  static
  {
    JniLib.a(EntrySet.class, 387);
  }
  
  private ConcurrentHashMultiset$EntrySet(ConcurrentHashMultiset paramConcurrentHashMultiset) {}
  
  private native List<Multiset.Entry<E>> snapshot();
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native int hashCode();
  
  public native boolean isEmpty();
  
  public native Iterator<Multiset.Entry<E>> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ConcurrentHashMultiset$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */