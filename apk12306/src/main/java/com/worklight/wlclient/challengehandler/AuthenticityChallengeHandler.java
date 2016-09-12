package com.worklight.wlclient.challengehandler;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.api.challengehandler.WLChallengeHandler;
import org.json.JSONObject;

public class AuthenticityChallengeHandler
  extends WLChallengeHandler
{
  private static final String AUTH_FAIL_ID = "WLClient.authFailure";
  private static final String CLOSE_ID = "WLClient.close";
  private static final String INIT_FAILURE_TITLE_ID = "WLClient.wlclientInitFailure";
  private static final String RESOURCE_BUNDLE = "com/worklight/wlclient/messages";
  
  static
  {
    JniLib.a(AuthenticityChallengeHandler.class, 1312);
  }
  
  public AuthenticityChallengeHandler(String paramString)
  {
    super(paramString);
  }
  
  public native void handleChallenge(JSONObject paramJSONObject);
  
  public native void handleFailure(JSONObject paramJSONObject);
  
  public native void handleSuccess(JSONObject paramJSONObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\challengehandler\AuthenticityChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */