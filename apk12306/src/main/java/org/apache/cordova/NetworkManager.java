package org.apache.cordova;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;

public class NetworkManager
  extends CordovaPlugin
{
  public static final String CDMA = "cdma";
  public static final String CELLULAR = "cellular";
  public static final String EDGE = "edge";
  public static final String EHRPD = "ehrpd";
  public static final String GPRS = "gprs";
  public static final String GSM = "gsm";
  public static final String HSDPA = "hsdpa";
  public static final String HSPA = "hspa";
  public static final String HSPA_PLUS = "hspa+";
  public static final String HSUPA = "hsupa";
  private static final String LOG_TAG = "NetworkManager";
  public static final String LTE = "lte";
  public static final String MOBILE = "mobile";
  public static int NOT_REACHABLE = 0;
  public static final String ONEXRTT = "1xrtt";
  public static int REACHABLE_VIA_CARRIER_DATA_NETWORK = 1;
  public static int REACHABLE_VIA_WIFI_NETWORK = 2;
  public static final String TYPE_2G = "2g";
  public static final String TYPE_3G = "3g";
  public static final String TYPE_4G = "4g";
  public static final String TYPE_ETHERNET = "ethernet";
  public static final String TYPE_NONE = "none";
  public static final String TYPE_UNKNOWN = "unknown";
  public static final String TYPE_WIFI = "wifi";
  public static final String UMB = "umb";
  public static final String UMTS = "umts";
  public static final String WIFI = "wifi";
  public static final String WIMAX = "wimax";
  private CallbackContext connectionCallbackContext;
  private String lastStatus = "";
  BroadcastReceiver receiver = null;
  private boolean registered = false;
  ConnectivityManager sockMan;
  
  private String getConnectionInfo(NetworkInfo paramNetworkInfo)
  {
    String str = "none";
    if (paramNetworkInfo != null) {
      if (paramNetworkInfo.isConnected()) {
        break label44;
      }
    }
    label44:
    for (str = "none";; str = getType(paramNetworkInfo))
    {
      Log.d("CordovaNetworkManager", "Connection Type: " + str);
      return str;
    }
  }
  
  private String getType(NetworkInfo paramNetworkInfo)
  {
    String str;
    if (paramNetworkInfo != null)
    {
      str = paramNetworkInfo.getTypeName();
      if (str.toLowerCase().equals("wifi")) {
        paramNetworkInfo = "wifi";
      }
    }
    for (;;)
    {
      return paramNetworkInfo;
      if ((str.toLowerCase().equals("mobile")) || (str.toLowerCase().equals("cellular")))
      {
        paramNetworkInfo = paramNetworkInfo.getSubtypeName();
        if ((paramNetworkInfo.toLowerCase().equals("gsm")) || (paramNetworkInfo.toLowerCase().equals("gprs")) || (paramNetworkInfo.toLowerCase().equals("edge")))
        {
          paramNetworkInfo = "2g";
          continue;
        }
        if ((paramNetworkInfo.toLowerCase().startsWith("cdma")) || (paramNetworkInfo.toLowerCase().equals("umts")) || (paramNetworkInfo.toLowerCase().equals("1xrtt")) || (paramNetworkInfo.toLowerCase().equals("ehrpd")) || (paramNetworkInfo.toLowerCase().equals("hsupa")) || (paramNetworkInfo.toLowerCase().equals("hsdpa")) || (paramNetworkInfo.toLowerCase().equals("hspa")))
        {
          paramNetworkInfo = "3g";
          continue;
        }
        if ((paramNetworkInfo.toLowerCase().equals("lte")) || (paramNetworkInfo.toLowerCase().equals("umb")) || (paramNetworkInfo.toLowerCase().equals("hspa+")))
        {
          paramNetworkInfo = "4g";
          continue;
          paramNetworkInfo = "none";
          continue;
        }
      }
      paramNetworkInfo = "unknown";
    }
  }
  
  private void sendUpdate(String paramString)
  {
    if (this.connectionCallbackContext != null)
    {
      PluginResult localPluginResult = new PluginResult(PluginResult.Status.OK, paramString);
      localPluginResult.setKeepCallback(true);
      this.connectionCallbackContext.sendPluginResult(localPluginResult);
    }
    this.webView.postMessage("networkconnection", paramString);
  }
  
  private void updateConnectionInfo(NetworkInfo paramNetworkInfo)
  {
    paramNetworkInfo = getConnectionInfo(paramNetworkInfo);
    if (!paramNetworkInfo.equals(this.lastStatus))
    {
      sendUpdate(paramNetworkInfo);
      this.lastStatus = paramNetworkInfo;
    }
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    boolean bool = true;
    if (paramString.equals("getConnectionInfo"))
    {
      this.connectionCallbackContext = paramCallbackContext;
      paramString = this.sockMan.getActiveNetworkInfo();
      paramString = new PluginResult(PluginResult.Status.OK, getConnectionInfo(paramString));
      paramString.setKeepCallback(true);
      paramCallbackContext.sendPluginResult(paramString);
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    super.initialize(paramCordovaInterface, paramCordovaWebView);
    this.sockMan = ((ConnectivityManager)paramCordovaInterface.getActivity().getSystemService("connectivity"));
    this.connectionCallbackContext = null;
    paramCordovaWebView = new IntentFilter();
    paramCordovaWebView.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    if (this.receiver == null)
    {
      this.receiver = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (NetworkManager.this.webView != null) {
            NetworkManager.this.updateConnectionInfo(NetworkManager.this.sockMan.getActiveNetworkInfo());
          }
        }
      };
      paramCordovaInterface.getActivity().registerReceiver(this.receiver, paramCordovaWebView);
      this.registered = true;
    }
  }
  
  public void onDestroy()
  {
    if ((this.receiver != null) && (this.registered)) {}
    try
    {
      this.cordova.getActivity().unregisterReceiver(this.receiver);
      this.registered = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("NetworkManager", "Error unregistering network receiver: " + localException.getMessage(), localException);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\NetworkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */