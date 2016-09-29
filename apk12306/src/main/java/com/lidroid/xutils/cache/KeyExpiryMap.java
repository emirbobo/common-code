package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.ConcurrentHashMap;

public class KeyExpiryMap<K, V>
  extends ConcurrentHashMap<K, Long>
{
  private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
  private static final long serialVersionUID = 1L;
  
  static
  {
    JniLib.a(KeyExpiryMap.class, 936);
  }
  
  public KeyExpiryMap() {}
  
  public KeyExpiryMap(int paramInt)
  {
    super(paramInt);
  }
  
  public KeyExpiryMap(int paramInt, float paramFloat)
  {
    super(paramInt, paramFloat, 16);
  }
  
  public KeyExpiryMap(int paramInt1, float paramFloat, int paramInt2)
  {
    super(paramInt1, paramFloat, paramInt2);
  }
  
  public native void clear();
  
  public native boolean containsKey(Object paramObject);
  
  public native Long get(Object paramObject);
  
  public native Long put(K paramK, Long paramLong);
  
  public native Long remove(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\KeyExpiryMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */