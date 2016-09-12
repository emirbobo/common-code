package com.google.common.collect;

import com.bangcle.andjni.JniLib;

final class Iterators$1
  extends UnmodifiableIterator<Object>
{
  static
  {
    JniLib.a(1.class, 536);
  }
  
  public native boolean hasNext();
  
  public native Object next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */