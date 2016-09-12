package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.ListIterator;

class Lists$TransformingSequentialList$1
  implements ListIterator<T>
{
  static
  {
    JniLib.a(1.class, 585);
  }
  
  Lists$TransformingSequentialList$1(Lists.TransformingSequentialList paramTransformingSequentialList, ListIterator paramListIterator) {}
  
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Lists$TransformingSequentialList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */