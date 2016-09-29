package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
class Chars$CharArrayAsList
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
  
  Chars$CharArrayAsList(char[] paramArrayOfChar)
  {
    this(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  Chars$CharArrayAsList(char[] paramArrayOfChar, int paramInt1, int paramInt2)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Chars$CharArrayAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */