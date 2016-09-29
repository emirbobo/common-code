package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Floats$FloatArrayAsList
  extends AbstractList<Float>
  implements RandomAccess, Serializable
{
  private static final long serialVersionUID = 0L;
  final float[] array;
  final int end;
  final int start;
  
  static
  {
    JniLib.a(FloatArrayAsList.class, 864);
  }
  
  Floats$FloatArrayAsList(float[] paramArrayOfFloat)
  {
    this(paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }
  
  Floats$FloatArrayAsList(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfFloat;
    this.start = paramInt1;
    this.end = paramInt2;
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean equals(Object paramObject);
  
  public native Float get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(Object paramObject);
  
  public native boolean isEmpty();
  
  public native int lastIndexOf(Object paramObject);
  
  public native Float set(int paramInt, Float paramFloat);
  
  public native int size();
  
  public native List<Float> subList(int paramInt1, int paramInt2);
  
  native float[] toFloatArray();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Floats$FloatArrayAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */