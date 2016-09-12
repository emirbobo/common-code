package com.lidroid.xutils.db.table;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.converter.ColumnConverter;
import com.lidroid.xutils.db.converter.ColumnConverterFactory;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.lang.reflect.Field;

public class Foreign
  extends Column
{
  private final ColumnConverter foreignColumnConverter;
  private final String foreignColumnName;
  
  static
  {
    JniLib.a(Foreign.class, 975);
  }
  
  Foreign(Class<?> paramClass, Field paramField)
  {
    super(paramClass, paramField);
    this.foreignColumnName = ColumnUtils.getForeignColumnNameByField(paramField);
    this.foreignColumnConverter = ColumnConverterFactory.getColumnConverter(TableUtils.getColumnOrId(getForeignEntityType(), this.foreignColumnName).columnField.getType());
  }
  
  public native ColumnDbType getColumnDbType();
  
  public native Object getColumnValue(Object paramObject);
  
  public native Object getDefaultValue();
  
  public native String getForeignColumnName();
  
  public native Class<?> getForeignEntityType();
  
  public native void setValue2Entity(Object paramObject, Cursor paramCursor, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\table\Foreign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */