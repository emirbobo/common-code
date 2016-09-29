package com.worklight.wlclient.api;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import com.worklight.common.WLConfig;
import com.worklight.wlclient.WLRequestListener;
import com.worklight.wlclient.api.challengehandler.BaseChallengeHandler;
import com.worklight.wlclient.api.challengehandler.ChallengeHandler;
import com.worklight.wlclient.api.challengehandler.WLChallengeHandler;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class WLClient
{
  private static final String ANTI_XSRF_REALM = "wl_antiXSRFRealm";
  private static final String AUTHENTICATE_REQUEST_PATH = "authenticate";
  private static final String AUTHENTICITY_REALM = "wl_authenticityRealm";
  private static final String CHALLENGE_HANDLER_NULL_ERROR = "Cannot register 'null' challenge handler";
  private static final String HEART_BEAT_ERROR = "WLClient not initialized - cannot send heart beat message before connect";
  private static final String HEART_BEAT_REQUEST_PATH = "heartbeat";
  private static final String INIT_REQUEST_PATH = "init";
  private static final String INVOKE_PROCEDURE_INIT_ERROR = "invokeProcedure() will not be executed because WLCLient is not initialized, ensure WLCLient.connect function has been called.";
  private static final String INVOKE_PROCEDURE_REQUEST_PATH = "query";
  private static final String INVOKE_PROCEDURE_RUN_ERROR = "Error during invocation of remote procedure, because responseListener parameter can't be null.";
  private static final String LOG_ACTIVITY_INIT_ERROR = "logActivity() will not be executed because WLCLient is not initialized, ensure WLCLient.connect function has been called.";
  private static final String LOG_ACTIVITY_REQUEST_PATH = "logactivity";
  private static final String NO_PROVISIONING_REALM = "wl_deviceNoProvisioningRealm";
  private static final String NO_REALM_REGISTER_ERROR = "Application will exit because the challengeHandler parameter for registerChallengeHandler (challengeHandler) has a null realm property. Call this API with a valid reference to challenge handler.";
  private static final String REMOTE_DISABLE_REALM = "wl_remoteDisableRealm";
  private static final String REQ_PATH_DELETE_USER_PREF = "deleteup";
  private static final String REQ_PATH_SET_USER_PREFS = "setup";
  private static final String SEND_INVOKE_PROCEDURE_REQUEST_PATH = "invoke";
  private static WLClient wlClient = null;
  private Hashtable<String, BaseChallengeHandler> chMap;
  private WLConfig config;
  private Context context;
  private Hashtable<String, String> globalHeaders;
  private int heartbeatInterval = 420;
  private HttpContext httpContext;
  private boolean isInitialized;
  private Timer timer;
  private HashMap<String, String> userPreferenceMap;
  private WLPush wlPush = null;
  
  static
  {
    JniLib.a(WLClient.class, 1292);
  }
  
  private WLClient(Context paramContext)
  {
    this.config = new WLConfig(paramContext);
    this.httpContext = new BasicHttpContext();
    this.context = paramContext;
    this.chMap = new Hashtable();
    this.globalHeaders = new Hashtable();
    this.userPreferenceMap = new HashMap();
    registerDefaultChallengeHandlers();
  }
  
  public static native WLClient createInstance(Context paramContext);
  
  public static native WLClient getInstance();
  
  private native String getWLServerURL();
  
  public static native boolean isApplicationSentToBackground(Context paramContext);
  
  private native void registerDefaultChallengeHandlers();
  
  private static native void releaseInstance();
  
  private native boolean updateCookiesFromWebView();
  
  public native HttpContext GetHttpContext();
  
  public native void addGlobalHeader(String paramString1, String paramString2);
  
  public native void addGlobalHeadersToRequest(HttpPost paramHttpPost);
  
  public native void checkForNotifications();
  
  public native void connect(WLResponseListener paramWLResponseListener);
  
  public native ChallengeHandler getChallengeHandler(WLResponse paramWLResponse);
  
  public native WLConfig getConfig();
  
  public native Context getContext();
  
  public native WLPush getPush();
  
  public native WLChallengeHandler getWLChallengeHandler(String paramString);
  
  public native void init(WLResponseListener paramWLResponseListener);
  
  public native void invokeProcedure(WLProcedureInvocationData paramWLProcedureInvocationData, WLResponseListener paramWLResponseListener);
  
  public native void invokeProcedure(WLProcedureInvocationData paramWLProcedureInvocationData, WLResponseListener paramWLResponseListener, WLRequestOptions paramWLRequestOptions);
  
  public native void logActivity(String paramString);
  
  public native void registerChallengeHandler(BaseChallengeHandler paramBaseChallengeHandler);
  
  public native void removeGlobalHeader(String paramString);
  
  native void sendHeartBeat();
  
  public native void sendInvoke(WLProcedureInvocationData paramWLProcedureInvocationData, WLResponseListener paramWLResponseListener, WLRequestOptions paramWLRequestOptions);
  
  public native void setHeartBeatInterval(int paramInt);
  
  protected native void setInitialized(boolean paramBoolean);
  
  class HeartBeatTask
    extends TimerTask
  {
    private Context context = null;
    
    static
    {
      JniLib.a(HeartBeatTask.class, 1287);
    }
    
    HeartBeatTask(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public native void run();
  }
  
  class HeartbeatListener
    implements WLRequestListener
  {
    static
    {
      JniLib.a(HeartbeatListener.class, 1288);
    }
    
    HeartbeatListener() {}
    
    public native void onFailure(WLFailResponse paramWLFailResponse);
    
    public native void onSuccess(WLResponse paramWLResponse);
  }
  
  class InitRequestListener
    implements WLRequestListener
  {
    static
    {
      JniLib.a(InitRequestListener.class, 1289);
    }
    
    public InitRequestListener() {}
    
    public native void onFailure(WLFailResponse paramWLFailResponse);
    
    public native void onSuccess(WLResponse paramWLResponse);
  }
  
  class InvokeProcedureRequestListener
    implements WLRequestListener
  {
    static
    {
      JniLib.a(InvokeProcedureRequestListener.class, 1290);
    }
    
    InvokeProcedureRequestListener() {}
    
    public native void onFailure(WLFailResponse paramWLFailResponse);
    
    public native void onSuccess(WLResponse paramWLResponse);
  }
  
  class LogActivityListener
    implements WLRequestListener
  {
    static
    {
      JniLib.a(LogActivityListener.class, 1291);
    }
    
    LogActivityListener() {}
    
    public native void onFailure(WLFailResponse paramWLFailResponse);
    
    public native void onSuccess(WLResponse paramWLResponse);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */