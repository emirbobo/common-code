package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class ByteColumnConverter
  implements ColumnConverter<Byte>
{
  static
  {
    JniLib.a(ByteColumnConverter.class, 949);
  }
  
  public native Object fieldValue2ColumnValue(Byte paramByte);
  
  public native ColumnDbType getColumnDbType();
  
  public native Byte getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Byte getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\ByteColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */