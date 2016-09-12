package net.sqlcipher.database;

import android.database.Cursor;

public class SQLiteDirectCursorDriver
  implements SQLiteCursorDriver
{
  private Cursor mCursor;
  private SQLiteDatabase mDatabase;
  private String mEditTable;
  private SQLiteQuery mQuery;
  private String mSql;
  
  public SQLiteDirectCursorDriver(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mEditTable = paramString2;
    this.mSql = paramString1;
  }
  
  public void cursorClosed()
  {
    this.mCursor = null;
  }
  
  public void cursorDeactivated() {}
  
  public void cursorRequeried(Cursor paramCursor) {}
  
  public Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString)
  {
    int i = 0;
    SQLiteQuery localSQLiteQuery2 = new SQLiteQuery(this.mDatabase, this.mSql, 0, paramArrayOfString);
    if (paramArrayOfString == null) {}
    for (;;)
    {
      int j = 0;
      for (;;)
      {
        if (j >= i) {
          break label67;
        }
        SQLiteQuery localSQLiteQuery1 = localSQLiteQuery2;
        try
        {
          localSQLiteQuery2.bindString(j + 1, paramArrayOfString[j]);
          j++;
        }
        finally
        {
          if (localSQLiteQuery1 == null) {
            break label178;
          }
          localSQLiteQuery1.close();
        }
      }
      localSQLiteQuery1 = localSQLiteQuery2;
      i = paramArrayOfString.length;
    }
    label67:
    if (paramCursorFactory == null)
    {
      localSQLiteQuery1 = localSQLiteQuery2;
      paramCursorFactory = new net/sqlcipher/database/SQLiteCursor;
      localSQLiteQuery1 = localSQLiteQuery2;
      paramCursorFactory.<init>(this.mDatabase, this, this.mEditTable, localSQLiteQuery2);
      localSQLiteQuery1 = localSQLiteQuery2;
    }
    for (this.mCursor = paramCursorFactory;; this.mCursor = paramCursorFactory.newCursor(this.mDatabase, this, this.mEditTable, localSQLiteQuery2))
    {
      localSQLiteQuery1 = localSQLiteQuery2;
      this.mQuery = localSQLiteQuery2;
      localSQLiteQuery1 = null;
      paramCursorFactory = this.mCursor;
      if (0 != 0) {
        throw new NullPointerException();
      }
      return paramCursorFactory;
      localSQLiteQuery1 = localSQLiteQuery2;
    }
  }
  
  public void setBindArguments(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      this.mQuery.bindString(i + 1, paramArrayOfString[i]);
    }
  }
  
  public String toString()
  {
    return "SQLiteDirectCursorDriver: " + this.mSql;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteDirectCursorDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */