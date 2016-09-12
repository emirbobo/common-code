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
public final class Chars
{
  public static final int BYTES = 2;
  
  static
  {
    JniLib.a(Chars.class, 861);
  }
  
  public static List<Character> asList(char... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (paramVarArgs = Collections.emptyList();; paramVarArgs = new CharArrayAsList(paramVarArgs)) {
      return paramVarArgs;
    }
  }
  
  public static native char checkedCast(long paramLong);
  
  public static native int compare(char paramChar1, char paramChar2);
  
  public static char[] concat(char[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    for (int i = 0; i < k; i++) {
      j += paramVarArgs[i].length;
    }
    char[] arrayOfChar2 = new char[j];
    j = 0;
    k = paramVarArgs.length;
    for (i = 0; i < k; i++)
    {
      char[] arrayOfChar1 = paramVarArgs[i];
      System.arraycopy(arrayOfChar1, 0, arrayOfChar2, j, arrayOfChar1.length);
      j += arrayOfChar1.length;
    }
    return arrayOfChar2;
  }
  
  public static native boolean contains(char[] paramArrayOfChar, char paramChar);
  
  private static native char[] copyOf(char[] paramArrayOfChar, int paramInt);
  
  public static native char[] ensureCapacity(char[] paramArrayOfChar, int paramInt1, int paramInt2);
  
  @GwtIncompatible("doesn't work")
  public static native char fromByteArray(byte[] paramArrayOfByte);
  
  @GwtIncompatible("doesn't work")
  public static native char fromBytes(byte paramByte1, byte paramByte2);
  
  public static native int hashCode(char paramChar);
  
  public static native int indexOf(char[] paramArrayOfChar, char paramChar);
  
  private static native int indexOf(char[] paramArrayOfChar, char paramChar, int paramInt1, int paramInt2);
  
  public static native int indexOf(char[] paramArrayOfChar1, char[] paramArrayOfChar2);
  
  public static String join(String paramString, char... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    int j = paramVarArgs.length;
    if (j == 0) {}
    StringBuilder localStringBuilder;
    for (paramString = "";; paramString = localStringBuilder.toString())
    {
      return paramString;
      localStringBuilder = new StringBuilder(paramString.length() * (j - 1) + j);
      localStringBuilder.append(paramVarArgs[0]);
      for (int i = 1; i < j; i++) {
        localStringBuilder.append(paramString).append(paramVarArgs[i]);
      }
    }
  }
  
  public static native int lastIndexOf(char[] paramArrayOfChar, char paramChar);
  
  private static native int lastIndexOf(char[] paramArrayOfChar, char paramChar, int paramInt1, int paramInt2);
  
  public static native Comparator<char[]> lexicographicalComparator();
  
  public static char max(char... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    char c1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      char c2 = paramVarArgs[0];
      int i = 1;
      for (c1 = c2; i < paramVarArgs.length; c1 = c2)
      {
        c2 = c1;
        if (paramVarArgs[i] > c1) {
          c2 = paramVarArgs[i];
        }
        i++;
      }
    }
    return c1;
  }
  
  public static char min(char... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    char c1;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      char c2 = paramVarArgs[0];
      int i = 1;
      for (c1 = c2; i < paramVarArgs.length; c1 = c2)
      {
        c2 = c1;
        if (paramVarArgs[i] < c1) {
          c2 = paramVarArgs[i];
        }
        i++;
      }
    }
    return c1;
  }
  
  public static native char saturatedCast(long paramLong);
  
  public static native char[] toArray(Collection<Character> paramCollection);
  
  @GwtIncompatible("doesn't work")
  public static native byte[] toByteArray(char paramChar);
  
  @GwtCompatible
  private static class CharArrayAsList
    extends AbstractList<Character>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final char[] array;
    final int end;
    final int start;
    
    static
    {
      JniLib.a(CharArrayAsList.class, 860);
    }
    
    CharArrayAsList(char[] paramArrayOfChar)
    {
      this(paramArrayOfChar, 0, paramArrayOfChar.length);
    }
    
    CharArrayAsList(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfChar;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean equals(Object paramObject);
    
    public native Character get(int paramInt);
    
    public native int hashCode();
    
    public native int indexOf(Object paramObject);
    
    public native boolean isEmpty();
    
    public native int lastIndexOf(Object paramObject);
    
    public native Character set(int paramInt, Character paramCharacter);
    
    public native int size();
    
    public native List<Character> subList(int paramInt1, int paramInt2);
    
    native char[] toCharArray();
    
    public native String toString();
  }
  
  private static enum LexicographicalComparator
    implements Comparator<char[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
    {
      int k = Math.min(paramArrayOfChar1.length, paramArrayOfChar2.length);
      int i = 0;
      int j;
      if (i < k)
      {
        j = Chars.compare(paramArrayOfChar1[i], paramArrayOfChar2[i]);
        if (j == 0) {}
      }
      for (i = j;; i = paramArrayOfChar1.length - paramArrayOfChar2.length)
      {
        return i;
        i++;
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Chars.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */