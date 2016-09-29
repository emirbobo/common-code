package com.lidroid.xutils.db.table;

import com.bangcle.andjni.JniLib;
import java.lang.reflect.Field;
import java.util.HashSet;

public class Id
  extends Column
{
  private static final HashSet<String> AUTO_INCREMENT_TYPES;
  private static final HashSet<String> INTEGER_TYPES;
  private String columnFieldClassName = this.columnField.getType().getName();
  private boolean isAutoIncrement = false;
  private boolean isAutoIncrementChecked = false;
  
  static
  {
    JniLib.a(Id.class, 976);
    INTEGER_TYPES = new HashSet(2);
    AUTO_INCREMENT_TYPES = new HashSet(4);
    INTEGER_TYPES.add(Integer.TYPE.getName());
    INTEGER_TYPES.add(Integer.class.getName());
    AUTO_INCREMENT_TYPES.addAll(INTEGER_TYPES);
    AUTO_INCREMENT_TYPES.add(Long.TYPE.getName());
    AUTO_INCREMENT_TYPES.add(Long.class.getName());
  }
  
  Id(Class<?> paramClass, Field paramField)
  {
    super(paramClass, paramField);
  }
  
  public native Object getColumnValue(Object paramObject);
  
  public native boolean isAutoIncrement();
  
  public native void setAutoIncrementId(Object paramObject, long paramLong);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\table\Id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */