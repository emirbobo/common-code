package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.List;
import java.util.ListIterator;

final class Lists$2
  extends Lists.AbstractListWrapper<E>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(2.class, 576);
  }
  
  Lists$2(List paramList)
  {
    super(paramList);
  }
  
  public native ListIterator<E> listIterator(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */