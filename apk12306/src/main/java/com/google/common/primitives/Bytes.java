package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
public final class Bytes
{
  static
  {
    JniLib.a(Bytes.class, 859);
  }
  
  public static List<Byte> asList(byte... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (paramVarArgs = Collections.emptyList();; paramVarArgs = new ByteArrayAsList(paramVarArgs)) {
      return paramVarArgs;
    }
  }
  
  public static byte[] concat(byte[]... paramVarArgs)
  {
    int i = 0;
    int k = paramVarArgs.length;
    for (int j = 0; j < k; j++) {
      i += paramVarArgs[j].length;
    }
    byte[] arrayOfByte2 = new byte[i];
    i = 0;
    k = paramVarArgs.length;
    for (j = 0; j < k; j++)
    {
      byte[] arrayOfByte1 = paramVarArgs[j];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i, arrayOfByte1.length);
      i += arrayOfByte1.length;
    }
    return arrayOfByte2;
  }
  
  public static native boolean contains(byte[] paramArrayOfByte, byte paramByte);
  
  private static native byte[] copyOf(byte[] paramArrayOfByte, int paramInt);
  
  public static native byte[] ensureCapacity(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int hashCode(byte paramByte);
  
  public static native int indexOf(byte[] paramArrayOfByte, byte paramByte);
  
  private static native int indexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2);
  
  public static native int indexOf(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int lastIndexOf(byte[] paramArrayOfByte, byte paramByte);
  
  private static native int lastIndexOf(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2);
  
  public static native byte[] toArray(Collection<Byte> paramCollection);
  
  @GwtCompatible
  private static class ByteArrayAsList
    extends AbstractList<Byte>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final byte[] array;
    final int end;
    final int start;
    
    static
    {
      JniLib.a(ByteArrayAsList.class, 858);
    }
    
    ByteArrayAsList(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    ByteArrayAsList(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfByte;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public native boolean contains(Object paramObject);
    
    public native boolean equals(Object paramObject);
    
    public native Byte get(int paramInt);
    
    public native int hashCode();
    
    public native int indexOf(Object paramObject);
    
    public native boolean isEmpty();
    
    public native int lastIndexOf(Object paramObject);
    
    public native Byte set(int paramInt, Byte paramByte);
    
    public native int size();
    
    public native List<Byte> subList(int paramInt1, int paramInt2);
    
    native byte[] toByteArray();
    
    public native String toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Bytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */