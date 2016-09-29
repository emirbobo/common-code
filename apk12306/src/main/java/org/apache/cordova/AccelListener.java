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

public class AccelListener
  extends CordovaPlugin
  implements SensorEventListener
{
  public static int ERROR_FAILED_TO_START = 3;
  public static int RUNNING;
  public static int STARTING;
  public static int STOPPED = 0;
  private int accuracy = 0;
  private CallbackContext callbackContext;
  private Sensor mSensor;
  private SensorManager sensorManager;
  private int status;
  private long timestamp = 0L;
  private float x = 0.0F;
  private float y = 0.0F;
  private float z = 0.0F;
  
  static
  {
    STARTING = 1;
    RUNNING = 2;
  }
  
  public AccelListener()
  {
    setStatus(STOPPED);
  }
  
  private void fail(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString);
      paramString = new PluginResult(PluginResult.Status.ERROR, localJSONObject);
      paramString.setKeepCallback(true);
      this.callbackContext.sendPluginResult(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private JSONObject getAccelerationJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("x", this.x);
      localJSONObject.put("y", this.y);
      localJSONObject.put("z", this.z);
      localJSONObject.put("timestamp", this.timestamp);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  private int start()
  {
    int i;
    if ((this.status == RUNNING) || (this.status == STARTING)) {
      i = this.status;
    }
    for (;;)
    {
      return i;
      setStatus(STARTING);
      List localList = this.sensorManager.getSensorList(1);
      if ((localList != null) && (localList.size() > 0))
      {
        this.mSensor = ((Sensor)localList.get(0));
        this.sensorManager.registerListener(this, this.mSensor, 2);
        setStatus(STARTING);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public void run()
          {
            AccelListener.this.timeout();
          }
        }, 2000L);
        i = this.status;
      }
      else
      {
        setStatus(ERROR_FAILED_TO_START);
        fail(ERROR_FAILED_TO_START, "No sensors found to register accelerometer listening to.");
        i = this.status;
      }
    }
  }
  
  private void stop()
  {
    if (this.status != STOPPED) {
      this.sensorManager.unregisterListener(this);
    }
    setStatus(STOPPED);
    this.accuracy = 0;
  }
  
  private void timeout()
  {
    if (this.status == STARTING)
    {
      setStatus(ERROR_FAILED_TO_START);
      fail(ERROR_FAILED_TO_START, "Accelerometer could not be started.");
    }
  }
  
  private void win()
  {
    PluginResult localPluginResult = new PluginResult(PluginResult.Status.OK, getAccelerationJSON());
    localPluginResult.setKeepCallback(true);
    this.callbackContext.sendPluginResult(localPluginResult);
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    boolean bool = true;
    if (paramString.equals("start"))
    {
      this.callbackContext = paramCallbackContext;
      if (this.status != RUNNING) {
        start();
      }
      paramString = new PluginResult(PluginResult.Status.NO_RESULT, "");
      paramString.setKeepCallback(true);
      paramCallbackContext.sendPluginResult(paramString);
    }
    for (;;)
    {
      return bool;
      if (paramString.equals("stop"))
      {
        if (this.status != RUNNING) {
          break;
        }
        stop();
        break;
      }
      bool = false;
    }
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    super.initialize(paramCordovaInterface, paramCordovaWebView);
    this.sensorManager = ((SensorManager)paramCordovaInterface.getActivity().getSystemService("sensor"));
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    if (paramSensor.getType() != 1) {}
    for (;;)
    {
      return;
      if (this.status != STOPPED) {
        this.accuracy = paramInt;
      }
    }
  }
  
  public void onDestroy()
  {
    stop();
  }
  
  public void onReset()
  {
    if (this.status == RUNNING) {
      stop();
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 1) {}
    for (;;)
    {
      return;
      if (this.status != STOPPED)
      {
        setStatus(RUNNING);
        if (this.accuracy >= 2)
        {
          this.timestamp = System.currentTimeMillis();
          this.x = paramSensorEvent.values[0];
          this.y = paramSensorEvent.values[1];
          this.z = paramSensorEvent.values[2];
          win();
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\AccelListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */