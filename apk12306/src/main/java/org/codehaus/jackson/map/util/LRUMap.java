package org.codehaus.jackson.map.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUMap<K, V>
  extends LinkedHashMap<K, V>
{
  protected final int _maxEntries;
  
  public LRUMap(int paramInt1, int paramInt2)
  {
    super(paramInt1, 0.8F, true);
    this._maxEntries = paramInt2;
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    if (size() > this._maxEntries) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\LRUMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */