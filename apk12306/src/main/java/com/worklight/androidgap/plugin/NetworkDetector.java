package com.worklight.androidgap.plugin;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkDetector
  extends CordovaPlugin
{
  public static final String ACTION_GET_NETWORK_INFO = "getNetworkInfo";
  private static LoggerPlugin loggerPlugin;
  
  static
  {
    JniLib.a(NetworkDetector.class, 1182);
  }
  
  public NetworkDetector()
  {
    if (loggerPlugin == null) {
      loggerPlugin = new LoggerPlugin();
    }
  }
  
  private native JSONObject[] getAllIpAddresses()
    throws JSONException;
  
  public static native String getPrimaryAddress(JSONObject[] paramArrayOfJSONObject)
    throws JSONException;
  
  public native boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
  
  public native JSONObject getNetworkData(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\NetworkDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */