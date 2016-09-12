package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.ConcurrentHashMap;

class CursorUtils$EntityTempCache
{
  private static final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap();
  private static long seq = 0L;
  
  static
  {
    JniLib.a(EntityTempCache.class, 960);
  }
  
  public static native <T> T get(Class<T> paramClass, Object paramObject);
  
  public static native <T> void put(Class<T> paramClass, Object paramObject1, Object paramObject2);
  
  public static native void setSeq(long paramLong);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\CursorUtils$EntityTempCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */