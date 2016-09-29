package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import java.util.concurrent.atomic.AtomicInteger;

class Ordering$ArbitraryOrdering$1
  implements Function<Object, Integer>
{
  final AtomicInteger counter = new AtomicInteger(0);
  
  static
  {
    JniLib.a(1.class, 699);
  }
  
  Ordering$ArbitraryOrdering$1(Ordering.ArbitraryOrdering paramArbitraryOrdering) {}
  
  public native Integer apply(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Ordering$ArbitraryOrdering$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */