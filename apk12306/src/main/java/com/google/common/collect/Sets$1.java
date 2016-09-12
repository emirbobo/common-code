package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Set;

final class Sets$1
  extends Sets.SetView<E>
{
  static
  {
    JniLib.a(1.class, 717);
  }
  
  Sets$1(Set paramSet1, Set paramSet2, Set paramSet3)
  {
    super(null);
  }
  
  public native boolean contains(Object paramObject);
  
  public native <S extends Set<E>> S copyInto(S paramS);
  
  public native ImmutableSet<E> immutableCopy();
  
  public native boolean isEmpty();
  
  public native Iterator<E> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */