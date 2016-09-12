package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Map.Entry;

final class Multimaps$1
  extends AbstractMapEntry<K, Collection<V>>
{
  static
  {
    JniLib.a(1.class, 647);
  }
  
  Multimaps$1(Map.Entry paramEntry) {}
  
  public native K getKey();
  
  public native Collection<V> getValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multimaps$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */