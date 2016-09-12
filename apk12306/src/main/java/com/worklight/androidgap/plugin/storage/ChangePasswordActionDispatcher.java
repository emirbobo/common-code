package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.PluginResult;

public class ChangePasswordActionDispatcher
  extends BaseActionDispatcher
{
  private static final String PARAM_NEW_PW = "newPW";
  private static final String PARAM_OLD_PW = "oldPW";
  private static final String PARAM_OPTIONS = "options";
  private static final String PARAM_USERNAME = "username";
  
  static
  {
    JniLib.a(ChangePasswordActionDispatcher.class, 1215);
  }
  
  public ChangePasswordActionDispatcher()
  {
    super("changePassword");
    addParameter("oldPW", true, false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
    addParameter("newPW", true, false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
    addParameter("username", true, true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
    addParameter("options", false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  private native String getNewPW(BaseActionDispatcher.Context paramContext);
  
  private native String getOldPW(BaseActionDispatcher.Context paramContext);
  
  private native String getUserName(BaseActionDispatcher.Context paramContext);
  
  public native PluginResult dispatch(BaseActionDispatcher.Context paramContext)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\ChangePasswordActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */