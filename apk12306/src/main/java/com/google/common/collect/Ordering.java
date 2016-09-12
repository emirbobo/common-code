package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Ordering<T>
  implements Comparator<T>
{
  static final int LEFT_IS_GREATER = 1;
  static final int RIGHT_IS_GREATER = -1;
  
  public static Ordering<Object> arbitrary()
  {
    return ArbitraryOrderingHolder.ARBITRARY_ORDERING;
  }
  
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> paramIterable)
  {
    return new CompoundOrdering(paramIterable);
  }
  
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> explicit(T paramT, T... paramVarArgs)
  {
    return explicit(Lists.asList(paramT, paramVarArgs));
  }
  
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> explicit(List<T> paramList)
  {
    return new ExplicitOrdering(paramList);
  }
  
  @Deprecated
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> from(Ordering<T> paramOrdering)
  {
    return (Ordering)Preconditions.checkNotNull(paramOrdering);
  }
  
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> from(Comparator<T> paramComparator)
  {
    if ((paramComparator instanceof Ordering)) {}
    for (paramComparator = (Ordering)paramComparator;; paramComparator = new ComparatorOrdering(paramComparator)) {
      return paramComparator;
    }
  }
  
  @GwtCompatible(serializable=true)
  public static <C extends Comparable> Ordering<C> natural()
  {
    return NaturalOrdering.INSTANCE;
  }
  
  private <E extends T> int partition(E[] paramArrayOfE, int paramInt1, int paramInt2, int paramInt3)
  {
    E ? = paramArrayOfE[paramInt3];
    paramArrayOfE[paramInt3] = paramArrayOfE[paramInt2];
    paramArrayOfE[paramInt2] = ?;
    for (int i = paramInt1; paramInt1 < paramInt2; i = paramInt3)
    {
      paramInt3 = i;
      if (compare(paramArrayOfE[paramInt1], ?) < 0)
      {
        ObjectArrays.swap(paramArrayOfE, i, paramInt1);
        paramInt3 = i + 1;
      }
      paramInt1++;
    }
    ObjectArrays.swap(paramArrayOfE, paramInt2, i);
    return i;
  }
  
  private <E extends T> void quicksortLeastK(E[] paramArrayOfE, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt1)
    {
      int i = partition(paramArrayOfE, paramInt1, paramInt2, paramInt1 + paramInt2 >>> 1);
      quicksortLeastK(paramArrayOfE, paramInt1, i - 1, paramInt3);
      if (i < paramInt3) {
        quicksortLeastK(paramArrayOfE, i + 1, paramInt2, paramInt3);
      }
    }
  }
  
  @GwtCompatible(serializable=true)
  public static Ordering<Object> usingToString()
  {
    return UsingToStringOrdering.INSTANCE;
  }
  
  public int binarySearch(List<? extends T> paramList, @Nullable T paramT)
  {
    return Collections.binarySearch(paramList, paramT, this);
  }
  
  public abstract int compare(@Nullable T paramT1, @Nullable T paramT2);
  
  @GwtCompatible(serializable=true)
  public <U extends T> Ordering<U> compound(Comparator<? super U> paramComparator)
  {
    return new CompoundOrdering(this, (Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  @Beta
  public <E extends T> List<E> greatestOf(Iterable<E> paramIterable, int paramInt)
  {
    return reverse().leastOf(paramIterable, paramInt);
  }
  
  public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> paramIterable)
  {
    return ImmutableList.copyOf(sortedCopy(paramIterable));
  }
  
  public boolean isOrdered(Iterable<? extends T> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    Object localObject;
    if (localIterator.hasNext())
    {
      paramIterable = localIterator.next();
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (compare(paramIterable, localObject) <= 0) {}
      }
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      paramIterable = (Iterable<? extends T>)localObject;
      break;
    }
  }
  
  public boolean isStrictlyOrdered(Iterable<? extends T> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    Object localObject;
    if (localIterator.hasNext())
    {
      paramIterable = localIterator.next();
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (compare(paramIterable, localObject) < 0) {}
      }
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      paramIterable = (Iterable<? extends T>)localObject;
      break;
    }
  }
  
  @Beta
  public <E extends T> List<E> leastOf(Iterable<E> paramIterable, int paramInt)
  {
    boolean bool;
    Object[] arrayOfObject;
    if (paramInt >= 0)
    {
      bool = true;
      Preconditions.checkArgument(bool, "%d is negative", new Object[] { Integer.valueOf(paramInt) });
      arrayOfObject = (Object[])Iterables.toArray(paramIterable);
      if (arrayOfObject.length > paramInt) {
        break label61;
      }
      Arrays.sort(arrayOfObject, this);
      paramIterable = arrayOfObject;
    }
    for (;;)
    {
      return Collections.unmodifiableList(Arrays.asList(paramIterable));
      bool = false;
      break;
      label61:
      quicksortLeastK(arrayOfObject, 0, arrayOfObject.length - 1, paramInt);
      paramIterable = (Object[])new Object[paramInt];
      System.arraycopy(arrayOfObject, 0, paramIterable, 0, paramInt);
    }
  }
  
  @GwtCompatible(serializable=true)
  public <S extends T> Ordering<Iterable<S>> lexicographical()
  {
    return new LexicographicalOrdering(this);
  }
  
  public <E extends T> E max(Iterable<E> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = max(paramIterable, localIterator.next())) {}
    return paramIterable;
  }
  
  public <E extends T> E max(@Nullable E paramE1, @Nullable E paramE2)
  {
    if (compare(paramE1, paramE2) >= 0) {}
    for (;;)
    {
      return paramE1;
      paramE1 = paramE2;
    }
  }
  
  public <E extends T> E max(@Nullable E paramE1, @Nullable E paramE2, @Nullable E paramE3, E... paramVarArgs)
  {
    paramE1 = max(max(paramE1, paramE2), paramE3);
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      paramE1 = max(paramE1, paramVarArgs[i]);
    }
    return paramE1;
  }
  
  public <E extends T> E min(Iterable<E> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = min(paramIterable, localIterator.next())) {}
    return paramIterable;
  }
  
  public <E extends T> E min(@Nullable E paramE1, @Nullable E paramE2)
  {
    if (compare(paramE1, paramE2) <= 0) {}
    for (;;)
    {
      return paramE1;
      paramE1 = paramE2;
    }
  }
  
  public <E extends T> E min(@Nullable E paramE1, @Nullable E paramE2, @Nullable E paramE3, E... paramVarArgs)
  {
    paramE1 = min(min(paramE1, paramE2), paramE3);
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      paramE1 = min(paramE1, paramVarArgs[i]);
    }
    return paramE1;
  }
  
  @GwtCompatible(serializable=true)
  public <S extends T> Ordering<S> nullsFirst()
  {
    return new NullsFirstOrdering(this);
  }
  
  @GwtCompatible(serializable=true)
  public <S extends T> Ordering<S> nullsLast()
  {
    return new NullsLastOrdering(this);
  }
  
  @GwtCompatible(serializable=true)
  public <F> Ordering<F> onResultOf(Function<F, ? extends T> paramFunction)
  {
    return new ByFunctionOrdering(paramFunction, this);
  }
  
  @GwtCompatible(serializable=true)
  public <S extends T> Ordering<S> reverse()
  {
    return new ReverseOrdering(this);
  }
  
  public <E extends T> List<E> sortedCopy(Iterable<E> paramIterable)
  {
    paramIterable = Lists.newArrayList(paramIterable);
    Collections.sort(paramIterable, this);
    return paramIterable;
  }
  
  @VisibleForTesting
  static class ArbitraryOrdering
    extends Ordering<Object>
  {
    private Map<Object, Integer> uids = Platform.tryWeakKeys(new MapMaker()).makeComputingMap(new Function()
    {
      final AtomicInteger counter = new AtomicInteger(0);
      
      static
      {
        JniLib.a(1.class, 699);
      }
      
      public native Integer apply(Object paramAnonymousObject);
    });
    
    static
    {
      JniLib.a(ArbitraryOrdering.class, 700);
    }
    
    public native int compare(Object paramObject1, Object paramObject2);
    
    native int identityHashCode(Object paramObject);
    
    public native String toString();
  }
  
  private static class ArbitraryOrderingHolder
  {
    static final Ordering<Object> ARBITRARY_ORDERING = new Ordering.ArbitraryOrdering();
  }
  
  @VisibleForTesting
  static class IncomparableValueException
    extends ClassCastException
  {
    private static final long serialVersionUID = 0L;
    final Object value;
    
    IncomparableValueException(Object paramObject)
    {
      super();
      this.value = paramObject;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Ordering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */