package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class DoubleColumnConverter
  implements ColumnConverter<Double>
{
  static
  {
    JniLib.a(DoubleColumnConverter.class, 953);
  }
  
  public native Object fieldValue2ColumnValue(Double paramDouble);
  
  public native ColumnDbType getColumnDbType();
  
  public native Double getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Double getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\DoubleColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */