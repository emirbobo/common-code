package org.apache.cordova;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeoBroker
  extends CordovaPlugin
{
  private GPSListener gpsListener;
  private LocationManager locationManager;
  private NetworkListener networkListener;
  
  private void addWatch(String paramString, CallbackContext paramCallbackContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.gpsListener.addWatch(paramString, paramCallbackContext);
    }
    for (;;)
    {
      return;
      this.networkListener.addWatch(paramString, paramCallbackContext);
    }
  }
  
  private void clearWatch(String paramString)
  {
    this.gpsListener.clearWatch(paramString);
    this.networkListener.clearWatch(paramString);
  }
  
  private void getCurrentLocation(CallbackContext paramCallbackContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.gpsListener.addCallback(paramCallbackContext);
    }
    for (;;)
    {
      return;
      this.networkListener.addCallback(paramCallbackContext);
    }
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    if (this.locationManager == null)
    {
      this.locationManager = ((LocationManager)this.cordova.getActivity().getSystemService("location"));
      this.networkListener = new NetworkListener(this.locationManager, this);
      this.gpsListener = new GPSListener(this.locationManager, this);
    }
    boolean bool;
    if ((this.locationManager.isProviderEnabled("gps")) || (this.locationManager.isProviderEnabled("network"))) {
      if (paramString.equals("getLocation"))
      {
        bool = paramJSONArray.getBoolean(0);
        int i = paramJSONArray.getInt(1);
        paramJSONArray = this.locationManager;
        if (bool)
        {
          paramString = "gps";
          paramString = paramJSONArray.getLastKnownLocation(paramString);
          if ((paramString == null) || (System.currentTimeMillis() - paramString.getTime() > i)) {
            break label176;
          }
          paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, returnLocationJSON(paramString)));
        }
      }
    }
    for (;;)
    {
      label164:
      for (bool = true;; bool = false)
      {
        return bool;
        paramString = "network";
        break;
        label176:
        getCurrentLocation(paramCallbackContext, bool);
        break label164;
        if (paramString.equals("addWatch"))
        {
          addWatch(paramJSONArray.getString(0), paramCallbackContext, paramJSONArray.getBoolean(1));
          break label164;
        }
        if (paramString.equals("clearWatch"))
        {
          clearWatch(paramJSONArray.getString(0));
          break label164;
        }
      }
      paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.NO_RESULT, "Location API is not available for this device."));
    }
  }
  
  public void fail(int paramInt, String paramString, CallbackContext paramCallbackContext)
  {
    localJSONObject = new JSONObject();
    Object localObject = null;
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString);
      paramString = localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONObject = null;
        String str = "{'code':" + paramInt + ",'message':'" + paramString.replaceAll("'", "'") + "'}";
        paramString = localJSONObject;
        continue;
        paramString = new PluginResult(PluginResult.Status.ERROR, str);
      }
    }
    if (paramString != null)
    {
      paramString = new PluginResult(PluginResult.Status.ERROR, paramString);
      paramCallbackContext.sendPluginResult(paramString);
      return;
    }
  }
  
  public boolean isGlobalListener(CordovaLocationListener paramCordovaLocationListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.gpsListener != null)
    {
      bool1 = bool2;
      if (this.networkListener != null) {
        if (!this.gpsListener.equals(paramCordovaLocationListener))
        {
          bool1 = bool2;
          if (!this.networkListener.equals(paramCordovaLocationListener)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    if (this.networkListener != null)
    {
      this.networkListener.destroy();
      this.networkListener = null;
    }
    if (this.gpsListener != null)
    {
      this.gpsListener.destroy();
      this.gpsListener = null;
    }
  }
  
  public void onReset()
  {
    onDestroy();
  }
  
  public JSONObject returnLocationJSON(Location paramLocation)
  {
    Object localObject2 = null;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("latitude", paramLocation.getLatitude());
        localJSONObject.put("longitude", paramLocation.getLongitude());
        if (!paramLocation.hasAltitude()) {
          continue;
        }
        localObject1 = Double.valueOf(paramLocation.getAltitude());
        localJSONObject.put("altitude", localObject1);
        localJSONObject.put("accuracy", paramLocation.getAccuracy());
        localObject1 = localObject2;
        if (paramLocation.hasBearing())
        {
          localObject1 = localObject2;
          if (paramLocation.hasSpeed()) {
            localObject1 = Float.valueOf(paramLocation.getBearing());
          }
        }
        localJSONObject.put("heading", localObject1);
        localJSONObject.put("velocity", paramLocation.getSpeed());
        localJSONObject.put("timestamp", paramLocation.getTime());
      }
      catch (JSONException paramLocation)
      {
        Object localObject1;
        paramLocation.printStackTrace();
        continue;
      }
      return localJSONObject;
      localObject1 = null;
    }
  }
  
  public void win(Location paramLocation, CallbackContext paramCallbackContext)
  {
    paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, returnLocationJSON(paramLocation)));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\GeoBroker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */