package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMultiset<E>
  extends Synchronized.SynchronizedCollection<E>
  implements Multiset<E>
{
  private static final long serialVersionUID = 0L;
  transient Set<E> elementSet;
  transient Set<Multiset.Entry<E>> entrySet;
  
  static
  {
    JniLib.a(SynchronizedMultiset.class, 791);
  }
  
  Synchronized$SynchronizedMultiset(Multiset<E> paramMultiset, @Nullable Object paramObject)
  {
    super(paramMultiset, paramObject, null);
  }
  
  public native int add(E paramE, int paramInt);
  
  public native int count(Object paramObject);
  
  native Multiset<E> delegate();
  
  public native Set<E> elementSet();
  
  public native Set<Multiset.Entry<E>> entrySet();
  
  public native boolean equals(Object paramObject);
  
  public native int hashCode();
  
  public native int remove(Object paramObject, int paramInt);
  
  public native int setCount(E paramE, int paramInt);
  
  public native boolean setCount(E paramE, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */