package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

public final class BulkCursorToCursorAdaptor
  extends AbstractWindowedCursor
{
  private static final String TAG = "BulkCursor";
  private IBulkCursor mBulkCursor;
  private String[] mColumns;
  private int mCount;
  private AbstractCursor.SelfContentObserver mObserverBridge;
  private boolean mWantsAllOnMoveCalls;
  
  public static int findRowIdColumnIndex(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!paramArrayOfString[i].equals("_id")) {}
    }
    for (;;)
    {
      return i;
      i++;
      break;
      i = -1;
    }
  }
  
  public void close()
  {
    super.close();
    try
    {
      this.mBulkCursor.close();
      this.mWindow = null;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("BulkCursor", "Remote process exception when closing");
      }
    }
  }
  
  /* Error */
  public boolean commitUpdates(java.util.Map<? extends Long, ? extends java.util.Map<String, Object>> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 61	net/sqlcipher/BulkCursorToCursorAdaptor:supportsUpdates	()Z
    //   4: ifne +15 -> 19
    //   7: ldc 8
    //   9: ldc 63
    //   11: invokestatic 66	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   14: pop
    //   15: iconst_0
    //   16: istore_2
    //   17: iload_2
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 70	net/sqlcipher/BulkCursorToCursorAdaptor:mUpdatedRows	Ljava/util/HashMap;
    //   23: astore_3
    //   24: aload_3
    //   25: monitorenter
    //   26: aload_1
    //   27: ifnull +11 -> 38
    //   30: aload_0
    //   31: getfield 70	net/sqlcipher/BulkCursorToCursorAdaptor:mUpdatedRows	Ljava/util/HashMap;
    //   34: aload_1
    //   35: invokevirtual 76	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   38: aload_0
    //   39: getfield 70	net/sqlcipher/BulkCursorToCursorAdaptor:mUpdatedRows	Ljava/util/HashMap;
    //   42: invokevirtual 80	java/util/HashMap:size	()I
    //   45: ifgt +10 -> 55
    //   48: aload_3
    //   49: monitorexit
    //   50: iconst_0
    //   51: istore_2
    //   52: goto -35 -> 17
    //   55: aload_0
    //   56: getfield 40	net/sqlcipher/BulkCursorToCursorAdaptor:mBulkCursor	Lnet/sqlcipher/IBulkCursor;
    //   59: aload_0
    //   60: getfield 70	net/sqlcipher/BulkCursorToCursorAdaptor:mUpdatedRows	Ljava/util/HashMap;
    //   63: invokeinterface 83 2 0
    //   68: istore_2
    //   69: iload_2
    //   70: iconst_1
    //   71: if_icmpne +15 -> 86
    //   74: aload_0
    //   75: getfield 70	net/sqlcipher/BulkCursorToCursorAdaptor:mUpdatedRows	Ljava/util/HashMap;
    //   78: invokevirtual 86	java/util/HashMap:clear	()V
    //   81: aload_0
    //   82: iconst_1
    //   83: invokevirtual 90	net/sqlcipher/BulkCursorToCursorAdaptor:onChange	(Z)V
    //   86: aload_3
    //   87: monitorexit
    //   88: goto -71 -> 17
    //   91: astore_1
    //   92: aload_3
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: ldc 8
    //   99: ldc 92
    //   101: invokestatic 66	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   104: pop
    //   105: aload_3
    //   106: monitorexit
    //   107: iconst_0
    //   108: istore_2
    //   109: goto -92 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	BulkCursorToCursorAdaptor
    //   0	112	1	paramMap	java.util.Map<? extends Long, ? extends java.util.Map<String, Object>>
    //   16	93	2	bool	boolean
    //   23	83	3	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   30	38	91	finally
    //   38	50	91	finally
    //   55	69	91	finally
    //   74	86	91	finally
    //   86	88	91	finally
    //   92	94	91	finally
    //   97	107	91	finally
    //   55	69	96	android/os/RemoteException
    //   74	86	96	android/os/RemoteException
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public void deactivate()
  {
    super.deactivate();
    try
    {
      this.mBulkCursor.deactivate();
      this.mWindow = null;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("BulkCursor", "Remote process exception when deactivating");
      }
    }
  }
  
  public boolean deleteRow()
  {
    for (;;)
    {
      try
      {
        boolean bool2 = this.mBulkCursor.deleteRow(this.mPos);
        bool1 = bool2;
        if (bool2)
        {
          this.mWindow = null;
          this.mCount = this.mBulkCursor.count();
          if (this.mPos >= this.mCount) {
            continue;
          }
          int i = this.mPos;
          this.mPos = -1;
          moveToPosition(i);
          onChange(true);
          bool1 = bool2;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("BulkCursor", "Unable to delete row because the remote process is dead");
        boolean bool1 = false;
        continue;
      }
      return bool1;
      this.mPos = this.mCount;
    }
  }
  
  public String[] getColumnNames()
  {
    if (this.mColumns == null) {}
    try
    {
      this.mColumns = this.mBulkCursor.getColumnNames();
      arrayOfString = this.mColumns;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        String[] arrayOfString;
        Log.e("BulkCursor", "Unable to fetch column names because the remote process is dead");
        Object localObject = null;
      }
    }
    return arrayOfString;
  }
  
  public int getCount()
  {
    return this.mCount;
  }
  
  public Bundle getExtras()
  {
    try
    {
      Bundle localBundle = this.mBulkCursor.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public IContentObserver getObserver()
  {
    try
    {
      if (this.mObserverBridge == null)
      {
        AbstractCursor.SelfContentObserver localSelfContentObserver = new net/sqlcipher/AbstractCursor$SelfContentObserver;
        localSelfContentObserver.<init>(this);
        this.mObserverBridge = localSelfContentObserver;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    bool = false;
    for (;;)
    {
      try
      {
        if (this.mWindow == null) {
          continue;
        }
        if ((paramInt2 >= this.mWindow.getStartPosition()) && (paramInt2 < this.mWindow.getStartPosition() + this.mWindow.getNumRows())) {
          continue;
        }
        this.mWindow = this.mBulkCursor.getWindow(paramInt2);
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("BulkCursor", "Unable to get window because the remote process is dead");
        continue;
        this.mWindow = this.mBulkCursor.getWindow(paramInt2);
        continue;
        bool = true;
        continue;
      }
      if (this.mWindow != null) {
        continue;
      }
      return bool;
      if (this.mWantsAllOnMoveCalls) {
        this.mBulkCursor.onMove(paramInt2);
      }
    }
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public boolean requery()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        int i = this.mCount;
        IBulkCursor localIBulkCursor = this.mBulkCursor;
        IContentObserver localIContentObserver = getObserver();
        CursorWindow localCursorWindow = new net/sqlcipher/CursorWindow;
        localCursorWindow.<init>(false);
        this.mCount = localIBulkCursor.requery(localIContentObserver, localCursorWindow);
        if (this.mCount == -1) {
          continue;
        }
        this.mPos = -1;
        this.mWindow = null;
        super.requery();
        bool = true;
      }
      catch (Exception localException)
      {
        Log.e("BulkCursor", "Unable to requery because the remote process exception " + localException.getMessage());
        deactivate();
        continue;
      }
      return bool;
      deactivate();
    }
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    try
    {
      paramBundle = this.mBulkCursor.respond(paramBundle);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      for (;;)
      {
        Log.w("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", paramBundle);
        paramBundle = Bundle.EMPTY;
      }
    }
  }
  
  public void set(IBulkCursor paramIBulkCursor)
  {
    this.mBulkCursor = paramIBulkCursor;
    try
    {
      this.mCount = this.mBulkCursor.count();
      this.mWantsAllOnMoveCalls = this.mBulkCursor.getWantsAllOnMoveCalls();
      this.mColumns = this.mBulkCursor.getColumnNames();
      this.mRowIdColumnIndex = findRowIdColumnIndex(this.mColumns);
      return;
    }
    catch (RemoteException paramIBulkCursor)
    {
      for (;;)
      {
        Log.e("BulkCursor", "Setup failed because the remote process is dead");
      }
    }
  }
  
  public void set(IBulkCursor paramIBulkCursor, int paramInt1, int paramInt2)
  {
    this.mBulkCursor = paramIBulkCursor;
    this.mColumns = null;
    this.mCount = paramInt1;
    this.mRowIdColumnIndex = paramInt2;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\BulkCursorToCursorAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */