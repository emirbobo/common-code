package net.sqlcipher.database;

import android.util.Log;

class SQLiteCompiledSql
{
  private static final String TAG = "SQLiteCompiledSql";
  SQLiteDatabase mDatabase;
  private boolean mInUse = false;
  private String mSqlStmt = null;
  private Throwable mStackTrace = null;
  int nHandle = 0;
  int nStatement = 0;
  
  SQLiteCompiledSql(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (!paramSQLiteDatabase.isOpen()) {
      throw new IllegalStateException("database " + paramSQLiteDatabase.getPath() + " already closed");
    }
    this.mDatabase = paramSQLiteDatabase;
    this.mSqlStmt = paramString;
    this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    this.nHandle = paramSQLiteDatabase.mNativeHandle;
    compile(paramString, true);
  }
  
  private void compile(String paramString, boolean paramBoolean)
  {
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    if (paramBoolean) {
      this.mDatabase.lock();
    }
    try
    {
      native_compile(paramString);
      return;
    }
    finally
    {
      this.mDatabase.unlock();
    }
  }
  
  private final native void native_compile(String paramString);
  
  private final native void native_finalize();
  
  /* Error */
  boolean acquire()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 33	net/sqlcipher/database/SQLiteCompiledSql:mInUse	Z
    //   8: istore_1
    //   9: iload_1
    //   10: ifeq +9 -> 19
    //   13: iconst_0
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 33	net/sqlcipher/database/SQLiteCompiledSql:mInUse	Z
    //   24: iload_2
    //   25: istore_1
    //   26: getstatic 95	net/sqlcipher/database/SQLiteDebug:DEBUG_ACTIVE_CURSOR_FINALIZATION	Z
    //   29: ifeq -14 -> 15
    //   32: new 43	java/lang/StringBuilder
    //   35: astore_3
    //   36: aload_3
    //   37: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   40: ldc 8
    //   42: aload_3
    //   43: ldc 97
    //   45: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 27	net/sqlcipher/database/SQLiteCompiledSql:nStatement	I
    //   52: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc 102
    //   57: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 108	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: iload_2
    //   68: istore_1
    //   69: goto -54 -> 15
    //   72: astore_3
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_3
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	SQLiteCompiledSql
    //   8	61	1	bool1	boolean
    //   1	67	2	bool2	boolean
    //   35	8	3	localStringBuilder	StringBuilder
    //   72	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	72	finally
    //   19	24	72	finally
    //   26	67	72	finally
  }
  
  /* Error */
  protected void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	net/sqlcipher/database/SQLiteCompiledSql:nStatement	I
    //   4: istore_1
    //   5: iload_1
    //   6: ifne +8 -> 14
    //   9: aload_0
    //   10: invokespecial 113	java/lang/Object:finalize	()V
    //   13: return
    //   14: getstatic 95	net/sqlcipher/database/SQLiteDebug:DEBUG_ACTIVE_CURSOR_FINALIZATION	Z
    //   17: ifeq +38 -> 55
    //   20: new 43	java/lang/StringBuilder
    //   23: astore_3
    //   24: aload_3
    //   25: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   28: ldc 8
    //   30: aload_3
    //   31: ldc 115
    //   33: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 27	net/sqlcipher/database/SQLiteCompiledSql:nStatement	I
    //   40: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: ldc 117
    //   45: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 108	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   54: pop
    //   55: aload_0
    //   56: getfield 29	net/sqlcipher/database/SQLiteCompiledSql:mSqlStmt	Ljava/lang/String;
    //   59: invokevirtual 123	java/lang/String:length	()I
    //   62: istore_2
    //   63: new 43	java/lang/StringBuilder
    //   66: astore_3
    //   67: aload_3
    //   68: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   71: aload_3
    //   72: ldc 125
    //   74: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: astore_3
    //   78: aload_0
    //   79: getfield 29	net/sqlcipher/database/SQLiteCompiledSql:mSqlStmt	Ljava/lang/String;
    //   82: astore 4
    //   84: iload_2
    //   85: istore_1
    //   86: iload_2
    //   87: bipush 100
    //   89: if_icmple +6 -> 95
    //   92: bipush 100
    //   94: istore_1
    //   95: ldc 8
    //   97: aload_3
    //   98: aload 4
    //   100: iconst_0
    //   101: iload_1
    //   102: invokevirtual 129	java/lang/String:substring	(II)Ljava/lang/String;
    //   105: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aload_0
    //   112: getfield 31	net/sqlcipher/database/SQLiteCompiledSql:mStackTrace	Ljava/lang/Throwable;
    //   115: invokestatic 133	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   118: pop
    //   119: aload_0
    //   120: invokevirtual 136	net/sqlcipher/database/SQLiteCompiledSql:releaseSqlStatement	()V
    //   123: goto -114 -> 9
    //   126: astore_3
    //   127: aload_0
    //   128: invokespecial 113	java/lang/Object:finalize	()V
    //   131: aload_3
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	SQLiteCompiledSql
    //   4	98	1	i	int
    //   62	28	2	j	int
    //   23	75	3	localStringBuilder	StringBuilder
    //   126	6	3	localObject	Object
    //   82	17	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	5	126	finally
    //   14	55	126	finally
    //   55	84	126	finally
    //   95	123	126	finally
  }
  
  void release()
  {
    try
    {
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        Log.v("SQLiteCompiledSql", "Released DbObj (id#" + this.nStatement + ") back to DB cache");
      }
      this.mInUse = false;
      return;
    }
    finally {}
  }
  
  void releaseSqlStatement()
  {
    if (this.nStatement != 0) {
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
        Log.v("SQLiteCompiledSql", "closed and deallocated DbObj (id#" + this.nStatement + ")");
      }
    }
    try
    {
      this.mDatabase.lock();
      native_finalize();
      this.nStatement = 0;
      return;
    }
    finally
    {
      this.mDatabase.unlock();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteCompiledSql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */