package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.json.JSONArray;

class DispatchingPlugin$ActionDispatcherRunnable
  implements Runnable
{
  private JSONArray args;
  private CallbackContext callbackContext;
  private CordovaInterface context;
  private ActionDispatcher dispatcher;
  
  static
  {
    JniLib.a(ActionDispatcherRunnable.class, 1220);
  }
  
  private DispatchingPlugin$ActionDispatcherRunnable(DispatchingPlugin paramDispatchingPlugin, ActionDispatcher paramActionDispatcher, JSONArray paramJSONArray, CordovaInterface paramCordovaInterface, CallbackContext paramCallbackContext)
  {
    this.args = paramJSONArray;
    this.callbackContext = paramCallbackContext;
    this.context = paramCordovaInterface;
    this.dispatcher = paramActionDispatcher;
  }
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\DispatchingPlugin$ActionDispatcherRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */