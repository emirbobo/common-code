package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public final class Multisets
{
  static
  {
    JniLib.a(Multisets.class, 692);
  }
  
  static native <E> boolean addAllImpl(Multiset<E> paramMultiset, Collection<? extends E> paramCollection);
  
  static native <T> Multiset<T> cast(Iterable<T> paramIterable);
  
  static native void checkNonnegative(int paramInt, String paramString);
  
  static native <E> Set<E> elementSetImpl(Multiset<E> paramMultiset);
  
  static native boolean equalsImpl(Multiset<?> paramMultiset, @Nullable Object paramObject);
  
  static native <E> Multiset<E> forSet(Set<E> paramSet);
  
  public static native <E> Multiset.Entry<E> immutableEntry(@Nullable E paramE, int paramInt);
  
  static native int inferDistinctElements(Iterable<?> paramIterable);
  
  public static native <E> Multiset<E> intersection(Multiset<E> paramMultiset, Multiset<?> paramMultiset1);
  
  static native <E> Iterator<E> iteratorImpl(Multiset<E> paramMultiset);
  
  static native boolean removeAllImpl(Multiset<?> paramMultiset, Collection<?> paramCollection);
  
  static native boolean retainAllImpl(Multiset<?> paramMultiset, Collection<?> paramCollection);
  
  static native <E> int setCountImpl(Multiset<E> paramMultiset, E paramE, int paramInt);
  
  static native <E> boolean setCountImpl(Multiset<E> paramMultiset, E paramE, int paramInt1, int paramInt2);
  
  static native int sizeImpl(Multiset<?> paramMultiset);
  
  public static native <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> paramMultiset);
  
  static abstract class AbstractEntry<E>
    implements Multiset.Entry<E>
  {
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Multiset.Entry))
      {
        paramObject = (Multiset.Entry)paramObject;
        bool1 = bool2;
        if (getCount() == ((Multiset.Entry)paramObject).getCount())
        {
          bool1 = bool2;
          if (Objects.equal(getElement(), ((Multiset.Entry)paramObject).getElement())) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      Object localObject = getElement();
      if (localObject == null) {}
      for (int i = 0;; i = localObject.hashCode()) {
        return i ^ getCount();
      }
    }
    
    public String toString()
    {
      String str = String.valueOf(getElement());
      int i = getCount();
      if (i == 1) {}
      for (;;)
      {
        return str;
        str = str + " x " + i;
      }
    }
  }
  
  private static final class ElementSetImpl<E>
    extends AbstractSet<E>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Multiset<E> multiset;
    
    static
    {
      JniLib.a(ElementSetImpl.class, 685);
    }
    
    ElementSetImpl(Multiset<E> paramMultiset)
    {
      this.multiset = paramMultiset;
    }
    
    public native boolean add(E paramE);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    public native boolean isEmpty();
    
    public native Iterator<E> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
  
  static final class MultisetIteratorImpl<E>
    implements Iterator<E>
  {
    private boolean canRemove;
    private Multiset.Entry<E> currentEntry;
    private final Iterator<Multiset.Entry<E>> entryIterator;
    private int laterCount;
    private final Multiset<E> multiset;
    private int totalCount;
    
    static
    {
      JniLib.a(MultisetIteratorImpl.class, 686);
    }
    
    MultisetIteratorImpl(Multiset<E> paramMultiset, Iterator<Multiset.Entry<E>> paramIterator)
    {
      this.multiset = paramMultiset;
      this.entryIterator = paramIterator;
    }
    
    public native boolean hasNext();
    
    public native E next();
    
    public native void remove();
  }
  
  private static class SetMultiset<E>
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
    
    SetMultiset(Set<E> paramSet)
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
  
  private static class UnmodifiableMultiset<E>
    extends ForwardingMultiset<E>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Multiset<? extends E> delegate;
    transient Set<E> elementSet;
    transient Set<Multiset.Entry<E>> entrySet;
    
    static
    {
      JniLib.a(UnmodifiableMultiset.class, 691);
    }
    
    UnmodifiableMultiset(Multiset<? extends E> paramMultiset)
    {
      this.delegate = paramMultiset;
    }
    
    public native int add(E paramE, int paramInt);
    
    public native boolean add(E paramE);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    public native void clear();
    
    protected native Multiset<E> delegate();
    
    public native Set<E> elementSet();
    
    public native Set<Multiset.Entry<E>> entrySet();
    
    public native Iterator<E> iterator();
    
    public native int remove(Object paramObject, int paramInt);
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int setCount(E paramE, int paramInt);
    
    public native boolean setCount(E paramE, int paramInt1, int paramInt2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */