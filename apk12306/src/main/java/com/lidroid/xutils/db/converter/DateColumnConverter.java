package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.util.Date;

public class DateColumnConverter
  implements ColumnConverter<Date>
{
  static
  {
    JniLib.a(DateColumnConverter.class, 952);
  }
  
  public native Object fieldValue2ColumnValue(Date paramDate);
  
  public native ColumnDbType getColumnDbType();
  
  public native Date getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Date getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\DateColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */