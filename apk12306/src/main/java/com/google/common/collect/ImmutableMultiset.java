package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public class ImmutableMultiset<E>
  extends ImmutableCollection<E>
  implements Multiset<E>
{
  private static final long serialVersionUID = 0L;
  private transient ImmutableSet<Multiset.Entry<E>> entrySet;
  private final transient ImmutableMap<E, Integer> map;
  private final transient int size;
  
  static
  {
    JniLib.a(ImmutableMultiset.class, 433);
  }
  
  ImmutableMultiset(ImmutableMap<E, Integer> paramImmutableMap, int paramInt)
  {
    this.map = paramImmutableMap;
    this.size = paramInt;
  }
  
  public static native <E> Builder<E> builder();
  
  public static native <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> paramIterable);
  
  public static native <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> paramIterator);
  
  public static native <E> ImmutableMultiset<E> copyOf(E[] paramArrayOfE);
  
  private static native <E> ImmutableMultiset<E> copyOfInternal(Multiset<? extends E> paramMultiset);
  
  private static <E> ImmutableMultiset<E> copyOfInternal(E... paramVarArgs)
  {
    return copyOf(Arrays.asList(paramVarArgs));
  }
  
  public static native <E> ImmutableMultiset<E> of();
  
  public static native <E> ImmutableMultiset<E> of(E paramE);
  
  public static native <E> ImmutableMultiset<E> of(E paramE1, E paramE2);
  
  public static native <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3);
  
  public static native <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4);
  
  public static native <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5);
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length + 6);
    Collections.addAll(localArrayList, new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6 });
    Collections.addAll(localArrayList, paramVarArgs);
    return copyOf(localArrayList);
  }
  
  @Deprecated
  public static native <E> ImmutableMultiset<E> of(E[] paramArrayOfE);
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException;
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  public native int add(E paramE, int paramInt);
  
  public native boolean contains(@Nullable Object paramObject);
  
  public native int count(@Nullable Object paramObject);
  
  public native Set<E> elementSet();
  
  public native Set<Multiset.Entry<E>> entrySet();
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<E> iterator();
  
  public native int remove(Object paramObject, int paramInt);
  
  public native int setCount(E paramE, int paramInt);
  
  public native boolean setCount(E paramE, int paramInt1, int paramInt2);
  
  public native int size();
  
  public native String toString();
  
  @GwtIncompatible("java serialization not supported.")
  native Object writeReplace();
  
  public static final class Builder<E>
    extends ImmutableCollection.Builder<E>
  {
    private final Multiset<E> contents = LinkedHashMultiset.create();
    
    static
    {
      JniLib.a(Builder.class, 484);
    }
    
    public native Builder<E> add(E paramE);
    
    public Builder<E> add(E... paramVarArgs)
    {
      super.add(paramVarArgs);
      return this;
    }
    
    public native Builder<E> addAll(Iterable<? extends E> paramIterable);
    
    public native Builder<E> addAll(Iterator<? extends E> paramIterator);
    
    public native Builder<E> addCopies(E paramE, int paramInt);
    
    public native ImmutableMultiset<E> build();
    
    public native Builder<E> setCount(E paramE, int paramInt);
  }
  
  private static class EntrySet<E>
    extends ImmutableSet<Multiset.Entry<E>>
  {
    private static final long serialVersionUID = 0L;
    final ImmutableMultiset<E> multiset;
    
    static
    {
      JniLib.a(EntrySet.class, 486);
    }
    
    public EntrySet(ImmutableMultiset<E> paramImmutableMultiset)
    {
      this.multiset = paramImmutableMultiset;
    }
    
    public native boolean contains(Object paramObject);
    
    public native int hashCode();
    
    native boolean isPartialView();
    
    public native UnmodifiableIterator<Multiset.Entry<E>> iterator();
    
    public native int size();
    
    public native Object[] toArray();
    
    public native <T> T[] toArray(T[] paramArrayOfT);
    
    @GwtIncompatible("not needed in emulated source.")
    native Object writeReplace();
  }
  
  @GwtIncompatible("java serialization is not supported.")
  private static class FieldSettersHolder
  {
    static final Serialization.FieldSetter<ImmutableMultiset> MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultiset.class, "map");
    static final Serialization.FieldSetter<ImmutableMultiset> SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultiset.class, "size");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */