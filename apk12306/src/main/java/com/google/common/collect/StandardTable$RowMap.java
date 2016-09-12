package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$RowMap
  extends Maps.ImprovedAbstractMap<R, Map<C, V>>
{
  static
  {
    JniLib.a(RowMap.class, 747);
  }
  
  StandardTable$RowMap(StandardTable paramStandardTable) {}
  
  public native boolean containsKey(Object paramObject);
  
  protected native Set<Map.Entry<R, Map<C, V>>> createEntrySet();
  
  public native Map<C, V> get(Object paramObject);
  
  public native Set<R> keySet();
  
  public native Map<C, V> remove(Object paramObject);
  
  class EntryIterator
    implements Iterator<Map.Entry<R, Map<C, V>>>
  {
    final Iterator<R> delegate = StandardTable.RowMap.this.this$0.backingMap.keySet().iterator();
    
    static
    {
      JniLib.a(EntryIterator.class, 773);
    }
    
    EntryIterator() {}
    
    public native boolean hasNext();
    
    public native Map.Entry<R, Map<C, V>> next();
    
    public native void remove();
  }
  
  class EntrySet
    extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>>
  {
    static
    {
      JniLib.a(EntrySet.class, 774);
    }
    
    EntrySet()
    {
      super(null);
    }
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Map.Entry<R, Map<C, V>>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$RowMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */