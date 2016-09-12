package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible(emulated=true)
public final class Ints
{
  public static final int BYTES = 4;
  
  static
  {
    JniLib.a(Ints.class, 867);
  }
  
  public static List<Integer> asList(int... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (paramVarArgs = Collections.emptyList();; paramVarArgs = new IntArrayAsList(paramVarArgs)) {
      return paramVarArgs;
    }
  }
  
  public static native int checkedCast(long paramLong);
  
  public static native int compare(int paramInt1, int paramInt2);
  
  public static int[] concat(int[]... paramVarArgs)
  {
    int i = 0;
    int k = paramVarArgs.length;
    for (int j = 0; j < k; j++) {
      i += paramVarArgs[j].length;
    }
    int[] arrayOfInt1 = new int[i];
    i = 0;
    k = paramVarArgs.length;
    for (j = 0; j < k; j++)
    {
      int[] arrayOfInt2 = paramVarArgs[j];
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, i, arrayOfInt2.length);
      i += arrayOfInt2.length;
    }
    return arrayOfInt1;
  }
  
  public static native boolean contains(int[] paramArrayOfInt, int paramInt);
  
  private static native int[] copyOf(int[] paramArrayOfInt, int paramInt);
  
  public static native int[] ensureCapacity(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  @GwtIncompatible("doesn't work")
  public static native int fromByteArray(byte[] paramArrayOfByte);
  
  @GwtIncompatible("doesn't work")
  public static native int fromBytes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
  
  public static native int hashCode(int paramInt);
  
  public static native int indexOf(int[] paramArrayOfInt, int paramInt);
  
  private static native int indexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int indexOf(int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public static String join(String paramString, int... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {}
    StringBuilder localStringBuilder;
    for (paramString = "";; paramString = localStringBuilder.toString())
    {
      return paramString;
      localStringBuilder = new StringBuilder(paramVarArgs.length * 5);
      localStringBuilder.append(paramVarArgs[0]);
      for (int i = 1; i < paramVarArgs.length; i++) {
        localStringBuilder.append(paramString).append(paramVarArgs[i]);
      }
    }
  }
  
  public static native int lastIndexOf(int[] paramArrayOfInt, int paramInt);
  
  private static native int lastIndexOf(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
  
  public static native Comparator<int[]> lexicographicalComparator();
  
  public static int max(int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int k;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      k = paramVarArgs[0];
      int j = 1;
      while (j < paramVarArgs.length)
      {
        int i = k;
        if (paramVarArgs[j] > k) {
          i = paramVarArgs[j];
        }
        j++;
        k = i;
      }
    }
    return k;
  }
  
  public static int min(int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      i = paramVarArgs[0];
      int k = 1;
      while (k < paramVarArgs.length)
      {
        int j = i;
        if (paramVarArgs[k] < i) {
          j = paramVarArgs[k];
        }
        k++;
        i = j;
      }
    }
    return i;
  }
  
  public static native int saturatedCast(long paramLong);
  
  public static native int[] toArray(Collection<Integer> paramCollection);
  
  @GwtIncompatible("doesn't work")
  public static native byte[] toByteArray(int paramInt);
  
  @GwtCompatible
  private static class IntArrayAsList
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
    
    IntArrayAsList(int[] paramArrayOfInt)
    {
      this(paramArrayOfInt, 0, paramArrayOfInt.length);
    }
    
    IntArrayAsList(int[] paramArrayOfInt, int paramInt1, int paramInt2)
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
  
  private static enum LexicographicalComparator
    implements Comparator<int[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      int k = Math.min(paramArrayOfInt1.length, paramArrayOfInt2.length);
      int i = 0;
      int j;
      if (i < k)
      {
        j = Ints.compare(paramArrayOfInt1[i], paramArrayOfInt2[i]);
        if (j == 0) {}
      }
      for (i = j;; i = paramArrayOfInt1.length - paramArrayOfInt2.length)
      {
        return i;
        i++;
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Ints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */