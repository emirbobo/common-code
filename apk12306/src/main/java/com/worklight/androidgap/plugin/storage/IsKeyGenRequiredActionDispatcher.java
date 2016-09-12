package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.PluginResult;

public class IsKeyGenRequiredActionDispatcher
  extends BaseActionDispatcher
{
  private static final String PARAM_USERNAME = "username";
  
  static
  {
    JniLib.a(IsKeyGenRequiredActionDispatcher.class, 1229);
  }
  
  protected IsKeyGenRequiredActionDispatcher()
  {
    super("isKeyGenRequired");
    addParameter("username", true, true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
  }
  
  private native String getUserName(BaseActionDispatcher.Context paramContext);
  
  public native PluginResult dispatch(BaseActionDispatcher.Context paramContext)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\IsKeyGenRequiredActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */