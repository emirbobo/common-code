package com.lidroid.xutils.db.table;

import com.bangcle.andjni.JniLib;
import java.util.HashMap;

public class DbModel
{
  private HashMap<String, String> dataMap = new HashMap();
  
  static
  {
    JniLib.a(DbModel.class, 973);
  }
  
  public native void add(String paramString1, String paramString2);
  
  public native boolean getBoolean(String paramString);
  
  public native HashMap<String, String> getDataMap();
  
  public native java.util.Date getDate(String paramString);
  
  public native double getDouble(String paramString);
  
  public native float getFloat(String paramString);
  
  public native int getInt(String paramString);
  
  public native long getLong(String paramString);
  
  public native java.sql.Date getSqlDate(String paramString);
  
  public native String getString(String paramString);
  
  public native boolean isEmpty(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\table\DbModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */