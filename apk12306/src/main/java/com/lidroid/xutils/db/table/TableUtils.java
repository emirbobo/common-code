package com.lidroid.xutils.db.table;

import com.bangcle.andjni.JniLib;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TableUtils
{
  private static ConcurrentHashMap<String, HashMap<String, Column>> entityColumnsMap = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Id> entityIdMap = new ConcurrentHashMap();
  
  static
  {
    JniLib.a(TableUtils.class, 978);
  }
  
  private static native void addColumns2Map(Class<?> paramClass, String paramString, HashMap<String, Column> paramHashMap);
  
  static native HashMap<String, Column> getColumnMap(Class<?> paramClass);
  
  static native Column getColumnOrId(Class<?> paramClass, String paramString);
  
  public static native String getExecAfterTableCreated(Class<?> paramClass);
  
  static native Id getId(Class<?> paramClass);
  
  private static native String getPrimaryKeyColumnName(Class<?> paramClass);
  
  private static native String getPrimaryKeyFieldName(Class<?> paramClass);
  
  public static native String getTableName(Class<?> paramClass);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\table\TableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */