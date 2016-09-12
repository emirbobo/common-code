package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$ColumnMap
  extends Maps.ImprovedAbstractMap<C, Map<R, V>>
{
  StandardTable<R, C, V>.ColumnMap.ColumnMapValues columnMapValues;
  
  static
  {
    JniLib.a(ColumnMap.class, 768);
  }
  
  private StandardTable$ColumnMap(StandardTable paramStandardTable) {}
  
  public native boolean containsKey(Object paramObject);
  
  public native Set<Map.Entry<C, Map<R, V>>> createEntrySet();
  
  public native Map<R, V> get(Object paramObject);
  
  public native Set<C> keySet();
  
  public native Map<R, V> remove(Object paramObject);
  
  public native Collection<Map<R, V>> values();
  
  class ColumnMapEntrySet
    extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>>
  {
    static
    {
      JniLib.a(ColumnMapEntrySet.class, 766);
    }
    
    ColumnMapEntrySet()
    {
      super(null);
    }
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Map.Entry<C, Map<R, V>>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
  }
  
  private class ColumnMapValues
    extends StandardTable<R, C, V>.TableCollection<Map<R, V>>
  {
    static
    {
      JniLib.a(ColumnMapValues.class, 767);
    }
    
    private ColumnMapValues()
    {
      super(null);
    }
    
    public native Iterator<Map<R, V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native boolean removeAll(Collection<?> paramCollection);
    
    public native boolean retainAll(Collection<?> paramCollection);
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$ColumnMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */