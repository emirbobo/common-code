package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class BooleanColumnConverter
  implements ColumnConverter<Boolean>
{
  static
  {
    JniLib.a(BooleanColumnConverter.class, 947);
  }
  
  public native Object fieldValue2ColumnValue(Boolean paramBoolean);
  
  public native ColumnDbType getColumnDbType();
  
  public native Boolean getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Boolean getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\BooleanColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */