package com.lidroid.xutils.db.sqlite;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.table.DbModel;
import java.util.concurrent.ConcurrentHashMap;

public class CursorUtils
{
  static
  {
    JniLib.a(CursorUtils.class, 962);
  }
  
  public static native DbModel getDbModel(Cursor paramCursor);
  
  public static native <T> T getEntity(DbUtils paramDbUtils, Cursor paramCursor, Class<T> paramClass, long paramLong);
  
  private static class EntityTempCache
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
  
  public static class FindCacheSequence
  {
    private static final String FINDER_LAZY_LOADER_CLASS_NAME = FinderLazyLoader.class.getName();
    private static final String FOREIGN_LAZY_LOADER_CLASS_NAME;
    private static long seq;
    
    static
    {
      JniLib.a(FindCacheSequence.class, 961);
      seq = 0L;
      FOREIGN_LAZY_LOADER_CLASS_NAME = ForeignLazyLoader.class.getName();
    }
    
    public static native long getSeq();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\CursorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */