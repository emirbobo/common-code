package com.lidroid.xutils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.DbModelSelector;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.SqlInfo;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.db.table.DbModel;
import com.lidroid.xutils.exception.DbException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DbUtils
{
  private static HashMap<String, DbUtils> daoMap = new HashMap();
  private boolean allowTransaction = false;
  private DaoConfig daoConfig;
  private SQLiteDatabase database;
  private boolean debug = false;
  private final FindTempCache findTempCache = new FindTempCache(null);
  private Lock writeLock = new ReentrantLock();
  private volatile boolean writeLocked = false;
  
  static
  {
    JniLib.a(DbUtils.class, 918);
  }
  
  private DbUtils(DaoConfig paramDaoConfig)
  {
    if (paramDaoConfig == null) {
      throw new IllegalArgumentException("daoConfig may not be null");
    }
    this.database = createDatabase(paramDaoConfig);
    this.daoConfig = paramDaoConfig;
  }
  
  private native void beginTransaction();
  
  public static native DbUtils create(Context paramContext);
  
  public static native DbUtils create(Context paramContext, String paramString);
  
  public static native DbUtils create(Context paramContext, String paramString, int paramInt, DbUpgradeListener paramDbUpgradeListener);
  
  public static native DbUtils create(Context paramContext, String paramString1, String paramString2);
  
  public static native DbUtils create(Context paramContext, String paramString1, String paramString2, int paramInt, DbUpgradeListener paramDbUpgradeListener);
  
  public static native DbUtils create(DaoConfig paramDaoConfig);
  
  private native SQLiteDatabase createDatabase(DaoConfig paramDaoConfig);
  
  private native void debugSql(String paramString);
  
  private native void endTransaction();
  
  private static native DbUtils getInstance(DaoConfig paramDaoConfig);
  
  private native long getLastAutoIncrementId(String paramString)
    throws DbException;
  
  private native boolean saveBindingIdWithoutTransaction(Object paramObject)
    throws DbException;
  
  private native void saveOrUpdateWithoutTransaction(Object paramObject)
    throws DbException;
  
  private native void setTransactionSuccessful();
  
  public native void close();
  
  public native DbUtils configAllowTransaction(boolean paramBoolean);
  
  public native DbUtils configDebug(boolean paramBoolean);
  
  public native long count(Selector paramSelector)
    throws DbException;
  
  public native long count(Class<?> paramClass)
    throws DbException;
  
  public native void createTableIfNotExist(Class<?> paramClass)
    throws DbException;
  
  public native void delete(Class<?> paramClass, WhereBuilder paramWhereBuilder)
    throws DbException;
  
  public native void delete(Object paramObject)
    throws DbException;
  
  public native void deleteAll(Class<?> paramClass)
    throws DbException;
  
  public native void deleteAll(List<?> paramList)
    throws DbException;
  
  public native void deleteById(Class<?> paramClass, Object paramObject)
    throws DbException;
  
  public native void dropDb()
    throws DbException;
  
  public native void dropTable(Class<?> paramClass)
    throws DbException;
  
  public native void execNonQuery(SqlInfo paramSqlInfo)
    throws DbException;
  
  public native void execNonQuery(String paramString)
    throws DbException;
  
  public native Cursor execQuery(SqlInfo paramSqlInfo)
    throws DbException;
  
  public native Cursor execQuery(String paramString)
    throws DbException;
  
  public native <T> List<T> findAll(Selector paramSelector)
    throws DbException;
  
  public native <T> List<T> findAll(Class<T> paramClass)
    throws DbException;
  
  public native <T> T findById(Class<T> paramClass, Object paramObject)
    throws DbException;
  
  public native List<DbModel> findDbModelAll(DbModelSelector paramDbModelSelector)
    throws DbException;
  
  public native List<DbModel> findDbModelAll(SqlInfo paramSqlInfo)
    throws DbException;
  
  public native DbModel findDbModelFirst(DbModelSelector paramDbModelSelector)
    throws DbException;
  
  public native DbModel findDbModelFirst(SqlInfo paramSqlInfo)
    throws DbException;
  
  public native <T> T findFirst(Selector paramSelector)
    throws DbException;
  
  public native <T> T findFirst(Class<T> paramClass)
    throws DbException;
  
  public native DaoConfig getDaoConfig();
  
  public native SQLiteDatabase getDatabase();
  
  public native void replace(Object paramObject)
    throws DbException;
  
  public native void replaceAll(List<?> paramList)
    throws DbException;
  
  public native void save(Object paramObject)
    throws DbException;
  
  public native void saveAll(List<?> paramList)
    throws DbException;
  
  public native boolean saveBindingId(Object paramObject)
    throws DbException;
  
  public native void saveBindingIdAll(List<?> paramList)
    throws DbException;
  
  public native void saveOrUpdate(Object paramObject)
    throws DbException;
  
  public native void saveOrUpdateAll(List<?> paramList)
    throws DbException;
  
  public native boolean tableIsExist(Class<?> paramClass)
    throws DbException;
  
  /* Error */
  public void update(Object paramObject, WhereBuilder paramWhereBuilder, String... paramVarArgs)
    throws DbException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 153	java/lang/Object:getClass	()Ljava/lang/Class;
    //   5: invokevirtual 155	com/lidroid/xutils/DbUtils:tableIsExist	(Ljava/lang/Class;)Z
    //   8: ifne +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: invokespecial 157	com/lidroid/xutils/DbUtils:beginTransaction	()V
    //   16: aload_0
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: aload_3
    //   21: invokestatic 163	com/lidroid/xutils/db/sqlite/SqlInfoBuilder:buildUpdateSqlInfo	(Lcom/lidroid/xutils/DbUtils;Ljava/lang/Object;Lcom/lidroid/xutils/db/sqlite/WhereBuilder;[Ljava/lang/String;)Lcom/lidroid/xutils/db/sqlite/SqlInfo;
    //   24: invokevirtual 165	com/lidroid/xutils/DbUtils:execNonQuery	(Lcom/lidroid/xutils/db/sqlite/SqlInfo;)V
    //   27: aload_0
    //   28: invokespecial 167	com/lidroid/xutils/DbUtils:setTransactionSuccessful	()V
    //   31: aload_0
    //   32: invokespecial 169	com/lidroid/xutils/DbUtils:endTransaction	()V
    //   35: goto -24 -> 11
    //   38: astore_1
    //   39: aload_0
    //   40: invokespecial 169	com/lidroid/xutils/DbUtils:endTransaction	()V
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	DbUtils
    //   0	45	1	paramObject	Object
    //   0	45	2	paramWhereBuilder	WhereBuilder
    //   0	45	3	paramVarArgs	String[]
    // Exception table:
    //   from	to	target	type
    //   12	31	38	finally
  }
  
  /* Error */
  public void update(Object paramObject, String... paramVarArgs)
    throws DbException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 153	java/lang/Object:getClass	()Ljava/lang/Class;
    //   5: invokevirtual 155	com/lidroid/xutils/DbUtils:tableIsExist	(Ljava/lang/Class;)Z
    //   8: ifne +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: invokespecial 157	com/lidroid/xutils/DbUtils:beginTransaction	()V
    //   16: aload_0
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: invokestatic 174	com/lidroid/xutils/db/sqlite/SqlInfoBuilder:buildUpdateSqlInfo	(Lcom/lidroid/xutils/DbUtils;Ljava/lang/Object;[Ljava/lang/String;)Lcom/lidroid/xutils/db/sqlite/SqlInfo;
    //   23: invokevirtual 165	com/lidroid/xutils/DbUtils:execNonQuery	(Lcom/lidroid/xutils/db/sqlite/SqlInfo;)V
    //   26: aload_0
    //   27: invokespecial 167	com/lidroid/xutils/DbUtils:setTransactionSuccessful	()V
    //   30: aload_0
    //   31: invokespecial 169	com/lidroid/xutils/DbUtils:endTransaction	()V
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: invokespecial 169	com/lidroid/xutils/DbUtils:endTransaction	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	DbUtils
    //   0	44	1	paramObject	Object
    //   0	44	2	paramVarArgs	String[]
    // Exception table:
    //   from	to	target	type
    //   12	30	37	finally
  }
  
  /* Error */
  public void updateAll(List<?> paramList, WhereBuilder paramWhereBuilder, String... paramVarArgs)
    throws DbException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +29 -> 30
    //   4: aload_1
    //   5: invokeinterface 182 1 0
    //   10: ifeq +20 -> 30
    //   13: aload_0
    //   14: aload_1
    //   15: iconst_0
    //   16: invokeinterface 186 2 0
    //   21: invokevirtual 153	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: invokevirtual 155	com/lidroid/xutils/DbUtils:tableIsExist	(Ljava/lang/Class;)Z
    //   27: ifne +4 -> 31
    //   30: return
    //   31: aload_0
    //   32: invokespecial 157	com/lidroid/xutils/DbUtils:beginTransaction	()V
    //   35: aload_1
    //   36: invokeinterface 190 1 0
    //   41: astore_1
    //   42: aload_1
    //   43: invokeinterface 196 1 0
    //   48: ifne +14 -> 62
    //   51: aload_0
    //   52: invokespecial 167	com/lidroid/xutils/DbUtils:setTransactionSuccessful	()V
    //   55: aload_0
    //   56: invokespecial 169	com/lidroid/xutils/DbUtils:endTransaction	()V
    //   59: goto -29 -> 30
    //   62: aload_0
    //   63: aload_0
    //   64: aload_1
    //   65: invokeinterface 200 1 0
    //   70: aload_2
    //   71: aload_3
    //   72: invokestatic 163	com/lidroid/xutils/db/sqlite/SqlInfoBuilder:buildUpdateSqlInfo	(Lcom/lidroid/xutils/DbUtils;Ljava/lang/Object;Lcom/lidroid/xutils/db/sqlite/WhereBuilder;[Ljava/lang/String;)Lcom/lidroid/xutils/db/sqlite/SqlInfo;
    //   75: invokevirtual 165	com/lidroid/xutils/DbUtils:execNonQuery	(Lcom/lidroid/xutils/db/sqlite/SqlInfo;)V
    //   78: goto -36 -> 42
    //   81: astore_1
    //   82: aload_0
    //   83: invokespecial 169	com/lidroid/xutils/DbUtils:endTransaction	()V
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	DbUtils
    //   0	88	1	paramList	List<?>
    //   0	88	2	paramWhereBuilder	WhereBuilder
    //   0	88	3	paramVarArgs	String[]
    // Exception table:
    //   from	to	target	type
    //   31	42	81	finally
    //   42	55	81	finally
    //   62	78	81	finally
  }
  
  /* Error */
  public void updateAll(List<?> paramList, String... paramVarArgs)
    throws DbException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +29 -> 30
    //   4: aload_1
    //   5: invokeinterface 182 1 0
    //   10: ifeq +20 -> 30
    //   13: aload_0
    //   14: aload_1
    //   15: iconst_0
    //   16: invokeinterface 186 2 0
    //   21: invokevirtual 153	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: invokevirtual 155	com/lidroid/xutils/DbUtils:tableIsExist	(Ljava/lang/Class;)Z
    //   27: ifne +4 -> 31
    //   30: return
    //   31: aload_0
    //   32: invokespecial 157	com/lidroid/xutils/DbUtils:beginTransaction	()V
    //   35: aload_1
    //   36: invokeinterface 190 1 0
    //   41: astore_1
    //   42: aload_1
    //   43: invokeinterface 196 1 0
    //   48: ifne +14 -> 62
    //   51: aload_0
    //   52: invokespecial 167	com/lidroid/xutils/DbUtils:setTransactionSuccessful	()V
    //   55: aload_0
    //   56: invokespecial 169	com/lidroid/xutils/DbUtils:endTransaction	()V
    //   59: goto -29 -> 30
    //   62: aload_0
    //   63: aload_0
    //   64: aload_1
    //   65: invokeinterface 200 1 0
    //   70: aload_2
    //   71: invokestatic 174	com/lidroid/xutils/db/sqlite/SqlInfoBuilder:buildUpdateSqlInfo	(Lcom/lidroid/xutils/DbUtils;Ljava/lang/Object;[Ljava/lang/String;)Lcom/lidroid/xutils/db/sqlite/SqlInfo;
    //   74: invokevirtual 165	com/lidroid/xutils/DbUtils:execNonQuery	(Lcom/lidroid/xutils/db/sqlite/SqlInfo;)V
    //   77: goto -35 -> 42
    //   80: astore_1
    //   81: aload_0
    //   82: invokespecial 169	com/lidroid/xutils/DbUtils:endTransaction	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	DbUtils
    //   0	87	1	paramList	List<?>
    //   0	87	2	paramVarArgs	String[]
    // Exception table:
    //   from	to	target	type
    //   31	42	80	finally
    //   42	55	80	finally
    //   62	77	80	finally
  }
  
  public static class DaoConfig
  {
    private Context context;
    private String dbDir;
    private String dbName = "xUtils.db";
    private DbUtils.DbUpgradeListener dbUpgradeListener;
    private int dbVersion = 1;
    
    static
    {
      JniLib.a(DaoConfig.class, 916);
    }
    
    public DaoConfig(Context paramContext)
    {
      this.context = paramContext.getApplicationContext();
    }
    
    public native Context getContext();
    
    public native String getDbDir();
    
    public native String getDbName();
    
    public native DbUtils.DbUpgradeListener getDbUpgradeListener();
    
    public native int getDbVersion();
    
    public native void setDbDir(String paramString);
    
    public native void setDbName(String paramString);
    
    public native void setDbUpgradeListener(DbUtils.DbUpgradeListener paramDbUpgradeListener);
    
    public native void setDbVersion(int paramInt);
  }
  
  public static abstract interface DbUpgradeListener
  {
    public abstract void onUpgrade(DbUtils paramDbUtils, int paramInt1, int paramInt2);
  }
  
  private class FindTempCache
  {
    private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap();
    private long seq = 0L;
    
    static
    {
      JniLib.a(FindTempCache.class, 917);
    }
    
    private FindTempCache() {}
    
    public native Object get(String paramString);
    
    public native void put(String paramString, Object paramObject);
    
    public native void setSeq(long paramLong);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\DbUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */