package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.SQLException;

public class SQLiteCursor
  extends AbstractWindowedCursor
{
  static final int NO_COUNT = -1;
  static final String TAG = "Cursor";
  private Map<String, Integer> mColumnNameMap;
  private String[] mColumns;
  private int mCount = -1;
  private int mCursorState = 0;
  private SQLiteDatabase mDatabase;
  private SQLiteCursorDriver mDriver;
  private String mEditTable;
  private int mInitialRead = Integer.MAX_VALUE;
  private ReentrantLock mLock = null;
  private int mMaxRead = Integer.MAX_VALUE;
  protected MainThreadNotificationHandler mNotificationHandler;
  private boolean mPendingData = false;
  private SQLiteQuery mQuery;
  private Throwable mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
  
  public SQLiteCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.mQuery = paramSQLiteQuery;
    try
    {
      paramSQLiteDatabase.lock();
      int j = this.mQuery.columnCountLocked();
      this.mColumns = new String[j];
      for (int i = 0; i < j; i++)
      {
        paramSQLiteCursorDriver = this.mQuery.columnNameLocked(i);
        this.mColumns[i] = paramSQLiteCursorDriver;
        if ("_id".equals(paramSQLiteCursorDriver)) {
          this.mRowIdColumnIndex = i;
        }
      }
    }
    finally
    {
      paramSQLiteDatabase.unlock();
    }
  }
  
  private void deactivateCommon()
  {
    this.mCursorState = 0;
    if (this.mWindow != null)
    {
      this.mWindow.close();
      this.mWindow = null;
    }
  }
  
  /* Error */
  private void fillWindow(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	net/sqlcipher/database/SQLiteCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   4: ifnonnull +86 -> 90
    //   7: aload_0
    //   8: new 137	net/sqlcipher/CursorWindow
    //   11: dup
    //   12: iconst_1
    //   13: invokespecial 145	net/sqlcipher/CursorWindow:<init>	(Z)V
    //   16: putfield 118	net/sqlcipher/database/SQLiteCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   19: aload_0
    //   20: getfield 118	net/sqlcipher/database/SQLiteCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   23: iload_1
    //   24: invokevirtual 148	net/sqlcipher/CursorWindow:setStartPosition	(I)V
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 78	net/sqlcipher/database/SQLiteCursor:mQuery	Lnet/sqlcipher/database/SQLiteQuery;
    //   32: aload_0
    //   33: getfield 118	net/sqlcipher/database/SQLiteCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   36: aload_0
    //   37: getfield 53	net/sqlcipher/database/SQLiteCursor:mInitialRead	I
    //   40: iconst_0
    //   41: invokevirtual 151	net/sqlcipher/database/SQLiteQuery:fillWindow	(Lnet/sqlcipher/CursorWindow;II)I
    //   44: putfield 48	net/sqlcipher/database/SQLiteCursor:mCount	I
    //   47: aload_0
    //   48: getfield 48	net/sqlcipher/database/SQLiteCursor:mCount	I
    //   51: iconst_m1
    //   52: if_icmpne +37 -> 89
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 53	net/sqlcipher/database/SQLiteCursor:mInitialRead	I
    //   60: iload_1
    //   61: iadd
    //   62: putfield 48	net/sqlcipher/database/SQLiteCursor:mCount	I
    //   65: new 153	java/lang/Thread
    //   68: dup
    //   69: new 9	net/sqlcipher/database/SQLiteCursor$QueryThread
    //   72: dup
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 55	net/sqlcipher/database/SQLiteCursor:mCursorState	I
    //   78: invokespecial 156	net/sqlcipher/database/SQLiteCursor$QueryThread:<init>	(Lnet/sqlcipher/database/SQLiteCursor;I)V
    //   81: ldc -98
    //   83: invokespecial 161	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   86: invokevirtual 164	java/lang/Thread:start	()V
    //   89: return
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 55	net/sqlcipher/database/SQLiteCursor:mCursorState	I
    //   95: iconst_1
    //   96: iadd
    //   97: putfield 55	net/sqlcipher/database/SQLiteCursor:mCursorState	I
    //   100: aload_0
    //   101: invokespecial 167	net/sqlcipher/database/SQLiteCursor:queryThreadLock	()V
    //   104: aload_0
    //   105: getfield 118	net/sqlcipher/database/SQLiteCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   108: invokevirtual 170	net/sqlcipher/CursorWindow:clear	()V
    //   111: aload_0
    //   112: invokespecial 173	net/sqlcipher/database/SQLiteCursor:queryThreadUnlock	()V
    //   115: goto -96 -> 19
    //   118: astore_2
    //   119: aload_0
    //   120: invokespecial 173	net/sqlcipher/database/SQLiteCursor:queryThreadUnlock	()V
    //   123: aload_2
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	SQLiteCursor
    //   0	125	1	paramInt	int
    //   118	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   104	111	118	finally
  }
  
  private void queryThreadLock()
  {
    if (this.mLock != null) {
      this.mLock.lock();
    }
  }
  
  private void queryThreadUnlock()
  {
    if (this.mLock != null) {
      this.mLock.unlock();
    }
  }
  
  public void close()
  {
    super.close();
    deactivateCommon();
    this.mQuery.close();
    this.mDriver.cursorClosed();
  }
  
  public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> paramMap)
  {
    if (!supportsUpdates()) {
      Log.e("Cursor", "commitUpdates not supported on this cursor, did you include the _id column?");
    }
    for (boolean bool = false;; bool = true)
    {
      HashMap localHashMap;
      for (;;)
      {
        return bool;
        localHashMap = this.mUpdatedRows;
        if (paramMap != null) {}
        try
        {
          this.mUpdatedRows.putAll(paramMap);
          if (this.mUpdatedRows.size() == 0) {
            bool = true;
          }
        }
        finally {}
      }
      this.mDatabase.beginTransaction();
      for (;;)
      {
        Object localObject3;
        Object localObject2;
        try
        {
          paramMap = new java/lang/StringBuilder;
          paramMap.<init>(128);
          Object localObject1 = this.mUpdatedRows.entrySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (Map)((Map.Entry)localObject3).getValue();
          localObject3 = (Long)((Map.Entry)localObject3).getKey();
          if ((localObject3 == null) || (localObject2 == null))
          {
            localObject1 = new java/lang/IllegalStateException;
            paramMap = new java/lang/StringBuilder;
            paramMap.<init>();
            ((IllegalStateException)localObject1).<init>("null rowId or values found! rowId = " + localObject3 + ", values = " + localObject2);
            throw ((Throwable)localObject1);
          }
        }
        finally
        {
          this.mDatabase.endTransaction();
        }
        if (((Map)localObject2).size() != 0)
        {
          long l = ((Long)localObject3).longValue();
          localObject3 = ((Map)localObject2).entrySet().iterator();
          paramMap.setLength(0);
          Object localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          paramMap.append("UPDATE " + this.mEditTable + " SET ");
          localObject2 = new Object[((Map)localObject2).size()];
          for (int i = 0; ((Iterator)localObject3).hasNext(); i++)
          {
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            paramMap.append((String)((Map.Entry)localObject4).getKey());
            paramMap.append("=?");
            localObject2[i] = ((Map.Entry)localObject4).getValue();
            if (((Iterator)localObject3).hasNext()) {
              paramMap.append(", ");
            }
          }
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          paramMap.append(" WHERE " + this.mColumns[this.mRowIdColumnIndex] + '=' + l);
          paramMap.append(';');
          this.mDatabase.execSQL(paramMap.toString(), (Object[])localObject2);
          this.mDatabase.rowUpdated(this.mEditTable, l);
        }
      }
      this.mDatabase.setTransactionSuccessful();
      this.mDatabase.endTransaction();
      this.mUpdatedRows.clear();
      onChange(true);
    }
  }
  
  public void deactivate()
  {
    super.deactivate();
    deactivateCommon();
    this.mDriver.cursorDeactivated();
  }
  
  public boolean deleteRow()
  {
    boolean bool = true;
    checkPosition();
    if ((this.mRowIdColumnIndex == -1) || (this.mCurrentRowID == null))
    {
      Log.e("Cursor", "Could not delete row because either the row ID column is not available or ithas not been read.");
      bool = false;
    }
    for (;;)
    {
      return bool;
      this.mDatabase.lock();
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.mDatabase;
        String str = this.mEditTable;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localSQLiteDatabase.delete(str, this.mColumns[this.mRowIdColumnIndex] + "=?", new String[] { this.mCurrentRowID.toString() });
        i = 1;
      }
      catch (SQLException localSQLException)
      {
        for (;;)
        {
          int j;
          int i = 0;
        }
      }
      finally
      {
        this.mDatabase.unlock();
      }
      j = this.mPos;
      requery();
      moveToPosition(j);
      this.mDatabase.unlock();
      if (i != 0) {
        onChange(true);
      } else {
        bool = false;
      }
    }
  }
  
  public void fillWindow(int paramInt, android.database.CursorWindow paramCursorWindow)
  {
    if (this.mWindow == null) {
      this.mWindow = new net.sqlcipher.CursorWindow(true);
    }
    for (;;)
    {
      this.mWindow.setStartPosition(paramInt);
      this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
      if (this.mCount == -1)
      {
        this.mCount = (this.mInitialRead + paramInt);
        new Thread(new QueryThread(this.mCursorState), "query thread").start();
      }
      return;
      this.mCursorState += 1;
      queryThreadLock();
      try
      {
        this.mWindow.clear();
        queryThreadUnlock();
      }
      finally
      {
        queryThreadUnlock();
      }
    }
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mWindow != null)
      {
        int j = this.mQuery.mSql.length();
        Object localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        StringBuilder localStringBuilder = ((StringBuilder)localObject1).append("Finalizing a Cursor that has not been deactivated or closed. database = ").append(this.mDatabase.getPath()).append(", table = ").append(this.mEditTable).append(", query = ");
        localObject1 = this.mQuery.mSql;
        int i = j;
        if (j > 100) {
          i = 100;
        }
        Log.e("Cursor", ((String)localObject1).substring(0, i), this.mStackTrace);
        close();
        SQLiteDebug.notifyActiveCursorFinalized();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    int j = -1;
    if (this.mColumnNameMap == null)
    {
      String[] arrayOfString = this.mColumns;
      int k = arrayOfString.length;
      localObject = new HashMap(k, 1.0F);
      for (i = 0; i < k; i++) {
        ((HashMap)localObject).put(arrayOfString[i], Integer.valueOf(i));
      }
      this.mColumnNameMap = ((Map)localObject);
    }
    int i = paramString.lastIndexOf('.');
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = new Exception();
      Log.e("Cursor", "requesting column name with table name -- " + paramString, (Throwable)localObject);
      localObject = paramString.substring(i + 1);
    }
    paramString = (Integer)this.mColumnNameMap.get(localObject);
    i = j;
    if (paramString != null) {
      i = paramString.intValue();
    }
    return i;
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    if (this.mCount == -1) {
      fillWindow(0);
    }
    return this.mCount;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.mDatabase;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    if ((this.mWindow == null) || (paramInt2 < this.mWindow.getStartPosition()) || (paramInt2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows())) {
      fillWindow(paramInt2);
    }
    return true;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    super.registerDataSetObserver(paramDataSetObserver);
    if (((Integer.MAX_VALUE != this.mMaxRead) || (Integer.MAX_VALUE != this.mInitialRead)) && (this.mNotificationHandler == null)) {
      queryThreadLock();
    }
    try
    {
      paramDataSetObserver = new net/sqlcipher/database/SQLiteCursor$MainThreadNotificationHandler;
      paramDataSetObserver.<init>(this);
      this.mNotificationHandler = paramDataSetObserver;
      if (this.mPendingData)
      {
        notifyDataSetChange();
        this.mPendingData = false;
      }
      return;
    }
    finally
    {
      queryThreadUnlock();
    }
  }
  
  /* Error */
  public boolean requery()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 443	net/sqlcipher/database/SQLiteCursor:isClosed	()Z
    //   4: ifeq +7 -> 11
    //   7: iconst_0
    //   8: istore_1
    //   9: iload_1
    //   10: ireturn
    //   11: aload_0
    //   12: getfield 70	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   15: invokevirtual 83	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   18: aload_0
    //   19: getfield 118	net/sqlcipher/database/SQLiteCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   22: ifnull +10 -> 32
    //   25: aload_0
    //   26: getfield 118	net/sqlcipher/database/SQLiteCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   29: invokevirtual 170	net/sqlcipher/CursorWindow:clear	()V
    //   32: aload_0
    //   33: iconst_m1
    //   34: putfield 345	net/sqlcipher/database/SQLiteCursor:mPos	I
    //   37: aload_0
    //   38: getfield 72	net/sqlcipher/database/SQLiteCursor:mDriver	Lnet/sqlcipher/database/SQLiteCursorDriver;
    //   41: aload_0
    //   42: invokeinterface 447 2 0
    //   47: aload_0
    //   48: iconst_m1
    //   49: putfield 48	net/sqlcipher/database/SQLiteCursor:mCount	I
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 55	net/sqlcipher/database/SQLiteCursor:mCursorState	I
    //   57: iconst_1
    //   58: iadd
    //   59: putfield 55	net/sqlcipher/database/SQLiteCursor:mCursorState	I
    //   62: aload_0
    //   63: invokespecial 167	net/sqlcipher/database/SQLiteCursor:queryThreadLock	()V
    //   66: aload_0
    //   67: getfield 78	net/sqlcipher/database/SQLiteCursor:mQuery	Lnet/sqlcipher/database/SQLiteQuery;
    //   70: invokevirtual 449	net/sqlcipher/database/SQLiteQuery:requery	()V
    //   73: aload_0
    //   74: invokespecial 173	net/sqlcipher/database/SQLiteCursor:queryThreadUnlock	()V
    //   77: aload_0
    //   78: getfield 70	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   81: invokevirtual 109	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   84: aload_0
    //   85: invokespecial 450	net/sqlcipher/AbstractWindowedCursor:requery	()Z
    //   88: istore_1
    //   89: goto -80 -> 9
    //   92: astore_2
    //   93: aload_0
    //   94: invokespecial 173	net/sqlcipher/database/SQLiteCursor:queryThreadUnlock	()V
    //   97: aload_2
    //   98: athrow
    //   99: astore_2
    //   100: aload_0
    //   101: getfield 70	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   104: invokevirtual 109	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	SQLiteCursor
    //   8	81	1	bool	boolean
    //   92	6	2	localObject1	Object
    //   99	9	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   66	73	92	finally
    //   18	32	99	finally
    //   32	66	99	finally
    //   73	77	99	finally
    //   93	99	99	finally
  }
  
  public void setLoadStyle(int paramInt1, int paramInt2)
  {
    this.mMaxRead = paramInt2;
    this.mInitialRead = paramInt1;
    this.mLock = new ReentrantLock(true);
  }
  
  public void setSelectionArguments(String[] paramArrayOfString)
  {
    this.mDriver.setBindArguments(paramArrayOfString);
  }
  
  public void setWindow(net.sqlcipher.CursorWindow paramCursorWindow)
  {
    if (this.mWindow != null)
    {
      this.mCursorState += 1;
      queryThreadLock();
    }
    try
    {
      this.mWindow.close();
      queryThreadUnlock();
      this.mCount = -1;
      this.mWindow = paramCursorWindow;
      return;
    }
    finally
    {
      queryThreadUnlock();
    }
  }
  
  public boolean supportsUpdates()
  {
    if (!TextUtils.isEmpty(this.mEditTable)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected class MainThreadNotificationHandler
    extends Handler
  {
    protected MainThreadNotificationHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      SQLiteCursor.this.notifyDataSetChange();
    }
  }
  
  private final class QueryThread
    implements Runnable
  {
    private final int mThreadState;
    
    QueryThread(int paramInt)
    {
      this.mThreadState = paramInt;
    }
    
    private void sendMessage()
    {
      if (SQLiteCursor.this.mNotificationHandler != null)
      {
        SQLiteCursor.this.mNotificationHandler.sendEmptyMessage(1);
        SQLiteCursor.access$002(SQLiteCursor.this, false);
      }
      for (;;)
      {
        return;
        SQLiteCursor.access$002(SQLiteCursor.this, true);
      }
    }
    
    public void run()
    {
      Object localObject1 = SQLiteCursor.this.mWindow;
      Process.setThreadPriority(Process.myTid(), 10);
      SQLiteCursor.this.mLock.lock();
      if (SQLiteCursor.this.mCursorState != this.mThreadState)
      {
        SQLiteCursor.this.mLock.unlock();
        label50:
        return;
      }
      for (;;)
      {
        try
        {
          int i = SQLiteCursor.this.mQuery.fillWindow((net.sqlcipher.CursorWindow)localObject1, SQLiteCursor.this.mMaxRead, SQLiteCursor.this.mCount);
          if (i == 0) {
            break label171;
          }
          if (i == -1)
          {
            SQLiteCursor.access$512(SQLiteCursor.this, SQLiteCursor.this.mMaxRead);
            sendMessage();
            SQLiteCursor.this.mLock.unlock();
            break;
          }
          SQLiteCursor.access$502(SQLiteCursor.this, i);
          sendMessage();
          localObject1 = SQLiteCursor.this.mLock;
        }
        catch (Exception localException)
        {
          ReentrantLock localReentrantLock1 = SQLiteCursor.this.mLock;
          continue;
        }
        finally
        {
          SQLiteCursor.this.mLock.unlock();
        }
        ((ReentrantLock)localObject1).unlock();
        break label50;
        label171:
        ReentrantLock localReentrantLock2 = SQLiteCursor.this.mLock;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */