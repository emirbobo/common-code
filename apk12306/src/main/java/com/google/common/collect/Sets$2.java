package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class Sets$2
  extends Sets.SetView<E>
{
  static
  {
    JniLib.a(2.class, 718);
  }
  
  Sets$2(Set paramSet1, Predicate paramPredicate, Set paramSet2)
  {
    super(null);
  }
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native boolean isEmpty();
  
  public native Iterator<E> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */