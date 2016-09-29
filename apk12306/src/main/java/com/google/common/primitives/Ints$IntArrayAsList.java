package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Ints$IntArrayAsList
  extends AbstractList<Integer>
  implements RandomAccess, Serializable
{
  private static final long serialVersionUID = 0L;
  final int[] array;
  final int end;
  final int start;
  
  static
  {
    JniLib.a(IntArrayAsList.class, 866);
  }
  
  Ints$IntArrayAsList(int[] paramArrayOfInt)
  {
    this(paramArrayOfInt, 0, paramArrayOfInt.length);
  }
  
  Ints$IntArrayAsList(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfInt;
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean equals(Object paramObject);
  
  public native Integer get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(Object paramObject);
  
  public native boolean isEmpty();
  
  public native int lastIndexOf(Object paramObject);
  
  public native Integer set(int paramInt, Integer paramInteger);
  
  public native int size();
  
  public native List<Integer> subList(int paramInt1, int paramInt2);
  
  native int[] toIntArray();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Ints$IntArrayAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */