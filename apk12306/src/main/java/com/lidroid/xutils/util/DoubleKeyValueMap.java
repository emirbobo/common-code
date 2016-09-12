package com.lidroid.xutils.util;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DoubleKeyValueMap<K1, K2, V>
{
  private ConcurrentHashMap<K1, ConcurrentHashMap<K2, V>> k1_k2V_map = new ConcurrentHashMap();
  
  static
  {
    JniLib.a(DoubleKeyValueMap.class, 1021);
  }
  
  public native void clear();
  
  public native boolean containsKey(K1 paramK1);
  
  public native boolean containsKey(K1 paramK1, K2 paramK2);
  
  public native V get(K1 paramK1, K2 paramK2);
  
  public native ConcurrentHashMap<K2, V> get(K1 paramK1);
  
  public native Collection<V> getAllValues();
  
  public native Collection<V> getAllValues(K1 paramK1);
  
  public native Set<K1> getFirstKeys();
  
  public native void put(K1 paramK1, K2 paramK2, V paramV);
  
  public native void remove(K1 paramK1);
  
  public native void remove(K1 paramK1, K2 paramK2);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\util\DoubleKeyValueMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */