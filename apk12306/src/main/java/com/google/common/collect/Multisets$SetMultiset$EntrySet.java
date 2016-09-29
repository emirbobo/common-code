package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

class Multisets$SetMultiset$EntrySet
  extends AbstractSet<Multiset.Entry<E>>
{
  static
  {
    JniLib.a(EntrySet.class, 689);
  }
  
  Multisets$SetMultiset$EntrySet(Multisets.SetMultiset paramSetMultiset) {}
  
  public native Iterator<Multiset.Entry<E>> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Multisets$SetMultiset$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */