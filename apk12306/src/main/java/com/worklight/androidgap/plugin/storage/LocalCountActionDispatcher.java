package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;

public class LocalCountActionDispatcher
  extends SimpleQueryActionDispatcher
{
  private static final String SQL_LOCALCOUNT = "SELECT COUNT(*) FROM {0} WHERE {1} > 0";
  
  static
  {
    JniLib.a(LocalCountActionDispatcher.class, 1230);
  }
  
  protected LocalCountActionDispatcher()
  {
    super("localCount");
  }
  
  protected native String getFormattedQuery(DatabaseActionDispatcher.Context paramContext)
    throws Throwable;
  
  protected native void logResult(DatabaseActionDispatcher.Context paramContext, int paramInt)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\LocalCountActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */