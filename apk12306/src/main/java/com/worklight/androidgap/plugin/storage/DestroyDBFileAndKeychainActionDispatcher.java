package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.PluginResult;

public class DestroyDBFileAndKeychainActionDispatcher
  extends BaseActionDispatcher
{
  private static final String PARAM_OPTIONS = "options";
  
  static
  {
    JniLib.a(DestroyDBFileAndKeychainActionDispatcher.class, 1219);
  }
  
  protected DestroyDBFileAndKeychainActionDispatcher()
  {
    super("destroyDbFileAndKeychain");
    addParameter("options", false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  public native PluginResult dispatch(BaseActionDispatcher.Context paramContext)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\DestroyDBFileAndKeychainActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */