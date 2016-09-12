package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Sets
{
  static
  {
    JniLib.a(Sets.class, 731);
  }
  
  public static native <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> paramList);
  
  public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... paramVarArgs)
  {
    return cartesianProduct(Arrays.asList(paramVarArgs));
  }
  
  public static native <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> paramCollection);
  
  public static native <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> paramCollection, Class<E> paramClass);
  
  public static native <E> SetView<E> difference(Set<E> paramSet, Set<?> paramSet1);
  
  static native boolean equalsImpl(Set<?> paramSet, @Nullable Object paramObject);
  
  public static native <E> Set<E> filter(Set<E> paramSet, Predicate<? super E> paramPredicate);
  
  static native int hashCodeImpl(Set<?> paramSet);
  
  @GwtCompatible(serializable=true)
  public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E paramE, E... paramVarArgs)
  {
    return new ImmutableEnumSet(EnumSet.of(paramE, paramVarArgs));
  }
  
  @GwtCompatible(serializable=true)
  public static native <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> paramIterable);
  
  public static native <E> SetView<E> intersection(Set<E> paramSet, Set<?> paramSet1);
  
  private static native <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> paramCollection, Class<E> paramClass);
  
  public static native <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> paramIterable, Class<E> paramClass);
  
  public static native <E> HashSet<E> newHashSet();
  
  public static native <E> HashSet<E> newHashSet(Iterable<? extends E> paramIterable);
  
  public static native <E> HashSet<E> newHashSet(Iterator<? extends E> paramIterator);
  
  public static <E> HashSet<E> newHashSet(E... paramVarArgs)
  {
    HashSet localHashSet = new HashSet(Maps.capacity(paramVarArgs.length));
    Collections.addAll(localHashSet, paramVarArgs);
    return localHashSet;
  }
  
  public static native <E> HashSet<E> newHashSetWithExpectedSize(int paramInt);
  
  public static native <E> Set<E> newIdentityHashSet();
  
  public static native <E> LinkedHashSet<E> newLinkedHashSet();
  
  public static native <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> paramIterable);
  
  public static native <E> Set<E> newSetFromMap(Map<E, Boolean> paramMap);
  
  public static native <E extends Comparable> TreeSet<E> newTreeSet();
  
  public static native <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> paramIterable);
  
  public static native <E> TreeSet<E> newTreeSet(Comparator<? super E> paramComparator);
  
  @GwtCompatible(serializable=false)
  public static native <E> Set<Set<E>> powerSet(Set<E> paramSet);
  
  public static native <E> SetView<E> symmetricDifference(Set<? extends E> paramSet1, Set<? extends E> paramSet2);
  
  static native <A, B> Set<B> transform(Set<A> paramSet, InvertibleFunction<A, B> paramInvertibleFunction);
  
  public static native <E> SetView<E> union(Set<? extends E> paramSet1, Set<? extends E> paramSet2);
  
  private static class CartesianSet<B>
    extends AbstractSet<List<B>>
  {
    final ImmutableList<CartesianSet<B>.Axis> axes;
    final int size;
    
    static
    {
      JniLib.a(CartesianSet.class, 722);
    }
    
    CartesianSet(List<? extends Set<? extends B>> paramList)
    {
      long l = 1L;
      ImmutableList.Builder localBuilder = ImmutableList.builder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Axis localAxis = new Axis((Set)paramList.next(), (int)l);
        localBuilder.add(localAxis);
        l *= localAxis.size();
      }
      this.axes = localBuilder.build();
      this.size = Ints.checkedCast(l);
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
    
    public native UnmodifiableIterator<List<B>> iterator();
    
    public native int size();
    
    private class Axis
    {
      final ImmutableSet<? extends B> choices;
      final ImmutableList<? extends B> choicesList;
      final int dividend;
      
      static
      {
        JniLib.a(Axis.class, 721);
      }
      
      Axis(int paramInt)
      {
        this.choices = ImmutableSet.copyOf(paramInt);
        this.choicesList = this.choices.asList();
        int i;
        this.dividend = i;
      }
      
      native boolean contains(Object paramObject);
      
      public native boolean equals(Object paramObject);
      
      native B getForIndex(int paramInt);
      
      public native int hashCode();
      
      native int size();
    }
  }
  
  private static class FilteredSet<E>
    extends Collections2.FilteredCollection<E>
    implements Set<E>
  {
    static
    {
      JniLib.a(FilteredSet.class, 723);
    }
    
    FilteredSet(Set<E> paramSet, Predicate<? super E> paramPredicate)
    {
      super(paramPredicate);
    }
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
  }
  
  static abstract class InvertibleFunction<A, B>
    implements Function<A, B>
  {
    public InvertibleFunction<B, A> inverse()
    {
      new InvertibleFunction()
      {
        static
        {
          JniLib.a(1.class, 724);
        }
        
        public native A apply(B paramAnonymousB);
        
        public native Sets.InvertibleFunction<A, B> inverse();
        
        native B invert(A paramAnonymousA);
      };
    }
    
    abstract A invert(B paramB);
  }
  
  private static final class PowerSet<E>
    extends AbstractSet<Set<E>>
  {
    final ImmutableList<E> inputList;
    final ImmutableSet<E> inputSet;
    final int powerSetSize;
    
    static
    {
      JniLib.a(PowerSet.class, 728);
    }
    
    PowerSet(ImmutableSet<E> paramImmutableSet)
    {
      this.inputSet = paramImmutableSet;
      this.inputList = paramImmutableSet.asList();
      this.powerSetSize = (1 << paramImmutableSet.size());
    }
    
    public native boolean contains(@Nullable Object paramObject);
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
    
    public native boolean isEmpty();
    
    public native Iterator<Set<E>> iterator();
    
    public native int size();
    
    public native String toString();
    
    private static final class BitFilteredSetIterator<E>
      extends UnmodifiableIterator<E>
    {
      final ImmutableList<E> input;
      int remainingSetBits;
      
      static
      {
        JniLib.a(BitFilteredSetIterator.class, 727);
      }
      
      BitFilteredSetIterator(ImmutableList<E> paramImmutableList, int paramInt)
      {
        this.input = paramImmutableList;
        this.remainingSetBits = paramInt;
      }
      
      public native boolean hasNext();
      
      public native E next();
    }
  }
  
  private static class SetFromMap<E>
    extends AbstractSet<E>
    implements Set<E>, Serializable
  {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    private final Map<E, Boolean> m;
    private transient Set<E> s;
    
    static
    {
      JniLib.a(SetFromMap.class, 729);
    }
    
    SetFromMap(Map<E, Boolean> paramMap)
    {
      Preconditions.checkArgument(paramMap.isEmpty(), "Map is non-empty");
      this.m = paramMap;
      this.s = paramMap.keySet();
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private native void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException;
    
    public native boolean add(E paramE);
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native boolean containsAll(Collection<?> paramCollection);
    
    public native boolean equals(@Nullable Object paramObject);
    
    public native int hashCode();
    
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
  
  public static abstract class SetView<E>
    extends AbstractSet<E>
  {
    public <S extends Set<E>> S copyInto(S paramS)
    {
      paramS.addAll(this);
      return paramS;
    }
    
    public ImmutableSet<E> immutableCopy()
    {
      return ImmutableSet.copyOf(this);
    }
  }
  
  private static class TransformedSet<A, B>
    extends AbstractSet<B>
  {
    final Sets.InvertibleFunction<A, B> bijection;
    final Set<A> delegate;
    
    static
    {
      JniLib.a(TransformedSet.class, 730);
    }
    
    TransformedSet(Set<A> paramSet, Sets.InvertibleFunction<A, B> paramInvertibleFunction)
    {
      this.delegate = paramSet;
      this.bijection = paramInvertibleFunction;
    }
    
    public native boolean add(B paramB);
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<B> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */