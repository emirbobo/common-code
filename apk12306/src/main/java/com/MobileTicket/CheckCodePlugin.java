package com.MobileTicket;

import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class CheckCodePlugin
  extends CordovaPlugin
{
  private static final String DECODE_ACTION = "decheckcode";
  private static final String GET_ACTION = "getcheckcode";
  
  static
  {
    JniLib.a(CheckCodePlugin.class, 0);
  }
  
  public native boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\CheckCodePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */