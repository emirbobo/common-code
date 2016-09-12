package com.worklight.wlclient.api.challengehandler;

import android.os.Build;
import android.os.Build.VERSION;
import com.worklight.common.WLConfig;
import com.worklight.common.security.WLDeviceAuthManager;
import com.worklight.wlclient.api.WLClient;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseDeviceAuthChallengeHandler
  extends WLChallengeHandler
{
  public BaseDeviceAuthChallengeHandler(String paramString)
  {
    super(paramString);
  }
  
  protected void getDeviceAuthDataAsync(String paramString)
    throws Exception, JSONException
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    WLClient localWLClient = WLClient.getInstance();
    localJSONObject3.put("id", localWLClient.getConfig().getAppId());
    localJSONObject3.put("version", localWLClient.getConfig().getApplicationVersion());
    localJSONObject1.put("id", WLDeviceAuthManager.getInstance().getDeviceUUID(localWLClient.getContext()));
    localJSONObject1.put("os", Build.VERSION.RELEASE);
    localJSONObject1.put("model", Build.MODEL);
    localJSONObject1.put("environment", "Android");
    localJSONObject2.put("app", localJSONObject3);
    localJSONObject2.put("device", localJSONObject1);
    localJSONObject2.put("token", paramString);
    onDeviceAuthDataReady(localJSONObject2);
  }
  
  protected abstract void onDeviceAuthDataReady(JSONObject paramJSONObject)
    throws JSONException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\challengehandler\BaseDeviceAuthChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */