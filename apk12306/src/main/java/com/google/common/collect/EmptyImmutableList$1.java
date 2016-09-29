package com.google.common.collect;

import com.bangcle.andjni.JniLib;

final class EmptyImmutableList$1
  extends UnmodifiableListIterator<Object>
{
  static
  {
    JniLib.a(1.class, 428);
  }
  
  public native boolean hasNext();
  
  public native boolean hasPrevious();
  
  public native Object next();
  
  public native int nextIndex();
  
  public native Object previous();
  
  public native int previousIndex();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\EmptyImmutableList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */