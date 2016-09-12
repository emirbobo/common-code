package com.lidroid.xutils.db.table;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.converter.ColumnConverter;
import com.lidroid.xutils.db.converter.ColumnConverterFactory;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Column
{
  protected final ColumnConverter columnConverter;
  protected final Field columnField;
  protected final String columnName;
  private final Object defaultValue;
  protected final Method getMethod;
  private int index = -1;
  protected final Method setMethod;
  private Table table;
  
  static
  {
    JniLib.a(Column.class, 971);
  }
  
  Column(Class<?> paramClass, Field paramField)
  {
    this.columnField = paramField;
    this.columnConverter = ColumnConverterFactory.getColumnConverter(paramField.getType());
    this.columnName = ColumnUtils.getColumnNameByField(paramField);
    if (this.columnConverter != null) {}
    for (this.defaultValue = this.columnConverter.getFieldValue(ColumnUtils.getColumnDefaultValue(paramField));; this.defaultValue = null)
    {
      this.getMethod = ColumnUtils.getColumnGetMethod(paramClass, paramField);
      this.setMethod = ColumnUtils.getColumnSetMethod(paramClass, paramField);
      return;
    }
  }
  
  public native ColumnConverter getColumnConverter();
  
  public native ColumnDbType getColumnDbType();
  
  public native Field getColumnField();
  
  public native String getColumnName();
  
  public native Object getColumnValue(Object paramObject);
  
  public native Object getDefaultValue();
  
  public native Object getFieldValue(Object paramObject);
  
  public native int getIndex();
  
  public native Table getTable();
  
  native void setTable(Table paramTable);
  
  public native void setValue2Entity(Object paramObject, Cursor paramCursor, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\table\Column.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */