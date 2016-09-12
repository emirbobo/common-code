package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Set;

class Multisets$SetMultiset$EntrySet$1
  implements Iterator<Multiset.Entry<E>>
{
  final Iterator<E> elements = this.this$1.this$0.delegate.iterator();
  
  static
  {
    JniLib.a(1.class, 688);
  }
  
  Multisets$SetMultiset$EntrySet$1(Multisets.SetMultiset.EntrySet paramEntrySet) {}
  
  public native boolean hasNext();
  
  public native Multiset.Entry<E> next();
  
  public native void remove();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$SetMultiset$EntrySet$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */