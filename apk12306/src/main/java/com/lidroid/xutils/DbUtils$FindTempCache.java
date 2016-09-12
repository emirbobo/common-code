package com.lidroid.xutils;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.ConcurrentHashMap;

class DbUtils$FindTempCache
{
  private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap();
  private long seq = 0L;
  
  static
  {
    JniLib.a(FindTempCache.class, 917);
  }
  
  private DbUtils$FindTempCache(DbUtils paramDbUtils) {}
  
  public native Object get(String paramString);
  
  public native void put(String paramString, Object paramObject);
  
  public native void setSeq(long paramLong);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\DbUtils$FindTempCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */