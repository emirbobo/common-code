package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Doubles$DoubleArrayAsList
  extends AbstractList<Double>
  implements RandomAccess, Serializable
{
  private static final long serialVersionUID = 0L;
  final double[] array;
  final int end;
  final int start;
  
  static
  {
    JniLib.a(DoubleArrayAsList.class, 862);
  }
  
  Doubles$DoubleArrayAsList(double[] paramArrayOfDouble)
  {
    this(paramArrayOfDouble, 0, paramArrayOfDouble.length);
  }
  
  Doubles$DoubleArrayAsList(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfDouble;
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean equals(Object paramObject);
  
  public native Double get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(Object paramObject);
  
  public native boolean isEmpty();
  
  public native int lastIndexOf(Object paramObject);
  
  public native Double set(int paramInt, Double paramDouble);
  
  public native int size();
  
  public native List<Double> subList(int paramInt1, int paramInt2);
  
  native double[] toDoubleArray();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Doubles$DoubleArrayAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */