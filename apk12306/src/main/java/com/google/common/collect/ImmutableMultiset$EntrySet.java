package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;

class ImmutableMultiset$EntrySet<E>
  extends ImmutableSet<Multiset.Entry<E>>
{
  private static final long serialVersionUID = 0L;
  final ImmutableMultiset<E> multiset;
  
  static
  {
    JniLib.a(EntrySet.class, 486);
  }
  
  public ImmutableMultiset$EntrySet(ImmutableMultiset<E> paramImmutableMultiset)
  {
    this.multiset = paramImmutableMultiset;
  }
  
  public native boolean contains(Object paramObject);
  
  public native int hashCode();
  
  native boolean isPartialView();
  
  public native UnmodifiableIterator<Multiset.Entry<E>> iterator();
  
  public native int size();
  
  public native Object[] toArray();
  
  public native <T> T[] toArray(T[] paramArrayOfT);
  
  @GwtIncompatible("not needed in emulated source.")
  native Object writeReplace();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableMultiset$EntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */