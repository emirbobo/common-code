package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

@GwtCompatible(emulated=true, serializable=true)
final class ExplicitOrderedImmutableSortedSet<E>
  extends ImmutableSortedSet<E>
{
  private final Object[] elements;
  private final int fromIndex;
  private final int toIndex;
  
  static
  {
    JniLib.a(ExplicitOrderedImmutableSortedSet.class, 446);
  }
  
  ExplicitOrderedImmutableSortedSet(Object[] paramArrayOfObject, Comparator<? super E> paramComparator)
  {
    this(paramArrayOfObject, paramComparator, 0, paramArrayOfObject.length);
  }
  
  ExplicitOrderedImmutableSortedSet(Object[] paramArrayOfObject, Comparator<? super E> paramComparator, int paramInt1, int paramInt2)
  {
    super(paramComparator);
    this.elements = paramArrayOfObject;
    this.fromIndex = paramInt1;
    this.toIndex = paramInt2;
  }
  
  static native <E> ImmutableSortedSet<E> create(List<E> paramList);
  
  private native ImmutableSortedSet<E> createSubset(int paramInt1, int paramInt2);
  
  private native int findSubsetIndex(E paramE);
  
  private native ImmutableMap<E, Integer> rankMap();
  
  private native void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException;
  
  public native boolean contains(Object paramObject);
  
  native ImmutableList<E> createAsList();
  
  public native E first();
  
  public native int hashCode();
  
  native ImmutableSortedSet<E> headSetImpl(E paramE);
  
  native int indexOf(Object paramObject);
  
  public native boolean isEmpty();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<E> iterator();
  
  public native E last();
  
  public native int size();
  
  native ImmutableSortedSet<E> subSetImpl(E paramE1, E paramE2);
  
  native ImmutableSortedSet<E> tailSetImpl(E paramE);
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  native Object writeReplace();
  
  private static class SerializedForm<E>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Object[] elements;
    
    static
    {
      JniLib.a(SerializedForm.class, 445);
    }
    
    public SerializedForm(Object[] paramArrayOfObject)
    {
      this.elements = paramArrayOfObject;
    }
    
    native Object readResolve();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ExplicitOrderedImmutableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */