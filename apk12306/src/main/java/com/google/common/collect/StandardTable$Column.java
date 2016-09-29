package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$Column
  extends Maps.ImprovedAbstractMap<R, V>
{
  final C columnKey;
  StandardTable<R, C, V>.Column.Values columnValues;
  StandardTable<R, C, V>.Column.KeySet keySet;
  
  static
  {
    JniLib.a(Column.class, 762);
  }
  
  StandardTable$Column(C paramC)
  {
    Object localObject;
    this.columnKey = Preconditions.checkNotNull(localObject);
  }
  
  public native boolean containsKey(Object paramObject);
  
  public native Set<Map.Entry<R, V>> createEntrySet();
  
  public native V get(Object paramObject);
  
  public native Set<R> keySet();
  
  public native V put(R paramR, V paramV);
  
  public native V remove(Object paramObject);
  
  native boolean removePredicate(Predicate<? super Map.Entry<R, V>> paramPredicate);
  
  public native Collection<V> values();
  
  class EntrySet
    extends AbstractSet<Map.Entry<R, V>>
  {
    static
    {
      JniLib.a(EntrySet.class, 754);
    }
    
    EntrySet() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native boolean isEmpty();
    
    public native Iterator<Map.Entry<R, V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
  }
  
  class EntrySetIterator
    extends AbstractIterator<Map.Entry<R, V>>
  {
    final Iterator<Map.Entry<R, Map<C, V>>> iterator = StandardTable.Column.this.this$0.backingMap.entrySet().iterator();
    
    static
    {
      JniLib.a(EntrySetIterator.class, 756);
    }
    
    EntrySetIterator() {}
    
    protected native Map.Entry<R, V> computeNext();
  }
  
  class KeySet
    extends AbstractSet<R>
  {
    static
    {
      JniLib.a(KeySet.class, 758);
    }
    
    KeySet() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native boolean isEmpty();
    
    public native Iterator<R> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
  }
  
  class Values
    extends AbstractCollection<V>
  {
    static
    {
      JniLib.a(Values.class, 761);
    }
    
    Values() {}
    
    public native void clear();
    
    public native boolean isEmpty();
    
    public native Iterator<V> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Column.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */