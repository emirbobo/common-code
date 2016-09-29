package net.sqlcipher.database;

import android.os.SystemClock;
import android.util.Log;
import net.sqlcipher.CursorWindow;

public class SQLiteQuery
  extends SQLiteProgram
{
  private static final String TAG = "Cursor";
  private String[] mBindArgs;
  private boolean mClosed = false;
  private int mOffsetIndex;
  
  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, String[] paramArrayOfString)
  {
    super(paramSQLiteDatabase, paramString);
    this.mOffsetIndex = paramInt;
    this.mBindArgs = paramArrayOfString;
  }
  
  private final native int native_column_count();
  
  private final native String native_column_name(int paramInt);
  
  private final native int native_fill_window(CursorWindow paramCursorWindow, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    this.mBindArgs[(paramInt - 1)] = Double.toString(paramDouble);
    if (!this.mClosed) {
      super.bindDouble(paramInt, paramDouble);
    }
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    this.mBindArgs[(paramInt - 1)] = Long.toString(paramLong);
    if (!this.mClosed) {
      super.bindLong(paramInt, paramLong);
    }
  }
  
  public void bindNull(int paramInt)
  {
    this.mBindArgs[(paramInt - 1)] = null;
    if (!this.mClosed) {
      super.bindNull(paramInt);
    }
  }
  
  public void bindString(int paramInt, String paramString)
  {
    this.mBindArgs[(paramInt - 1)] = paramString;
    if (!this.mClosed) {
      super.bindString(paramInt, paramString);
    }
  }
  
  public void close()
  {
    super.close();
    this.mClosed = true;
  }
  
  int columnCountLocked()
  {
    acquireReference();
    try
    {
      int i = native_column_count();
      return i;
    }
    finally
    {
      releaseReference();
    }
  }
  
  String columnNameLocked(int paramInt)
  {
    acquireReference();
    try
    {
      String str = native_column_name(paramInt);
      return str;
    }
    finally
    {
      releaseReference();
    }
  }
  
  int fillWindow(CursorWindow paramCursorWindow, int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    this.mDatabase.lock();
    this.mDatabase.logTimeStat(this.mSql, l, "GETLOCK:");
    try
    {
      acquireReference();
      try
      {
        paramCursorWindow.acquireReference();
        paramInt1 = native_fill_window(paramCursorWindow, paramCursorWindow.getStartPosition(), this.mOffsetIndex, paramInt1, paramInt2);
        if (SQLiteDebug.DEBUG_SQL_STATEMENTS)
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          Log.d("Cursor", "fillWindow(): " + this.mSql);
        }
        this.mDatabase.logTimeStat(this.mSql, l);
        paramCursorWindow.releaseReference();
        releaseReference();
        paramCursorWindow = this.mDatabase;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          paramInt1 = 0;
          paramCursorWindow.releaseReference();
          releaseReference();
          paramCursorWindow = this.mDatabase;
        }
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        this.mDatabase.onCorruption();
        throw localSQLiteDatabaseCorruptException;
      }
      finally
      {
        paramCursorWindow.releaseReference();
      }
      paramCursorWindow.unlock();
      return paramInt1;
    }
    finally
    {
      releaseReference();
      this.mDatabase.unlock();
    }
  }
  
  void requery()
  {
    if (this.mBindArgs != null)
    {
      int j = this.mBindArgs.length;
      int i = 0;
      while (i < j) {
        try
        {
          super.bindString(i + 1, this.mBindArgs[i]);
          i++;
        }
        catch (SQLiteMisuseException localSQLiteMisuseException)
        {
          StringBuilder localStringBuilder = new StringBuilder("mSql " + this.mSql);
          for (i = 0; i < j; i++)
          {
            localStringBuilder.append(" ");
            localStringBuilder.append(this.mBindArgs[i]);
          }
          localStringBuilder.append(" ");
          throw new IllegalStateException(localStringBuilder.toString(), localSQLiteMisuseException);
        }
      }
    }
  }
  
  public String toString()
  {
    return "SQLiteQuery: " + this.mSql;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */