package com.worklight.wlclient.challengehandler;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.api.challengehandler.WLChallengeHandler;
import org.json.JSONObject;

public class RemoteDisableChallengeHandler
  extends WLChallengeHandler
{
  private static final String APPLICATION_DISABLED_ID = "WLClient.applicationDenied";
  private static final String CLOSE_ID = "WLClient.close";
  private static final String GET_NEW_VERSION_ID = "WLClient.getNewVersion";
  private static final String NOTIFICATION_TITLE_ID = "WLClient.notificationTitle";
  private static final String NOTIFY_MESAGE = "NOTIFY";
  private static final String PROTOCOL_DOWNLOAD_LINK = "downloadLink";
  private static final String PROTOCOL_ERROR_MESSAGE = "Protocol Error - could not parse JSON object";
  private static final String PROTOCOL_MESSAGE = "message";
  private static final String PROTOCOL_MESSAGE_ID = "messageId";
  private static final String PROTOCOL_MESSAGE_TYPE = "messageType";
  private static final String RESOURCE_BUNDLE = "com/worklight/wlclient/messages";
  
  static
  {
    JniLib.a(RemoteDisableChallengeHandler.class, 1315);
  }
  
  public RemoteDisableChallengeHandler(String paramString)
  {
    super(paramString);
  }
  
  private native void createAndShowDisableDialogue(String paramString1, String paramString2);
  
  private native void createAndShowMessageDialogue(String paramString1, String paramString2);
  
  private native boolean isDisplayMessageDialogue(String paramString1, String paramString2, String paramString3);
  
  public native void handleChallenge(JSONObject paramJSONObject);
  
  public native void handleFailure(JSONObject paramJSONObject);
  
  public native void handleSuccess(JSONObject paramJSONObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\challengehandler\RemoteDisableChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */