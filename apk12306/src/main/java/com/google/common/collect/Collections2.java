package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

@GwtCompatible
public final class Collections2
{
  static final Joiner STANDARD_JOINER = Joiner.on(", ");
  
  static
  {
    JniLib.a(Collections2.class, 371);
  }
  
  static native <T> Collection<T> cast(Iterable<T> paramIterable);
  
  static native boolean containsAllImpl(Collection<?> paramCollection1, Collection<?> paramCollection2);
  
  public static native <E> Collection<E> filter(Collection<E> paramCollection, Predicate<? super E> paramPredicate);
  
  static native StringBuilder newStringBuilderForCollection(int paramInt);
  
  static native boolean safeContains(Collection<?> paramCollection, Object paramObject);
  
  static native String toStringImpl(Collection<?> paramCollection);
  
  public static native <F, T> Collection<T> transform(Collection<F> paramCollection, Function<? super F, T> paramFunction);
  
  static class FilteredCollection<E>
    implements Collection<E>
  {
    final Predicate<? super E> predicate;
    final Collection<E> unfiltered;
    
    static
    {
      JniLib.a(FilteredCollection.class, 369);
    }
    
    FilteredCollection(Collection<E> paramCollection, Predicate<? super E> paramPredicate)
    {
      this.unfiltered = paramCollection;
      this.predicate = paramPredicate;
    }
    
    public native boolean add(E paramE);
    
    public native boolean addAll(Collection<? extends E> paramCollection);
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    native FilteredCollection<E> createCombined(Predicate<? super E> paramPredicate);
    
    public native boolean isEmpty();
    
    public native Iterator<E> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
    
    public native String toString();
  }
  
  static class TransformedCollection<F, T>
    extends AbstractCollection<T>
  {
    final Collection<F> fromCollection;
    final Function<? super F, ? extends T> function;
    
    static
    {
      JniLib.a(TransformedCollection.class, 370);
    }
    
    TransformedCollection(Collection<F> paramCollection, Function<? super F, ? extends T> paramFunction)
    {
      this.fromCollection = ((Collection)Preconditions.checkNotNull(paramCollection));
      this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    public native void clear();
    
    public native boolean isEmpty();
    
    public native Iterator<T> iterator();
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Collections2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */