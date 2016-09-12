package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
public final class Floats
{
  static
  {
    JniLib.a(Floats.class, 865);
  }
  
  public static List<Float> asList(float... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (paramVarArgs = Collections.emptyList();; paramVarArgs = new FloatArrayAsList(paramVarArgs)) {
      return paramVarArgs;
    }
  }
  
  public static native int compare(float paramFloat1, float paramFloat2);
  
  public static float[] concat(float[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    for (int i = 0; i < k; i++) {
      j += paramVarArgs[i].length;
    }
    float[] arrayOfFloat2 = new float[j];
    i = 0;
    k = paramVarArgs.length;
    for (j = 0; j < k; j++)
    {
      float[] arrayOfFloat1 = paramVarArgs[j];
      System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, i, arrayOfFloat1.length);
      i += arrayOfFloat1.length;
    }
    return arrayOfFloat2;
  }
  
  public static native boolean contains(float[] paramArrayOfFloat, float paramFloat);
  
  private static native float[] copyOf(float[] paramArrayOfFloat, int paramInt);
  
  public static native float[] ensureCapacity(float[] paramArrayOfFloat, int paramInt1, int paramInt2);
  
  public static native int hashCode(float paramFloat);
  
  public static native int indexOf(float[] paramArrayOfFloat, float paramFloat);
  
  private static native int indexOf(float[] paramArrayOfFloat, float paramFloat, int paramInt1, int paramInt2);
  
  public static native int indexOf(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  public static String join(String paramString, float... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {}
    StringBuilder localStringBuilder;
    for (paramString = "";; paramString = localStringBuilder.toString())
    {
      return paramString;
      localStringBuilder = new StringBuilder(paramVarArgs.length * 12);
      localStringBuilder.append(paramVarArgs[0]);
      for (int i = 1; i < paramVarArgs.length; i++) {
        localStringBuilder.append(paramString).append(paramVarArgs[i]);
      }
    }
  }
  
  public static native int lastIndexOf(float[] paramArrayOfFloat, float paramFloat);
  
  private static native int lastIndexOf(float[] paramArrayOfFloat, float paramFloat, int paramInt1, int paramInt2);
  
  public static native Comparator<float[]> lexicographicalComparator();
  
  public static float max(float... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    float f;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      f = paramVarArgs[0];
      for (int i = 1; i < paramVarArgs.length; i++) {
        f = Math.max(f, paramVarArgs[i]);
      }
    }
    return f;
  }
  
  public static float min(float... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    float f;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      f = paramVarArgs[0];
      for (int i = 1; i < paramVarArgs.length; i++) {
        f = Math.min(f, paramVarArgs[i]);
      }
    }
    return f;
  }
  
  public static native float[] toArray(Collection<Float> paramCollection);
  
  @GwtCompatible
  private static class FloatArrayAsList
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
    
    FloatArrayAsList(float[] paramArrayOfFloat)
    {
      this(paramArrayOfFloat, 0, paramArrayOfFloat.length);
    }
    
    FloatArrayAsList(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
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
  
  private static enum LexicographicalComparator
    implements Comparator<float[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
    {
      int k = Math.min(paramArrayOfFloat1.length, paramArrayOfFloat2.length);
      int i = 0;
      int j;
      if (i < k)
      {
        j = Floats.compare(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
        if (j == 0) {}
      }
      for (i = j;; i = paramArrayOfFloat1.length - paramArrayOfFloat2.length)
      {
        return i;
        i++;
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Floats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */