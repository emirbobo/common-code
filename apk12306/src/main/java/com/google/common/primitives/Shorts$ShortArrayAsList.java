package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Shorts$ShortArrayAsList
  extends AbstractList<Short>
  implements RandomAccess, Serializable
{
  private static final long serialVersionUID = 0L;
  final short[] array;
  final int end;
  final int start;
  
  static
  {
    JniLib.a(ShortArrayAsList.class, 871);
  }
  
  Shorts$ShortArrayAsList(short[] paramArrayOfShort)
  {
    this(paramArrayOfShort, 0, paramArrayOfShort.length);
  }
  
  Shorts$ShortArrayAsList(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfShort;
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean equals(Object paramObject);
  
  public native Short get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(Object paramObject);
  
  public native boolean isEmpty();
  
  public native int lastIndexOf(Object paramObject);
  
  public native Short set(int paramInt, Short paramShort);
  
  public native int size();
  
  public native List<Short> subList(int paramInt1, int paramInt2);
  
  native short[] toShortArray();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Shorts$ShortArrayAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */