package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractList;
import java.util.List;
import javax.annotation.Nullable;

final class Lists$CharSequenceAsList
  extends AbstractList<Character>
{
  private final CharSequence sequence;
  
  static
  {
    JniLib.a(CharSequenceAsList.class, 577);
  }
  
  Lists$CharSequenceAsList(CharSequence paramCharSequence)
  {
    this.sequence = paramCharSequence;
  }
  
  public native boolean contains(@Nullable Object paramObject);
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native Character get(int paramInt);
  
  public native int hashCode();
  
  public native int indexOf(@Nullable Object paramObject);
  
  public native int lastIndexOf(@Nullable Object paramObject);
  
  public native int size();
  
  public native List<Character> subList(int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$CharSequenceAsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */