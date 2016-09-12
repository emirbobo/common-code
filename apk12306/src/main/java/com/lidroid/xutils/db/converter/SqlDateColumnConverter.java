package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.sql.Date;

public class SqlDateColumnConverter
  implements ColumnConverter<Date>
{
  static
  {
    JniLib.a(SqlDateColumnConverter.class, 958);
  }
  
  public native Object fieldValue2ColumnValue(Date paramDate);
  
  public native ColumnDbType getColumnDbType();
  
  public native Date getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Date getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\SqlDateColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */