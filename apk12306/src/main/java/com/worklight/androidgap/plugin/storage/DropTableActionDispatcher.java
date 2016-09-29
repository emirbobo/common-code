package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.PluginResult;

public class DropTableActionDispatcher
  extends DatabaseActionDispatcher
{
  private static final String PARAM_OPTIONS = "options";
  
  static
  {
    JniLib.a(DropTableActionDispatcher.class, 1223);
  }
  
  protected DropTableActionDispatcher()
  {
    super("dropTable");
    addParameter("options", false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  public native PluginResult dispatch(DatabaseActionDispatcher.Context paramContext)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\DropTableActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */