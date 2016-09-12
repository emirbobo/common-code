package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

class Collections2$TransformedCollection<F, T>
  extends AbstractCollection<T>
{
  final Collection<F> fromCollection;
  final Function<? super F, ? extends T> function;
  
  static
  {
    JniLib.a(TransformedCollection.class, 370);
  }
  
  Collections2$TransformedCollection(Collection<F> paramCollection, Function<? super F, ? extends T> paramFunction)
  {
    this.fromCollection = ((Collection)Preconditions.checkNotNull(paramCollection));
    this.function = ((Function)Preconditions.checkNotNull(paramFunction));
  }
  
  public native void clear();
  
  public native boolean isEmpty();
  
  public native Iterator<T> iterator();
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Collections2$TransformedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */