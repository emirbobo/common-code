package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public abstract class ImmutableSet<E>
  extends ImmutableCollection<E>
  implements Set<E>
{
  static final int CUTOFF = 536870912;
  static final int MAX_TABLE_SIZE = 1073741824;
  
  public static <E> Builder<E> builder()
  {
    return new Builder();
  }
  
  static int chooseTableSize(int paramInt)
  {
    if (paramInt < 536870912)
    {
      paramInt = Integer.highestOneBit(paramInt) << 2;
      return paramInt;
    }
    if (paramInt < 1073741824) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "collection too large");
      paramInt = 1073741824;
      break;
    }
  }
  
  private static <E> ImmutableSet<E> construct(Object... paramVarArgs)
  {
    int n = chooseTableSize(paramVarArgs.length);
    Object[] arrayOfObject = new Object[n];
    int i1 = n - 1;
    Object localObject1 = null;
    int j = 0;
    int i = 0;
    if (i < paramVarArgs.length)
    {
      Object localObject3 = paramVarArgs[i];
      int m = localObject3.hashCode();
      label173:
      for (int k = Hashing.smear(m);; k++)
      {
        int i2 = k & i1;
        Object localObject2 = arrayOfObject[i2];
        if (localObject2 == null)
        {
          if (localObject1 != null) {
            ((ArrayList)localObject1).add(localObject3);
          }
          arrayOfObject[i2] = localObject3;
          k = j + m;
          localObject2 = localObject1;
        }
        do
        {
          i++;
          j = k;
          localObject1 = localObject2;
          break;
          if (!localObject2.equals(localObject3)) {
            break label173;
          }
          k = j;
          localObject2 = localObject1;
        } while (localObject1 != null);
        localObject1 = new ArrayList(paramVarArgs.length);
        for (m = 0;; m++)
        {
          k = j;
          localObject2 = localObject1;
          if (m >= i) {
            break;
          }
          ((ArrayList)localObject1).add(paramVarArgs[m]);
        }
      }
    }
    if (localObject1 == null)
    {
      if (paramVarArgs.length != 1) {
        break label213;
      }
      paramVarArgs = new SingletonImmutableSet(paramVarArgs[0], j);
    }
    for (;;)
    {
      return paramVarArgs;
      paramVarArgs = ((ArrayList)localObject1).toArray();
      break;
      label213:
      if (n > chooseTableSize(paramVarArgs.length) * 2) {
        paramVarArgs = construct(paramVarArgs);
      } else {
        paramVarArgs = new RegularImmutableSet(paramVarArgs, j, arrayOfObject, i1);
      }
    }
  }
  
  private static <E> ImmutableSet<E> copyFromCollection(Collection<? extends E> paramCollection)
  {
    paramCollection = paramCollection.toArray();
    switch (paramCollection.length)
    {
    default: 
      paramCollection = construct(paramCollection);
    }
    for (;;)
    {
      return paramCollection;
      paramCollection = of();
      continue;
      paramCollection = of(paramCollection[0]);
    }
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {}
    for (paramIterable = copyOf(Collections2.cast(paramIterable));; paramIterable = copyOf(paramIterable.iterator())) {
      return paramIterable;
    }
  }
  
  public static <E> ImmutableSet<E> copyOf(Collection<? extends E> paramCollection)
  {
    ImmutableSet localImmutableSet;
    if (((paramCollection instanceof ImmutableSet)) && (!(paramCollection instanceof ImmutableSortedSet)))
    {
      localImmutableSet = (ImmutableSet)paramCollection;
      if (localImmutableSet.isPartialView()) {}
    }
    for (paramCollection = localImmutableSet;; paramCollection = copyFromCollection(paramCollection)) {
      return paramCollection;
    }
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> paramIterator)
  {
    return copyFromCollection(Lists.newArrayList(paramIterator));
  }
  
  public static <E> ImmutableSet<E> copyOf(E[] paramArrayOfE)
  {
    switch (paramArrayOfE.length)
    {
    default: 
      paramArrayOfE = construct((Object[])paramArrayOfE.clone());
    }
    for (;;)
    {
      return paramArrayOfE;
      paramArrayOfE = of();
      continue;
      paramArrayOfE = of(paramArrayOfE[0]);
    }
  }
  
  public static <E> ImmutableSet<E> of()
  {
    return EmptyImmutableSet.INSTANCE;
  }
  
  public static <E> ImmutableSet<E> of(E paramE)
  {
    return new SingletonImmutableSet(paramE);
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2)
  {
    return construct(new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    Object[] arrayOfObject = new Object[paramVarArgs.length + 6];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    for (int i = 6; i < arrayOfObject.length; i++) {
      arrayOfObject[i] = paramVarArgs[(i - 6)];
    }
    return construct(arrayOfObject);
  }
  
  @Deprecated
  public static <E> ImmutableSet<E> of(E[] paramArrayOfE)
  {
    return copyOf(paramArrayOfE);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool;
    if (paramObject == this) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (((paramObject instanceof ImmutableSet)) && (isHashCodeFast()) && (((ImmutableSet)paramObject).isHashCodeFast()) && (hashCode() != paramObject.hashCode())) {
        bool = false;
      } else {
        bool = Sets.equalsImpl(this, paramObject);
      }
    }
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
  
  boolean isHashCodeFast()
  {
    return false;
  }
  
  public abstract UnmodifiableIterator<E> iterator();
  
  Object writeReplace()
  {
    return new SerializedForm(toArray());
  }
  
  static abstract class ArrayImmutableSet<E>
    extends ImmutableSet<E>
  {
    final transient Object[] elements;
    
    ArrayImmutableSet(Object[] paramArrayOfObject)
    {
      this.elements = paramArrayOfObject;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramCollection == this) {
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        if (!(paramCollection instanceof ArrayImmutableSet))
        {
          bool1 = super.containsAll(paramCollection);
        }
        else
        {
          if (paramCollection.size() <= size()) {
            break;
          }
          bool1 = false;
        }
      }
      paramCollection = ((ArrayImmutableSet)paramCollection).elements;
      int j = paramCollection.length;
      for (int i = 0;; i++)
      {
        bool1 = bool2;
        if (i >= j) {
          break;
        }
        if (!contains(paramCollection[i]))
        {
          bool1 = false;
          break;
        }
      }
    }
    
    ImmutableList<E> createAsList()
    {
      return new ImmutableAsList(this.elements, this);
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    public UnmodifiableIterator<E> iterator()
    {
      return Iterators.forArray(this.elements);
    }
    
    public int size()
    {
      return this.elements.length;
    }
    
    public Object[] toArray()
    {
      Object[] arrayOfObject = new Object[size()];
      System.arraycopy(this.elements, 0, arrayOfObject, 0, size());
      return arrayOfObject;
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      int i = size();
      Object localObject;
      if (paramArrayOfT.length < i) {
        localObject = ObjectArrays.newArray(paramArrayOfT, i);
      }
      for (;;)
      {
        System.arraycopy(this.elements, 0, localObject, 0, i);
        return (T[])localObject;
        localObject = paramArrayOfT;
        if (paramArrayOfT.length > i)
        {
          paramArrayOfT[i] = null;
          localObject = paramArrayOfT;
        }
      }
    }
  }
  
  public static class Builder<E>
    extends ImmutableCollection.Builder<E>
  {
    final ArrayList<E> contents = Lists.newArrayList();
    
    static
    {
      JniLib.a(Builder.class, 487);
    }
    
    public native Builder<E> add(E paramE);
    
    public Builder<E> add(E... paramVarArgs)
    {
      this.contents.ensureCapacity(this.contents.size() + paramVarArgs.length);
      super.add(paramVarArgs);
      return this;
    }
    
    public native Builder<E> addAll(Iterable<? extends E> paramIterable);
    
    public native Builder<E> addAll(Iterator<? extends E> paramIterator);
    
    public native ImmutableSet<E> build();
  }
  
  private static class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Object[] elements;
    
    static
    {
      JniLib.a(SerializedForm.class, 488);
    }
    
    SerializedForm(Object[] paramArrayOfObject)
    {
      this.elements = paramArrayOfObject;
    }
    
    native Object readResolve();
  }
  
  static abstract class TransformedImmutableSet<D, E>
    extends ImmutableSet<E>
  {
    final int hashCode;
    final D[] source;
    
    TransformedImmutableSet(D[] paramArrayOfD, int paramInt)
    {
      this.source = paramArrayOfD;
      this.hashCode = paramInt;
    }
    
    public final int hashCode()
    {
      return this.hashCode;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    boolean isHashCodeFast()
    {
      return true;
    }
    
    public UnmodifiableIterator<E> iterator()
    {
      new AbstractIndexedListIterator(this.source.length)
      {
        static
        {
          JniLib.a(1.class, 489);
        }
        
        protected native E get(int paramAnonymousInt);
      };
    }
    
    public int size()
    {
      return this.source.length;
    }
    
    public Object[] toArray()
    {
      return toArray(new Object[size()]);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      int i = size();
      Object localObject;
      if (paramArrayOfT.length < i) {
        localObject = ObjectArrays.newArray(paramArrayOfT, i);
      }
      for (;;)
      {
        for (i = 0; i < this.source.length; i++) {
          localObject[i] = transform(this.source[i]);
        }
        localObject = paramArrayOfT;
        if (paramArrayOfT.length > i)
        {
          paramArrayOfT[i] = null;
          localObject = paramArrayOfT;
        }
      }
      return (T[])localObject;
    }
    
    abstract E transform(D paramD);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */