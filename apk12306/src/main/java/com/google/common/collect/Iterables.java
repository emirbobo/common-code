package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Iterables
{
  static
  {
    JniLib.a(Iterables.class, 529);
  }
  
  public static native <T> boolean addAll(Collection<T> paramCollection, Iterable<? extends T> paramIterable);
  
  public static native <T> boolean all(Iterable<T> paramIterable, Predicate<? super T> paramPredicate);
  
  public static native <T> boolean any(Iterable<T> paramIterable, Predicate<? super T> paramPredicate);
  
  private static native void checkNonnegativeIndex(int paramInt);
  
  public static native <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> paramIterable);
  
  public static native <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2);
  
  public static native <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3);
  
  public static native <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3, Iterable<? extends T> paramIterable4);
  
  public static <T> Iterable<T> concat(Iterable<? extends T>... paramVarArgs)
  {
    return concat(ImmutableList.copyOf(paramVarArgs));
  }
  
  public static native <T> Iterable<T> consumingIterable(Iterable<T> paramIterable);
  
  public static native boolean contains(Iterable<?> paramIterable, @Nullable Object paramObject);
  
  public static native <T> Iterable<T> cycle(Iterable<T> paramIterable);
  
  public static <T> Iterable<T> cycle(T... paramVarArgs)
  {
    return cycle(Lists.newArrayList(paramVarArgs));
  }
  
  public static native boolean elementsEqual(Iterable<?> paramIterable1, Iterable<?> paramIterable2);
  
  public static native <T> Iterable<T> filter(Iterable<T> paramIterable, Predicate<? super T> paramPredicate);
  
  @GwtIncompatible("Class.isInstance")
  public static native <T> Iterable<T> filter(Iterable<?> paramIterable, Class<T> paramClass);
  
  public static native <T> T find(Iterable<T> paramIterable, Predicate<? super T> paramPredicate);
  
  public static native <T> T find(Iterable<T> paramIterable, Predicate<? super T> paramPredicate, @Nullable T paramT);
  
  public static native int frequency(Iterable<?> paramIterable, @Nullable Object paramObject);
  
  public static native <T> T get(Iterable<T> paramIterable, int paramInt);
  
  public static native <T> T get(Iterable<T> paramIterable, int paramInt, @Nullable T paramT);
  
  public static native <T> T getFirst(Iterable<T> paramIterable, @Nullable T paramT);
  
  public static native <T> T getLast(Iterable<T> paramIterable);
  
  public static native <T> T getLast(Iterable<T> paramIterable, @Nullable T paramT);
  
  private static native <T> T getLastInNonemptyList(List<T> paramList);
  
  public static native <T> T getOnlyElement(Iterable<T> paramIterable);
  
  public static native <T> T getOnlyElement(Iterable<T> paramIterable, @Nullable T paramT);
  
  public static native <T> int indexOf(Iterable<T> paramIterable, Predicate<? super T> paramPredicate);
  
  public static native <T> boolean isEmpty(Iterable<T> paramIterable);
  
  private static native <T> UnmodifiableIterator<Iterator<? extends T>> iterators(Iterable<? extends Iterable<? extends T>> paramIterable);
  
  public static native <T> Iterable<T> limit(Iterable<T> paramIterable, int paramInt);
  
  public static native <T> Iterable<List<T>> paddedPartition(Iterable<T> paramIterable, int paramInt);
  
  public static native <T> Iterable<List<T>> partition(Iterable<T> paramIterable, int paramInt);
  
  static native boolean remove(Iterable<?> paramIterable, @Nullable Object paramObject);
  
  public static native boolean removeAll(Iterable<?> paramIterable, Collection<?> paramCollection);
  
  public static native <T> boolean removeIf(Iterable<T> paramIterable, Predicate<? super T> paramPredicate);
  
  private static native <T> boolean removeIfFromRandomAccessList(List<T> paramList, Predicate<? super T> paramPredicate);
  
  public static native boolean retainAll(Iterable<?> paramIterable, Collection<?> paramCollection);
  
  @Deprecated
  public static native <T> Iterable<T> reverse(List<T> paramList);
  
  public static native int size(Iterable<?> paramIterable);
  
  public static native <T> Iterable<T> skip(Iterable<T> paramIterable, int paramInt);
  
  static native Object[] toArray(Iterable<?> paramIterable);
  
  @GwtIncompatible("Array.newInstance(Class, int)")
  public static native <T> T[] toArray(Iterable<? extends T> paramIterable, Class<T> paramClass);
  
  private static native <E> Collection<E> toCollection(Iterable<E> paramIterable);
  
  public static native String toString(Iterable<?> paramIterable);
  
  public static native <F, T> Iterable<T> transform(Iterable<F> paramIterable, Function<? super F, ? extends T> paramFunction);
  
  public static native <T> Iterable<T> unmodifiableIterable(Iterable<T> paramIterable);
  
  private static class ConsumingQueueIterator<T>
    extends AbstractIterator<T>
  {
    private final Queue<T> queue;
    
    static
    {
      JniLib.a(ConsumingQueueIterator.class, 528);
    }
    
    private ConsumingQueueIterator(Queue<T> paramQueue)
    {
      this.queue = paramQueue;
    }
    
    public native T computeNext();
  }
  
  static abstract class IterableWithToString<E>
    implements Iterable<E>
  {
    public String toString()
    {
      return Iterables.toString(this);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */