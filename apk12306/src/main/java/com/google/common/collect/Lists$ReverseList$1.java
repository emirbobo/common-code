package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.ListIterator;

class Lists$ReverseList$1
  implements ListIterator<T>
{
  boolean canRemove;
  boolean canSet;
  
  static
  {
    JniLib.a(1.class, 581);
  }
  
  Lists$ReverseList$1(Lists.ReverseList paramReverseList, ListIterator paramListIterator) {}
  
  public native void add(T paramT);
  
  public native boolean hasNext();
  
  public native boolean hasPrevious();
  
  public native T next();
  
  public native int nextIndex();
  
  public native T previous();
  
  public native int previousIndex();
  
  public native void remove();
  
  public native void set(T paramT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$ReverseList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */