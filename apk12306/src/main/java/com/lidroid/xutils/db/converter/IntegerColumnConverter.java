package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class IntegerColumnConverter
  implements ColumnConverter<Integer>
{
  static
  {
    JniLib.a(IntegerColumnConverter.class, 955);
  }
  
  public native Object fieldValue2ColumnValue(Integer paramInteger);
  
  public native ColumnDbType getColumnDbType();
  
  public native Integer getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Integer getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\IntegerColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */