package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.table.ColumnUtils;
import com.lidroid.xutils.db.table.Finder;
import com.lidroid.xutils.exception.DbException;
import java.util.List;

public class FinderLazyLoader<T>
{
  private final Finder finderColumn;
  private final Object finderValue;
  
  static
  {
    JniLib.a(FinderLazyLoader.class, 964);
  }
  
  public FinderLazyLoader(Finder paramFinder, Object paramObject)
  {
    this.finderColumn = paramFinder;
    this.finderValue = ColumnUtils.convert2DbColumnValueIfNeeded(paramObject);
  }
  
  public native List<T> getAllFromDb()
    throws DbException;
  
  public native T getFirstFromDb()
    throws DbException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\FinderLazyLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */