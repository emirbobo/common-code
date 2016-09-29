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
public final class Doubles
{
  static
  {
    JniLib.a(Doubles.class, 863);
  }
  
  public static List<Double> asList(double... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (paramVarArgs = Collections.emptyList();; paramVarArgs = new DoubleArrayAsList(paramVarArgs)) {
      return paramVarArgs;
    }
  }
  
  public static native int compare(double paramDouble1, double paramDouble2);
  
  public static double[] concat(double[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    for (int i = 0; i < k; i++) {
      j += paramVarArgs[i].length;
    }
    double[] arrayOfDouble2 = new double[j];
    i = 0;
    k = paramVarArgs.length;
    for (j = 0; j < k; j++)
    {
      double[] arrayOfDouble1 = paramVarArgs[j];
      System.arraycopy(arrayOfDouble1, 0, arrayOfDouble2, i, arrayOfDouble1.length);
      i += arrayOfDouble1.length;
    }
    return arrayOfDouble2;
  }
  
  public static native boolean contains(double[] paramArrayOfDouble, double paramDouble);
  
  private static native double[] copyOf(double[] paramArrayOfDouble, int paramInt);
  
  public static native double[] ensureCapacity(double[] paramArrayOfDouble, int paramInt1, int paramInt2);
  
  public static native int hashCode(double paramDouble);
  
  public static native int indexOf(double[] paramArrayOfDouble, double paramDouble);
  
  private static native int indexOf(double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2);
  
  public static native int indexOf(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2);
  
  public static String join(String paramString, double... paramVarArgs)
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
  
  public static native int lastIndexOf(double[] paramArrayOfDouble, double paramDouble);
  
  private static native int lastIndexOf(double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2);
  
  public static native Comparator<double[]> lexicographicalComparator();
  
  public static double max(double... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      d = paramVarArgs[0];
      for (int i = 1; i < paramVarArgs.length; i++) {
        d = Math.max(d, paramVarArgs[i]);
      }
    }
    return d;
  }
  
  public static double min(double... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    double d;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      d = paramVarArgs[0];
      for (int i = 1; i < paramVarArgs.length; i++) {
        d = Math.min(d, paramVarArgs[i]);
      }
    }
    return d;
  }
  
  public static native double[] toArray(Collection<Double> paramCollection);
  
  @GwtCompatible
  private static class DoubleArrayAsList
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
    
    DoubleArrayAsList(double[] paramArrayOfDouble)
    {
      this(paramArrayOfDouble, 0, paramArrayOfDouble.length);
    }
    
    DoubleArrayAsList(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
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
  
  private static enum LexicographicalComparator
    implements Comparator<double[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
    {
      int k = Math.min(paramArrayOfDouble1.length, paramArrayOfDouble2.length);
      int i = 0;
      int j;
      if (i < k)
      {
        j = Doubles.compare(paramArrayOfDouble1[i], paramArrayOfDouble2[i]);
        if (j == 0) {}
      }
      for (i = j;; i = paramArrayOfDouble1.length - paramArrayOfDouble2.length)
      {
        return i;
        i++;
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Doubles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */