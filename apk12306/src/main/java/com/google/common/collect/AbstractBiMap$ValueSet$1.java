package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class AbstractBiMap$ValueSet$1
  implements Iterator<V>
{
  V valueToRemove;
  
  static
  {
    JniLib.a(1.class, 334);
  }
  
  AbstractBiMap$ValueSet$1(AbstractBiMap.ValueSet paramValueSet, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native V next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractBiMap$ValueSet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */