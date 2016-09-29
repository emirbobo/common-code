package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class Maps$AbstractMapWrapper<K, V>
  extends Maps.ImprovedAbstractMap<K, V>
{
  private final Map<K, V> map;
  
  static
  {
    JniLib.a(AbstractMapWrapper.class, 621);
  }
  
  Maps$AbstractMapWrapper(Map<K, V> paramMap)
  {
    this.map = ((Map)Preconditions.checkNotNull(paramMap));
  }
  
  public native void clear();
  
  public native boolean containsKey(Object paramObject);
  
  public native boolean containsValue(Object paramObject);
  
  protected native Set<Map.Entry<K, V>> createEntrySet();
  
  public native boolean isEmpty();
  
  public native V remove(Object paramObject);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$AbstractMapWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */