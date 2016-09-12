package org.apache.cordova;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BatteryListener
  extends CordovaPlugin
{
  private static final String LOG_TAG = "BatteryManager";
  private CallbackContext batteryCallbackContext = null;
  BroadcastReceiver receiver = null;
  
  private JSONObject getBatteryInfo(Intent paramIntent)
  {
    boolean bool = false;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("level", paramIntent.getIntExtra("level", 0));
      if (paramIntent.getIntExtra("plugged", -1) > 0) {
        bool = true;
      }
      localJSONObject.put("isPlugged", bool);
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        Log.e("BatteryManager", paramIntent.getMessage(), paramIntent);
      }
    }
    return localJSONObject;
  }
  
  private void removeBatteryListener()
  {
    if (this.receiver != null) {}
    try
    {
      this.cordova.getActivity().unregisterReceiver(this.receiver);
      this.receiver = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("BatteryManager", "Error unregistering battery receiver: " + localException.getMessage(), localException);
      }
    }
  }
  
  private void sendUpdate(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (this.batteryCallbackContext != null)
    {
      paramJSONObject = new PluginResult(PluginResult.Status.OK, paramJSONObject);
      paramJSONObject.setKeepCallback(paramBoolean);
      this.batteryCallbackContext.sendPluginResult(paramJSONObject);
    }
  }
  
  private void updateBatteryInfo(Intent paramIntent)
  {
    sendUpdate(getBatteryInfo(paramIntent), true);
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    boolean bool = true;
    if (paramString.equals("start")) {
      if (this.batteryCallbackContext != null) {
        paramCallbackContext.error("Battery listener already running.");
      }
    }
    for (;;)
    {
      return bool;
      this.batteryCallbackContext = paramCallbackContext;
      paramString = new IntentFilter();
      paramString.addAction("android.intent.action.BATTERY_CHANGED");
      if (this.receiver == null)
      {
        this.receiver = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            BatteryListener.this.updateBatteryInfo(paramAnonymousIntent);
          }
        };
        this.cordova.getActivity().registerReceiver(this.receiver, paramString);
      }
      paramString = new PluginResult(PluginResult.Status.NO_RESULT);
      paramString.setKeepCallback(true);
      paramCallbackContext.sendPluginResult(paramString);
      continue;
      if (paramString.equals("stop"))
      {
        removeBatteryListener();
        sendUpdate(new JSONObject(), false);
        this.batteryCallbackContext = null;
        paramCallbackContext.success();
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void onDestroy()
  {
    removeBatteryListener();
  }
  
  public void onReset()
  {
    removeBatteryListener();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\BatteryListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */