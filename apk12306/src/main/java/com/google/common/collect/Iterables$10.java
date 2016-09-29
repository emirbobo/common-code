package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.List;

final class Iterables$10
  extends Iterables.IterableWithToString<T>
{
  static
  {
    JniLib.a(10.class, 513);
  }
  
  Iterables$10(int paramInt, List paramList) {}
  
  public native Iterator<T> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Iterables$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */