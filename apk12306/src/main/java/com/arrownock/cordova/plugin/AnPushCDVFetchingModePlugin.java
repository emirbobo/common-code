package com.arrownock.cordova.plugin;

import android.content.Context;
import com.arrownock.exception.ArrownockException;
import com.arrownock.push.AnPush;
import com.arrownock.push.AnPushCallbackAdapter;
import com.arrownock.push.AnPushStatus;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnPushCDVFetchingModePlugin
  extends CordovaPlugin
{
  private static final String ACTION_CLEAR_MUTE = "clearMute";
  private static final String ACTION_CLEAR_SILENT_PERIOD = "clearSilentPeriod";
  private static final String ACTION_CONNECT = "connect";
  private static final String ACTION_DISABLE = "disable";
  private static final String ACTION_DISCONNECT = "disconnect";
  private static final String ACTION_ENABLE = "enableFetchMode";
  private static final String ACTION_FETCH_LOCAL_STORE = "fetchLocalStore";
  private static final String ACTION_GET_ANID = "getAnID";
  private static final String ACTION_GET_VERSION = "version";
  private static final String ACTION_INITIALIZE = "init";
  private static final String ACTION_IS_CONNECTED = "isConnected";
  private static final String ACTION_IS_ENABLED = "isEnabled";
  private static final String ACTION_REGISTER = "register";
  private static final String ACTION_SAVE_TO_LOCAL_STORE = "saveToLocalStore";
  private static final String ACTION_SET_DEVICE_ID = "setDeviceId";
  private static final String ACTION_SET_FETCHING_INTERVAL = "setFetchingInterval";
  private static final String ACTION_SET_MUTE = "setMute";
  private static final String ACTION_SET_SCHEDULED_MUTE = "setScheduledMute";
  private static final String ACTION_SET_SERVERS = "setServerHosts";
  private static final String ACTION_SET_SILENT_PERIOD = "setSilentPeriod";
  private static final String ACTION_SHOW_FOREGROUND_NOTIFICATION = "showForegroundNotification";
  private static final String ACTION_UNREGISTER = "unregister";
  public static final String APP_NAME = "12306";
  private static final String LOCAL_STORAGE = "LOCAL_STORAGE";
  public static final int NOTIFICATION_ID = 1;
  private static final String PENDING_PUSH_NOTIFICATIONS = "PENDING_PUSH_NOTIFICATIONS";
  private static final String PENDING_PUSH_STORAGE = "PENDING_PUSH_STORAGE";
  private static AnPushCallbackAdapter callback = null;
  public static String foregroundAlert;
  private static AnPushCDVFetchingModePlugin instance;
  public static boolean isAppRunning;
  private static AnPush sdk;
  
  static
  {
    JniLib.a(AnPushCDVFetchingModePlugin.class, 146);
    isAppRunning = false;
    foregroundAlert = "You have a new message";
    instance = null;
    sdk = null;
  }
  
  public AnPushCDVFetchingModePlugin()
  {
    instance = this;
  }
  
  private native JSONObject clearMute();
  
  private native JSONObject clearSilentPeriod();
  
  private native JSONObject connect();
  
  private native JSONObject disable();
  
  private native JSONObject disconnect();
  
  private native JSONObject enable();
  
  private native void fetchPendingPushNotifications();
  
  private native Object getAnID();
  
  private native JSONObject initialize(String paramString, boolean paramBoolean, JSONObject paramJSONObject);
  
  public static native void onReceivePayload(Context paramContext, String paramString);
  
  private native JSONObject register(JSONArray paramJSONArray);
  
  private static native void sendJavaScripStatement(String paramString);
  
  private native JSONObject setDeviceId(JSONArray paramJSONArray);
  
  private native JSONObject setFetchingInterval(JSONArray paramJSONArray);
  
  private native JSONObject setMute();
  
  private native JSONObject setScheduledMute(JSONArray paramJSONArray);
  
  private native JSONObject setServers(JSONArray paramJSONArray);
  
  private native JSONObject setSilentPeriod(JSONArray paramJSONArray);
  
  private native JSONObject showForegroundNotificaton(JSONArray paramJSONArray);
  
  public static native void showForegroundNotificaton(Context paramContext, String paramString, boolean paramBoolean, int paramInt);
  
  public static native void showForegroundNotificaton(Context paramContext, boolean paramBoolean, int paramInt);
  
  private native JSONObject unregister(JSONArray paramJSONArray);
  
  private native JSONObject validateSDKStatus();
  
  public native boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
  
  public native void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView);
  
  public native void onPause(boolean paramBoolean);
  
  public native void onResume(boolean paramBoolean);
  
  class CordovaAnPushCallback
    extends AnPushCallbackAdapter
  {
    static
    {
      JniLib.a(CordovaAnPushCallback.class, 145);
    }
    
    CordovaAnPushCallback() {}
    
    private native String generateErrorJSON(ArrownockException paramArrownockException);
    
    public native void clearMute(boolean paramBoolean, ArrownockException paramArrownockException);
    
    public native void clearSilentPeriod(boolean paramBoolean, ArrownockException paramArrownockException);
    
    public native void register(boolean paramBoolean, String paramString, ArrownockException paramArrownockException);
    
    public native void setMute(boolean paramBoolean, ArrownockException paramArrownockException);
    
    public native void setScheduledMute(boolean paramBoolean, ArrownockException paramArrownockException);
    
    public native void setSilentPeriod(boolean paramBoolean, ArrownockException paramArrownockException);
    
    public native void statusChanged(AnPushStatus paramAnPushStatus, ArrownockException paramArrownockException);
    
    public native void unregister(boolean paramBoolean, ArrownockException paramArrownockException);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\cordova\plugin\AnPushCDVFetchingModePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */