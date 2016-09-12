package com.worklight.wlclient.challengehandler;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.api.challengehandler.BaseProvisioningChallengeHandler;
import org.json.JSONObject;

public class AutoProvisioningChallengeHandler
  extends BaseProvisioningChallengeHandler
{
  static
  {
    JniLib.a(AutoProvisioningChallengeHandler.class, 1313);
  }
  
  public AutoProvisioningChallengeHandler(String paramString)
  {
    super(paramString);
  }
  
  protected native JSONObject createJsonCsr(String paramString1, String paramString2, String paramString3);
  
  public native void handleChallenge(JSONObject paramJSONObject);
  
  public native void handleFailure(JSONObject paramJSONObject);
  
  public native void handleSuccess(JSONObject paramJSONObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\challengehandler\AutoProvisioningChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */