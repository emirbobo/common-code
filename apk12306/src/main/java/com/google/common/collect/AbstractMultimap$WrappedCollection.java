package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class AbstractMultimap$WrappedCollection
  extends AbstractCollection<V>
{
  final AbstractMultimap<K, V>.WrappedCollection ancestor;
  final Collection<V> ancestorDelegate;
  Collection<V> delegate;
  final K key;
  
  static
  {
    JniLib.a(WrappedCollection.class, 355);
  }
  
  AbstractMultimap$WrappedCollection(@Nullable K paramK, Collection<V> paramCollection, @Nullable AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    this.key = paramCollection;
    this.delegate = paramAbstractMultimap;
    WrappedCollection localWrappedCollection;
    this.ancestor = localWrappedCollection;
    if (localWrappedCollection == null) {}
    for (paramK = null;; paramK = localWrappedCollection.getDelegate())
    {
      this.ancestorDelegate = paramK;
      return;
    }
  }
  
  public native boolean add(V paramV);
  
  public native boolean addAll(Collection<? extends V> paramCollection);
  
  native void addToMap();
  
  public native void clear();
  
  public native boolean contains(Object paramObject);
  
  public native boolean containsAll(Collection<?> paramCollection);
  
  public native boolean equals(@Nullable Object paramObject);
  
  native AbstractMultimap<K, V>.WrappedCollection getAncestor();
  
  native Collection<V> getDelegate();
  
  native K getKey();
  
  public native int hashCode();
  
  public native Iterator<V> iterator();
  
  native void refreshIfEmpty();
  
  public native boolean remove(Object paramObject);
  
  public native boolean removeAll(Collection<?> paramCollection);
  
  native void removeIfEmpty();
  
  public native boolean retainAll(Collection<?> paramCollection);
  
  public native int size();
  
  public native String toString();
  
  class WrappedIterator
    implements Iterator<V>
  {
    final Iterator<V> delegateIterator;
    final Collection<V> originalDelegate = AbstractMultimap.WrappedCollection.this.delegate;
    
    static
    {
      JniLib.a(WrappedIterator.class, 361);
    }
    
    WrappedIterator()
    {
      this.delegateIterator = AbstractMultimap.access$100(AbstractMultimap.WrappedCollection.this.this$0, AbstractMultimap.WrappedCollection.this.delegate);
    }
    
    WrappedIterator()
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\AbstractMultimap$WrappedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */