package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
public final class Lists
{
  static
  {
    JniLib.a(Lists.class, 588);
  }
  
  static native <E> boolean addAllImpl(List<E> paramList, int paramInt, Iterable<? extends E> paramIterable);
  
  public static native <E> List<E> asList(@Nullable E paramE1, @Nullable E paramE2, E[] paramArrayOfE);
  
  public static native <E> List<E> asList(@Nullable E paramE, E[] paramArrayOfE);
  
  @Beta
  public static native ImmutableList<Character> charactersOf(String paramString);
  
  @Beta
  public static native List<Character> charactersOf(CharSequence paramCharSequence);
  
  @VisibleForTesting
  static native int computeArrayListCapacity(int paramInt);
  
  static native boolean equalsImpl(List<?> paramList, @Nullable Object paramObject);
  
  static native int hashCodeImpl(List<?> paramList);
  
  static native int indexOfImpl(List<?> paramList, @Nullable Object paramObject);
  
  static native int lastIndexOfImpl(List<?> paramList, @Nullable Object paramObject);
  
  static native <E> ListIterator<E> listIteratorImpl(List<E> paramList, int paramInt);
  
  @GwtCompatible(serializable=true)
  public static native <E> ArrayList<E> newArrayList();
  
  @GwtCompatible(serializable=true)
  public static native <E> ArrayList<E> newArrayList(Iterable<? extends E> paramIterable);
  
  @GwtCompatible(serializable=true)
  public static native <E> ArrayList<E> newArrayList(Iterator<? extends E> paramIterator);
  
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayList(E... paramVarArgs)
  {
    Preconditions.checkNotNull(paramVarArgs);
    ArrayList localArrayList = new ArrayList(computeArrayListCapacity(paramVarArgs.length));
    Collections.addAll(localArrayList, paramVarArgs);
    return localArrayList;
  }
  
  @GwtCompatible(serializable=true)
  public static native <E> ArrayList<E> newArrayListWithCapacity(int paramInt);
  
  @GwtCompatible(serializable=true)
  public static native <E> ArrayList<E> newArrayListWithExpectedSize(int paramInt);
  
  @GwtCompatible(serializable=true)
  public static native <E> LinkedList<E> newLinkedList();
  
  @GwtCompatible(serializable=true)
  public static native <E> LinkedList<E> newLinkedList(Iterable<? extends E> paramIterable);
  
  public static native <T> List<List<T>> partition(List<T> paramList, int paramInt);
  
  public static native <T> List<T> reverse(List<T> paramList);
  
  static native <E> List<E> subListImpl(List<E> paramList, int paramInt1, int paramInt2);
  
  public static native <F, T> List<T> transform(List<F> paramList, Function<? super F, ? extends T> paramFunction);
  
  private static class AbstractListWrapper<E>
    extends AbstractList<E>
  {
    final List<E> backingList;
    
    static
    {
      JniLib.a(AbstractListWrapper.class, 574);
    }
    
    AbstractListWrapper(List<E> paramList)
    {
      this.backingList = ((List)Preconditions.checkNotNull(paramList));
    }
    
    public native void add(int paramInt, E paramE);
    
    public native boolean addAll(int paramInt, Collection<? extends E> paramCollection);
    
    public native boolean contains(Object paramObject);
    
    public native E get(int paramInt);
    
    public native E remove(int paramInt);
    
    public native E set(int paramInt, E paramE);
    
    public native int size();
  }
  
  private static final class CharSequenceAsList
    extends AbstractList<Character>
  {
    private final CharSequence sequence;
    
    static
    {
      JniLib.a(CharSequenceAsList.class, 577);
    }
    
    CharSequenceAsList(CharSequence paramCharSequence)
    {
      this.sequence = paramCharSequence;
    }
    
    public native boolean contains(@Nullable Object paramObject);
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native Character get(int paramInt);
    
    public native int hashCode();
    
    public native int indexOf(@Nullable Object paramObject);
    
    public native int lastIndexOf(@Nullable Object paramObject);
    
    public native int size();
    
    public native List<Character> subList(int paramInt1, int paramInt2);
  }
  
  private static class OnePlusArrayList<E>
    extends AbstractList<E>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final E first;
    final E[] rest;
    
    static
    {
      JniLib.a(OnePlusArrayList.class, 578);
    }
    
    OnePlusArrayList(@Nullable E paramE, E[] paramArrayOfE)
    {
      this.first = paramE;
      this.rest = ((Object[])Preconditions.checkNotNull(paramArrayOfE));
    }
    
    public native E get(int paramInt);
    
    public native int size();
  }
  
  private static class Partition<T>
    extends AbstractList<List<T>>
  {
    final List<T> list;
    final int size;
    
    static
    {
      JniLib.a(Partition.class, 579);
    }
    
    Partition(List<T> paramList, int paramInt)
    {
      this.list = paramList;
      this.size = paramInt;
    }
    
    public native List<T> get(int paramInt);
    
    public native boolean isEmpty();
    
    public native int size();
  }
  
  private static class RandomAccessListWrapper<E>
    extends Lists.AbstractListWrapper<E>
    implements RandomAccess
  {
    RandomAccessListWrapper(List<E> paramList)
    {
      super();
    }
  }
  
  private static class RandomAccessPartition<T>
    extends Lists.Partition<T>
    implements RandomAccess
  {
    RandomAccessPartition(List<T> paramList, int paramInt)
    {
      super(paramInt);
    }
  }
  
  private static class RandomAccessReverseList<T>
    extends Lists.ReverseList<T>
    implements RandomAccess
  {
    RandomAccessReverseList(List<T> paramList)
    {
      super();
    }
  }
  
  private static class ReverseList<T>
    extends AbstractList<T>
  {
    private final List<T> forwardList;
    
    static
    {
      JniLib.a(ReverseList.class, 580);
    }
    
    ReverseList(List<T> paramList)
    {
      this.forwardList = ((List)Preconditions.checkNotNull(paramList));
    }
    
    private native int reverseIndex(int paramInt);
    
    private native int reversePosition(int paramInt);
    
    public native void add(int paramInt, @Nullable T paramT);
    
    public native void clear();
    
    public native boolean contains(@Nullable Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    public native T get(int paramInt);
    
    native List<T> getForwardList();
    
    public native int indexOf(@Nullable Object paramObject);
    
    public native boolean isEmpty();
    
    public native Iterator<T> iterator();
    
    public native int lastIndexOf(@Nullable Object paramObject);
    
    public native ListIterator<T> listIterator(int paramInt);
    
    public native T remove(int paramInt);
    
    protected native void removeRange(int paramInt1, int paramInt2);
    
    public native T set(int paramInt, @Nullable T paramT);
    
    public native int size();
    
    public native List<T> subList(int paramInt1, int paramInt2);
  }
  
  private static final class StringAsImmutableList
    extends ImmutableList<Character>
  {
    int hash = 0;
    private final String string;
    
    static
    {
      JniLib.a(StringAsImmutableList.class, 583);
    }
    
    StringAsImmutableList(String paramString)
    {
      this.string = paramString;
    }
    
    public native boolean contains(@Nullable Object paramObject);
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native Character get(int paramInt);
    
    public native int hashCode();
    
    public native int indexOf(@Nullable Object paramObject);
    
    native boolean isPartialView();
    
    public native int lastIndexOf(@Nullable Object paramObject);
    
    public native UnmodifiableListIterator<Character> listIterator(int paramInt);
    
    public native int size();
    
    public native ImmutableList<Character> subList(int paramInt1, int paramInt2);
  }
  
  private static class TransformingRandomAccessList<F, T>
    extends AbstractList<T>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final List<F> fromList;
    final Function<? super F, ? extends T> function;
    
    static
    {
      JniLib.a(TransformingRandomAccessList.class, 584);
    }
    
    TransformingRandomAccessList(List<F> paramList, Function<? super F, ? extends T> paramFunction)
    {
      this.fromList = ((List)Preconditions.checkNotNull(paramList));
      this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    public native void clear();
    
    public native T get(int paramInt);
    
    public native boolean isEmpty();
    
    public native T remove(int paramInt);
    
    public native int size();
  }
  
  private static class TransformingSequentialList<F, T>
    extends AbstractSequentialList<T>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final List<F> fromList;
    final Function<? super F, ? extends T> function;
    
    static
    {
      JniLib.a(TransformingSequentialList.class, 586);
    }
    
    TransformingSequentialList(List<F> paramList, Function<? super F, ? extends T> paramFunction)
    {
      this.fromList = ((List)Preconditions.checkNotNull(paramList));
      this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    public native void clear();
    
    public native ListIterator<T> listIterator(int paramInt);
    
    public native int size();
  }
  
  private static class TwoPlusArrayList<E>
    extends AbstractList<E>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final E first;
    final E[] rest;
    final E second;
    
    static
    {
      JniLib.a(TwoPlusArrayList.class, 587);
    }
    
    TwoPlusArrayList(@Nullable E paramE1, @Nullable E paramE2, E[] paramArrayOfE)
    {
      this.first = paramE1;
      this.second = paramE2;
      this.rest = ((Object[])Preconditions.checkNotNull(paramArrayOfE));
    }
    
    public native E get(int paramInt);
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */