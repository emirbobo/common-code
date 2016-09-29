package com.worklight.androidgap.plugin;

import android.content.Context;
import com.worklight.utils.SecurityUtils;
import org.apache.cordova.api.CallbackContext;
import org.json.JSONArray;

 enum SecurityPlugin$ACTION$4
{
  SecurityPlugin$ACTION$4()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean execute(JSONArray paramJSONArray, CallbackContext paramCallbackContext, Context paramContext)
  {
    try
    {
      paramCallbackContext.success(SecurityUtils.hashDataFromJSON(paramContext, paramJSONArray));
      bool = true;
    }
    catch (Exception paramJSONArray)
    {
      for (;;)
      {
        boolean bool = executeError(hashData, paramCallbackContext, paramJSONArray.getLocalizedMessage());
      }
    }
    return bool;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\SecurityPlugin$ACTION$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */