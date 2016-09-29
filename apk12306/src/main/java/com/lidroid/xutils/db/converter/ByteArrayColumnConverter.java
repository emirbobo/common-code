package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class ByteArrayColumnConverter
  implements ColumnConverter<byte[]>
{
  static
  {
    JniLib.a(ByteArrayColumnConverter.class, 948);
  }
  
  public native Object fieldValue2ColumnValue(byte[] paramArrayOfByte);
  
  public native ColumnDbType getColumnDbType();
  
  public native byte[] getFieldValue(Cursor paramCursor, int paramInt);
  
  public native byte[] getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\ByteArrayColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */