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
public final class Booleans
{
  static
  {
    JniLib.a(Booleans.class, 857);
  }
  
  public static List<Boolean> asList(boolean... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (paramVarArgs = Collections.emptyList();; paramVarArgs = new BooleanArrayAsList(paramVarArgs)) {
      return paramVarArgs;
    }
  }
  
  public static native int compare(boolean paramBoolean1, boolean paramBoolean2);
  
  public static boolean[] concat(boolean[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    for (int i = 0; i < k; i++) {
      j += paramVarArgs[i].length;
    }
    boolean[] arrayOfBoolean2 = new boolean[j];
    i = 0;
    k = paramVarArgs.length;
    for (j = 0; j < k; j++)
    {
      boolean[] arrayOfBoolean1 = paramVarArgs[j];
      System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean2, i, arrayOfBoolean1.length);
      i += arrayOfBoolean1.length;
    }
    return arrayOfBoolean2;
  }
  
  public static native boolean contains(boolean[] paramArrayOfBoolean, boolean paramBoolean);
  
  private static native boolean[] copyOf(boolean[] paramArrayOfBoolean, int paramInt);
  
  public static native boolean[] ensureCapacity(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2);
  
  public static native int hashCode(boolean paramBoolean);
  
  public static native int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean);
  
  private static native int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public static native int indexOf(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2);
  
  public static String join(String paramString, boolean... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {}
    StringBuilder localStringBuilder;
    for (paramString = "";; paramString = localStringBuilder.toString())
    {
      return paramString;
      localStringBuilder = new StringBuilder(paramVarArgs.length * 7);
      localStringBuilder.append(paramVarArgs[0]);
      for (int i = 1; i < paramVarArgs.length; i++) {
        localStringBuilder.append(paramString).append(paramVarArgs[i]);
      }
    }
  }
  
  public static native int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean);
  
  private static native int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public static native Comparator<boolean[]> lexicographicalComparator();
  
  public static native boolean[] toArray(Collection<Boolean> paramCollection);
  
  @GwtCompatible
  private static class BooleanArrayAsList
    extends AbstractList<Boolean>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final boolean[] array;
    final int end;
    final int start;
    
    static
    {
      JniLib.a(BooleanArrayAsList.class, 856);
    }
    
    BooleanArrayAsList(boolean[] paramArrayOfBoolean)
    {
      this(paramArrayOfBoolean, 0, paramArrayOfBoolean.length);
    }
    
    BooleanArrayAsList(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfBoolean;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean equals(Object paramObject);
    
    public native Boolean get(int paramInt);
    
    public native int hashCode();
    
    public native int indexOf(Object paramObject);
    
    public native boolean isEmpty();
    
    public native int lastIndexOf(Object paramObject);
    
    public native Boolean set(int paramInt, Boolean paramBoolean);
    
    public native int size();
    
    public native List<Boolean> subList(int paramInt1, int paramInt2);
    
    native boolean[] toBooleanArray();
    
    public native String toString();
  }
  
  private static enum LexicographicalComparator
    implements Comparator<boolean[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
    {
      int k = Math.min(paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
      int i = 0;
      int j;
      if (i < k)
      {
        j = Booleans.compare(paramArrayOfBoolean1[i], paramArrayOfBoolean2[i]);
        if (j == 0) {}
      }
      for (i = j;; i = paramArrayOfBoolean1.length - paramArrayOfBoolean2.length)
      {
        return i;
        i++;
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Booleans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */