package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;

class Synchronized$SynchronizedAsMapValues$1
  extends ForwardingIterator<Collection<V>>
{
  static
  {
    JniLib.a(1.class, 785);
  }
  
  Synchronized$SynchronizedAsMapValues$1(Synchronized.SynchronizedAsMapValues paramSynchronizedAsMapValues, Iterator paramIterator) {}
  
  protected native Iterator<Collection<V>> delegate();
  
  public native Collection<V> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedAsMapValues$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */