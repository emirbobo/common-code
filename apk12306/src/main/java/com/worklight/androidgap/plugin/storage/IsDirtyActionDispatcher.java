package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;

public class IsDirtyActionDispatcher
  extends SimpleQueryActionDispatcher
{
  private static final String PARAM_OBJ = "obj";
  private static final String SQL_IS_DIRTY = "SELECT {0} FROM {1} WHERE {0} > 0 AND _id = {2}";
  
  static
  {
    JniLib.a(IsDirtyActionDispatcher.class, 1228);
  }
  
  protected IsDirtyActionDispatcher()
  {
    super("isDirty");
    addParameter("obj", true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  private native int getId(DatabaseActionDispatcher.Context paramContext)
    throws Throwable;
  
  protected native String getFormattedQuery(DatabaseActionDispatcher.Context paramContext)
    throws Throwable;
  
  protected native int getModifiedResultValue(int paramInt);
  
  protected native int getNotFoundResultValue();
  
  protected native void logResult(DatabaseActionDispatcher.Context paramContext, int paramInt)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\IsDirtyActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */