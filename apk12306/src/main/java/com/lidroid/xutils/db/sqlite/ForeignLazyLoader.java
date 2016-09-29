package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.table.ColumnUtils;
import com.lidroid.xutils.db.table.Foreign;
import com.lidroid.xutils.exception.DbException;
import java.util.List;

public class ForeignLazyLoader<T>
{
  private Object columnValue;
  private final Foreign foreignColumn;
  
  static
  {
    JniLib.a(ForeignLazyLoader.class, 965);
  }
  
  public ForeignLazyLoader(Foreign paramForeign, Object paramObject)
  {
    this.foreignColumn = paramForeign;
    this.columnValue = ColumnUtils.convert2DbColumnValueIfNeeded(paramObject);
  }
  
  public native List<T> getAllFromDb()
    throws DbException;
  
  public native Object getColumnValue();
  
  public native T getFirstFromDb()
    throws DbException;
  
  public native void setColumnValue(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\ForeignLazyLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */