package com.worklight.androidgap.plugin;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.cordova.api.CallbackContext;

public abstract class WLLocationListener
  implements LocationListener
{
  public static int PERMISSION_DENIED = 1;
  public static int POSITION_UNAVAILABLE = 2;
  public static int TIMEOUT = 3;
  private String TAG = "[Worklight Location Listener]";
  protected Map<String, CallbackContext> callbacks = new ConcurrentHashMap();
  protected LocationManager locationManager;
  protected int maximumAge = 500;
  protected int minChangeDistance = 10;
  protected int minChangeTime = 60000;
  private WLGeolocationPlugin owner;
  protected String provider;
  protected boolean running = false;
  protected Map<String, CallbackContext> watches = new ConcurrentHashMap();
  
  public WLLocationListener(LocationManager paramLocationManager, WLGeolocationPlugin paramWLGeolocationPlugin, String paramString)
  {
    this.locationManager = paramLocationManager;
    this.owner = paramWLGeolocationPlugin;
    this.TAG = ("[WL " + paramString + " Listener]");
    this.provider = paramString;
  }
  
  private void stop()
  {
    if (this.running)
    {
      this.locationManager.removeUpdates(this);
      this.running = false;
    }
  }
  
  private void win(Location paramLocation)
  {
    long l = System.currentTimeMillis() - paramLocation.getTime();
    if (l > this.maximumAge) {
      Log.d(this.TAG, "Acquired location age: " + l + " milliseconds. More than maximumAge of " + this.maximumAge + " milliseconds. Ignoring.");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.callbacks.values().iterator();
      while (localIterator.hasNext()) {
        this.owner.win(paramLocation, (CallbackContext)localIterator.next(), false);
      }
      if ((this.owner.isGlobalListener(this)) && (this.watches.size() == 0))
      {
        Log.d(this.TAG, "Stopping global listener");
        stop();
      }
      this.callbacks.clear();
      localIterator = this.watches.values().iterator();
      while (localIterator.hasNext()) {
        this.owner.win(paramLocation, (CallbackContext)localIterator.next(), true);
      }
      if (this.watches.isEmpty()) {
        stop();
      }
    }
  }
  
  public void addCallback(String paramString, CallbackContext paramCallbackContext, int paramInt)
  {
    this.maximumAge = paramInt;
    this.callbacks.put(paramString, paramCallbackContext);
    if (size() == 1) {
      start();
    }
  }
  
  public void addWatch(String paramString, CallbackContext paramCallbackContext, int paramInt1, int paramInt2)
  {
    this.minChangeDistance = paramInt1;
    this.minChangeTime = paramInt2;
    this.watches.put(paramString, paramCallbackContext);
    stop();
    start();
  }
  
  public void clearWatch(String paramString)
  {
    this.watches.remove(paramString);
    if (size() == 0) {
      stop();
    }
  }
  
  public void destroy()
  {
    stop();
  }
  
  protected void fail(int paramInt, String paramString)
  {
    Iterator localIterator = this.callbacks.values().iterator();
    while (localIterator.hasNext()) {
      this.owner.fail(paramInt, paramString, (CallbackContext)localIterator.next(), false);
    }
    if ((this.owner.isGlobalListener(this)) && (this.watches.size() == 0))
    {
      Log.d(this.TAG, "Stopping global listener");
      stop();
    }
    this.callbacks.clear();
    localIterator = this.watches.values().iterator();
    while (localIterator.hasNext()) {
      this.owner.fail(paramInt, paramString, (CallbackContext)localIterator.next(), true);
    }
  }
  
  public Location getLastKnownLocation()
  {
    try
    {
      Location localLocation = this.locationManager.getLastKnownLocation(this.provider);
      return localLocation;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    Log.d(this.TAG, "The location has been updated!");
    win(paramLocation);
  }
  
  public void onProviderDisabled(String paramString)
  {
    Log.d(this.TAG, "Location provider '" + paramString + "' disabled.");
    fail(POSITION_UNAVAILABLE, paramString + " provider disabled.");
  }
  
  public void onProviderEnabled(String paramString)
  {
    Log.d(this.TAG, "Location provider " + paramString + " has been enabled");
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    Log.d(this.TAG, "The status of the provider " + paramString + " has changed");
    if (paramInt == 0)
    {
      Log.d(this.TAG, paramString + " is OUT OF SERVICE");
      fail(POSITION_UNAVAILABLE, "Provider " + paramString + " is out of service.");
    }
    for (;;)
    {
      return;
      if (paramInt == 1) {
        Log.d(this.TAG, paramString + " is TEMPORARILY_UNAVAILABLE");
      } else {
        Log.d(this.TAG, paramString + " is AVAILABLE");
      }
    }
  }
  
  public void removeCallback(String paramString)
  {
    this.callbacks.remove(paramString);
    if (size() == 0) {
      stop();
    }
  }
  
  public int size()
  {
    return this.watches.size() + this.callbacks.size();
  }
  
  protected void start()
  {
    if (!this.running)
    {
      if (this.locationManager.getProvider("network") == null) {
        break label45;
      }
      this.running = true;
      this.locationManager.requestLocationUpdates("network", this.minChangeTime, this.minChangeDistance, this);
    }
    for (;;)
    {
      return;
      label45:
      fail(POSITION_UNAVAILABLE, "Network provider is not available.");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLLocationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */