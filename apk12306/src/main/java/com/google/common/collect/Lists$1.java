package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.List;
import java.util.ListIterator;

final class Lists$1
  extends Lists.RandomAccessListWrapper<E>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(1.class, 575);
  }
  
  Lists$1(List paramList)
  {
    super(paramList);
  }
  
  public native ListIterator<E> listIterator(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */