package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class StringColumnConverter
  implements ColumnConverter<String>
{
  static
  {
    JniLib.a(StringColumnConverter.class, 959);
  }
  
  public native Object fieldValue2ColumnValue(String paramString);
  
  public native ColumnDbType getColumnDbType();
  
  public native String getFieldValue(Cursor paramCursor, int paramInt);
  
  public native String getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\StringColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */