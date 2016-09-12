package com.worklight.androidgap.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.json.JSONArray;

class WLCustomDialog$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 1197);
  }
  
  WLCustomDialog$1(WLCustomDialog paramWLCustomDialog, CordovaInterface paramCordovaInterface, String paramString1, String paramString2, JSONArray paramJSONArray, CallbackContext paramCallbackContext) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLCustomDialog$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */