package a.a.a.a.a;

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

class b
  extends SQLiteOpenHelper
{
  protected static final int b = 1;
  protected static final int c = 0;
  protected static final long d = 0L;
  protected static final long e = -1L;
  protected static final int f = 0;
  protected static final int g = 1;
  protected static final int h = 2;
  protected static final int i = 3;
  protected static final int j = 0;
  protected static final int k = 1;
  protected static final int l = 2;
  protected static final int m = 3;
  protected static final int n = 4;
  private static final int o = 1;
  private static final String p = "Cache.db";
  private static b r = null;
  private static final String s = " TEXT";
  private static final String t = " LONG";
  private static final String u = " INTEGER";
  private static final String v = ",";
  private static final String w = "CREATE TABLE IF NOT EXISTS resourceGroup(_id INTEGER PRIMARY KEY,Rgid TEXT,Expires LONG,UseDate LONG,Ppid TEXT,Tracker TEXT,EventTrackerURL TEXT,State INTEGER );";
  private static final String x = "CREATE TABLE IF NOT EXISTS resource(_id INTEGER PRIMARY KEY,Ridd TEXT,Rgid TEXT,Type INTEGER,ResourceUrl TEXT,Path TEXT,DownState INTEGER,ContentLength LONG,CreatDate LONG,Width INTEGER,Height INTEGER );";
  private static final String y = "DROP TABLE IF EXISTS resourceGroup";
  private static final String z = "DROP TABLE IF EXISTS resource";
  f a = new f(b.class.getSimpleName());
  private SQLiteDatabase q = null;
  
  private b(Context paramContext)
  {
    super(paramContext.getApplicationContext(), "Cache.db", null, 1);
    try
    {
      this.q = getWritableDatabase();
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
      if ((r == null) || (!r.a()))
      {
        b localb = new a/a/a/a/a/b;
        localb.<init>(paramContext);
        r = localb;
      }
      paramContext = r;
      return paramContext;
    }
    finally {}
  }
  
  protected int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    if (!a()) {}
    for (int i1 = -1;; i1 = this.q.update(paramString1, paramContentValues, paramString2, paramArrayOfString)) {
      return i1;
    }
  }
  
  /* Error */
  protected int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 111	a/a/a/a/a/b:a	()Z
    //   7: ifne +9 -> 16
    //   10: iconst_m1
    //   11: istore 4
    //   13: iload 4
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 100	a/a/a/a/a/b:q	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_1
    //   21: iconst_1
    //   22: anewarray 124	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 126
    //   29: aastore
    //   30: aload_2
    //   31: aload_3
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 130	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +47 -> 87
    //   43: aload_2
    //   44: astore_1
    //   45: aload_2
    //   46: invokeinterface 136 1 0
    //   51: istore 5
    //   53: iload 5
    //   55: istore 4
    //   57: aload_2
    //   58: ifnull -45 -> 13
    //   61: iload 5
    //   63: istore 4
    //   65: aload_2
    //   66: invokeinterface 139 1 0
    //   71: ifne -58 -> 13
    //   74: aload_2
    //   75: invokeinterface 142 1 0
    //   80: iload 5
    //   82: istore 4
    //   84: goto -71 -> 13
    //   87: aload_2
    //   88: ifnull +18 -> 106
    //   91: aload_2
    //   92: invokeinterface 139 1 0
    //   97: ifne +9 -> 106
    //   100: aload_2
    //   101: invokeinterface 142 1 0
    //   106: iconst_m1
    //   107: istore 4
    //   109: goto -96 -> 13
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 98	a/a/a/a/a/b:a	Lcn/domob/android/i/f;
    //   121: aload_3
    //   122: invokevirtual 107	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   125: aload_2
    //   126: ifnull -20 -> 106
    //   129: aload_2
    //   130: invokeinterface 139 1 0
    //   135: ifne -29 -> 106
    //   138: aload_2
    //   139: invokeinterface 142 1 0
    //   144: goto -38 -> 106
    //   147: astore_2
    //   148: aload 6
    //   150: astore_1
    //   151: aload_1
    //   152: ifnull +18 -> 170
    //   155: aload_1
    //   156: invokeinterface 139 1 0
    //   161: ifne +9 -> 170
    //   164: aload_1
    //   165: invokeinterface 142 1 0
    //   170: aload_2
    //   171: athrow
    //   172: astore_2
    //   173: goto -22 -> 151
    //   176: astore_3
    //   177: goto -62 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	b
    //   0	180	1	paramString1	String
    //   0	180	2	paramString2	String
    //   0	180	3	paramArrayOfString	String[]
    //   11	97	4	i1	int
    //   51	30	5	i2	int
    //   1	148	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	39	112	java/lang/Exception
    //   16	39	147	finally
    //   45	53	172	finally
    //   117	125	172	finally
    //   45	53	176	java/lang/Exception
  }
  
  protected Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = null;
    if (!a()) {}
    for (paramString1 = localSQLiteQueryBuilder;; paramString1 = localSQLiteQueryBuilder.query(this.q, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3, paramString4))
    {
      return paramString1;
      localSQLiteQueryBuilder = new SQLiteQueryBuilder();
      localSQLiteQueryBuilder.setTables(paramString1);
    }
  }
  
  protected void a(String paramString)
  {
    if (!a()) {}
    for (;;)
    {
      return;
      this.q.delete("resourceGroup", "Rgid= ?", new String[] { paramString });
    }
  }
  
  protected boolean a()
  {
    if ((this.q != null) && (this.q.isOpen()) && (!this.q.isReadOnly())) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      this.a.e("freq database is not available");
    }
  }
  
  protected boolean a(c paramc)
  {
    if (!a()) {}
    ContentValues localContentValues;
    for (boolean bool = false;; bool = a("resource", localContentValues))
    {
      return bool;
      this.a.a("insert a new data : " + paramc.toString());
      localContentValues = new ContentValues();
      localContentValues.put("Ridd", paramc.a());
      localContentValues.put("Rgid", paramc.b());
      localContentValues.put("Type", Integer.valueOf(paramc.c()));
      localContentValues.put("ResourceUrl", paramc.d());
      localContentValues.put("Path", paramc.e());
      localContentValues.put("DownState", Integer.valueOf(paramc.f()));
      localContentValues.put("ContentLength", Long.valueOf(paramc.g()));
      localContentValues.put("CreatDate", Long.valueOf(paramc.h()));
      localContentValues.put("Width", Integer.valueOf(paramc.i()));
      localContentValues.put("Height", Integer.valueOf(paramc.j()));
    }
  }
  
  protected boolean a(String paramString, ContentValues paramContentValues)
  {
    if (this.q.insert(paramString, null, paramContentValues) < 0L) {
      this.a.e("Insert: failed! " + paramContentValues.toString());
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      this.a.b("insert successfully");
    }
  }
  
  protected void b()
  {
    if (!a()) {}
    for (;;)
    {
      return;
      this.a.d("empty database");
      this.q.delete("resourceGroup", null, null);
      this.q.delete("resource", null, null);
    }
  }
  
  protected void b(String paramString)
  {
    if (!a()) {}
    for (;;)
    {
      return;
      this.q.delete("resource", "_id = ?", new String[] { paramString });
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS resourceGroup(_id INTEGER PRIMARY KEY,Rgid TEXT,Expires LONG,UseDate LONG,Ppid TEXT,Tracker TEXT,EventTrackerURL TEXT,State INTEGER );");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS resource(_id INTEGER PRIMARY KEY,Ridd TEXT,Rgid TEXT,Type INTEGER,ResourceUrl TEXT,Path TEXT,DownState INTEGER,ContentLength LONG,CreatDate LONG,Width INTEGER,Height INTEGER );");
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
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS resourceGroup");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS resource");
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
  
  protected static abstract class a
    implements BaseColumns
  {
    protected static final String a = "resourceGroup";
    protected static final String b = "Rgid";
    protected static final String c = "Expires";
    protected static final String d = "UseDate";
    protected static final String e = "State";
    protected static final String f = "Ppid";
    protected static final String g = "Tracker";
    protected static final String h = "EventTrackerURL";
  }
  
  protected static abstract class b
    implements BaseColumns
  {
    protected static final String a = "resource";
    protected static final String b = "Ridd";
    protected static final String c = "Rgid";
    protected static final String d = "Type";
    protected static final String e = "ResourceUrl";
    protected static final String f = "Path";
    protected static final String g = "DownState";
    protected static final String h = "ContentLength";
    protected static final String i = "CreatDate";
    protected static final String j = "Width";
    protected static final String k = "Height";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\a\a\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */