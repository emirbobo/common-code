package com.worklight.androidgap.plugin;

import android.content.Context;
import org.apache.cordova.api.CallbackContext;
import org.json.JSONArray;

 enum SecurityPlugin$ACTION$2
{
  SecurityPlugin$ACTION$2()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean execute(JSONArray paramJSONArray, CallbackContext paramCallbackContext, Context paramContext)
  {
    try
    {
      paramCallbackContext.success(SecurityPlugin.access$200(paramJSONArray));
      bool = true;
    }
    catch (Exception paramJSONArray)
    {
      for (;;)
      {
        boolean bool = executeError(encrypt, paramCallbackContext, paramJSONArray.getLocalizedMessage());
      }
    }
    return bool;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\SecurityPlugin$ACTION$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */