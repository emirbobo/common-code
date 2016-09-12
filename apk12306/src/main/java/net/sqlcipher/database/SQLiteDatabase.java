package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.SQLException;

public class SQLiteDatabase
  extends SQLiteClosable
{
  private static final String COMMIT_SQL = "COMMIT;";
  public static final int CONFLICT_ABORT = 2;
  public static final int CONFLICT_FAIL = 3;
  public static final int CONFLICT_IGNORE = 4;
  public static final int CONFLICT_NONE = 0;
  public static final int CONFLICT_REPLACE = 5;
  public static final int CONFLICT_ROLLBACK = 1;
  private static final String[] CONFLICT_VALUES = { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
  public static final int CREATE_IF_NECESSARY = 268435456;
  private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
  private static final int EVENT_DB_CORRUPT = 75004;
  private static final int EVENT_DB_OPERATION = 52000;
  static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
  private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
  private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
  private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
  private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
  private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
  public static final int MAX_SQL_CACHE_SIZE = 250;
  private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
  public static final int NO_LOCALIZED_COLLATORS = 16;
  public static final int OPEN_READONLY = 1;
  public static final int OPEN_READWRITE = 0;
  private static final int OPEN_READ_MASK = 1;
  private static final int QUERY_LOG_SQL_LENGTH = 64;
  private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
  public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
  private static final String TAG = "Database";
  private static int sQueryLogTimeInMillis = 0;
  private int mCacheFullWarnings;
  Map<String, SQLiteCompiledSql> mCompiledQueries = Maps.newHashMap();
  private CursorFactory mFactory;
  private int mFlags;
  private boolean mInnerTransactionIsSuccessful;
  private long mLastLockMessageTime = 0L;
  private String mLastSqlStatement = null;
  private final ReentrantLock mLock = new ReentrantLock(true);
  private long mLockAcquiredThreadTime = 0L;
  private long mLockAcquiredWallTime = 0L;
  private boolean mLockingEnabled = true;
  private int mMaxSqlCacheSize = 250;
  int mNativeHandle = 0;
  private int mNumCacheHits;
  private int mNumCacheMisses;
  private String mPath;
  private String mPathForLogs = null;
  private WeakHashMap<SQLiteClosable, Object> mPrograms;
  private final Random mRandom = new Random();
  private final int mSlowQueryThreshold;
  private Throwable mStackTrace = null;
  private final Map<String, SyncUpdateInfo> mSyncUpdateInfo = new HashMap();
  int mTempTableSequence = 0;
  private String mTimeClosed = null;
  private String mTimeOpened = null;
  private boolean mTransactionIsSuccessful;
  private SQLiteTransactionListener mTransactionListener;
  
  public SQLiteDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramString1, paramString2, paramCursorFactory, paramInt, null);
  }
  
  public SQLiteDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("path should not be null");
    }
    this.mFlags = paramInt;
    this.mPath = paramString1;
    this.mSlowQueryThreshold = -1;
    this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    this.mFactory = paramCursorFactory;
    dbopen(this.mPath, this.mFlags);
    if (paramSQLiteDatabaseHook != null) {
      paramSQLiteDatabaseHook.preKey(this);
    }
    execSQL("PRAGMA key = '" + paramString2 + "'");
    if (paramSQLiteDatabaseHook != null) {
      paramSQLiteDatabaseHook.postKey(this);
    }
    if (SQLiteDebug.DEBUG_SQL_CACHE) {
      this.mTimeOpened = getTime();
    }
    this.mPrograms = new WeakHashMap();
    try
    {
      setLocale(Locale.getDefault());
      return;
    }
    catch (RuntimeException paramString1)
    {
      Log.e("Database", "Failed to setLocale() when constructing, closing the database", paramString1);
      dbclose();
      if (SQLiteDebug.DEBUG_SQL_CACHE) {
        this.mTimeClosed = getTime();
      }
      throw paramString1;
    }
  }
  
  private void checkLockHoldTime()
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = l2 - this.mLockAcquiredWallTime;
    if ((l1 < 2000L) && (!Log.isLoggable("Database", 2)) && (l2 - this.mLastLockMessageTime < 20000L)) {}
    for (;;)
    {
      return;
      if (l1 > 300L)
      {
        int i = (int)((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000L);
        if ((i > 100) || (l1 > 2000L))
        {
          this.mLastLockMessageTime = l2;
          String str = "lock held on " + this.mPath + " for " + l1 + "ms. Thread time was " + i + "ms";
          if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE) {
            Log.d("Database", str, new Exception());
          } else {
            Log.d("Database", str);
          }
        }
      }
    }
  }
  
  private void closeClosable()
  {
    deallocCachedSqlStatements();
    Iterator localIterator = this.mPrograms.entrySet().iterator();
    while (localIterator.hasNext())
    {
      SQLiteClosable localSQLiteClosable = (SQLiteClosable)((Map.Entry)localIterator.next()).getKey();
      if (localSQLiteClosable != null) {
        localSQLiteClosable.onAllReferencesReleasedFromContainer();
      }
    }
  }
  
  public static SQLiteDatabase create(CursorFactory paramCursorFactory, String paramString)
  {
    return openDatabase(":memory:", paramString, paramCursorFactory, 268435456);
  }
  
  private native void dbclose();
  
  private native void dbopen(String paramString, int paramInt);
  
  private void deallocCachedSqlStatements()
  {
    synchronized (this.mCompiledQueries)
    {
      Iterator localIterator = this.mCompiledQueries.values().iterator();
      if (localIterator.hasNext()) {
        ((SQLiteCompiledSql)localIterator.next()).releaseSqlStatement();
      }
    }
    this.mCompiledQueries.clear();
  }
  
  private native void enableSqlProfiling(String paramString);
  
  private native void enableSqlTracing(String paramString);
  
  public static String findEditTable(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int j = paramString.indexOf(' ');
      int i = paramString.indexOf(',');
      String str;
      if ((j > 0) && ((j < i) || (i < 0))) {
        str = paramString.substring(0, j);
      }
      for (;;)
      {
        return str;
        str = paramString;
        if (i > 0) {
          if (i >= j)
          {
            str = paramString;
            if (j >= 0) {}
          }
          else
          {
            str = paramString.substring(0, i);
          }
        }
      }
    }
    throw new IllegalStateException("Invalid tables");
  }
  
  private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!paramSQLiteDatabase.isOpen()) {}
    ArrayList localArrayList;
    for (paramSQLiteDatabase = null;; paramSQLiteDatabase = localArrayList)
    {
      return paramSQLiteDatabase;
      localArrayList = new ArrayList();
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("pragma database_list;", null);
      while (paramSQLiteDatabase.moveToNext()) {
        localArrayList.add(new Pair(paramSQLiteDatabase.getString(1), paramSQLiteDatabase.getString(2)));
      }
      paramSQLiteDatabase.close();
    }
  }
  
  static ArrayList<SQLiteDebug.DbStats> getDbStats()
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = ActiveDatabases.getInstance().mActiveDatabases.iterator();
    while (localIterator.hasNext())
    {
      SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)((WeakReference)localIterator.next()).get();
      if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen()))
      {
        int j = localSQLiteDatabase.native_getDbLookaside();
        Object localObject = localSQLiteDatabase.getPath();
        int i = ((String)localObject).lastIndexOf("/");
        label91:
        label113:
        Pair localPair;
        long l;
        if (i != -1)
        {
          i++;
          String str1 = ((String)localObject).substring(i);
          ArrayList localArrayList2 = getAttachedDbs(localSQLiteDatabase);
          if (localArrayList2 == null) {
            continue;
          }
          i = 0;
          if (i < localArrayList2.size())
          {
            localPair = (Pair)localArrayList2.get(i);
            l = getPragmaVal(localSQLiteDatabase, (String)localPair.first + ".page_count;");
            if (i != 0) {
              break label213;
            }
            localObject = str1;
          }
        }
        label213:
        int k;
        do
        {
          if (l > 0L) {
            localArrayList1.add(new SQLiteDebug.DbStats((String)localObject, l, localSQLiteDatabase.getPageSize(), j));
          }
          i++;
          break label113;
          break;
          i = 0;
          break label91;
          k = 0;
          str2 = "  (attached) " + (String)localPair.first;
          localObject = str2;
          j = k;
        } while (((String)localPair.second).trim().length() <= 0);
        j = ((String)localPair.second).lastIndexOf("/");
        localObject = new StringBuilder().append(str2).append(" : ");
        String str2 = (String)localPair.second;
        if (j != -1) {
          j++;
        }
        for (;;)
        {
          localObject = str2.substring(j);
          j = k;
          break;
          j = 0;
        }
      }
    }
    return localArrayList1;
  }
  
  private String getPathForLogs()
  {
    if (this.mPathForLogs != null) {}
    for (String str = this.mPathForLogs;; str = null)
    {
      return str;
      if (this.mPath != null) {
        break;
      }
    }
    if (this.mPath.indexOf('@') == -1) {}
    for (this.mPathForLogs = this.mPath;; this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY"))
    {
      str = this.mPathForLogs;
      break;
    }
  }
  
  private static long getPragmaVal(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    long l1;
    if (!paramSQLiteDatabase.isOpen())
    {
      l1 = 0L;
      label9:
      return l1;
    }
    Object localObject = null;
    try
    {
      localSQLiteStatement = new net/sqlcipher/database/SQLiteStatement;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localSQLiteStatement.<init>(paramSQLiteDatabase, "PRAGMA " + paramString);
    }
    finally
    {
      try
      {
        long l2 = localSQLiteStatement.simpleQueryForLong();
        l1 = l2;
        if (localSQLiteStatement == null) {
          break label9;
        }
        localSQLiteStatement.close();
        l1 = l2;
        break label9;
      }
      finally
      {
        SQLiteStatement localSQLiteStatement;
        paramString = localSQLiteStatement;
      }
      paramSQLiteDatabase = finally;
      paramString = (String)localObject;
      if (paramString != null) {
        paramString.close();
      }
      throw paramSQLiteDatabase;
    }
  }
  
  private String getTime()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ").format(Long.valueOf(System.currentTimeMillis()));
  }
  
  private static void loadICUData(Context paramContext, File paramFile)
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(paramFile, "icu");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      Object localObject = new java/io/File;
      ((File)localObject).<init>(localFile, "icudt46l.dat");
      if (!((File)localObject).exists())
      {
        paramFile = new java/util/zip/ZipInputStream;
        paramFile.<init>(paramContext.getAssets().open("icudt46l.zip"));
        paramFile.getNextEntry();
        paramContext = new java/io/FileOutputStream;
        paramContext.<init>((File)localObject);
        localObject = new byte['Ѐ'];
        for (;;)
        {
          int i = paramFile.read((byte[])localObject);
          if (i <= 0) {
            break;
          }
          paramContext.write((byte[])localObject, 0, i);
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("Database", "Error copying icu data file", paramContext);
    }
    for (;;)
    {
      paramFile.close();
      paramContext.flush();
      paramContext.close();
    }
  }
  
  public static void loadLibs(Context paramContext)
  {
    loadLibs(paramContext, paramContext.getFilesDir());
  }
  
  public static void loadLibs(Context paramContext, File paramFile)
  {
    System.loadLibrary("stlport_shared");
    System.loadLibrary("sqlcipher_android");
    System.loadLibrary("database_sqlcipher");
    boolean bool = new File("/system/usr/icu/icudt46l.dat").exists();
    if (bool) {}
    for (String str = "/system/usr";; str = paramFile.getAbsolutePath())
    {
      setICURoot(str);
      if (!bool) {
        loadICUData(paramContext, paramFile);
      }
      return;
    }
  }
  
  private void lockForced()
  {
    this.mLock.lock();
    if ((SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) && (this.mLock.getHoldCount() == 1))
    {
      this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
      this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
    }
  }
  
  /* Error */
  private void markTableSyncable(String paramString1, String arg2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 677	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   4: new 236	java/lang/StringBuilder
    //   7: astore 5
    //   9: aload 5
    //   11: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   14: aload_0
    //   15: aload 5
    //   17: ldc_w 679
    //   20: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_3
    //   24: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 681
    //   30: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 684	net/sqlcipher/database/SQLiteDatabase:native_execSQL	(Ljava/lang/String;)V
    //   39: new 236	java/lang/StringBuilder
    //   42: astore 5
    //   44: aload 5
    //   46: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   49: aload_0
    //   50: aload 5
    //   52: ldc_w 686
    //   55: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_2
    //   59: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 688
    //   65: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 681
    //   75: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokevirtual 684	net/sqlcipher/database/SQLiteDatabase:native_execSQL	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: invokevirtual 691	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   88: new 14	net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo
    //   91: dup
    //   92: aload_3
    //   93: aload 4
    //   95: aload_2
    //   96: invokespecial 694	net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_0
    //   101: getfield 202	net/sqlcipher/database/SQLiteDatabase:mSyncUpdateInfo	Ljava/util/Map;
    //   104: astore_2
    //   105: aload_2
    //   106: monitorenter
    //   107: aload_0
    //   108: getfield 202	net/sqlcipher/database/SQLiteDatabase:mSyncUpdateInfo	Ljava/util/Map;
    //   111: aload_1
    //   112: aload_3
    //   113: invokeinterface 698 3 0
    //   118: pop
    //   119: aload_2
    //   120: monitorexit
    //   121: return
    //   122: astore_1
    //   123: aload_0
    //   124: invokevirtual 691	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_2
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	SQLiteDatabase
    //   0	134	1	paramString1	String
    //   0	134	3	paramString3	String
    //   0	134	4	paramString4	String
    //   7	44	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	84	122	finally
    //   107	121	129	finally
    //   130	132	129	finally
  }
  
  private native int native_getDbLookaside();
  
  private native void native_rawExecSQL(String paramString);
  
  private native int native_status(int paramInt, boolean paramBoolean);
  
  public static SQLiteDatabase openDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, 268435456, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase3 = new net/sqlcipher/database/SQLiteDatabase;
        localSQLiteDatabase3.<init>(paramString1, paramString2, paramCursorFactory, paramInt, paramSQLiteDatabaseHook);
        SQLiteDatabase localSQLiteDatabase1;
        Log.e("Database", "Deleting and re-creating corrupt database " + paramString1, localSQLiteDatabaseCorruptException1);
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException1)
      {
        try
        {
          if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
            localSQLiteDatabase3.enableSqlTracing(paramString1);
          }
          localSQLiteDatabase1 = localSQLiteDatabase3;
          if (SQLiteDebug.DEBUG_SQL_TIME)
          {
            localSQLiteDatabase3.enableSqlProfiling(paramString1);
            localSQLiteDatabase1 = localSQLiteDatabase3;
          }
          ActiveDatabases.getInstance().mActiveDatabases.add(new WeakReference(localSQLiteDatabase1));
          return localSQLiteDatabase1;
        }
        catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException2)
        {
          SQLiteDatabase localSQLiteDatabase2;
          for (;;) {}
        }
        localSQLiteDatabaseCorruptException1 = localSQLiteDatabaseCorruptException1;
      }
      if (!paramString1.equalsIgnoreCase(":memory")) {
        new File(paramString1).delete();
      }
      localSQLiteDatabase2 = new SQLiteDatabase(paramString1, paramString2, paramCursorFactory, paramInt, paramSQLiteDatabaseHook);
    }
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, String paramString, CursorFactory paramCursorFactory)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramString, paramCursorFactory, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, String paramString, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramString, paramCursorFactory, paramSQLiteDatabaseHook);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, 268435456, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, 268435456, paramSQLiteDatabaseHook);
  }
  
  public static native int releaseMemory();
  
  public static native void setICURoot(String paramString);
  
  private void unlockForced()
  {
    if ((SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) && (this.mLock.getHoldCount() == 1)) {
      checkLockHoldTime();
    }
    this.mLock.unlock();
  }
  
  public static void upgradeDatabaseFormatFromVersion1To2(File paramFile, String paramString)
    throws Exception
  {
    SQLiteDatabaseHook local1 = new SQLiteDatabaseHook()
    {
      public void postKey(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        paramAnonymousSQLiteDatabase.execSQL("PRAGMA cipher_default_use_hmac = on");
      }
      
      public void preKey(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        paramAnonymousSQLiteDatabase.execSQL("PRAGMA cipher_default_use_hmac = off");
      }
    };
    try
    {
      File localFile = File.createTempFile("temp", "db", paramFile.getParentFile());
      paramString = openOrCreateDatabase(paramFile, paramString, null, local1);
      paramString.rawExecSQL(String.format("ATTACH DATABASE '%s' as newdb", new Object[] { localFile.getAbsolutePath() }));
      paramString.rawExecSQL("SELECT sqlcipher_export('newdb')");
      paramString.rawExecSQL("DETACH DATABASE newdb");
      paramString.close();
      if (1 != 0)
      {
        paramFile.delete();
        localFile.renameTo(paramFile);
      }
      return;
    }
    catch (Exception paramFile)
    {
      throw paramFile;
    }
  }
  
  private boolean yieldIfContendedHelper(boolean paramBoolean, long paramLong)
  {
    if (this.mLock.getQueueLength() == 0)
    {
      this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
      this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
      paramBoolean = false;
    }
    for (;;)
    {
      return paramBoolean;
      setTransactionSuccessful();
      SQLiteTransactionListener localSQLiteTransactionListener = this.mTransactionListener;
      endTransaction();
      if ((paramBoolean) && (isDbLockedByCurrentThread())) {
        throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
      }
      label70:
      long l;
      if ((paramLong > 0L) && (paramLong > 0L))
      {
        if (paramLong >= 1000L) {
          break label119;
        }
        l = paramLong;
      }
      try
      {
        for (;;)
        {
          Thread.sleep(l);
          paramLong -= 1000L;
          if (this.mLock.getQueueLength() != 0) {
            break label70;
          }
          beginTransactionWithListener(localSQLiteTransactionListener);
          paramBoolean = true;
          break;
          label119:
          l = 1000L;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Thread.interrupted();
        }
      }
    }
  }
  
  void addSQLiteClosable(SQLiteClosable paramSQLiteClosable)
  {
    lock();
    try
    {
      this.mPrograms.put(paramSQLiteClosable, null);
      return;
    }
    finally
    {
      unlock();
    }
  }
  
  void addToCompiledQueries(String paramString, SQLiteCompiledSql paramSQLiteCompiledSql)
  {
    if (this.mMaxSqlCacheSize == 0) {
      if (SQLiteDebug.DEBUG_SQL_CACHE) {
        Log.v("Database", "|NOT adding_sql_to_cache|" + getPath() + "|" + paramString);
      }
    }
    for (;;)
    {
      return;
      synchronized (this.mCompiledQueries)
      {
        if ((SQLiteCompiledSql)this.mCompiledQueries.get(paramString) == null) {
          break;
        }
      }
    }
    if (this.mCompiledQueries.size() == this.mMaxSqlCacheSize)
    {
      int i = this.mCacheFullWarnings + 1;
      this.mCacheFullWarnings = i;
      if (i == 1)
      {
        paramSQLiteCompiledSql = new java/lang/StringBuilder;
        paramSQLiteCompiledSql.<init>();
        Log.w("Database", "Reached MAX size for compiled-sql statement cache for database " + getPath() + "; i.e., NO space for this sql statement in cache: " + paramString + ". Please change your sql statements to use '?' for " + "bindargs, instead of using actual values");
      }
    }
    for (;;)
    {
      break;
      this.mCompiledQueries.put(paramString, paramSQLiteCompiledSql);
      if (SQLiteDebug.DEBUG_SQL_CACHE)
      {
        paramSQLiteCompiledSql = new java/lang/StringBuilder;
        paramSQLiteCompiledSql.<init>();
        Log.v("Database", "|adding_sql_to_cache|" + getPath() + "|" + this.mCompiledQueries.size() + "|" + paramString);
      }
    }
  }
  
  public void beginTransaction()
  {
    beginTransactionWithListener(null);
  }
  
  public void beginTransactionWithListener(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    lockForced();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    try
    {
      if (this.mLock.getHoldCount() <= 1) {
        break label83;
      }
      if (this.mInnerTransactionIsSuccessful)
      {
        paramSQLiteTransactionListener = new java/lang/IllegalStateException;
        paramSQLiteTransactionListener.<init>("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
        Log.e("Database", "beginTransaction() failed", paramSQLiteTransactionListener);
        throw paramSQLiteTransactionListener;
      }
    }
    finally
    {
      if (0 == 0) {
        unlockForced();
      }
    }
    if (1 == 0) {
      unlockForced();
    }
    for (;;)
    {
      return;
      label83:
      execSQL("BEGIN EXCLUSIVE;");
      this.mTransactionListener = paramSQLiteTransactionListener;
      this.mTransactionIsSuccessful = true;
      this.mInnerTransactionIsSuccessful = false;
      if (paramSQLiteTransactionListener != null) {}
      try
      {
        paramSQLiteTransactionListener.onBegin();
        if (1 != 0) {
          continue;
        }
        unlockForced();
      }
      catch (RuntimeException paramSQLiteTransactionListener)
      {
        execSQL("ROLLBACK;");
        throw paramSQLiteTransactionListener;
      }
    }
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 424	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokevirtual 677	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   12: aload_0
    //   13: invokespecial 871	net/sqlcipher/database/SQLiteDatabase:closeClosable	()V
    //   16: aload_0
    //   17: invokevirtual 874	net/sqlcipher/database/SQLiteDatabase:onAllReferencesReleased	()V
    //   20: aload_0
    //   21: invokevirtual 691	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   24: goto -17 -> 7
    //   27: astore_1
    //   28: aload_0
    //   29: invokevirtual 691	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	SQLiteDatabase
    //   27	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	20	27	finally
  }
  
  public SQLiteStatement compileStatement(String paramString)
    throws SQLException
  {
    lock();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    try
    {
      paramString = new SQLiteStatement(this, paramString);
      return paramString;
    }
    finally
    {
      unlock();
    }
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    lock();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    Object localObject1 = localObject4;
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localObject2 = localObject3;
      localObject1 = localObject4;
      localStringBuilder.<init>();
      localObject2 = localObject3;
      localObject1 = localObject4;
      localStringBuilder = localStringBuilder.append("DELETE FROM ").append(paramString1);
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        paramString1 = new java/lang/StringBuilder;
        localObject2 = localObject3;
        localObject1 = localObject4;
        paramString1.<init>();
        localObject2 = localObject3;
        localObject1 = localObject4;
      }
      for (paramString1 = " WHERE " + paramString2;; paramString1 = "")
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        paramString1 = compileStatement(paramString1);
        if (paramArrayOfString == null) {
          break;
        }
        localObject2 = paramString1;
        localObject1 = paramString1;
        int j = paramArrayOfString.length;
        for (i = 0; i < j; i++)
        {
          localObject2 = paramString1;
          localObject1 = paramString1;
          DatabaseUtils.bindObjectToProgram(paramString1, i + 1, paramArrayOfString[i]);
        }
      }
      localObject2 = paramString1;
      localObject1 = paramString1;
      paramString1.execute();
      localObject2 = paramString1;
      localObject1 = paramString1;
      int i = lastChangeCount();
      if (paramString1 != null) {
        paramString1.close();
      }
      unlock();
      return i;
    }
    catch (SQLiteDatabaseCorruptException paramString1)
    {
      localObject1 = localObject2;
      onCorruption();
      localObject1 = localObject2;
      throw paramString1;
    }
    finally
    {
      if (localObject1 != null) {
        ((SQLiteStatement)localObject1).close();
      }
      unlock();
    }
  }
  
  public void endTransaction()
  {
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    if (!this.mLock.isHeldByCurrentThread()) {
      throw new IllegalStateException("no transaction pending");
    }
    try
    {
      if (this.mInnerTransactionIsSuccessful) {
        this.mInnerTransactionIsSuccessful = false;
      }
      for (;;)
      {
        int i = this.mLock.getHoldCount();
        if (i == 1) {
          break;
        }
        return;
        this.mTransactionIsSuccessful = false;
      }
      localObject3 = null;
    }
    finally
    {
      this.mTransactionListener = null;
      unlockForced();
    }
    Object localObject3;
    SQLiteTransactionListener localSQLiteTransactionListener = this.mTransactionListener;
    Object localObject2 = localObject3;
    if (localSQLiteTransactionListener != null) {}
    for (;;)
    {
      try
      {
        if (!this.mTransactionIsSuccessful) {
          continue;
        }
        this.mTransactionListener.onCommit();
        localObject2 = localObject3;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mTransactionIsSuccessful = false;
        continue;
        try
        {
          execSQL("ROLLBACK;");
          if (localRuntimeException == null) {
            continue;
          }
          throw localRuntimeException;
        }
        catch (SQLException localSQLException)
        {
          Log.d("Database", "exception during rollback, maybe the DB previously performed an auto-rollback");
        }
        continue;
      }
      if (!this.mTransactionIsSuccessful) {
        continue;
      }
      execSQL("COMMIT;");
      this.mTransactionListener = null;
      unlockForced();
      break;
      this.mTransactionListener.onRollback();
      localObject2 = localObject3;
    }
  }
  
  public void execSQL(String paramString)
    throws SQLException
  {
    long l = SystemClock.uptimeMillis();
    lock();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    logTimeStat(this.mLastSqlStatement, l, "GETLOCK:");
    for (;;)
    {
      try
      {
        native_execSQL(paramString);
        unlock();
        if (paramString == "COMMIT;")
        {
          logTimeStat(this.mLastSqlStatement, l, "COMMIT;");
          return;
        }
      }
      catch (SQLiteDatabaseCorruptException paramString)
      {
        throw paramString;
      }
      finally
      {
        unlock();
      }
      logTimeStat(paramString, l, null);
    }
  }
  
  public void execSQL(String paramString, Object[] paramArrayOfObject)
    throws SQLException
  {
    if (paramArrayOfObject == null) {
      throw new IllegalArgumentException("Empty bindArgs");
    }
    long l = SystemClock.uptimeMillis();
    lock();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      SQLiteStatement localSQLiteStatement = compileStatement(paramString);
      if (paramArrayOfObject != null)
      {
        localObject1 = localSQLiteStatement;
        localObject2 = localSQLiteStatement;
        int j = paramArrayOfObject.length;
        for (int i = 0; i < j; i++)
        {
          localObject1 = localSQLiteStatement;
          localObject2 = localSQLiteStatement;
          DatabaseUtils.bindObjectToProgram(localSQLiteStatement, i + 1, paramArrayOfObject[i]);
        }
      }
      localObject1 = localSQLiteStatement;
      localObject2 = localSQLiteStatement;
      localSQLiteStatement.execute();
      if (localSQLiteStatement != null) {
        localSQLiteStatement.close();
      }
      unlock();
      logTimeStat(paramString, l);
      return;
    }
    catch (SQLiteDatabaseCorruptException paramString)
    {
      localObject2 = localObject1;
      onCorruption();
      localObject2 = localObject1;
      throw paramString;
    }
    finally
    {
      if (localObject2 != null) {
        ((SQLiteStatement)localObject2).close();
      }
      unlock();
    }
  }
  
  protected void finalize()
  {
    if (isOpen())
    {
      Log.e("Database", "close() was never explicitly called on database '" + this.mPath + "' ", this.mStackTrace);
      closeClosable();
      onAllReferencesReleased();
    }
  }
  
  SQLiteCompiledSql getCompiledStatementForSql(String paramString)
  {
    for (;;)
    {
      synchronized (this.mCompiledQueries)
      {
        if (this.mMaxSqlCacheSize == 0)
        {
          if (SQLiteDebug.DEBUG_SQL_CACHE)
          {
            paramString = new java/lang/StringBuilder;
            paramString.<init>();
            Log.v("Database", "|cache NOT found|" + getPath());
          }
          paramString = null;
          return paramString;
        }
        SQLiteCompiledSql localSQLiteCompiledSql = (SQLiteCompiledSql)this.mCompiledQueries.get(paramString);
        boolean bool;
        if (localSQLiteCompiledSql != null)
        {
          bool = true;
          if (bool)
          {
            this.mNumCacheHits += 1;
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
              Log.v("Database", "|cache_stats|" + getPath() + "|" + this.mCompiledQueries.size() + "|" + this.mNumCacheHits + "|" + this.mNumCacheMisses + "|" + bool + "|" + this.mTimeOpened + "|" + this.mTimeClosed + "|" + paramString);
            }
            paramString = localSQLiteCompiledSql;
          }
        }
        else
        {
          bool = false;
        }
      }
      this.mNumCacheMisses += 1;
    }
  }
  
  public int getMaxSqlCacheSize()
  {
    try
    {
      int i = this.mMaxSqlCacheSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getMaximumSize()
  {
    localObject3 = null;
    lock();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    try
    {
      localSQLiteStatement = new net/sqlcipher/database/SQLiteStatement;
      localSQLiteStatement.<init>(this, "PRAGMA max_page_count;");
      long l1;
      long l2;
      if (localObject3 == null) {
        break label80;
      }
    }
    finally
    {
      try
      {
        l1 = localSQLiteStatement.simpleQueryForLong();
        l2 = getPageSize();
        if (localSQLiteStatement != null) {
          localSQLiteStatement.close();
        }
        unlock();
        return l2 * l1;
      }
      finally
      {
        SQLiteStatement localSQLiteStatement;
        localObject3 = localSQLiteStatement;
      }
      localObject1 = finally;
    }
    ((SQLiteStatement)localObject3).close();
    label80:
    unlock();
    throw ((Throwable)localObject1);
  }
  
  public long getPageSize()
  {
    localObject3 = null;
    lock();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    try
    {
      localSQLiteStatement = new net/sqlcipher/database/SQLiteStatement;
      localSQLiteStatement.<init>(this, "PRAGMA page_size;");
      long l;
      if (localObject3 == null) {
        break label72;
      }
    }
    finally
    {
      try
      {
        l = localSQLiteStatement.simpleQueryForLong();
        if (localSQLiteStatement != null) {
          localSQLiteStatement.close();
        }
        unlock();
        return l;
      }
      finally
      {
        SQLiteStatement localSQLiteStatement;
        localObject3 = localSQLiteStatement;
      }
      localObject1 = finally;
    }
    ((SQLiteStatement)localObject3).close();
    label72:
    unlock();
    throw ((Throwable)localObject1);
  }
  
  public final String getPath()
  {
    return this.mPath;
  }
  
  public Map<String, String> getSyncedTables()
  {
    HashMap localHashMap;
    synchronized (this.mSyncUpdateInfo)
    {
      localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      Iterator localIterator = this.mSyncUpdateInfo.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        SyncUpdateInfo localSyncUpdateInfo = (SyncUpdateInfo)this.mSyncUpdateInfo.get(str);
        if (localSyncUpdateInfo.deletedTable != null) {
          localHashMap.put(str, localSyncUpdateInfo.deletedTable);
        }
      }
    }
    return localHashMap;
  }
  
  public int getVersion()
  {
    localObject3 = null;
    lock();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    try
    {
      localSQLiteStatement = new net/sqlcipher/database/SQLiteStatement;
      localSQLiteStatement.<init>(this, "PRAGMA user_version;");
      long l;
      int i;
      if (localObject3 == null) {
        break label76;
      }
    }
    finally
    {
      try
      {
        l = localSQLiteStatement.simpleQueryForLong();
        i = (int)l;
        if (localSQLiteStatement != null) {
          localSQLiteStatement.close();
        }
        unlock();
        return i;
      }
      finally
      {
        SQLiteStatement localSQLiteStatement;
        localObject3 = localSQLiteStatement;
      }
      localObject1 = finally;
    }
    ((SQLiteStatement)localObject3).close();
    label76:
    unlock();
    throw ((Throwable)localObject1);
  }
  
  public boolean inTransaction()
  {
    if (this.mLock.getHoldCount() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
      return l;
    }
    catch (SQLException paramString1)
    {
      for (;;)
      {
        Log.e("Database", "Error inserting " + paramContentValues, paramString1);
        long l = -1L;
      }
    }
  }
  
  public long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
    throws SQLException
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
  }
  
  /* Error */
  public long insertWithOnConflict(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 424	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   4: ifne +14 -> 18
    //   7: new 416	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc_w 850
    //   14: invokespecial 419	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: new 236	java/lang/StringBuilder
    //   21: dup
    //   22: sipush 152
    //   25: invokespecial 981	java/lang/StringBuilder:<init>	(I)V
    //   28: astore 10
    //   30: aload 10
    //   32: ldc_w 983
    //   35: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 10
    //   41: getstatic 131	net/sqlcipher/database/SQLiteDatabase:CONFLICT_VALUES	[Ljava/lang/String;
    //   44: iload 4
    //   46: aaload
    //   47: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 10
    //   53: ldc_w 985
    //   56: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 10
    //   62: aload_1
    //   63: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: new 236	java/lang/StringBuilder
    //   70: dup
    //   71: bipush 40
    //   73: invokespecial 981	java/lang/StringBuilder:<init>	(I)V
    //   76: astore_1
    //   77: aconst_null
    //   78: astore 8
    //   80: aload_3
    //   81: ifnull +235 -> 316
    //   84: aload_3
    //   85: invokevirtual 988	android/content/ContentValues:size	()I
    //   88: ifle +228 -> 316
    //   91: aload_3
    //   92: invokevirtual 991	android/content/ContentValues:valueSet	()Ljava/util/Set;
    //   95: astore 8
    //   97: aload 8
    //   99: invokeinterface 353 1 0
    //   104: astore_2
    //   105: aload 10
    //   107: bipush 40
    //   109: invokevirtual 994	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: iconst_0
    //   114: istore 4
    //   116: aload_2
    //   117: invokeinterface 359 1 0
    //   122: ifeq +61 -> 183
    //   125: iload 4
    //   127: ifeq +20 -> 147
    //   130: aload 10
    //   132: ldc_w 996
    //   135: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_1
    //   140: ldc_w 996
    //   143: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: iconst_1
    //   148: istore 4
    //   150: aload 10
    //   152: aload_2
    //   153: invokeinterface 363 1 0
    //   158: checkcast 365	java/util/Map$Entry
    //   161: invokeinterface 368 1 0
    //   166: checkcast 117	java/lang/String
    //   169: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_1
    //   174: bipush 63
    //   176: invokevirtual 994	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: goto -64 -> 116
    //   183: aload 10
    //   185: bipush 41
    //   187: invokevirtual 994	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 10
    //   193: ldc_w 998
    //   196: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 10
    //   202: aload_1
    //   203: invokevirtual 1001	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 10
    //   209: ldc_w 1003
    //   212: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_0
    //   217: invokevirtual 677	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   220: aconst_null
    //   221: astore_2
    //   222: aconst_null
    //   223: astore_1
    //   224: aload_0
    //   225: aload 10
    //   227: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokevirtual 885	net/sqlcipher/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
    //   233: astore 9
    //   235: aload 8
    //   237: ifnull +122 -> 359
    //   240: aload 9
    //   242: astore_1
    //   243: aload 9
    //   245: astore_2
    //   246: aload 8
    //   248: invokeinterface 1004 1 0
    //   253: istore 5
    //   255: aload 9
    //   257: astore_1
    //   258: aload 9
    //   260: astore_2
    //   261: aload 8
    //   263: invokeinterface 353 1 0
    //   268: astore 8
    //   270: iconst_0
    //   271: istore 4
    //   273: iload 4
    //   275: iload 5
    //   277: if_icmpge +82 -> 359
    //   280: aload 9
    //   282: astore_1
    //   283: aload 9
    //   285: astore_2
    //   286: aload 9
    //   288: iload 4
    //   290: iconst_1
    //   291: iadd
    //   292: aload 8
    //   294: invokeinterface 363 1 0
    //   299: checkcast 365	java/util/Map$Entry
    //   302: invokeinterface 1007 1 0
    //   307: invokestatic 891	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
    //   310: iinc 4 1
    //   313: goto -40 -> 273
    //   316: aload 10
    //   318: new 236	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 1009
    //   328: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_2
    //   332: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc_w 1011
    //   338: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_1
    //   349: ldc_w 1013
    //   352: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: goto -165 -> 191
    //   359: aload 9
    //   361: astore_1
    //   362: aload 9
    //   364: astore_2
    //   365: aload 9
    //   367: invokevirtual 894	net/sqlcipher/database/SQLiteStatement:execute	()V
    //   370: aload 9
    //   372: astore_1
    //   373: aload 9
    //   375: astore_2
    //   376: aload_0
    //   377: invokevirtual 1016	net/sqlcipher/database/SQLiteDatabase:lastInsertRow	()J
    //   380: lstore 6
    //   382: lload 6
    //   384: ldc2_w 976
    //   387: lcmp
    //   388: ifne +80 -> 468
    //   391: aload 9
    //   393: astore_1
    //   394: aload 9
    //   396: astore_2
    //   397: new 236	java/lang/StringBuilder
    //   400: astore 8
    //   402: aload 9
    //   404: astore_1
    //   405: aload 9
    //   407: astore_2
    //   408: aload 8
    //   410: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   413: aload 9
    //   415: astore_1
    //   416: aload 9
    //   418: astore_2
    //   419: ldc 73
    //   421: aload 8
    //   423: ldc_w 972
    //   426: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_3
    //   430: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   433: ldc_w 1018
    //   436: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 10
    //   441: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 1020	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   450: pop
    //   451: aload 9
    //   453: ifnull +8 -> 461
    //   456: aload 9
    //   458: invokevirtual 552	net/sqlcipher/database/SQLiteStatement:close	()V
    //   461: aload_0
    //   462: invokevirtual 691	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   465: lload 6
    //   467: lreturn
    //   468: aload 9
    //   470: astore_1
    //   471: aload 9
    //   473: astore_2
    //   474: ldc 73
    //   476: iconst_2
    //   477: invokestatic 302	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   480: ifeq -29 -> 451
    //   483: aload 9
    //   485: astore_1
    //   486: aload 9
    //   488: astore_2
    //   489: new 236	java/lang/StringBuilder
    //   492: astore 8
    //   494: aload 9
    //   496: astore_1
    //   497: aload 9
    //   499: astore_2
    //   500: aload 8
    //   502: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   505: aload 9
    //   507: astore_1
    //   508: aload 9
    //   510: astore_2
    //   511: ldc 73
    //   513: aload 8
    //   515: ldc_w 1022
    //   518: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: lload 6
    //   523: invokevirtual 320	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   526: ldc_w 1024
    //   529: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_3
    //   533: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   536: ldc_w 1018
    //   539: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload 10
    //   544: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 826	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   553: pop
    //   554: goto -103 -> 451
    //   557: astore_3
    //   558: aload_1
    //   559: astore_2
    //   560: aload_0
    //   561: invokevirtual 900	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   564: aload_1
    //   565: astore_2
    //   566: aload_3
    //   567: athrow
    //   568: astore_1
    //   569: aload_2
    //   570: ifnull +7 -> 577
    //   573: aload_2
    //   574: invokevirtual 552	net/sqlcipher/database/SQLiteStatement:close	()V
    //   577: aload_0
    //   578: invokevirtual 691	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   581: aload_1
    //   582: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	SQLiteDatabase
    //   0	583	1	paramString1	String
    //   0	583	2	paramString2	String
    //   0	583	3	paramContentValues	ContentValues
    //   0	583	4	paramInt	int
    //   253	25	5	i	int
    //   380	142	6	l	long
    //   78	436	8	localObject	Object
    //   233	276	9	localSQLiteStatement	SQLiteStatement
    //   28	515	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   224	235	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   246	255	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   261	270	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   286	310	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   365	370	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   376	382	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   397	402	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   408	413	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   419	451	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   474	483	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   489	494	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   500	505	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   511	554	557	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   224	235	568	finally
    //   246	255	568	finally
    //   261	270	568	finally
    //   286	310	568	finally
    //   365	370	568	finally
    //   376	382	568	finally
    //   397	402	568	finally
    //   408	413	568	finally
    //   419	451	568	finally
    //   474	483	568	finally
    //   489	494	568	finally
    //   500	505	568	finally
    //   511	554	568	finally
    //   560	564	568	finally
    //   566	568	568	finally
  }
  
  public boolean isDbLockedByCurrentThread()
  {
    return this.mLock.isHeldByCurrentThread();
  }
  
  public boolean isDbLockedByOtherThreads()
  {
    if ((!this.mLock.isHeldByCurrentThread()) && (this.mLock.isLocked())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isInCompiledSqlCache(String paramString)
  {
    synchronized (this.mCompiledQueries)
    {
      boolean bool = this.mCompiledQueries.containsKey(paramString);
      return bool;
    }
  }
  
  public boolean isOpen()
  {
    if (this.mNativeHandle != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isReadOnly()
  {
    boolean bool = true;
    if ((this.mFlags & 0x1) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  native int lastChangeCount();
  
  native long lastInsertRow();
  
  void lock()
  {
    if (!this.mLockingEnabled) {}
    for (;;)
    {
      return;
      this.mLock.lock();
      if ((SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) && (this.mLock.getHoldCount() == 1))
      {
        this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
        this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
      }
    }
  }
  
  void logTimeStat(String paramString, long paramLong)
  {
    logTimeStat(paramString, paramLong, null);
  }
  
  void logTimeStat(String paramString1, long paramLong, String paramString2)
  {
    this.mLastSqlStatement = paramString1;
    paramLong = SystemClock.uptimeMillis() - paramLong;
    if ((paramLong == 0L) && (paramString2 == "GETLOCK:")) {}
    for (;;)
    {
      return;
      if (sQueryLogTimeInMillis == 0) {
        sQueryLogTimeInMillis = 500;
      }
      if (paramLong >= sQueryLogTimeInMillis) {}
      int i;
      do
      {
        String str = paramString1;
        if (paramString2 != null) {
          str = paramString2 + paramString1;
        }
        if (str.length() > 64) {
          str.substring(0, 64);
        }
        if ("unknown" != null) {
          break;
        }
        break;
        i = (int)(100L * paramLong / sQueryLogTimeInMillis);
      } while (this.mRandom.nextInt(100) < i + 1);
    }
  }
  
  public void markTableSyncable(String paramString1, String paramString2)
  {
    markTableSyncable(paramString1, "_id", paramString1, paramString2);
  }
  
  public void markTableSyncable(String paramString1, String paramString2, String paramString3)
  {
    markTableSyncable(paramString1, paramString2, paramString3, null);
  }
  
  native void native_execSQL(String paramString)
    throws SQLException;
  
  native void native_setLocale(String paramString, int paramInt);
  
  public boolean needUpgrade(int paramInt)
  {
    if (paramInt > getVersion()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void onAllReferencesReleased()
  {
    if (isOpen())
    {
      if (SQLiteDebug.DEBUG_SQL_CACHE) {
        this.mTimeClosed = getTime();
      }
      dbclose();
    }
  }
  
  void onCorruption()
  {
    Log.e("Database", "Removing corrupt database: " + this.mPath);
    try
    {
      close();
      return;
    }
    finally
    {
      if (!this.mPath.equalsIgnoreCase(":memory")) {
        new File(this.mPath).delete();
      }
    }
  }
  
  public void purgeFromCompiledSqlCache(String paramString)
  {
    synchronized (this.mCompiledQueries)
    {
      this.mCompiledQueries.remove(paramString);
      return;
    }
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, null);
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    return rawQueryWithFactory(paramCursorFactory, SQLiteQueryBuilder.buildQueryString(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4, paramString5, paramString6), paramArrayOfString2, findEditTable(paramString1));
  }
  
  public void rawExecSQL(String paramString)
  {
    long l = SystemClock.uptimeMillis();
    lock();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    logTimeStat(this.mLastSqlStatement, l, "GETLOCK:");
    for (;;)
    {
      try
      {
        native_rawExecSQL(paramString);
        unlock();
        if (paramString == "COMMIT;")
        {
          logTimeStat(this.mLastSqlStatement, l, "COMMIT;");
          return;
        }
      }
      catch (SQLiteDatabaseCorruptException paramString)
      {
        throw paramString;
      }
      finally
      {
        unlock();
      }
      logTimeStat(paramString, l, null);
    }
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return rawQueryWithFactory(null, paramString, paramArrayOfString, null);
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    paramString = (SQLiteCursor)rawQueryWithFactory(null, paramString, paramArrayOfString, null);
    paramString.setLoadStyle(paramInt1, paramInt2);
    return paramString;
  }
  
  public Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    l = 0L;
    if (this.mSlowQueryThreshold != -1) {
      l = System.currentTimeMillis();
    }
    paramString1 = new SQLiteDirectCursorDriver(this, paramString1, paramString2);
    if (paramCursorFactory != null) {}
    for (;;)
    {
      try
      {
        paramString2 = paramString1.query(paramCursorFactory, paramArrayOfString);
        if (this.mSlowQueryThreshold == -1) {
          continue;
        }
        i = -1;
        if (paramString2 != null) {
          i = paramString2.getCount();
        }
        l = System.currentTimeMillis() - l;
        if (l < this.mSlowQueryThreshold) {
          continue;
        }
        paramString1 = new StringBuilder().append("query (").append(l).append(" ms): ").append(paramString1.toString()).append(", args are ");
        if (paramArrayOfString == null) {
          continue;
        }
        paramCursorFactory = TextUtils.join(",", paramArrayOfString);
      }
      finally
      {
        int i;
        if (this.mSlowQueryThreshold == -1) {
          continue;
        }
        if (0 == 0) {
          continue;
        }
        throw new NullPointerException();
        l = System.currentTimeMillis() - l;
        if (l < this.mSlowQueryThreshold) {
          continue;
        }
        paramString1 = new StringBuilder().append("query (").append(l).append(" ms): ").append(paramString1.toString()).append(", args are ");
        if (paramArrayOfString == null) {
          continue;
        }
        paramCursorFactory = TextUtils.join(",", paramArrayOfString);
        continue;
        paramCursorFactory = "<null>";
        continue;
      }
      Log.v("Database", paramCursorFactory + ", count is " + i);
      return new CrossProcessCursorWrapper(paramString2);
      paramCursorFactory = this.mFactory;
    }
    paramCursorFactory = "<null>";
    Log.v("Database", paramCursorFactory + ", count is " + -1);
    throw paramString2;
  }
  
  void removeSQLiteClosable(SQLiteClosable paramSQLiteClosable)
  {
    lock();
    try
    {
      this.mPrograms.remove(paramSQLiteClosable);
      return;
    }
    finally
    {
      unlock();
    }
  }
  
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
      return l;
    }
    catch (SQLException paramString1)
    {
      for (;;)
      {
        Log.e("Database", "Error inserting " + paramContentValues, paramString1);
        long l = -1L;
      }
    }
  }
  
  public long replaceOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
    throws SQLException
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
  }
  
  public void resetCompiledSqlCache()
  {
    synchronized (this.mCompiledQueries)
    {
      this.mCompiledQueries.clear();
      return;
    }
  }
  
  void rowUpdated(String paramString, long paramLong)
  {
    synchronized (this.mSyncUpdateInfo)
    {
      SyncUpdateInfo localSyncUpdateInfo = (SyncUpdateInfo)this.mSyncUpdateInfo.get(paramString);
      if (localSyncUpdateInfo != null) {
        execSQL("UPDATE " + localSyncUpdateInfo.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + localSyncUpdateInfo.foreignKey + " FROM " + paramString + " WHERE _id=" + paramLong + ")");
      }
      return;
    }
  }
  
  public void setLocale(Locale paramLocale)
  {
    lock();
    try
    {
      native_setLocale(paramLocale.toString(), this.mFlags);
      return;
    }
    finally
    {
      unlock();
    }
  }
  
  public void setLockingEnabled(boolean paramBoolean)
  {
    this.mLockingEnabled = paramBoolean;
  }
  
  public void setMaxSqlCacheSize(int paramInt)
  {
    if ((paramInt > 250) || (paramInt < 0)) {
      try
      {
        IllegalStateException localIllegalStateException1 = new java/lang/IllegalStateException;
        localIllegalStateException1.<init>("expected value between 0 and 250");
        throw localIllegalStateException1;
      }
      finally {}
    }
    if (paramInt < this.mMaxSqlCacheSize)
    {
      IllegalStateException localIllegalStateException2 = new java/lang/IllegalStateException;
      localIllegalStateException2.<init>("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
      throw localIllegalStateException2;
    }
    this.mMaxSqlCacheSize = paramInt;
  }
  
  public long setMaximumSize(long paramLong)
  {
    localObject3 = null;
    lock();
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    try
    {
      long l3 = getPageSize();
      long l2 = paramLong / l3;
      long l1 = l2;
      if (paramLong % l3 != 0L) {
        l1 = l2 + 1L;
      }
      localSQLiteStatement = new net/sqlcipher/database/SQLiteStatement;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localSQLiteStatement.<init>(this, "PRAGMA max_page_count = " + l1);
      if (localObject3 == null) {
        break label127;
      }
    }
    finally
    {
      try
      {
        paramLong = localSQLiteStatement.simpleQueryForLong();
        if (localSQLiteStatement != null) {
          localSQLiteStatement.close();
        }
        unlock();
        return paramLong * l3;
      }
      finally
      {
        SQLiteStatement localSQLiteStatement;
        localObject3 = localSQLiteStatement;
      }
      localObject1 = finally;
    }
    ((SQLiteStatement)localObject3).close();
    label127:
    unlock();
    throw ((Throwable)localObject1);
  }
  
  public void setPageSize(long paramLong)
  {
    execSQL("PRAGMA page_size = " + paramLong);
  }
  
  public void setTransactionSuccessful()
  {
    if (!isOpen()) {
      throw new IllegalStateException("database not open");
    }
    if (!this.mLock.isHeldByCurrentThread()) {
      throw new IllegalStateException("no transaction pending");
    }
    if (this.mInnerTransactionIsSuccessful) {
      throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
    }
    this.mInnerTransactionIsSuccessful = true;
  }
  
  public void setVersion(int paramInt)
  {
    execSQL("PRAGMA user_version = " + paramInt);
  }
  
  public int status(int paramInt, boolean paramBoolean)
  {
    return native_status(paramInt, paramBoolean);
  }
  
  void unlock()
  {
    if (!this.mLockingEnabled) {}
    for (;;)
    {
      return;
      if ((SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) && (this.mLock.getHoldCount() == 1)) {
        checkLockHoldTime();
      }
      this.mLock.unlock();
    }
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return updateWithOnConflict(paramString1, paramContentValues, paramString2, paramArrayOfString, 0);
  }
  
  /* Error */
  public int updateWithOnConflict(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokevirtual 988	android/content/ContentValues:size	()I
    //   8: ifne +14 -> 22
    //   11: new 204	java/lang/IllegalArgumentException
    //   14: dup
    //   15: ldc_w 1177
    //   18: invokespecial 209	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: new 236	java/lang/StringBuilder
    //   25: dup
    //   26: bipush 120
    //   28: invokespecial 981	java/lang/StringBuilder:<init>	(I)V
    //   31: astore 10
    //   33: aload 10
    //   35: ldc_w 1133
    //   38: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 10
    //   44: getstatic 131	net/sqlcipher/database/SQLiteDatabase:CONFLICT_VALUES	[Ljava/lang/String;
    //   47: iload 5
    //   49: aaload
    //   50: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 10
    //   56: aload_1
    //   57: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 10
    //   63: ldc_w 1179
    //   66: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: invokevirtual 991	android/content/ContentValues:valueSet	()Ljava/util/Set;
    //   74: astore 11
    //   76: aload 11
    //   78: invokeinterface 353 1 0
    //   83: astore_1
    //   84: aload_1
    //   85: invokeinterface 359 1 0
    //   90: ifeq +56 -> 146
    //   93: aload 10
    //   95: aload_1
    //   96: invokeinterface 363 1 0
    //   101: checkcast 365	java/util/Map$Entry
    //   104: invokeinterface 368 1 0
    //   109: checkcast 117	java/lang/String
    //   112: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 10
    //   118: ldc_w 1181
    //   121: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: invokeinterface 359 1 0
    //   131: ifeq -47 -> 84
    //   134: aload 10
    //   136: ldc_w 996
    //   139: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: goto -59 -> 84
    //   146: aload_3
    //   147: invokestatic 406	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +19 -> 169
    //   153: aload 10
    //   155: ldc_w 883
    //   158: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 10
    //   164: aload_3
    //   165: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_0
    //   170: invokevirtual 677	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   173: aload_0
    //   174: invokevirtual 424	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   177: ifne +14 -> 191
    //   180: new 416	java/lang/IllegalStateException
    //   183: dup
    //   184: ldc_w 850
    //   187: invokespecial 419	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: aconst_null
    //   192: astore_1
    //   193: aconst_null
    //   194: astore 8
    //   196: aconst_null
    //   197: astore_3
    //   198: aload_0
    //   199: aload 10
    //   201: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokevirtual 885	net/sqlcipher/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
    //   207: astore 9
    //   209: aload 9
    //   211: astore_3
    //   212: aload 9
    //   214: astore_1
    //   215: aload 9
    //   217: astore 8
    //   219: aload 11
    //   221: invokeinterface 1004 1 0
    //   226: istore 7
    //   228: aload 9
    //   230: astore_3
    //   231: aload 9
    //   233: astore_1
    //   234: aload 9
    //   236: astore 8
    //   238: aload 11
    //   240: invokeinterface 353 1 0
    //   245: astore 11
    //   247: iconst_1
    //   248: istore 5
    //   250: iconst_0
    //   251: istore 6
    //   253: iload 6
    //   255: iload 7
    //   257: if_icmpge +44 -> 301
    //   260: aload 9
    //   262: astore_3
    //   263: aload 9
    //   265: astore_1
    //   266: aload 9
    //   268: astore 8
    //   270: aload 9
    //   272: iload 5
    //   274: aload 11
    //   276: invokeinterface 363 1 0
    //   281: checkcast 365	java/util/Map$Entry
    //   284: invokeinterface 1007 1 0
    //   289: invokestatic 891	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
    //   292: iinc 5 1
    //   295: iinc 6 1
    //   298: goto -45 -> 253
    //   301: aload 4
    //   303: ifnull +59 -> 362
    //   306: aload 9
    //   308: astore_3
    //   309: aload 9
    //   311: astore_1
    //   312: aload 9
    //   314: astore 8
    //   316: aload 4
    //   318: arraylength
    //   319: istore 7
    //   321: iconst_0
    //   322: istore 6
    //   324: iload 6
    //   326: iload 7
    //   328: if_icmpge +34 -> 362
    //   331: aload 9
    //   333: astore_3
    //   334: aload 9
    //   336: astore_1
    //   337: aload 9
    //   339: astore 8
    //   341: aload 9
    //   343: iload 5
    //   345: aload 4
    //   347: iload 6
    //   349: aaload
    //   350: invokevirtual 1185	net/sqlcipher/database/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   353: iinc 5 1
    //   356: iinc 6 1
    //   359: goto -35 -> 324
    //   362: aload 9
    //   364: astore_3
    //   365: aload 9
    //   367: astore_1
    //   368: aload 9
    //   370: astore 8
    //   372: aload 9
    //   374: invokevirtual 894	net/sqlcipher/database/SQLiteStatement:execute	()V
    //   377: aload 9
    //   379: astore_3
    //   380: aload 9
    //   382: astore_1
    //   383: aload 9
    //   385: astore 8
    //   387: aload_0
    //   388: invokevirtual 897	net/sqlcipher/database/SQLiteDatabase:lastChangeCount	()I
    //   391: istore 5
    //   393: aload 9
    //   395: astore_3
    //   396: aload 9
    //   398: astore_1
    //   399: aload 9
    //   401: astore 8
    //   403: ldc 73
    //   405: iconst_2
    //   406: invokestatic 302	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   409: ifeq +86 -> 495
    //   412: aload 9
    //   414: astore_3
    //   415: aload 9
    //   417: astore_1
    //   418: aload 9
    //   420: astore 8
    //   422: new 236	java/lang/StringBuilder
    //   425: astore 4
    //   427: aload 9
    //   429: astore_3
    //   430: aload 9
    //   432: astore_1
    //   433: aload 9
    //   435: astore 8
    //   437: aload 4
    //   439: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   442: aload 9
    //   444: astore_3
    //   445: aload 9
    //   447: astore_1
    //   448: aload 9
    //   450: astore 8
    //   452: ldc 73
    //   454: aload 4
    //   456: ldc_w 1187
    //   459: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: iload 5
    //   464: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: ldc_w 1018
    //   470: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_2
    //   474: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   477: ldc_w 1189
    //   480: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload 10
    //   485: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 826	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   494: pop
    //   495: aload 9
    //   497: ifnull +8 -> 505
    //   500: aload 9
    //   502: invokevirtual 552	net/sqlcipher/database/SQLiteStatement:close	()V
    //   505: aload_0
    //   506: invokevirtual 691	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   509: iload 5
    //   511: ireturn
    //   512: astore_2
    //   513: aload_3
    //   514: astore_1
    //   515: aload_0
    //   516: invokevirtual 900	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   519: aload_3
    //   520: astore_1
    //   521: aload_2
    //   522: athrow
    //   523: astore_2
    //   524: aload_1
    //   525: ifnull +7 -> 532
    //   528: aload_1
    //   529: invokevirtual 552	net/sqlcipher/database/SQLiteStatement:close	()V
    //   532: aload_0
    //   533: invokevirtual 691	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   536: aload_2
    //   537: athrow
    //   538: astore 4
    //   540: aload 8
    //   542: astore_1
    //   543: new 236	java/lang/StringBuilder
    //   546: astore_3
    //   547: aload 8
    //   549: astore_1
    //   550: aload_3
    //   551: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   554: aload 8
    //   556: astore_1
    //   557: ldc 73
    //   559: aload_3
    //   560: ldc_w 1191
    //   563: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_2
    //   567: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   570: ldc_w 1018
    //   573: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 10
    //   578: invokevirtual 975	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 1020	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   587: pop
    //   588: aload 8
    //   590: astore_1
    //   591: aload 4
    //   593: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	SQLiteDatabase
    //   0	594	1	paramString1	String
    //   0	594	2	paramContentValues	ContentValues
    //   0	594	3	paramString2	String
    //   0	594	4	paramArrayOfString	String[]
    //   0	594	5	paramInt	int
    //   251	106	6	i	int
    //   226	103	7	j	int
    //   194	395	8	localObject1	Object
    //   207	294	9	localSQLiteStatement	SQLiteStatement
    //   31	546	10	localStringBuilder	StringBuilder
    //   74	201	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   198	209	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   219	228	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   238	247	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   270	292	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   316	321	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   341	353	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   372	377	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   387	393	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   403	412	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   422	427	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   437	442	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   452	495	512	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   198	209	523	finally
    //   219	228	523	finally
    //   238	247	523	finally
    //   270	292	523	finally
    //   316	321	523	finally
    //   341	353	523	finally
    //   372	377	523	finally
    //   387	393	523	finally
    //   403	412	523	finally
    //   422	427	523	finally
    //   437	442	523	finally
    //   452	495	523	finally
    //   515	519	523	finally
    //   521	523	523	finally
    //   543	547	523	finally
    //   550	554	523	finally
    //   557	588	523	finally
    //   591	594	523	finally
    //   198	209	538	net/sqlcipher/SQLException
    //   219	228	538	net/sqlcipher/SQLException
    //   238	247	538	net/sqlcipher/SQLException
    //   270	292	538	net/sqlcipher/SQLException
    //   316	321	538	net/sqlcipher/SQLException
    //   341	353	538	net/sqlcipher/SQLException
    //   372	377	538	net/sqlcipher/SQLException
    //   387	393	538	net/sqlcipher/SQLException
    //   403	412	538	net/sqlcipher/SQLException
    //   422	427	538	net/sqlcipher/SQLException
    //   437	442	538	net/sqlcipher/SQLException
    //   452	495	538	net/sqlcipher/SQLException
  }
  
  @Deprecated
  public boolean yieldIfContended()
  {
    return yieldIfContendedHelper(false, -1L);
  }
  
  public boolean yieldIfContendedSafely()
  {
    return yieldIfContendedHelper(true, -1L);
  }
  
  public boolean yieldIfContendedSafely(long paramLong)
  {
    return yieldIfContendedHelper(true, paramLong);
  }
  
  static class ActiveDatabases
  {
    private static final ActiveDatabases activeDatabases = new ActiveDatabases();
    private HashSet<WeakReference<SQLiteDatabase>> mActiveDatabases = new HashSet();
    
    static ActiveDatabases getInstance()
    {
      return activeDatabases;
    }
  }
  
  public static abstract interface CursorFactory
  {
    public abstract Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery);
  }
  
  private static class SyncUpdateInfo
  {
    String deletedTable;
    String foreignKey;
    String masterTable;
    
    SyncUpdateInfo(String paramString1, String paramString2, String paramString3)
    {
      this.masterTable = paramString1;
      this.deletedTable = paramString2;
      this.foreignKey = paramString3;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */