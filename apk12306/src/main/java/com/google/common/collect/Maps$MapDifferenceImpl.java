package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map;

class Maps$MapDifferenceImpl<K, V>
  implements MapDifference<K, V>
{
  final boolean areEqual;
  final Map<K, MapDifference.ValueDifference<V>> differences;
  final Map<K, V> onBoth;
  final Map<K, V> onlyOnLeft;
  final Map<K, V> onlyOnRight;
  
  static
  {
    JniLib.a(MapDifferenceImpl.class, 632);
  }
  
  Maps$MapDifferenceImpl(boolean paramBoolean, Map<K, V> paramMap1, Map<K, V> paramMap2, Map<K, V> paramMap3, Map<K, MapDifference.ValueDifference<V>> paramMap)
  {
    this.areEqual = paramBoolean;
    this.onlyOnLeft = paramMap1;
    this.onlyOnRight = paramMap2;
    this.onBoth = paramMap3;
    this.differences = paramMap;
  }
  
  public native boolean areEqual();
  
  public native Map<K, MapDifference.ValueDifference<V>> entriesDiffering();
  
  public native Map<K, V> entriesInCommon();
  
  public native Map<K, V> entriesOnlyOnLeft();
  
  public native Map<K, V> entriesOnlyOnRight();
  
  public native boolean equals(Object paramObject);
  
  public native int hashCode();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$MapDifferenceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */