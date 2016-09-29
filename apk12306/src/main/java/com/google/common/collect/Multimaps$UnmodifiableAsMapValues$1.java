package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;

class Multimaps$UnmodifiableAsMapValues$1
  implements Iterator<Collection<V>>
{
  static
  {
    JniLib.a(1.class, 672);
  }
  
  Multimaps$UnmodifiableAsMapValues$1(Multimaps.UnmodifiableAsMapValues paramUnmodifiableAsMapValues, Iterator paramIterator) {}
  
  public native boolean hasNext();
  
  public native Collection<V> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$UnmodifiableAsMapValues$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */