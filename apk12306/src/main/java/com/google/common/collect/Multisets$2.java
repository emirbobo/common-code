package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

final class Multisets$2
  extends AbstractMultiset<E>
{
  final Set<Multiset.Entry<E>> entrySet = new AbstractSet()
  {
    static
    {
      JniLib.a(1.class, 682);
    }
    
    public native boolean contains(Object paramAnonymousObject);
    
    public native boolean isEmpty();
    
    public native Iterator<Multiset.Entry<E>> iterator();
    
    public native int size();
  };
  
  static
  {
    JniLib.a(2.class, 683);
  }
  
  Multisets$2(Multiset paramMultiset1, Multiset paramMultiset2) {}
  
  public native int count(Object paramObject);
  
  native Set<E> createElementSet();
  
  public native Set<Multiset.Entry<E>> entrySet();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */