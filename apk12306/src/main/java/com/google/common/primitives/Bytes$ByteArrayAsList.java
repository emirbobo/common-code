package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Bytes$ByteArrayAsList
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
  
  Bytes$ByteArrayAsList(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  Bytes$ByteArrayAsList(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Bytes$ByteArrayAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */