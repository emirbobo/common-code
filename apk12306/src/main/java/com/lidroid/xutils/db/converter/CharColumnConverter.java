package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class CharColumnConverter
  implements ColumnConverter<Character>
{
  static
  {
    JniLib.a(CharColumnConverter.class, 950);
  }
  
  public native Object fieldValue2ColumnValue(Character paramCharacter);
  
  public native ColumnDbType getColumnDbType();
  
  public native Character getFieldValue(Cursor paramCursor, int paramInt);
  
  public native Character getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\CharColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */