package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import java.util.HashMap;
import org.apache.cordova.api.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONObject;

public class BaseActionDispatcher$Context
{
  private CordovaInterface cordovaContext;
  private HashMap<String, Object> parameters;
  
  static
  {
    JniLib.a(Context.class, 1213);
  }
  
  protected BaseActionDispatcher$Context(CordovaInterface paramCordovaInterface)
  {
    this.cordovaContext = paramCordovaInterface;
    this.parameters = new HashMap();
  }
  
  private native void addParameter(String paramString, Object paramObject);
  
  public native JSONArray getArrayParameter(String paramString);
  
  public native Boolean getBooleanParameter(String paramString);
  
  public native CordovaInterface getCordovaContext();
  
  public native float getFloatParameter(String paramString);
  
  public native int getIntParameter(String paramString);
  
  public native JSONObject getObjectParameter(String paramString);
  
  public native String getStringParameter(String paramString);
  
  public native Object getUntypedParameter(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\BaseActionDispatcher$Context.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */