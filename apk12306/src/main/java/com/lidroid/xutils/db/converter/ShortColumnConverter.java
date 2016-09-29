package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class ShortColumnConverter
  implements ColumnConverter<Short>
{
  static
  {
    JniLib.a(ShortColumnConverter.class, 957);
  }
  
  public native Object fieldValue2ColumnValue(Short paramShort);
  
  public native ColumnDbType getColumnDbType();
  
  public native Short getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Short getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\ShortColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */