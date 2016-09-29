package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Longs$LongArrayAsList
  extends AbstractList<Long>
  implements RandomAccess, Serializable
{
  private static final long serialVersionUID = 0L;
  final long[] array;
  final int end;
  final int start;
  
  static
  {
    JniLib.a(LongArrayAsList.class, 868);
  }
  
  Longs$LongArrayAsList(long[] paramArrayOfLong)
  {
    this(paramArrayOfLong, 0, paramArrayOfLong.length);
  }
  
  Longs$LongArrayAsList(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfLong;
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean equals(Object paramObject);
  
  public native Long get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(Object paramObject);
  
  public native boolean isEmpty();
  
  public native int lastIndexOf(Object paramObject);
  
  public native Long set(int paramInt, Long paramLong);
  
  public native int size();
  
  public native List<Long> subList(int paramInt1, int paramInt2);
  
  native long[] toLongArray();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Longs$LongArrayAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */