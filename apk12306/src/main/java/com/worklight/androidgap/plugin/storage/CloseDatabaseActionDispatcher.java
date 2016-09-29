package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.PluginResult;

public class CloseDatabaseActionDispatcher
  extends BaseActionDispatcher
{
  private static final String PARAM_OPTIONS = "options";
  
  static
  {
    JniLib.a(CloseDatabaseActionDispatcher.class, 1216);
  }
  
  protected CloseDatabaseActionDispatcher()
  {
    super("closeDatabase");
    addParameter("options", false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  public native PluginResult dispatch(BaseActionDispatcher.Context paramContext)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\CloseDatabaseActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */