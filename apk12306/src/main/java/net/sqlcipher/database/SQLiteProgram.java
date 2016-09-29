package net.sqlcipher.database;

import android.util.Log;
import java.util.Map;

public abstract class SQLiteProgram
  extends SQLiteClosable
{
  private static final String TAG = "SQLiteProgram";
  private SQLiteCompiledSql mCompiledSql;
  @Deprecated
  protected SQLiteDatabase mDatabase;
  final String mSql;
  @Deprecated
  protected int nHandle = 0;
  @Deprecated
  protected int nStatement = 0;
  
  SQLiteProgram(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mSql = paramString.trim();
    paramSQLiteDatabase.acquireReference();
    paramSQLiteDatabase.addSQLiteClosable(this);
    this.nHandle = paramSQLiteDatabase.mNativeHandle;
    String str = this.mSql.substring(0, 6);
    if ((!str.equalsIgnoreCase("INSERT")) && (!str.equalsIgnoreCase("UPDATE")) && (!str.equalsIgnoreCase("REPLAC")) && (!str.equalsIgnoreCase("DELETE")) && (!str.equalsIgnoreCase("SELECT")))
    {
      this.mCompiledSql = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      this.nStatement = this.mCompiledSql.nStatement;
      return;
    }
    this.mCompiledSql = paramSQLiteDatabase.getCompiledStatementForSql(paramString);
    if (this.mCompiledSql == null)
    {
      this.mCompiledSql = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      this.mCompiledSql.acquire();
      paramSQLiteDatabase.addToCompiledQueries(paramString, this.mCompiledSql);
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
        Log.v("SQLiteProgram", "Created DbObj (id#" + this.mCompiledSql.nStatement + ") for sql: " + paramString);
      }
    }
    for (;;)
    {
      this.nStatement = this.mCompiledSql.nStatement;
      break;
      if (!this.mCompiledSql.acquire())
      {
        int i = this.mCompiledSql.nStatement;
        this.mCompiledSql = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
          Log.v("SQLiteProgram", "** possible bug ** Created NEW DbObj (id#" + this.mCompiledSql.nStatement + ") because the previously created DbObj (id#" + i + ") was not released for sql:" + paramString);
        }
      }
    }
  }
  
  private final native void native_clear_bindings();
  
  private void releaseCompiledSqlIfNotInCache()
  {
    if (this.mCompiledSql == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.mDatabase.mCompiledQueries)
      {
        if (!this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql))
        {
          this.mCompiledSql.releaseSqlStatement();
          this.mCompiledSql = null;
          this.nStatement = 0;
        }
      }
      this.mCompiledSql.release();
    }
  }
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("the bind value at index " + paramInt + " is null");
    }
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    acquireReference();
    try
    {
      native_bind_blob(paramInt, paramArrayOfByte);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    acquireReference();
    try
    {
      native_bind_double(paramInt, paramDouble);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    acquireReference();
    try
    {
      native_bind_long(paramInt, paramLong);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void bindNull(int paramInt)
  {
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    acquireReference();
    try
    {
      native_bind_null(paramInt);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void bindString(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("the bind value at index " + paramInt + " is null");
    }
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    acquireReference();
    try
    {
      native_bind_string(paramInt, paramString);
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void clearBindings()
  {
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    acquireReference();
    try
    {
      native_clear_bindings();
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	net/sqlcipher/database/SQLiteProgram:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   4: invokevirtual 153	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   7: ifne +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 28	net/sqlcipher/database/SQLiteProgram:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   15: invokevirtual 197	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   18: aload_0
    //   19: invokevirtual 170	net/sqlcipher/database/SQLiteProgram:releaseReference	()V
    //   22: aload_0
    //   23: getfield 28	net/sqlcipher/database/SQLiteProgram:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   26: invokevirtual 200	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   29: goto -19 -> 10
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 28	net/sqlcipher/database/SQLiteProgram:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   37: invokevirtual 200	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	SQLiteProgram
    //   32	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	22	32	finally
  }
  
  @Deprecated
  protected void compile(String paramString, boolean paramBoolean) {}
  
  String getSqlString()
  {
    return this.mSql;
  }
  
  public final int getUniqueId()
  {
    return this.nStatement;
  }
  
  protected final native void native_bind_blob(int paramInt, byte[] paramArrayOfByte);
  
  protected final native void native_bind_double(int paramInt, double paramDouble);
  
  protected final native void native_bind_long(int paramInt, long paramLong);
  
  protected final native void native_bind_null(int paramInt);
  
  protected final native void native_bind_string(int paramInt, String paramString);
  
  @Deprecated
  protected final native void native_compile(String paramString);
  
  @Deprecated
  protected final native void native_finalize();
  
  protected void onAllReferencesReleased()
  {
    releaseCompiledSqlIfNotInCache();
    this.mDatabase.releaseReference();
    this.mDatabase.removeSQLiteClosable(this);
  }
  
  protected void onAllReferencesReleasedFromContainer()
  {
    releaseCompiledSqlIfNotInCache();
    this.mDatabase.releaseReference();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteProgram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */