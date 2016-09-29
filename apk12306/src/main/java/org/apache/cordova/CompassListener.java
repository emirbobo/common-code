package org.apache.cordova;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import java.util.List;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CompassListener
  extends CordovaPlugin
  implements SensorEventListener
{
  public static int ERROR_FAILED_TO_START = 3;
  public static int RUNNING;
  public static int STARTING;
  public static int STOPPED = 0;
  public long TIMEOUT = 30000L;
  int accuracy;
  private CallbackContext callbackContext;
  float heading = 0.0F;
  long lastAccessTime;
  Sensor mSensor;
  private SensorManager sensorManager;
  int status;
  long timeStamp = 0L;
  
  static
  {
    STARTING = 1;
    RUNNING = 2;
  }
  
  public CompassListener()
  {
    setStatus(STOPPED);
  }
  
  private JSONObject getCompassHeading()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("magneticHeading", getHeading());
    localJSONObject.put("trueHeading", getHeading());
    localJSONObject.put("headingAccuracy", 0);
    localJSONObject.put("timestamp", this.timeStamp);
    return localJSONObject;
  }
  
  private void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  private void timeout()
  {
    if (this.status == STARTING)
    {
      setStatus(ERROR_FAILED_TO_START);
      if (this.callbackContext != null) {
        this.callbackContext.error("Compass listener failed to start.");
      }
    }
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = true;
    if (paramString.equals("start")) {
      start();
    }
    for (;;)
    {
      return bool;
      if (paramString.equals("stop"))
      {
        stop();
      }
      else if (paramString.equals("getStatus"))
      {
        int i = getStatus();
        paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, i));
      }
      else if (paramString.equals("getHeading"))
      {
        if (this.status != RUNNING)
        {
          if (start() == ERROR_FAILED_TO_START) {
            paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, ERROR_FAILED_TO_START));
          } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
            {
              public void run()
              {
                CompassListener.this.timeout();
              }
            }, 2000L);
          }
        }
        else {
          paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, getCompassHeading()));
        }
      }
      else if (paramString.equals("setTimeout"))
      {
        setTimeout(paramJSONArray.getLong(0));
      }
      else if (paramString.equals("getTimeout"))
      {
        long l = getTimeout();
        paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float)l));
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public float getHeading()
  {
    this.lastAccessTime = System.currentTimeMillis();
    return this.heading;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public long getTimeout()
  {
    return this.TIMEOUT;
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    super.initialize(paramCordovaInterface, paramCordovaWebView);
    this.sensorManager = ((SensorManager)paramCordovaInterface.getActivity().getSystemService("sensor"));
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onDestroy()
  {
    stop();
  }
  
  public void onReset()
  {
    stop();
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f = paramSensorEvent.values[0];
    this.timeStamp = System.currentTimeMillis();
    this.heading = f;
    setStatus(RUNNING);
    if (this.timeStamp - this.lastAccessTime > this.TIMEOUT) {
      stop();
    }
  }
  
  public void setTimeout(long paramLong)
  {
    this.TIMEOUT = paramLong;
  }
  
  public int start()
  {
    int i;
    if ((this.status == RUNNING) || (this.status == STARTING))
    {
      i = this.status;
      return i;
    }
    List localList = this.sensorManager.getSensorList(3);
    if ((localList != null) && (localList.size() > 0))
    {
      this.mSensor = ((Sensor)localList.get(0));
      this.sensorManager.registerListener(this, this.mSensor, 3);
      this.lastAccessTime = System.currentTimeMillis();
      setStatus(STARTING);
    }
    for (;;)
    {
      i = this.status;
      break;
      setStatus(ERROR_FAILED_TO_START);
    }
  }
  
  public void stop()
  {
    if (this.status != STOPPED) {
      this.sensorManager.unregisterListener(this);
    }
    setStatus(STOPPED);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CompassListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */