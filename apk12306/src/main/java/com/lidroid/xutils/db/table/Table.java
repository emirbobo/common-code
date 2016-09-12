package com.lidroid.xutils.db.table;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.DbUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Table
{
  private static final HashMap<String, Table> tableMap = new HashMap();
  private boolean checkedDatabase;
  public final HashMap<String, Column> columnMap;
  public final DbUtils db;
  public final HashMap<String, Finder> finderMap;
  public final Id id;
  public final String tableName;
  
  static
  {
    JniLib.a(Table.class, 977);
  }
  
  private Table(DbUtils paramDbUtils, Class<?> paramClass)
  {
    this.db = paramDbUtils;
    this.tableName = TableUtils.getTableName(paramClass);
    this.id = TableUtils.getId(paramClass);
    this.columnMap = TableUtils.getColumnMap(paramClass);
    this.finderMap = new HashMap();
    paramDbUtils = this.columnMap.values().iterator();
    for (;;)
    {
      if (!paramDbUtils.hasNext()) {
        return;
      }
      paramClass = (Column)paramDbUtils.next();
      paramClass.setTable(this);
      if ((paramClass instanceof Finder)) {
        this.finderMap.put(paramClass.getColumnName(), (Finder)paramClass);
      }
    }
  }
  
  public static native Table get(DbUtils paramDbUtils, Class<?> paramClass);
  
  public static native void remove(DbUtils paramDbUtils, Class<?> paramClass);
  
  public static native void remove(DbUtils paramDbUtils, String paramString);
  
  public native boolean isCheckedDatabase();
  
  public native void setCheckedDatabase(boolean paramBoolean);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\table\Table.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */