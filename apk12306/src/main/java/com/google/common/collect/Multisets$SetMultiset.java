package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class Multisets$SetMultiset<E>
  extends ForwardingCollection<E>
  implements Multiset<E>, Serializable
{
  private static final long serialVersionUID = 0L;
  final Set<E> delegate;
  transient Set<E> elementSet;
  transient Set<Multiset.Entry<E>> entrySet;
  
  static
  {
    JniLib.a(SetMultiset.class, 690);
  }
  
  Multisets$SetMultiset(Set<E> paramSet)
  {
    this.delegate = ((Set)Preconditions.checkNotNull(paramSet));
  }
  
  public native int add(E paramE, int paramInt);
  
  public native boolean add(E paramE);
  
  public native boolean addAll(Collection<? extends E> paramCollection);
  
  public native int count(Object paramObject);
  
  protected native Set<E> delegate();
  
  public native Set<E> elementSet();
  
  public native Set<Multiset.Entry<E>> entrySet();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native int remove(Object paramObject, int paramInt);
  
  public native int setCount(E paramE, int paramInt);
  
  public native boolean setCount(E paramE, int paramInt1, int paramInt2);
  
  class ElementSet
    extends ForwardingSet<E>
  {
    static
    {
      JniLib.a(ElementSet.class, 687);
    }
    
    ElementSet() {}
    
    public native boolean add(E paramE);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    protected native Set<E> delegate();
  }
  
  class EntrySet
    extends AbstractSet<Multiset.Entry<E>>
  {
    static
    {
      JniLib.a(EntrySet.class, 689);
    }
    
    EntrySet() {}
    
    public native Iterator<Multiset.Entry<E>> iterator();
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$SetMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */