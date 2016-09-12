package net.sqlcipher.database;

public class SQLiteDebug$DbStats
{
  public String dbName;
  public long dbSize;
  public int lookaside;
  public long pageSize;
  
  public SQLiteDebug$DbStats(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    this.dbName = paramString;
    this.pageSize = paramLong2;
    this.dbSize = (paramLong1 * paramLong2 / 1024L);
    this.lookaside = paramInt;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteDebug$DbStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */