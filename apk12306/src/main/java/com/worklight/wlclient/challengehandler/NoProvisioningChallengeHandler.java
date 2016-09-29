package com.worklight.wlclient.challengehandler;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.api.challengehandler.BaseDeviceAuthChallengeHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class NoProvisioningChallengeHandler
  extends BaseDeviceAuthChallengeHandler
{
  static
  {
    JniLib.a(NoProvisioningChallengeHandler.class, 1314);
  }
  
  public NoProvisioningChallengeHandler(String paramString)
  {
    super(paramString);
  }
  
  public native void handleChallenge(JSONObject paramJSONObject);
  
  public native void handleFailure(JSONObject paramJSONObject);
  
  public native void handleSuccess(JSONObject paramJSONObject);
  
  protected native void onDeviceAuthDataReady(JSONObject paramJSONObject)
    throws JSONException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\challengehandler\NoProvisioningChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */