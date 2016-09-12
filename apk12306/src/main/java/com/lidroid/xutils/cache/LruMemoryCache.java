package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruMemoryCache<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private KeyExpiryMap<K, Long> keyExpiryMap;
  private final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  static
  {
    JniLib.a(LruMemoryCache.class, 929);
  }
  
  public LruMemoryCache(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.maxSize = paramInt;
    this.map = new LinkedHashMap(0, 0.75F, true);
    this.keyExpiryMap = new KeyExpiryMap(0, 0.75F);
  }
  
  private native int safeSizeOf(K paramK, V paramV);
  
  private native void trimToSize(int paramInt);
  
  public final native boolean containsKey(K paramK);
  
  protected native V create(K paramK);
  
  public final native int createCount();
  
  protected native void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2);
  
  public final native void evictAll();
  
  public final native int evictionCount();
  
  public final native V get(K paramK);
  
  public final native int hitCount();
  
  public final native int maxSize();
  
  public final native int missCount();
  
  public final native V put(K paramK, V paramV);
  
  public final native V put(K paramK, V paramV, long paramLong);
  
  public final native int putCount();
  
  public final native V remove(K paramK);
  
  public native void setMaxSize(int paramInt);
  
  public final native int size();
  
  protected native int sizeOf(K paramK, V paramV);
  
  public final native Map<K, V> snapshot();
  
  public final native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */