package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.util.JsonstoreUtil;
import com.worklight.androidgap.jsonstore.util.Logger;
import com.worklight.androidgap.jsonstore.util.jackson.JsonOrgModule;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseActionDispatcher
  implements ActionDispatcher
{
  protected static final int RC_FALSE = 0;
  protected static final int RC_OK = 0;
  protected static final int RC_TRUE = 1;
  protected Logger logger = JsonstoreUtil.getCoreLogger();
  private String name;
  private LinkedList<Parameter> parameters;
  
  public BaseActionDispatcher(String paramString)
  {
    this.name = paramString;
    this.parameters = new LinkedList();
  }
  
  private void collectParameters(Context paramContext, JSONArray paramJSONArray)
    throws Throwable
  {
    int i = 0;
    Iterator localIterator = this.parameters.iterator();
    while (localIterator.hasNext())
    {
      Parameter localParameter = (Parameter)localIterator.next();
      int m = 0;
      ParameterType[] arrayOfParameterType = localParameter.getTypes();
      int n = arrayOfParameterType.length;
      for (int k = 0;; k++)
      {
        int j = m;
        if (k < n)
        {
          Object localObject = convertParameter(paramJSONArray, i, arrayOfParameterType[k]);
          if (localObject != null)
          {
            j = 1;
            paramContext.addParameter(localParameter.getName(), localObject);
          }
        }
        else
        {
          if ((!localParameter.isRequired()) || (j != 0)) {
            break;
          }
          throw new Throwable("invalid type for parameter \"" + localParameter.getName() + "\" in action dispatcher \"" + getName() + "\"");
        }
      }
      i++;
    }
  }
  
  private Object convertParameter(JSONArray paramJSONArray, int paramInt, ParameterType paramParameterType)
    throws Throwable
  {
    localObject = null;
    for (;;)
    {
      try
      {
        switch (paramParameterType)
        {
        default: 
          paramJSONArray = (JSONArray)localObject;
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray = (JSONArray)localObject;
        continue;
      }
      return paramJSONArray;
      paramJSONArray = JsonOrgModule.deserializeJSONArray(paramJSONArray.getString(paramInt));
      continue;
      paramJSONArray = Boolean.valueOf(paramJSONArray.getBoolean(paramInt));
      continue;
      paramJSONArray = Double.valueOf(paramJSONArray.getDouble(paramInt));
      continue;
      paramJSONArray = Integer.valueOf(paramJSONArray.getInt(paramInt));
      continue;
      paramJSONArray = Long.valueOf(paramJSONArray.getLong(paramInt));
      continue;
      paramJSONArray = JsonOrgModule.deserializeJSONObject(paramJSONArray.getString(paramInt));
      continue;
      paramJSONArray = paramJSONArray.getString(paramInt);
    }
  }
  
  protected void addParameter(String paramString, boolean paramBoolean1, boolean paramBoolean2, ParameterType... paramVarArgs)
  {
    this.parameters.add(new Parameter(paramString, paramBoolean1, paramBoolean2, paramVarArgs, null));
  }
  
  protected void addParameter(String paramString, boolean paramBoolean, ParameterType... paramVarArgs)
  {
    this.parameters.add(new Parameter(paramString, paramBoolean, true, paramVarArgs, null));
  }
  
  public abstract PluginResult dispatch(Context paramContext)
    throws Throwable;
  
  public PluginResult dispatch(CordovaInterface paramCordovaInterface, JSONArray paramJSONArray)
    throws Throwable
  {
    paramCordovaInterface = new Context(paramCordovaInterface);
    collectParameters(paramCordovaInterface, paramJSONArray);
    if (this.logger.isLoggable(3))
    {
      this.logger.logDebug("invoking action dispatcher \"" + this.name + "\" with parameters:");
      Iterator localIterator = this.parameters.iterator();
      while (localIterator.hasNext())
      {
        paramJSONArray = (Parameter)localIterator.next();
        String str = paramJSONArray.getName();
        if (paramJSONArray.isLoggable()) {
          this.logger.logDebug("   " + str + "=" + paramCordovaInterface.getUntypedParameter(str));
        } else {
          this.logger.logDebug("   " + str + "=[value not logged]");
        }
      }
    }
    return dispatch(paramCordovaInterface);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public static class Context
  {
    private CordovaInterface cordovaContext;
    private HashMap<String, Object> parameters;
    
    static
    {
      JniLib.a(Context.class, 1213);
    }
    
    protected Context(CordovaInterface paramCordovaInterface)
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
  
  private class Parameter
  {
    private boolean loggable;
    private String name;
    private boolean required;
    private BaseActionDispatcher.ParameterType[] types;
    
    static
    {
      JniLib.a(Parameter.class, 1214);
    }
    
    private Parameter(String paramString, boolean paramBoolean1, boolean paramBoolean2, BaseActionDispatcher.ParameterType[] paramArrayOfParameterType)
    {
      this.name = paramString;
      this.required = paramBoolean1;
      this.loggable = paramBoolean2;
      this.types = paramArrayOfParameterType;
    }
    
    public native String getName();
    
    public native BaseActionDispatcher.ParameterType[] getTypes();
    
    public native boolean isLoggable();
    
    public native boolean isRequired();
  }
  
  public static enum ParameterType
  {
    ARRAY,  BOOLEAN,  DOUBLE,  INTEGER,  LONG,  OBJECT,  STRING;
    
    private ParameterType() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\BaseActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */