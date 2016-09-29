package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;

@GwtCompatible
public final class SignedBytes
{
  static
  {
    JniLib.a(SignedBytes.class, 873);
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
      localStringBuilder.append(paramVarArgs[0]);
      for (int i = 1; i < paramVarArgs.length; i++) {
        localStringBuilder.append(paramString).append(paramVarArgs[i]);
      }
    }
  }
  
  public static native Comparator<byte[]> lexicographicalComparator();
  
  public static byte max(byte... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    byte b1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      byte b2 = paramVarArgs[0];
      int i = 1;
      for (b1 = b2; i < paramVarArgs.length; b1 = b2)
      {
        b2 = b1;
        if (paramVarArgs[i] > b1) {
          b2 = paramVarArgs[i];
        }
        i++;
      }
    }
    return b1;
  }
  
  public static byte min(byte... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    byte b1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      byte b2 = paramVarArgs[0];
      int i = 1;
      for (b1 = b2; i < paramVarArgs.length; b1 = b2)
      {
        b2 = b1;
        if (paramVarArgs[i] < b1) {
          b2 = paramVarArgs[i];
        }
        i++;
      }
    }
    return b1;
  }
  
  public static native byte saturatedCast(long paramLong);
  
  private static enum LexicographicalComparator
    implements Comparator<byte[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      int k = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
      int i = 0;
      int j;
      if (i < k)
      {
        j = SignedBytes.compare(paramArrayOfByte1[i], paramArrayOfByte2[i]);
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\SignedBytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */