package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Booleans$BooleanArrayAsList
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
  
  Booleans$BooleanArrayAsList(boolean[] paramArrayOfBoolean)
  {
    this(paramArrayOfBoolean, 0, paramArrayOfBoolean.length);
  }
  
  Booleans$BooleanArrayAsList(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Booleans$BooleanArrayAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */