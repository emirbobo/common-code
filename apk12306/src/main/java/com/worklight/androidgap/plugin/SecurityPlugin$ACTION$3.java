package com.worklight.androidgap.plugin;

import android.content.Context;
import org.apache.cordova.api.CallbackContext;
import org.json.JSONArray;

 enum SecurityPlugin$ACTION$3
{
  SecurityPlugin$ACTION$3()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean execute(JSONArray paramJSONArray, CallbackContext paramCallbackContext, Context paramContext)
  {
    try
    {
      paramContext = new java/lang/String;
      paramContext.<init>(SecurityPlugin.access$300(paramJSONArray));
      paramCallbackContext.success(paramContext);
      bool = true;
    }
    catch (Exception paramJSONArray)
    {
      for (;;)
      {
        boolean bool = executeError(decrypt, paramCallbackContext, paramJSONArray.getLocalizedMessage());
      }
    }
    return bool;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\SecurityPlugin$ACTION$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */