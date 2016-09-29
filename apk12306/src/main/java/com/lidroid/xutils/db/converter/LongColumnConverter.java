package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class LongColumnConverter
  implements ColumnConverter<Long>
{
  static
  {
    JniLib.a(LongColumnConverter.class, 956);
  }
  
  public native Object fieldValue2ColumnValue(Long paramLong);
  
  public native ColumnDbType getColumnDbType();
  
  public native Long getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Long getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\LongColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */