package net.sqlcipher.database;

import android.os.SystemClock;

public class SQLiteStatement
  extends SQLiteProgram
{
  SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    super(paramSQLiteDatabase, paramString);
  }
  
  private final native long native_1x1_long();
  
  private final native String native_1x1_string();
  
  private final native void native_execute();
  
  public void execute()
  {
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    long l = SystemClock.uptimeMillis();
    this.mDatabase.lock();
    acquireReference();
    try
    {
      native_execute();
      this.mDatabase.logTimeStat(this.mSql, l);
      return;
    }
    finally
    {
      releaseReference();
      this.mDatabase.unlock();
    }
  }
  
  /* Error */
  public long executeInsert()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	net/sqlcipher/database/SQLiteStatement:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   4: invokevirtual 26	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   7: ifne +41 -> 48
    //   10: new 28	java/lang/IllegalStateException
    //   13: dup
    //   14: new 30	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   21: ldc 34
    //   23: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 20	net/sqlcipher/database/SQLiteStatement:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   30: invokevirtual 41	net/sqlcipher/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   33: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 43
    //   38: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 49	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: invokestatic 54	android/os/SystemClock:uptimeMillis	()J
    //   51: lstore_1
    //   52: aload_0
    //   53: getfield 20	net/sqlcipher/database/SQLiteStatement:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   56: invokevirtual 57	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   59: aload_0
    //   60: invokevirtual 60	net/sqlcipher/database/SQLiteStatement:acquireReference	()V
    //   63: aload_0
    //   64: invokespecial 62	net/sqlcipher/database/SQLiteStatement:native_execute	()V
    //   67: aload_0
    //   68: getfield 20	net/sqlcipher/database/SQLiteStatement:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   71: aload_0
    //   72: getfield 66	net/sqlcipher/database/SQLiteStatement:mSql	Ljava/lang/String;
    //   75: lload_1
    //   76: invokevirtual 70	net/sqlcipher/database/SQLiteDatabase:logTimeStat	(Ljava/lang/String;J)V
    //   79: aload_0
    //   80: getfield 20	net/sqlcipher/database/SQLiteStatement:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   83: invokevirtual 81	net/sqlcipher/database/SQLiteDatabase:lastChangeCount	()I
    //   86: ifle +24 -> 110
    //   89: aload_0
    //   90: getfield 20	net/sqlcipher/database/SQLiteStatement:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   93: invokevirtual 84	net/sqlcipher/database/SQLiteDatabase:lastInsertRow	()J
    //   96: lstore_1
    //   97: aload_0
    //   98: invokevirtual 73	net/sqlcipher/database/SQLiteStatement:releaseReference	()V
    //   101: aload_0
    //   102: getfield 20	net/sqlcipher/database/SQLiteStatement:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   105: invokevirtual 76	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   108: lload_1
    //   109: lreturn
    //   110: ldc2_w 85
    //   113: lstore_1
    //   114: goto -17 -> 97
    //   117: astore_3
    //   118: aload_0
    //   119: invokevirtual 73	net/sqlcipher/database/SQLiteStatement:releaseReference	()V
    //   122: aload_0
    //   123: getfield 20	net/sqlcipher/database/SQLiteStatement:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   126: invokevirtual 76	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   129: aload_3
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	SQLiteStatement
    //   51	63	1	l	long
    //   117	13	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   63	97	117	finally
  }
  
  public long simpleQueryForLong()
  {
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    long l1 = SystemClock.uptimeMillis();
    this.mDatabase.lock();
    acquireReference();
    try
    {
      long l2 = native_1x1_long();
      this.mDatabase.logTimeStat(this.mSql, l1);
      return l2;
    }
    finally
    {
      releaseReference();
      this.mDatabase.unlock();
    }
  }
  
  public String simpleQueryForString()
  {
    if (!this.mDatabase.isOpen()) {
      throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }
    long l = SystemClock.uptimeMillis();
    this.mDatabase.lock();
    acquireReference();
    try
    {
      String str = native_1x1_string();
      this.mDatabase.logTimeStat(this.mSql, l);
      return str;
    }
    finally
    {
      releaseReference();
      this.mDatabase.unlock();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */