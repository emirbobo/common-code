package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.List;

final class Iterators$6
  extends UnmodifiableIterator<List<T>>
{
  static
  {
    JniLib.a(6.class, 541);
  }
  
  Iterators$6(Iterator paramIterator, int paramInt, boolean paramBoolean) {}
  
  public native boolean hasNext();
  
  public native List<T> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterators$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */