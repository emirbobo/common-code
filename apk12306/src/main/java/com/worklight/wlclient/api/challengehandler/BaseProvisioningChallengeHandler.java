package com.worklight.wlclient.api.challengehandler;

import org.json.JSONObject;

public abstract class BaseProvisioningChallengeHandler
  extends BaseDeviceAuthChallengeHandler
{
  public BaseProvisioningChallengeHandler(String paramString)
  {
    super(paramString);
  }
  
  protected abstract JSONObject createJsonCsr(String paramString1, String paramString2, String paramString3);
  
  protected boolean isCertificateChallengeResponse(JSONObject paramJSONObject)
  {
    return false;
  }
  
  protected void onDeviceAuthDataReady(JSONObject paramJSONObject) {}
  
  protected void submitCsr(JSONObject paramJSONObject) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\challengehandler\BaseProvisioningChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */