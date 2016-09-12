package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@VisibleForTesting
class Ordering$ArbitraryOrdering
  extends Ordering<Object>
{
  private Map<Object, Integer> uids = Platform.tryWeakKeys(new MapMaker()).makeComputingMap(new Function()
  {
    final AtomicInteger counter = new AtomicInteger(0);
    
    static
    {
      JniLib.a(1.class, 699);
    }
    
    public native Integer apply(Object paramAnonymousObject);
  });
  
  static
  {
    JniLib.a(ArbitraryOrdering.class, 700);
  }
  
  public native int compare(Object paramObject1, Object paramObject2);
  
  native int identityHashCode(Object paramObject);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Ordering$ArbitraryOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */