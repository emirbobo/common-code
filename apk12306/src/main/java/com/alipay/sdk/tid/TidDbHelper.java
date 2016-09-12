package com.alipay.sdk.tid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bangcle.andjni.JniLib;
import java.lang.ref.WeakReference;
import java.util.List;

final class TidDbHelper
  extends SQLiteOpenHelper
{
  private static final String a = "msp.db";
  private static final int b = 1;
  private WeakReference c;
  
  static
  {
    JniLib.a(TidDbHelper.class, 124);
  }
  
  public TidDbHelper(Context paramContext)
  {
    super(paramContext, "msp.db", null, 1);
    this.c = new WeakReference(paramContext);
  }
  
  private native void a(SQLiteDatabase paramSQLiteDatabase);
  
  private native void a(SQLiteDatabase paramSQLiteDatabase, String paramString);
  
  private native void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private native boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2);
  
  private native void b(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private native String e(String paramString1, String paramString2);
  
  public native List a();
  
  public native void a(String paramString1, String paramString2);
  
  public native void a(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public native String b(String paramString1, String paramString2);
  
  public native long c(String paramString1, String paramString2);
  
  public native String d(String paramString1, String paramString2);
  
  public native void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public native void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\tid\TidDbHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */