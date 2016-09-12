package com.MobileTicket;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class PushMsgPlugin
  extends CordovaPlugin
{
  private static final String DEC_ACTION = "decrypt";
  private static final String ENC_ACTION = "encrypt";
  
  static
  {
    JniLib.a(PushMsgPlugin.class, 13);
  }
  
  public native boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\PushMsgPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */