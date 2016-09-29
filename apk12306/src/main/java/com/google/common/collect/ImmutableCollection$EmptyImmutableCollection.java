package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;

class ImmutableCollection$EmptyImmutableCollection
  extends ImmutableCollection<Object>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  
  static
  {
    JniLib.a(EmptyImmutableCollection.class, 466);
  }
  
  public native boolean contains(@Nullable Object paramObject);
  
  native ImmutableList<Object> createAsList();
  
  public native boolean isEmpty();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<Object> iterator();
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableCollection$EmptyImmutableCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */