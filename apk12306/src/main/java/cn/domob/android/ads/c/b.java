package cn.domob.android.ads.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import cn.domob.android.i.f;

public final class b
  extends SQLiteOpenHelper
{
  static final String a = "def_res";
  static final String b = "tmp_res";
  static final String c = "domob_ads.db";
  public static final String d = "domob_splash_ad_cache_res";
  public static final String e = "creative_alias";
  public static final String f = "alias_info";
  public static final int g = 2;
  public static final int h = 10;
  private static b j = null;
  private static f l = new f(b.class.getSimpleName());
  private Context i;
  private SQLiteDatabase k = null;
  
  private b(Context paramContext)
  {
    super(paramContext, "domob_ads.db", null, 2);
    this.i = paramContext;
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (j == null)
      {
        b localb = new cn/domob/android/ads/c/b;
        localb.<init>(paramContext);
        j = localb;
      }
      paramContext = j;
      return paramContext;
    }
    finally {}
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return this.k.update(paramString1, paramContentValues, paramString2, null);
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return this.k.delete(paramString1, paramString2, null);
  }
  
  public Context a()
  {
    return this.i;
  }
  
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    return this.k.rawQuery(paramString, paramArrayOfString);
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables(paramString1);
    return localSQLiteQueryBuilder.query(this.k, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3);
  }
  
  public boolean a(String paramString, ContentValues paramContentValues)
  {
    if (this.k.insert(paramString, null, paramContentValues) <= 0L) {
      l.e("Insert: failed! " + paramContentValues.toString());
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public void b()
  {
    if ((this.k != null) && (this.k.isOpen())) {
      this.k.close();
    }
    if (j != null) {
      j = null;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS domob_splash_ad_cache_res(_ad_id VARCHAR NOT NULL PRIMARY KEY,_ad_content TEXT ,_ad_alive_time LONG ,_enter_db_time LONG ,_orientation VARCHAR ,_ad_type VARCHAR );");
    paramSQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s VARCHAR NOT NULL, %s VARCHAR NOT NULL, PRIMARY KEY (%s, %s));", new Object[] { "creative_alias", "creative_id", "alias", "creative_id", "alias" }));
    paramSQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s VARCHAR NOT NULL PRIMARY KEY, %s TEXT, %s TEXT, %s INTEGER);", new Object[] { "alias_info", "alias", "url", "local_path", "ts" }));
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS def_res;");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS tmp_res;");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS domob_splash_ad_cache_res;");
    onCreate(paramSQLiteDatabase);
  }
  
  public static final class a
    implements BaseColumns
  {
    public static final String a = "_ad_id";
    public static final String b = "_ad_content";
    public static final String c = "_ad_alive_time";
    public static final String d = "_enter_db_time";
    public static final String e = "_ad_type";
    public static final String f = "_orientation";
  }
  
  public static final class b
    implements BaseColumns
  {
    public static final String a = "alias";
    public static final String b = "url";
    public static final String c = "local_path";
    public static final String d = "creative_id";
    public static final String e = "ts";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */