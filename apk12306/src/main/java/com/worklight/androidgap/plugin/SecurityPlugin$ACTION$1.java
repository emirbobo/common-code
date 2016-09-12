package com.worklight.androidgap.plugin;

import android.content.Context;
import com.worklight.common.WLUtils;
import org.apache.cordova.api.CallbackContext;
import org.json.JSONArray;

 enum SecurityPlugin$ACTION$1
{
  SecurityPlugin$ACTION$1()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean execute(JSONArray paramJSONArray, CallbackContext paramCallbackContext, Context paramContext)
  {
    try
    {
      paramCallbackContext.success(WLUtils.byteArrayToHexString(SecurityPlugin.access$100(paramJSONArray)));
      bool = true;
    }
    catch (Exception paramJSONArray)
    {
      for (;;)
      {
        boolean bool = executeError(keygen, paramCallbackContext, paramJSONArray.getLocalizedMessage());
      }
    }
    return bool;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\SecurityPlugin$ACTION$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */