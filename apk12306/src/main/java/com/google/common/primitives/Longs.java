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
public final class Longs
{
  public static final int BYTES = 8;
  
  static
  {
    JniLib.a(Longs.class, 869);
  }
  
  public static List<Long> asList(long... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (paramVarArgs = Collections.emptyList();; paramVarArgs = new LongArrayAsList(paramVarArgs)) {
      return paramVarArgs;
    }
  }
  
  public static native int compare(long paramLong1, long paramLong2);
  
  public static long[] concat(long[]... paramVarArgs)
  {
    int i = 0;
    int k = paramVarArgs.length;
    for (int j = 0; j < k; j++) {
      i += paramVarArgs[j].length;
    }
    long[] arrayOfLong2 = new long[i];
    j = 0;
    k = paramVarArgs.length;
    for (i = 0; i < k; i++)
    {
      long[] arrayOfLong1 = paramVarArgs[i];
      System.arraycopy(arrayOfLong1, 0, arrayOfLong2, j, arrayOfLong1.length);
      j += arrayOfLong1.length;
    }
    return arrayOfLong2;
  }
  
  public static native boolean contains(long[] paramArrayOfLong, long paramLong);
  
  private static native long[] copyOf(long[] paramArrayOfLong, int paramInt);
  
  public static native long[] ensureCapacity(long[] paramArrayOfLong, int paramInt1, int paramInt2);
  
  @GwtIncompatible("doesn't work")
  public static native long fromByteArray(byte[] paramArrayOfByte);
  
  @GwtIncompatible("doesn't work")
  public static native long fromBytes(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8);
  
  public static native int hashCode(long paramLong);
  
  public static native int indexOf(long[] paramArrayOfLong, long paramLong);
  
  private static native int indexOf(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2);
  
  public static native int indexOf(long[] paramArrayOfLong1, long[] paramArrayOfLong2);
  
  public static String join(String paramString, long... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {}
    StringBuilder localStringBuilder;
    for (paramString = "";; paramString = localStringBuilder.toString())
    {
      return paramString;
      localStringBuilder = new StringBuilder(paramVarArgs.length * 10);
      localStringBuilder.append(paramVarArgs[0]);
      for (int i = 1; i < paramVarArgs.length; i++) {
        localStringBuilder.append(paramString).append(paramVarArgs[i]);
      }
    }
  }
  
  public static native int lastIndexOf(long[] paramArrayOfLong, long paramLong);
  
  private static native int lastIndexOf(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2);
  
  public static native Comparator<long[]> lexicographicalComparator();
  
  public static long max(long... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    long l2;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      l2 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        long l1 = l2;
        if (paramVarArgs[i] > l2) {
          l1 = paramVarArgs[i];
        }
        i++;
        l2 = l1;
      }
    }
    return l2;
  }
  
  public static long min(long... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    long l2;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      l2 = paramVarArgs[0];
      int i = 1;
      while (i < paramVarArgs.length)
      {
        long l1 = l2;
        if (paramVarArgs[i] < l2) {
          l1 = paramVarArgs[i];
        }
        i++;
        l2 = l1;
      }
    }
    return l2;
  }
  
  public static native long[] toArray(Collection<Long> paramCollection);
  
  @GwtIncompatible("doesn't work")
  public static native byte[] toByteArray(long paramLong);
  
  private static enum LexicographicalComparator
    implements Comparator<long[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      int k = Math.min(paramArrayOfLong1.length, paramArrayOfLong2.length);
      int i = 0;
      int j;
      if (i < k)
      {
        j = Longs.compare(paramArrayOfLong1[i], paramArrayOfLong2[i]);
        if (j == 0) {}
      }
      for (i = j;; i = paramArrayOfLong1.length - paramArrayOfLong2.length)
      {
        return i;
        i++;
        break;
      }
    }
  }
  
  @GwtCompatible
  private static class LongArrayAsList
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
    
    LongArrayAsList(long[] paramArrayOfLong)
    {
      this(paramArrayOfLong, 0, paramArrayOfLong.length);
    }
    
    LongArrayAsList(long[] paramArrayOfLong, int paramInt1, int paramInt2)
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Longs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */