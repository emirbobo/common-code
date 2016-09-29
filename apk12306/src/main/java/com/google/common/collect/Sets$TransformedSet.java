package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

class Sets$TransformedSet<A, B>
  extends AbstractSet<B>
{
  final Sets.InvertibleFunction<A, B> bijection;
  final Set<A> delegate;
  
  static
  {
    JniLib.a(TransformedSet.class, 730);
  }
  
  Sets$TransformedSet(Set<A> paramSet, Sets.InvertibleFunction<A, B> paramInvertibleFunction)
  {
    this.delegate = paramSet;
    this.bijection = paramInvertibleFunction;
  }
  
  public native boolean add(B paramB);
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native Iterator<B> iterator();
  
  public native boolean remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$TransformedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */