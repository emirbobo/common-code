package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Comparator;
import sun.misc.Unsafe;

public final class UnsignedBytes
{
  static
  {
    JniLib.a(UnsignedBytes.class, 876);
  }
  
  public static native byte checkedCast(long paramLong);
  
  public static native int compare(byte paramByte1, byte paramByte2);
  
  public static String join(String paramString, byte... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {}
    StringBuilder localStringBuilder;
    for (paramString = "";; paramString = localStringBuilder.toString())
    {
      return paramString;
      localStringBuilder = new StringBuilder(paramVarArgs.length * 5);
      localStringBuilder.append(toInt(paramVarArgs[0]));
      for (int i = 1; i < paramVarArgs.length; i++) {
        localStringBuilder.append(paramString).append(toInt(paramVarArgs[i]));
      }
    }
  }
  
  public static native Comparator<byte[]> lexicographicalComparator();
  
  @VisibleForTesting
  static native Comparator<byte[]> lexicographicalComparatorJavaImpl();
  
  public static byte max(byte... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int k;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      k = toInt(paramVarArgs[0]);
      int j = 1;
      while (j < paramVarArgs.length)
      {
        int m = toInt(paramVarArgs[j]);
        int i = k;
        if (m > k) {
          i = m;
        }
        j++;
        k = i;
      }
    }
    return (byte)k;
  }
  
  public static byte min(byte... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      i = toInt(paramVarArgs[0]);
      int k = 1;
      while (k < paramVarArgs.length)
      {
        int m = toInt(paramVarArgs[k]);
        int j = i;
        if (m < i) {
          j = m;
        }
        k++;
        i = j;
      }
    }
    return (byte)i;
  }
  
  public static native byte saturatedCast(long paramLong);
  
  public static native int toInt(byte paramByte);
  
  @VisibleForTesting
  static class LexicographicalComparatorHolder
  {
    static final Comparator<byte[]> BEST_COMPARATOR = getBestComparator();
    static final String UNSAFE_COMPARATOR_NAME;
    
    static
    {
      JniLib.a(LexicographicalComparatorHolder.class, 875);
      UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
    }
    
    static native Comparator<byte[]> getBestComparator();
    
    static enum PureJavaComparator
      implements Comparator<byte[]>
    {
      INSTANCE;
      
      private PureJavaComparator() {}
      
      public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
      {
        int k = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
        int i = 0;
        int j;
        if (i < k)
        {
          j = UnsignedBytes.compare(paramArrayOfByte1[i], paramArrayOfByte2[i]);
          if (j == 0) {}
        }
        for (i = j;; i = paramArrayOfByte1.length - paramArrayOfByte2.length)
        {
          return i;
          i++;
          break;
        }
      }
    }
    
    static enum UnsafeComparator
      implements Comparator<byte[]>
    {
      static final int BYTE_ARRAY_BASE_OFFSET;
      static final boolean littleEndian;
      static final Unsafe theUnsafe;
      
      static
      {
        $VALUES = new UnsafeComparator[] { INSTANCE };
        littleEndian = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);
        theUnsafe = (Unsafe)AccessController.doPrivileged(new PrivilegedAction()
        {
          static
          {
            JniLib.a(1.class, 874);
          }
          
          public native Object run();
        });
        BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
        if (theUnsafe.arrayIndexScale(byte[].class) != 1) {
          throw new AssertionError();
        }
      }
      
      private UnsafeComparator() {}
      
      static boolean lessThanUnsigned(long paramLong1, long paramLong2)
      {
        if (paramLong1 - Long.MIN_VALUE < Long.MIN_VALUE + paramLong2) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      
      public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
      {
        int k = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
        int j = k / 8;
        int i = 0;
        long l1;
        long l3;
        long l2;
        if (i < j * 8)
        {
          l1 = theUnsafe.getLong(paramArrayOfByte1, BYTE_ARRAY_BASE_OFFSET + i);
          l3 = theUnsafe.getLong(paramArrayOfByte2, BYTE_ARRAY_BASE_OFFSET + i);
          l2 = l1 ^ l3;
          if (l2 != 0L) {
            if (!littleEndian) {
              if (lessThanUnsigned(l1, l3)) {
                i = -1;
              }
            }
          }
        }
        for (;;)
        {
          return i;
          i = 1;
          continue;
          j = 0;
          k = (int)l2;
          i = k;
          if (k == 0)
          {
            i = (int)(l2 >>> 32);
            j = 32;
          }
          k = i << 16;
          if (k == 0) {
            j += 16;
          }
          for (;;)
          {
            k = j;
            if (i << 8 == 0) {
              k = j + 8;
            }
            i = (int)((l1 >>> k & 0xFF) - (l3 >>> k & 0xFF));
            break;
            i = k;
          }
          i += 8;
          break;
          for (i = j * 8;; i++)
          {
            if (i >= k) {
              break label233;
            }
            j = UnsignedBytes.compare(paramArrayOfByte1[i], paramArrayOfByte2[i]);
            if (j != 0)
            {
              i = j;
              break;
            }
          }
          label233:
          i = paramArrayOfByte1.length - paramArrayOfByte2.length;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\UnsignedBytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */