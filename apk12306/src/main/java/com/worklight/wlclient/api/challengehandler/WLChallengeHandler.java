package com.worklight.wlclient.api.challengehandler;

import com.worklight.wlclient.WLRequest;
import org.json.JSONObject;

public abstract class WLChallengeHandler
  extends BaseChallengeHandler<JSONObject>
{
  public WLChallengeHandler(String paramString)
  {
    super(paramString);
  }
  
  public abstract void handleFailure(JSONObject paramJSONObject);
  
  public abstract void handleSuccess(JSONObject paramJSONObject);
  
  public void submitChallengeAnswer(Object paramObject)
  {
    if (paramObject == null) {
      this.activeRequest.removeExpectedAnswer(getRealm());
    }
    for (;;)
    {
      this.activeRequest = null;
      return;
      this.activeRequest.submitAnswer(getRealm(), paramObject);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\challengehandler\WLChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */