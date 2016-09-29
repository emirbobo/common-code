package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class FloatColumnConverter
  implements ColumnConverter<Float>
{
  static
  {
    JniLib.a(FloatColumnConverter.class, 954);
  }
  
  public native Object fieldValue2ColumnValue(Float paramFloat);
  
  public native ColumnDbType getColumnDbType();
  
  public native Float getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Float getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\FloatColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */