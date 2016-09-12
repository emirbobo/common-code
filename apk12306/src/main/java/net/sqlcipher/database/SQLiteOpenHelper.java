package net.sqlcipher.database;

import android.content.Context;
import android.util.Log;
import java.io.File;

public abstract class SQLiteOpenHelper
{
  private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
  private final Context mContext;
  private SQLiteDatabase mDatabase = null;
  private final SQLiteDatabase.CursorFactory mFactory;
  private boolean mIsInitializing = false;
  private final String mName;
  private final int mNewVersion;
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("Version must be >= 1, was " + paramInt);
    }
    this.mContext = paramContext;
    this.mName = paramString;
    this.mFactory = paramCursorFactory;
    this.mNewVersion = paramInt;
  }
  
  public void close()
  {
    try
    {
      if (this.mIsInitializing)
      {
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>("Closed during initialization");
        throw localIllegalStateException;
      }
    }
    finally {}
    if ((this.mDatabase != null) && (this.mDatabase.isOpen()))
    {
      this.mDatabase.close();
      this.mDatabase = null;
    }
  }
  
  public SQLiteDatabase getReadableDatabase(String paramString)
  {
    for (;;)
    {
      try
      {
        if ((this.mDatabase != null) && (this.mDatabase.isOpen()))
        {
          paramString = this.mDatabase;
          return paramString;
        }
        if (this.mIsInitializing)
        {
          paramString = new java/lang/IllegalStateException;
          paramString.<init>("getReadableDatabase called recursively");
          throw paramString;
        }
      }
      finally {}
      Object localObject2;
      Object localObject3;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase(paramString);
        paramString = localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException)
      {
        if (this.mName == null) {
          throw localSQLiteException;
        }
        localObject2 = TAG;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        Log.e((String)localObject2, "Couldn't open " + this.mName + " for writing (will try read-only):", localSQLiteException);
        localObject3 = null;
        localObject2 = null;
        Object localObject1 = localObject3;
        try
        {
          this.mIsInitializing = true;
          localObject1 = localObject3;
          String str = this.mContext.getDatabasePath(this.mName).getPath();
          localObject1 = localObject3;
          File localFile1 = new java/io/File;
          localObject1 = localObject3;
          localFile1.<init>(str);
          localObject1 = localObject3;
          File localFile2 = new java/io/File;
          localObject1 = localObject3;
          localFile2.<init>(this.mContext.getDatabasePath(this.mName).getParent());
          localObject1 = localObject3;
          if (!localFile2.exists())
          {
            localObject1 = localObject3;
            localFile2.mkdirs();
          }
          localObject1 = localObject3;
          if (!localFile1.exists())
          {
            localObject1 = localObject3;
            this.mIsInitializing = false;
            localObject1 = localObject3;
            localObject2 = getWritableDatabase(paramString);
            localObject1 = localObject2;
            this.mIsInitializing = true;
            localObject1 = localObject2;
            ((SQLiteDatabase)localObject2).close();
          }
          localObject1 = localObject2;
          localObject2 = SQLiteDatabase.openDatabase(str, paramString, this.mFactory, 1);
          localObject1 = localObject2;
          if (((SQLiteDatabase)localObject2).getVersion() != this.mNewVersion)
          {
            localObject1 = localObject2;
            paramString = new net/sqlcipher/database/SQLiteException;
            localObject1 = localObject2;
            localObject3 = new java/lang/StringBuilder;
            localObject1 = localObject2;
            ((StringBuilder)localObject3).<init>();
            localObject1 = localObject2;
            paramString.<init>("Can't upgrade read-only database from version " + ((SQLiteDatabase)localObject2).getVersion() + " to " + this.mNewVersion + ": " + str);
            localObject1 = localObject2;
            throw paramString;
          }
        }
        finally
        {
          this.mIsInitializing = false;
          if ((localObject1 != null) && (localObject1 != this.mDatabase)) {
            ((SQLiteDatabase)localObject1).close();
          }
        }
        localObject1 = localObject2;
        onOpen((SQLiteDatabase)localObject2);
        localObject1 = localObject2;
        localObject3 = TAG;
        localObject1 = localObject2;
        paramString = new java/lang/StringBuilder;
        localObject1 = localObject2;
        paramString.<init>();
        localObject1 = localObject2;
        Log.w((String)localObject3, "Opened " + this.mName + " in read-only mode");
        localObject1 = localObject2;
        this.mDatabase = ((SQLiteDatabase)localObject2);
        localObject1 = localObject2;
        localObject3 = this.mDatabase;
        this.mIsInitializing = false;
        paramString = (String)localObject3;
      }
      if (localObject2 != null)
      {
        paramString = (String)localObject3;
        if (localObject2 != this.mDatabase)
        {
          ((SQLiteDatabase)localObject2).close();
          paramString = (String)localObject3;
        }
      }
    }
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   13: invokevirtual 76	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   16: ifeq +22 -> 38
    //   19: aload_0
    //   20: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   23: invokevirtual 150	net/sqlcipher/database/SQLiteDatabase:isReadOnly	()Z
    //   26: ifne +12 -> 38
    //   29: aload_0
    //   30: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   33: astore_3
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: areturn
    //   38: aload_0
    //   39: getfield 36	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   42: ifeq +20 -> 62
    //   45: new 67	java/lang/IllegalStateException
    //   48: astore_1
    //   49: aload_1
    //   50: ldc -104
    //   52: invokespecial 70	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: athrow
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aconst_null
    //   63: astore 4
    //   65: aload_0
    //   66: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   69: ifnull +10 -> 79
    //   72: aload_0
    //   73: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   76: invokevirtual 155	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   79: aload 4
    //   81: astore_3
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 36	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   87: aload 4
    //   89: astore_3
    //   90: aload_0
    //   91: getfield 60	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   94: ifnonnull +111 -> 205
    //   97: aload 4
    //   99: astore_3
    //   100: aconst_null
    //   101: aload_1
    //   102: invokestatic 159	net/sqlcipher/database/SQLiteDatabase:create	(Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteDatabase;
    //   105: astore_1
    //   106: aload_1
    //   107: astore_3
    //   108: aload_1
    //   109: invokevirtual 126	net/sqlcipher/database/SQLiteDatabase:getVersion	()I
    //   112: istore_2
    //   113: aload_1
    //   114: astore_3
    //   115: iload_2
    //   116: aload_0
    //   117: getfield 64	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   120: if_icmpeq +36 -> 156
    //   123: aload_1
    //   124: astore_3
    //   125: aload_1
    //   126: invokevirtual 162	net/sqlcipher/database/SQLiteDatabase:beginTransaction	()V
    //   129: iload_2
    //   130: ifne +152 -> 282
    //   133: aload_0
    //   134: aload_1
    //   135: invokevirtual 165	net/sqlcipher/database/SQLiteOpenHelper:onCreate	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   138: aload_1
    //   139: aload_0
    //   140: getfield 64	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   143: invokevirtual 169	net/sqlcipher/database/SQLiteDatabase:setVersion	(I)V
    //   146: aload_1
    //   147: invokevirtual 172	net/sqlcipher/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   150: aload_1
    //   151: astore_3
    //   152: aload_1
    //   153: invokevirtual 175	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   156: aload_1
    //   157: astore_3
    //   158: aload_0
    //   159: aload_1
    //   160: invokevirtual 137	net/sqlcipher/database/SQLiteOpenHelper:onOpen	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   163: aload_0
    //   164: iconst_0
    //   165: putfield 36	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   168: iconst_1
    //   169: ifeq +206 -> 375
    //   172: aload_0
    //   173: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   176: astore_3
    //   177: aload_3
    //   178: ifnull +17 -> 195
    //   181: aload_0
    //   182: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   185: invokevirtual 78	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   188: aload_0
    //   189: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   192: invokevirtual 178	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   195: aload_0
    //   196: aload_1
    //   197: putfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   200: aload_1
    //   201: astore_3
    //   202: goto -168 -> 34
    //   205: aload 4
    //   207: astore_3
    //   208: aload_0
    //   209: getfield 58	net/sqlcipher/database/SQLiteOpenHelper:mContext	Landroid/content/Context;
    //   212: aload_0
    //   213: getfield 60	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   216: invokevirtual 103	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   219: invokevirtual 108	java/io/File:getPath	()Ljava/lang/String;
    //   222: astore 6
    //   224: aload 4
    //   226: astore_3
    //   227: new 105	java/io/File
    //   230: astore 5
    //   232: aload 4
    //   234: astore_3
    //   235: aload 5
    //   237: aload 6
    //   239: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: aload 4
    //   244: astore_3
    //   245: aload 5
    //   247: invokevirtual 115	java/io/File:exists	()Z
    //   250: ifne +15 -> 265
    //   253: aload 4
    //   255: astore_3
    //   256: aload 5
    //   258: invokevirtual 182	java/io/File:getParentFile	()Ljava/io/File;
    //   261: invokevirtual 118	java/io/File:mkdirs	()Z
    //   264: pop
    //   265: aload 4
    //   267: astore_3
    //   268: aload 6
    //   270: aload_1
    //   271: aload_0
    //   272: getfield 62	net/sqlcipher/database/SQLiteOpenHelper:mFactory	Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;
    //   275: invokestatic 186	net/sqlcipher/database/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;)Lnet/sqlcipher/database/SQLiteDatabase;
    //   278: astore_1
    //   279: goto -173 -> 106
    //   282: aload_0
    //   283: aload_1
    //   284: iload_2
    //   285: aload_0
    //   286: getfield 64	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   289: invokevirtual 190	net/sqlcipher/database/SQLiteOpenHelper:onUpgrade	(Lnet/sqlcipher/database/SQLiteDatabase;II)V
    //   292: goto -154 -> 138
    //   295: astore 4
    //   297: aload_1
    //   298: astore_3
    //   299: aload_1
    //   300: invokevirtual 175	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   303: aload_1
    //   304: astore_3
    //   305: aload 4
    //   307: athrow
    //   308: astore_1
    //   309: aload_0
    //   310: iconst_0
    //   311: putfield 36	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   314: iconst_0
    //   315: ifeq +35 -> 350
    //   318: aload_0
    //   319: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   322: astore 4
    //   324: aload 4
    //   326: ifnull +17 -> 343
    //   329: aload_0
    //   330: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   333: invokevirtual 78	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   336: aload_0
    //   337: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   340: invokevirtual 178	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   343: aload_0
    //   344: aload_3
    //   345: putfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   348: aload_1
    //   349: athrow
    //   350: aload_0
    //   351: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   354: ifnull +10 -> 364
    //   357: aload_0
    //   358: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   361: invokevirtual 178	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   364: aload_3
    //   365: ifnull -17 -> 348
    //   368: aload_3
    //   369: invokevirtual 78	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   372: goto -24 -> 348
    //   375: aload_0
    //   376: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   379: ifnull +10 -> 389
    //   382: aload_0
    //   383: getfield 34	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   386: invokevirtual 178	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   389: aload_1
    //   390: astore_3
    //   391: aload_1
    //   392: ifnull -358 -> 34
    //   395: aload_1
    //   396: invokevirtual 78	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   399: aload_1
    //   400: astore_3
    //   401: goto -367 -> 34
    //   404: astore_3
    //   405: goto -217 -> 188
    //   408: astore 4
    //   410: goto -74 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	SQLiteOpenHelper
    //   0	413	1	paramString	String
    //   112	173	2	i	int
    //   33	368	3	localObject1	Object
    //   404	1	3	localException1	Exception
    //   63	203	4	localObject2	Object
    //   295	11	4	localObject3	Object
    //   322	3	4	localSQLiteDatabase	SQLiteDatabase
    //   408	1	4	localException2	Exception
    //   230	27	5	localFile	File
    //   222	47	6	str	String
    // Exception table:
    //   from	to	target	type
    //   2	34	57	finally
    //   38	57	57	finally
    //   65	79	57	finally
    //   163	168	57	finally
    //   172	177	57	finally
    //   181	188	57	finally
    //   188	195	57	finally
    //   195	200	57	finally
    //   309	314	57	finally
    //   318	324	57	finally
    //   329	336	57	finally
    //   336	343	57	finally
    //   343	348	57	finally
    //   348	350	57	finally
    //   350	364	57	finally
    //   368	372	57	finally
    //   375	389	57	finally
    //   395	399	57	finally
    //   133	138	295	finally
    //   138	150	295	finally
    //   282	292	295	finally
    //   82	87	308	finally
    //   90	97	308	finally
    //   100	106	308	finally
    //   108	113	308	finally
    //   115	123	308	finally
    //   125	129	308	finally
    //   152	156	308	finally
    //   158	163	308	finally
    //   208	224	308	finally
    //   227	232	308	finally
    //   235	242	308	finally
    //   245	253	308	finally
    //   256	265	308	finally
    //   268	279	308	finally
    //   299	303	308	finally
    //   305	308	308	finally
    //   181	188	404	java/lang/Exception
    //   329	336	408	java/lang/Exception
  }
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */