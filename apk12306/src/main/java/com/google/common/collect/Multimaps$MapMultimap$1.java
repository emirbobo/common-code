package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;

class Multimaps$MapMultimap$1
  extends AbstractSet<V>
{
  static
  {
    JniLib.a(1.class, 655);
  }
  
  Multimaps$MapMultimap$1(Multimaps.MapMultimap paramMapMultimap, Object paramObject) {}
  
  public native Iterator<V> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$MapMultimap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */