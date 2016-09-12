package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;
import java.util.LinkedList;

public class SqlInfo
{
  private LinkedList<Object> bindArgs;
  private String sql;
  
  static
  {
    JniLib.a(SqlInfo.class, 968);
  }
  
  public SqlInfo() {}
  
  public SqlInfo(String paramString)
  {
    this.sql = paramString;
  }
  
  public SqlInfo(String paramString, Object... paramVarArgs)
  {
    this.sql = paramString;
    addBindArgs(paramVarArgs);
  }
  
  public native void addBindArg(Object paramObject);
  
  native void addBindArgWithoutConverter(Object paramObject);
  
  public void addBindArgs(Object... paramVarArgs)
  {
    int j;
    if (paramVarArgs != null) {
      j = paramVarArgs.length;
    }
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      addBindArg(paramVarArgs[i]);
    }
  }
  
  public native LinkedList<Object> getBindArgs();
  
  public native Object[] getBindArgsAsArray();
  
  public native String[] getBindArgsAsStrArray();
  
  public native String getSql();
  
  public native void setSql(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\SqlInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */