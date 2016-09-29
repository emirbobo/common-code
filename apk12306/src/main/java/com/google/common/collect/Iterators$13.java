package com.google.common.collect;

import com.bangcle.andjni.JniLib;

final class Iterators$13
  extends UnmodifiableIterator<T>
{
  boolean done;
  
  static
  {
    JniLib.a(13.class, 533);
  }
  
  Iterators$13(Object paramObject) {}
  
  public native boolean hasNext();
  
  public native T next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */