package com.worklight.androidgap.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WLGeolocationPlugin
  extends CordovaPlugin
{
  private WLGPSListener gpsListener;
  private LocationManager locationManager;
  private WLNetworkListener networkListener;
  
  static
  {
    JniLib.a(WLGeolocationPlugin.class, 1201);
  }
  
  private native boolean addWatch(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
  
  private native boolean clearWatch(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
  
  private native WLLocationListener getListener(JSONArray paramJSONArray, int paramInt1, int paramInt2, CallbackContext paramCallbackContext)
    throws JSONException;
  
  private native boolean getLocation(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
  
  private native boolean isHighAccuracyEnabled(JSONArray paramJSONArray)
    throws JSONException;
  
  private native String makeNewId(boolean paramBoolean, String paramString)
    throws JSONException;
  
  private native boolean removeCallback(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
  
  public native boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
  
  public native void fail(int paramInt, String paramString, CallbackContext paramCallbackContext, boolean paramBoolean);
  
  public native boolean isGlobalListener(WLLocationListener paramWLLocationListener);
  
  public native void onDestroy();
  
  public native void onReset();
  
  public native JSONObject returnLocationJSON(Location paramLocation);
  
  public native void win(Location paramLocation, CallbackContext paramCallbackContext, boolean paramBoolean);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLGeolocationPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */