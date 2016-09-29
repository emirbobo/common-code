package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

final class Maps$1
  extends AbstractMapEntry<K, V>
{
  static
  {
    JniLib.a(1.class, 615);
  }
  
  Maps$1(Map.Entry paramEntry) {}
  
  public native K getKey();
  
  public native V getValue();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */