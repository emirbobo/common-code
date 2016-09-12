package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;

class AbstractMultimap$WrappedCollection$WrappedIterator
  implements Iterator<V>
{
  final Iterator<V> delegateIterator;
  final Collection<V> originalDelegate = this.this$1.delegate;
  
  static
  {
    JniLib.a(WrappedIterator.class, 361);
  }
  
  AbstractMultimap$WrappedCollection$WrappedIterator(AbstractMultimap.WrappedCollection paramWrappedCollection)
  {
    this.delegateIterator = AbstractMultimap.access$100(paramWrappedCollection.this$0, paramWrappedCollection.delegate);
  }
  
  AbstractMultimap$WrappedCollection$WrappedIterator(Iterator<V> paramIterator)
  {
    Iterator localIterator;
    this.delegateIterator = localIterator;
  }
  
  native Iterator<V> getDelegateIterator();
  
  public native boolean hasNext();
  
  public native V next();
  
  public native void remove();
  
  native void validateIterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$WrappedCollection$WrappedIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */