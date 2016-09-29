package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;

public class CountActionDispatcher
  extends SimpleQueryActionDispatcher
{
  private static final String SQL_COUNT = "SELECT COUNT(*) FROM {0} WHERE {1} = 0";
  
  static
  {
    JniLib.a(CountActionDispatcher.class, 1217);
  }
  
  protected CountActionDispatcher()
  {
    super("count");
  }
  
  protected native String getFormattedQuery(DatabaseActionDispatcher.Context paramContext)
    throws Throwable;
  
  protected native void logResult(DatabaseActionDispatcher.Context paramContext, int paramInt)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\CountActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */