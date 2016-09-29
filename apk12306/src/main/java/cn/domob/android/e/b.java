package cn.domob.android.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import cn.domob.android.i.f;
import org.json.JSONArray;
import org.json.JSONException;

class b
  extends SQLiteOpenHelper
{
  private static final int b = 1;
  private static final String c = "Freq.db";
  private static b e = null;
  private static final String f = " TEXT";
  private static final String g = " LONG";
  private static final String h = " INTEGER";
  private static final String i = ",";
  private static final String j = "CREATE TABLE IF NOT EXISTS freq(_id INTEGER PRIMARY KEY,frequency_id TEXT,imp_times INTEGER,imp_limit_times INTEGER,click_times INTEGER,click_limit_times INTEGER,end_time LONG,update_time LONG );";
  private static final String k = "DROP TABLE IF EXISTS freq";
  f a = new f(b.class.getSimpleName());
  private SQLiteDatabase d = null;
  
  private b(Context paramContext)
  {
    super(paramContext.getApplicationContext(), "Freq.db", null, 1);
    try
    {
      this.d = getWritableDatabase();
      return;
    }
    catch (SQLiteException paramContext)
    {
      for (;;)
      {
        this.a.a(paramContext);
      }
    }
  }
  
  protected static b a(Context paramContext)
  {
    try
    {
      if ((e == null) || (!e.e()))
      {
        b localb = new cn/domob/android/e/b;
        localb.<init>(paramContext);
        e = localb;
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  private boolean a(a parama)
  {
    boolean bool = false;
    if (!e()) {}
    for (;;)
    {
      return bool;
      this.a.a("insert a new data : " + parama.toString());
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("frequency_id", parama.a());
      localContentValues.put("imp_times", Integer.valueOf(parama.b()));
      localContentValues.put("imp_limit_times", Integer.valueOf(parama.c()));
      localContentValues.put("click_times", Integer.valueOf(parama.d()));
      localContentValues.put("click_limit_times", Integer.valueOf(parama.e()));
      localContentValues.put("end_time", Long.valueOf(parama.f()));
      localContentValues.put("update_time", Long.valueOf(parama.g()));
      if (this.d.insert("freq", null, localContentValues) <= 0L)
      {
        this.a.e("Insert: failed! " + localContentValues.toString());
      }
      else
      {
        this.a.b("insert successfully");
        bool = true;
      }
    }
  }
  
  private String c(JSONArray paramJSONArray)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("(");
    for (int m = 0;; m++)
    {
      if (m >= paramJSONArray.length()) {
        break label132;
      }
      Object localObject = null;
      try
      {
        String str = paramJSONArray.getString(m);
        localObject = str;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          this.a.a(localJSONException);
        }
      }
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = ((String)localObject).split("_");
        if ((localObject != null) && (localObject.length == 4))
        {
          localObject = localObject[0];
          localStringBuffer.append("frequency_id");
          localStringBuffer.append(" = ");
          localStringBuffer.append((String)localObject);
          if (m != paramJSONArray.length() - 1) {
            localStringBuffer.append(" or ");
          }
        }
      }
    }
    label132:
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
  
  private boolean e()
  {
    if ((this.d != null) && (this.d.isOpen()) && (!this.d.isReadOnly())) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      this.a.e("freq database is not available");
    }
  }
  
  /* Error */
  protected int a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokespecial 83	cn/domob/android/e/b:e	()Z
    //   7: ifne +7 -> 14
    //   10: iconst_m1
    //   11: istore_3
    //   12: iload_3
    //   13: ireturn
    //   14: aload_0
    //   15: getfield 72	cn/domob/android/e/b:d	Landroid/database/sqlite/SQLiteDatabase;
    //   18: ldc -98
    //   20: iconst_1
    //   21: anewarray 195	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc -34
    //   28: aastore
    //   29: aload_1
    //   30: aload_2
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 226	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +44 -> 83
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: invokeinterface 231 1 0
    //   50: istore 4
    //   52: iload 4
    //   54: istore_3
    //   55: aload_2
    //   56: ifnull -44 -> 12
    //   59: iload 4
    //   61: istore_3
    //   62: aload_2
    //   63: invokeinterface 234 1 0
    //   68: ifne -56 -> 12
    //   71: aload_2
    //   72: invokeinterface 237 1 0
    //   77: iload 4
    //   79: istore_3
    //   80: goto -68 -> 12
    //   83: aload_2
    //   84: ifnull +18 -> 102
    //   87: aload_2
    //   88: invokeinterface 234 1 0
    //   93: ifne +9 -> 102
    //   96: aload_2
    //   97: invokeinterface 237 1 0
    //   102: iconst_m1
    //   103: istore_3
    //   104: goto -92 -> 12
    //   107: astore 5
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 70	cn/domob/android/e/b:a	Lcn/domob/android/i/f;
    //   117: aload 5
    //   119: invokevirtual 79	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   122: aload_2
    //   123: ifnull -21 -> 102
    //   126: aload_2
    //   127: invokeinterface 234 1 0
    //   132: ifne -30 -> 102
    //   135: aload_2
    //   136: invokeinterface 237 1 0
    //   141: goto -39 -> 102
    //   144: astore_2
    //   145: aload 5
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +18 -> 167
    //   152: aload_1
    //   153: invokeinterface 234 1 0
    //   158: ifne +9 -> 167
    //   161: aload_1
    //   162: invokeinterface 237 1 0
    //   167: aload_2
    //   168: athrow
    //   169: astore_2
    //   170: goto -22 -> 148
    //   173: astore 5
    //   175: goto -64 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	b
    //   0	178	1	paramString	String
    //   0	178	2	paramArrayOfString	String[]
    //   11	93	3	m	int
    //   50	28	4	n	int
    //   1	1	5	localObject	Object
    //   107	39	5	localException1	Exception
    //   173	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   14	38	107	java/lang/Exception
    //   14	38	144	finally
    //   44	52	169	finally
    //   113	122	169	finally
    //   44	52	173	java/lang/Exception
  }
  
  protected Cursor a(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = null;
    if (!e()) {}
    for (paramArrayOfString1 = localSQLiteQueryBuilder;; paramArrayOfString1 = localSQLiteQueryBuilder.query(this.d, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2))
    {
      return paramArrayOfString1;
      localSQLiteQueryBuilder = new SQLiteQueryBuilder();
      localSQLiteQueryBuilder.setTables("freq");
    }
  }
  
  protected void a()
  {
    if (!e()) {}
    for (;;)
    {
      return;
      this.a.d("empty database");
      this.d.delete("freq", null, null);
    }
  }
  
  protected void a(JSONArray paramJSONArray)
  {
    this.a.b("imp Times of current ad Add One");
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0) || (!e())) {
      this.a.b("freqJSONArray is not available");
    }
    for (;;)
    {
      return;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("update ").append("freq").append(" set ").append("imp_times").append(" = ").append("imp_times").append(" + 1, ").append("update_time").append(" = ").append(System.currentTimeMillis()).append(" where ").append(c(paramJSONArray)).append(" and ").append("end_time").append(">").append(System.currentTimeMillis());
      paramJSONArray = localStringBuffer.toString();
      this.a.a(paramJSONArray);
      try
      {
        this.d.execSQL(paramJSONArray);
      }
      catch (SQLException paramJSONArray)
      {
        this.a.a(paramJSONArray);
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    boolean bool = false;
    if (!e()) {}
    for (;;)
    {
      return bool;
      this.a.b("deleted from DB which freqId is " + paramString);
      this.d.delete("freq", "frequency_id= ?", new String[] { paramString });
      bool = true;
    }
  }
  
  protected boolean a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (!e()) {}
    for (;;)
    {
      return bool;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("imp_limit_times", Integer.valueOf(paramInt1));
      localContentValues.put("click_limit_times", Integer.valueOf(paramInt2));
      this.a.a("update DB, and the updated content is " + localContentValues.toString());
      long l = System.currentTimeMillis();
      paramInt1 = this.d.update("freq", localContentValues, "frequency_id = ? and end_time > ?", new String[] { paramString, String.valueOf(l) });
      if (paramInt1 == 1)
      {
        this.a.b("update BD successfully");
        bool = true;
      }
      else
      {
        this.a.e("update DB failed and the affected row number is " + paramInt1);
      }
    }
  }
  
  protected boolean a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    a locala = new a();
    locala.a(paramString);
    locala.a(0);
    locala.b(paramInt1);
    locala.c(0);
    locala.d(paramInt2);
    locala.a(paramLong);
    locala.b(System.currentTimeMillis());
    return a(locala);
  }
  
  /* Error */
  protected String b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 83	cn/domob/android/e/b:e	()Z
    //   4: ifne +9 -> 13
    //   7: ldc_w 334
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: aload_0
    //   14: getfield 72	cn/domob/android/e/b:d	Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc -98
    //   19: iconst_1
    //   20: anewarray 195	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc_w 336
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 226	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +339 -> 378
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: invokeinterface 231 1 0
    //   50: pop
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 339 1 0
    //   59: pop
    //   60: ldc_w 341
    //   63: astore_3
    //   64: aload_2
    //   65: astore_1
    //   66: aload_2
    //   67: invokeinterface 344 1 0
    //   72: ifne +278 -> 350
    //   75: aload_2
    //   76: astore_1
    //   77: getstatic 348	java/lang/System:out	Ljava/io/PrintStream;
    //   80: ldc_w 350
    //   83: invokevirtual 355	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   86: aload_2
    //   87: astore_1
    //   88: new 6	cn/domob/android/e/b$a
    //   91: astore 5
    //   93: aload_2
    //   94: astore_1
    //   95: aload 5
    //   97: aload_0
    //   98: invokespecial 315	cn/domob/android/e/b$a:<init>	(Lcn/domob/android/e/b;)V
    //   101: aload_2
    //   102: astore_1
    //   103: aload 5
    //   105: aload_2
    //   106: aload_2
    //   107: ldc 107
    //   109: invokeinterface 359 2 0
    //   114: invokeinterface 360 2 0
    //   119: invokevirtual 316	cn/domob/android/e/b$a:a	(Ljava/lang/String;)V
    //   122: aload_2
    //   123: astore_1
    //   124: aload 5
    //   126: aload_2
    //   127: aload_2
    //   128: ldc 115
    //   130: invokeinterface 359 2 0
    //   135: invokeinterface 364 2 0
    //   140: invokevirtual 319	cn/domob/android/e/b$a:a	(I)V
    //   143: aload_2
    //   144: astore_1
    //   145: aload 5
    //   147: aload_2
    //   148: aload_2
    //   149: ldc -127
    //   151: invokeinterface 359 2 0
    //   156: invokeinterface 364 2 0
    //   161: invokevirtual 321	cn/domob/android/e/b$a:b	(I)V
    //   164: aload_2
    //   165: astore_1
    //   166: aload 5
    //   168: aload_2
    //   169: aload_2
    //   170: ldc -123
    //   172: invokeinterface 359 2 0
    //   177: invokeinterface 364 2 0
    //   182: invokevirtual 323	cn/domob/android/e/b$a:c	(I)V
    //   185: aload_2
    //   186: astore_1
    //   187: aload 5
    //   189: aload_2
    //   190: aload_2
    //   191: ldc -119
    //   193: invokeinterface 359 2 0
    //   198: invokeinterface 364 2 0
    //   203: invokevirtual 325	cn/domob/android/e/b$a:d	(I)V
    //   206: aload_2
    //   207: astore_1
    //   208: aload 5
    //   210: aload_2
    //   211: aload_2
    //   212: ldc -115
    //   214: invokeinterface 359 2 0
    //   219: invokeinterface 368 2 0
    //   224: invokevirtual 328	cn/domob/android/e/b$a:a	(J)V
    //   227: aload_2
    //   228: astore_1
    //   229: aload 5
    //   231: aload_2
    //   232: aload_2
    //   233: ldc -102
    //   235: invokeinterface 359 2 0
    //   240: invokeinterface 368 2 0
    //   245: invokevirtual 330	cn/domob/android/e/b$a:b	(J)V
    //   248: aload_2
    //   249: astore_1
    //   250: getstatic 348	java/lang/System:out	Ljava/io/PrintStream;
    //   253: aload 5
    //   255: invokevirtual 99	cn/domob/android/e/b$a:toString	()Ljava/lang/String;
    //   258: invokevirtual 355	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   261: aload_2
    //   262: astore_1
    //   263: new 88	java/lang/StringBuilder
    //   266: astore 4
    //   268: aload_2
    //   269: astore_1
    //   270: aload 4
    //   272: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   275: aload_2
    //   276: astore_1
    //   277: aload 4
    //   279: aload_3
    //   280: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 5
    //   285: invokevirtual 99	cn/domob/android/e/b$a:toString	()Ljava/lang/String;
    //   288: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 370
    //   294: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore_3
    //   301: aload_2
    //   302: astore_1
    //   303: aload_2
    //   304: invokeinterface 373 1 0
    //   309: pop
    //   310: goto -246 -> 64
    //   313: astore_3
    //   314: aload_2
    //   315: astore_1
    //   316: aload_0
    //   317: getfield 70	cn/domob/android/e/b:a	Lcn/domob/android/i/f;
    //   320: aload_3
    //   321: invokevirtual 79	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   324: aload_2
    //   325: ifnull +18 -> 343
    //   328: aload_2
    //   329: invokeinterface 234 1 0
    //   334: ifne +9 -> 343
    //   337: aload_2
    //   338: invokeinterface 237 1 0
    //   343: ldc_w 375
    //   346: astore_1
    //   347: goto -336 -> 11
    //   350: aload_3
    //   351: astore_1
    //   352: aload_2
    //   353: ifnull -342 -> 11
    //   356: aload_3
    //   357: astore_1
    //   358: aload_2
    //   359: invokeinterface 234 1 0
    //   364: ifne -353 -> 11
    //   367: aload_2
    //   368: invokeinterface 237 1 0
    //   373: aload_3
    //   374: astore_1
    //   375: goto -364 -> 11
    //   378: aload_2
    //   379: ifnull -36 -> 343
    //   382: aload_2
    //   383: invokeinterface 234 1 0
    //   388: ifne -45 -> 343
    //   391: aload_2
    //   392: invokeinterface 237 1 0
    //   397: goto -54 -> 343
    //   400: astore_2
    //   401: aconst_null
    //   402: astore_1
    //   403: aload_1
    //   404: ifnull +18 -> 422
    //   407: aload_1
    //   408: invokeinterface 234 1 0
    //   413: ifne +9 -> 422
    //   416: aload_1
    //   417: invokeinterface 237 1 0
    //   422: aload_2
    //   423: athrow
    //   424: astore_2
    //   425: goto -22 -> 403
    //   428: astore_3
    //   429: aconst_null
    //   430: astore_2
    //   431: goto -117 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	b
    //   10	407	1	localObject1	Object
    //   37	355	2	localCursor	Cursor
    //   400	23	2	localObject2	Object
    //   424	1	2	localObject3	Object
    //   430	1	2	localObject4	Object
    //   63	238	3	str	String
    //   313	61	3	localException1	Exception
    //   428	1	3	localException2	Exception
    //   266	12	4	localStringBuilder	StringBuilder
    //   91	193	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   44	51	313	java/lang/Exception
    //   53	60	313	java/lang/Exception
    //   66	75	313	java/lang/Exception
    //   77	86	313	java/lang/Exception
    //   88	93	313	java/lang/Exception
    //   95	101	313	java/lang/Exception
    //   103	122	313	java/lang/Exception
    //   124	143	313	java/lang/Exception
    //   145	164	313	java/lang/Exception
    //   166	185	313	java/lang/Exception
    //   187	206	313	java/lang/Exception
    //   208	227	313	java/lang/Exception
    //   229	248	313	java/lang/Exception
    //   250	261	313	java/lang/Exception
    //   263	268	313	java/lang/Exception
    //   270	275	313	java/lang/Exception
    //   277	301	313	java/lang/Exception
    //   303	310	313	java/lang/Exception
    //   13	38	400	finally
    //   44	51	424	finally
    //   53	60	424	finally
    //   66	75	424	finally
    //   77	86	424	finally
    //   88	93	424	finally
    //   95	101	424	finally
    //   103	122	424	finally
    //   124	143	424	finally
    //   145	164	424	finally
    //   166	185	424	finally
    //   187	206	424	finally
    //   208	227	424	finally
    //   229	248	424	finally
    //   250	261	424	finally
    //   263	268	424	finally
    //   270	275	424	finally
    //   277	301	424	finally
    //   303	310	424	finally
    //   316	324	424	finally
    //   13	38	428	java/lang/Exception
  }
  
  protected void b(JSONArray paramJSONArray)
  {
    this.a.b("click Times of current ad Add One");
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0) || (!e())) {
      this.a.b("freqJSONArray is not available");
    }
    for (;;)
    {
      return;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("update ").append("freq").append(" set ").append("click_times").append(" = ").append("click_times").append(" + 1, ").append("update_time").append(" = ").append(System.currentTimeMillis()).append(" where ").append(c(paramJSONArray)).append(" and ").append("end_time").append(">").append(System.currentTimeMillis());
      paramJSONArray = localStringBuffer.toString();
      this.a.a(paramJSONArray);
      try
      {
        this.d.execSQL(paramJSONArray);
      }
      catch (SQLException paramJSONArray)
      {
        this.a.a(paramJSONArray);
      }
    }
  }
  
  protected void c()
  {
    if (!e()) {}
    for (;;)
    {
      return;
      this.a.b("delete expired data from DB");
      long l = System.currentTimeMillis();
      this.d.delete("freq", "end_time < ?", new String[] { String.valueOf(l) });
    }
  }
  
  protected void d()
  {
    if ((this.d != null) && (this.d.isOpen())) {
      this.d.close();
    }
    if (e != null) {
      e = null;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS freq(_id INTEGER PRIMARY KEY,frequency_id TEXT,imp_times INTEGER,imp_limit_times INTEGER,click_times INTEGER,click_limit_times INTEGER,end_time LONG,update_time LONG );");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      for (;;)
      {
        this.a.a(paramSQLiteDatabase);
      }
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS freq");
      onCreate(paramSQLiteDatabase);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        this.a.a(localSQLException);
      }
    }
  }
  
  protected class a
  {
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private long g;
    private long h;
    
    protected a() {}
    
    protected String a()
    {
      return this.b;
    }
    
    protected void a(int paramInt)
    {
      this.c = paramInt;
    }
    
    protected void a(long paramLong)
    {
      this.g = paramLong;
    }
    
    protected void a(String paramString)
    {
      this.b = paramString;
    }
    
    protected int b()
    {
      return this.c;
    }
    
    protected void b(int paramInt)
    {
      this.d = paramInt;
    }
    
    protected void b(long paramLong)
    {
      this.h = paramLong;
    }
    
    protected int c()
    {
      return this.d;
    }
    
    protected void c(int paramInt)
    {
      this.e = paramInt;
    }
    
    protected int d()
    {
      return this.e;
    }
    
    protected void d(int paramInt)
    {
      this.f = paramInt;
    }
    
    protected int e()
    {
      return this.f;
    }
    
    protected long f()
    {
      return this.g;
    }
    
    protected long g()
    {
      return this.h;
    }
    
    public String toString()
    {
      return "Freq [freqId=" + this.b + ", impTimes=" + this.c + ", impLimitTimes=" + this.d + ", clickTimes=" + this.e + ", clickLimitTimes=" + this.f + ", endTimestamp=" + this.g + ", updateTimestamp=" + this.h + "]";
    }
  }
  
  protected static abstract class b
    implements BaseColumns
  {
    protected static final String a = "freq";
    protected static final String b = "frequency_id";
    protected static final String c = "imp_times";
    protected static final String d = "imp_limit_times";
    protected static final String e = "click_times";
    protected static final String f = "click_limit_times";
    protected static final String g = "end_time";
    protected static final String h = "update_time";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */