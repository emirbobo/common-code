package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public abstract interface ColumnConverter<T>
{
  public abstract Object fieldValue2ColumnValue(T paramT);
  
  public abstract ColumnDbType getColumnDbType();
  
  public abstract T getFieldValue(Cursor paramCursor, int paramInt);
  
  public abstract T getFieldValue(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\ColumnConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */