package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$Row
  extends Maps.ImprovedAbstractMap<C, V>
{
  final R rowKey;
  
  static
  {
    JniLib.a(Row.class, 772);
  }
  
  StandardTable$Row(R paramR)
  {
    Object localObject;
    this.rowKey = Preconditions.checkNotNull(localObject);
  }
  
  public native boolean containsKey(Object paramObject);
  
  protected native Set<Map.Entry<C, V>> createEntrySet();
  
  public native V get(Object paramObject);
  
  public native V put(C paramC, V paramV);
  
  public native V remove(Object paramObject);
  
  private class RowEntrySet
    extends AbstractSet<Map.Entry<C, V>>
  {
    static
    {
      JniLib.a(RowEntrySet.class, 771);
    }
    
    private RowEntrySet() {}
    
    public native void clear();
    
    public native boolean contains(Object paramObject);
    
    public native Iterator<Map.Entry<C, V>> iterator();
    
    public native boolean remove(Object paramObject);
    
    public native int size();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\StandardTable$Row.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */