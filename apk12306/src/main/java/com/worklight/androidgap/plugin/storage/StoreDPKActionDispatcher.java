package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.PluginResult;

public class StoreDPKActionDispatcher
  extends BaseActionDispatcher
{
  private static final String PARAM_CBK_CLEAR = "cbkClear";
  private static final String PARAM_DPK_CLEAR = "dpkClear";
  private static final String PARAM_LOCALKEYGEN = "localKeyGen";
  private static final String PARAM_OPTIONS = "options";
  private static final String PARAM_SALT = "salt";
  private static final String PARAM_USERNAME = "username";
  
  static
  {
    JniLib.a(StoreDPKActionDispatcher.class, 1241);
  }
  
  protected StoreDPKActionDispatcher()
  {
    super("storeDPK");
    addParameter("dpkClear", true, false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
    addParameter("cbkClear", true, false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
    addParameter("salt", true, false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
    addParameter("username", true, true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
    addParameter("localKeyGen", true, true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.BOOLEAN });
    addParameter("options", false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  private native String getCBKClear(BaseActionDispatcher.Context paramContext);
  
  private native String getDPKClear(BaseActionDispatcher.Context paramContext);
  
  private native Boolean getLocalKeyGen(BaseActionDispatcher.Context paramContext);
  
  private native String getSalt(BaseActionDispatcher.Context paramContext);
  
  private native String getUserName(BaseActionDispatcher.Context paramContext);
  
  public native PluginResult dispatch(BaseActionDispatcher.Context paramContext)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\StoreDPKActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */