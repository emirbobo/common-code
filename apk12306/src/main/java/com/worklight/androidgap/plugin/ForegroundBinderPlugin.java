package com.worklight.androidgap.plugin;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class ForegroundBinderPlugin
  extends CordovaPlugin
{
  public static final String TAG = "WLForegroundBinder";
  private Context ctx;
  private Integer notificationIdentifier;
  private ServiceConnection serviceConnection;
  
  static
  {
    JniLib.a(ForegroundBinderPlugin.class, 1176);
  }
  
  private native void bindService(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
  
  private native void cancelNotification();
  
  private static native String toAllCaps(String paramString);
  
  private native void unbindService(CallbackContext paramCallbackContext);
  
  public native boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
  
  public native void onDestroy();
  
  static enum Action
  {
    BIND_TO_SERVICE,  UNBIND_FROM_SERVICE;
    
    private Action() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\ForegroundBinderPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */