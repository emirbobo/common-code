package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;
import java.util.ArrayList;
import java.util.List;

public class WhereBuilder
{
  private final List<String> whereItems = new ArrayList();
  
  static
  {
    JniLib.a(WhereBuilder.class, 970);
  }
  
  private native void appendCondition(String paramString1, String paramString2, String paramString3, Object paramObject);
  
  public static native WhereBuilder b();
  
  public static native WhereBuilder b(String paramString1, String paramString2, Object paramObject);
  
  public native WhereBuilder and(String paramString1, String paramString2, Object paramObject);
  
  public native WhereBuilder expr(String paramString);
  
  public native WhereBuilder expr(String paramString1, String paramString2, Object paramObject);
  
  public native int getWhereItemSize();
  
  public native WhereBuilder or(String paramString1, String paramString2, Object paramObject);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\WhereBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */