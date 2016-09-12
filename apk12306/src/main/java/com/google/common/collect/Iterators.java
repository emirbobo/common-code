package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Iterators
{
  static final UnmodifiableIterator<Object> EMPTY_ITERATOR = new UnmodifiableIterator()
  {
    static
    {
      JniLib.a(1.class, 536);
    }
    
    public native boolean hasNext();
    
    public native Object next();
  };
  private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR = new Iterator()
  {
    static
    {
      JniLib.a(2.class, 537);
    }
    
    public native boolean hasNext();
    
    public native Object next();
    
    public native void remove();
  };
  
  static
  {
    JniLib.a(Iterators.class, 546);
  }
  
  public static native <T> boolean addAll(Collection<T> paramCollection, Iterator<? extends T> paramIterator);
  
  public static native <T> boolean all(Iterator<T> paramIterator, Predicate<? super T> paramPredicate);
  
  public static native <T> boolean any(Iterator<T> paramIterator, Predicate<? super T> paramPredicate);
  
  public static native <T> Enumeration<T> asEnumeration(Iterator<T> paramIterator);
  
  private static native void checkNonnegative(int paramInt);
  
  public static native <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> paramIterator);
  
  public static native <T> Iterator<T> concat(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2);
  
  public static native <T> Iterator<T> concat(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2, Iterator<? extends T> paramIterator3);
  
  public static native <T> Iterator<T> concat(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2, Iterator<? extends T> paramIterator3, Iterator<? extends T> paramIterator4);
  
  public static <T> Iterator<T> concat(Iterator<? extends T>... paramVarArgs)
  {
    return concat(ImmutableList.copyOf(paramVarArgs).iterator());
  }
  
  public static native <T> Iterator<T> consumingIterator(Iterator<T> paramIterator);
  
  public static native boolean contains(Iterator<?> paramIterator, @Nullable Object paramObject);
  
  public static native <T> Iterator<T> cycle(Iterable<T> paramIterable);
  
  public static <T> Iterator<T> cycle(T... paramVarArgs)
  {
    return cycle(Lists.newArrayList(paramVarArgs));
  }
  
  public static native boolean elementsEqual(Iterator<?> paramIterator1, Iterator<?> paramIterator2);
  
  public static native <T> UnmodifiableIterator<T> emptyIterator();
  
  static native <T> Iterator<T> emptyModifiableIterator();
  
  public static native <T> UnmodifiableIterator<T> filter(Iterator<T> paramIterator, Predicate<? super T> paramPredicate);
  
  @GwtIncompatible("Class.isInstance")
  public static native <T> UnmodifiableIterator<T> filter(Iterator<?> paramIterator, Class<T> paramClass);
  
  public static native <T> T find(Iterator<T> paramIterator, Predicate<? super T> paramPredicate);
  
  public static native <T> T find(Iterator<T> paramIterator, Predicate<? super T> paramPredicate, @Nullable T paramT);
  
  public static <T> UnmodifiableIterator<T> forArray(final T... paramVarArgs)
  {
    Preconditions.checkNotNull(paramVarArgs);
    new AbstractIndexedListIterator(paramVarArgs.length)
    {
      static
      {
        JniLib.a(11.class, 531);
      }
      
      protected native T get(int paramAnonymousInt);
    };
  }
  
  static native <T> UnmodifiableIterator<T> forArray(T[] paramArrayOfT, int paramInt1, int paramInt2);
  
  public static native <T> UnmodifiableIterator<T> forEnumeration(Enumeration<T> paramEnumeration);
  
  public static native int frequency(Iterator<?> paramIterator, @Nullable Object paramObject);
  
  public static native <T> T get(Iterator<T> paramIterator, int paramInt);
  
  public static native <T> T get(Iterator<T> paramIterator, int paramInt, @Nullable T paramT);
  
  public static native <T> T getLast(Iterator<T> paramIterator);
  
  public static native <T> T getLast(Iterator<T> paramIterator, @Nullable T paramT);
  
  public static native <T> T getNext(Iterator<T> paramIterator, @Nullable T paramT);
  
  public static native <T> T getOnlyElement(Iterator<T> paramIterator);
  
  public static native <T> T getOnlyElement(Iterator<T> paramIterator, @Nullable T paramT);
  
  public static native <T> int indexOf(Iterator<T> paramIterator, Predicate<? super T> paramPredicate);
  
  public static native <T> Iterator<T> limit(Iterator<T> paramIterator, int paramInt);
  
  public static native <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> paramIterator, int paramInt);
  
  public static native <T> UnmodifiableIterator<List<T>> partition(Iterator<T> paramIterator, int paramInt);
  
  private static native <T> UnmodifiableIterator<List<T>> partitionImpl(Iterator<T> paramIterator, int paramInt, boolean paramBoolean);
  
  public static native <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> paramIterator);
  
  public static native boolean removeAll(Iterator<?> paramIterator, Collection<?> paramCollection);
  
  public static native <T> boolean removeIf(Iterator<T> paramIterator, Predicate<? super T> paramPredicate);
  
  public static native boolean retainAll(Iterator<?> paramIterator, Collection<?> paramCollection);
  
  public static native <T> UnmodifiableIterator<T> singletonIterator(@Nullable T paramT);
  
  public static native int size(Iterator<?> paramIterator);
  
  @Beta
  public static native <T> int skip(Iterator<T> paramIterator, int paramInt);
  
  @GwtIncompatible("Array.newInstance(Class, int)")
  public static native <T> T[] toArray(Iterator<? extends T> paramIterator, Class<T> paramClass);
  
  public static native String toString(Iterator<?> paramIterator);
  
  public static native <F, T> Iterator<T> transform(Iterator<F> paramIterator, Function<? super F, ? extends T> paramFunction);
  
  public static native <T> UnmodifiableIterator<T> unmodifiableIterator(Iterator<T> paramIterator);
  
  private static class PeekingImpl<E>
    implements PeekingIterator<E>
  {
    private boolean hasPeeked;
    private final Iterator<? extends E> iterator;
    private E peekedElement;
    
    static
    {
      JniLib.a(PeekingImpl.class, 545);
    }
    
    public PeekingImpl(Iterator<? extends E> paramIterator)
    {
      this.iterator = ((Iterator)Preconditions.checkNotNull(paramIterator));
    }
    
    public native boolean hasNext();
    
    public native E next();
    
    public native E peek();
    
    public native void remove();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */