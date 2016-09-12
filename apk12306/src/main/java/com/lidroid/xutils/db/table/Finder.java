package com.lidroid.xutils.db.table;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.lang.reflect.Field;

public class Finder
  extends Column
{
  private final String targetColumnName;
  private final String valueColumnName;
  
  static
  {
    JniLib.a(Finder.class, 974);
  }
  
  Finder(Class<?> paramClass, Field paramField)
  {
    super(paramClass, paramField);
    paramClass = (com.lidroid.xutils.db.annotation.Finder)paramField.getAnnotation(com.lidroid.xutils.db.annotation.Finder.class);
    this.valueColumnName = paramClass.valueColumn();
    this.targetColumnName = paramClass.targetColumn();
  }
  
  public native ColumnDbType getColumnDbType();
  
  public native Object getColumnValue(Object paramObject);
  
  public native Object getDefaultValue();
  
  public native String getTargetColumnName();
  
  public native Class<?> getTargetEntityType();
  
  public native void setValue2Entity(Object paramObject, Cursor paramCursor, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\table\Finder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */