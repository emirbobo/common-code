package com.worklight.wlclient.challengehandler;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.api.challengehandler.WLChallengeHandler;
import org.json.JSONObject;

public class AntiXSRFChallengeHandler
  extends WLChallengeHandler
{
  private static final String PROTOCOL_ERROR_MESSAGE = "Application will exit because wrong JSON arrived when processing it from AntiXSRFChallengeHandler with ";
  
  static
  {
    JniLib.a(AntiXSRFChallengeHandler.class, 1311);
  }
  
  public AntiXSRFChallengeHandler(String paramString)
  {
    super(paramString);
  }
  
  public native void handleChallenge(JSONObject paramJSONObject);
  
  public native void handleFailure(JSONObject paramJSONObject);
  
  public native void handleSuccess(JSONObject paramJSONObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\challengehandler\AntiXSRFChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */