package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;

final class Lists$StringAsImmutableList
  extends ImmutableList<Character>
{
  int hash = 0;
  private final String string;
  
  static
  {
    JniLib.a(StringAsImmutableList.class, 583);
  }
  
  Lists$StringAsImmutableList(String paramString)
  {
    this.string = paramString;
  }
  
  public native boolean contains(@Nullable Object paramObject);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native Character get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(@Nullable Object paramObject);
  
  native boolean isPartialView();
  
  public native int lastIndexOf(@Nullable Object paramObject);
  
  public native UnmodifiableListIterator<Character> listIterator(int paramInt);
  
  public native int size();
  
  public native ImmutableList<Character> subList(int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$StringAsImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */