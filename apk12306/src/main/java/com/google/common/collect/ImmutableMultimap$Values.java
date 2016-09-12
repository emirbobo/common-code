package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;

class ImmutableMultimap$Values<V>
  extends ImmutableCollection<V>
{
  private static final long serialVersionUID = 0L;
  final ImmutableMultimap<?, V> multimap;
  
  static
  {
    JniLib.a(Values.class, 482);
  }
  
  ImmutableMultimap$Values(ImmutableMultimap<?, V> paramImmutableMultimap)
  {
    this.multimap = paramImmutableMultimap;
  }
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<V> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultimap$Values.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */