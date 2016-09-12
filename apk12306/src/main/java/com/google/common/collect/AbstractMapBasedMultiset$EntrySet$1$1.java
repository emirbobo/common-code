package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$EntrySet$1$1
  extends Multisets.AbstractEntry<E>
{
  static
  {
    JniLib.a(1.class, 336);
  }
  
  AbstractMapBasedMultiset$EntrySet$1$1(AbstractMapBasedMultiset.EntrySet.1 param1, Map.Entry paramEntry) {}
  
  public native int getCount();
  
  public native E getElement();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMapBasedMultiset$EntrySet$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */