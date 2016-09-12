package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;

public class Selector$OrderBy
{
  private String columnName;
  private boolean desc;
  
  static
  {
    JniLib.a(OrderBy.class, 966);
  }
  
  public Selector$OrderBy(Selector paramSelector, String paramString)
  {
    this.columnName = paramString;
  }
  
  public Selector$OrderBy(Selector paramSelector, String paramString, boolean paramBoolean)
  {
    this.columnName = paramString;
    this.desc = paramBoolean;
  }
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\Selector$OrderBy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */