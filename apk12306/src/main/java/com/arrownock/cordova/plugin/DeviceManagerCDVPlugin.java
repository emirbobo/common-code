package com.arrownock.cordova.plugin;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class DeviceManagerCDVPlugin
  extends CordovaPlugin
{
  private static final String ACTION_SET_HOST = "setHost";
  
  static
  {
    JniLib.a(DeviceManagerCDVPlugin.class, 149);
  }
  
  public native boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\cordova\plugin\DeviceManagerCDVPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */