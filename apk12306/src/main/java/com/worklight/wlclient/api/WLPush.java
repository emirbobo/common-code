package com.worklight.wlclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.push.WLGCMIntentService.Message;
import com.worklight.common.WLConfig;
import com.worklight.wlclient.WLRequestListener;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONObject;

public class WLPush
{
  private static final String ERROR_ID = "WLClient.error";
  private static final String FROM_NOTIFICATION_BAR = "notificationBar";
  private static final String NOT_UPDATE_FAILURE = "WLClient.notificationUpdateFailure";
  private static final String OK = "WLClient.ok";
  private static final String RESOURCE_BUNDLE = "com/worklight/wlclient/messages";
  private WLConfig config;
  private Context context;
  private String deviceToken;
  private HttpContext httpContext;
  private boolean isTokenUpdatedOnServer;
  private BroadcastReceiver onMessage;
  private WLOnReadyToSubscribeListener onReadyToSubscribeListener;
  private BroadcastReceiver onRegister;
  private BroadcastReceiver onRegisterError;
  private ArrayList<WLGCMIntentService.Message> pending;
  private ArrayList<JSONObject> pendingPushEvents;
  private HashMap<String, RegisteredEventSource> registeredEventSources;
  private String serverToken;
  private ArrayList<String> subscribedEventSources;
  
  static
  {
    JniLib.a(WLPush.class, 1308);
  }
  
  /* Error */
  WLPush(HttpContext paramHttpContext, WLConfig paramWLConfig, Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 83	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 85	com/worklight/wlclient/api/WLPush:isTokenUpdatedOnServer	Z
    //   9: aload_0
    //   10: new 87	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 88	java/util/ArrayList:<init>	()V
    //   17: putfield 90	com/worklight/wlclient/api/WLPush:subscribedEventSources	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: new 87	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 88	java/util/ArrayList:<init>	()V
    //   28: putfield 92	com/worklight/wlclient/api/WLPush:pendingPushEvents	Ljava/util/ArrayList;
    //   31: aload_0
    //   32: new 87	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 88	java/util/ArrayList:<init>	()V
    //   39: putfield 94	com/worklight/wlclient/api/WLPush:pending	Ljava/util/ArrayList;
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 96	com/worklight/wlclient/api/WLPush:serverToken	Ljava/lang/String;
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 98	com/worklight/wlclient/api/WLPush:deviceToken	Ljava/lang/String;
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 100	com/worklight/wlclient/api/WLPush:onReadyToSubscribeListener	Lcom/worklight/wlclient/api/WLOnReadyToSubscribeListener;
    //   57: aload_0
    //   58: new 10	com/worklight/wlclient/api/WLPush$3
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 103	com/worklight/wlclient/api/WLPush$3:<init>	(Lcom/worklight/wlclient/api/WLPush;)V
    //   66: putfield 105	com/worklight/wlclient/api/WLPush:onRegister	Landroid/content/BroadcastReceiver;
    //   69: aload_0
    //   70: new 12	com/worklight/wlclient/api/WLPush$4
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 106	com/worklight/wlclient/api/WLPush$4:<init>	(Lcom/worklight/wlclient/api/WLPush;)V
    //   78: putfield 108	com/worklight/wlclient/api/WLPush:onRegisterError	Landroid/content/BroadcastReceiver;
    //   81: aload_0
    //   82: new 14	com/worklight/wlclient/api/WLPush$5
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 109	com/worklight/wlclient/api/WLPush$5:<init>	(Lcom/worklight/wlclient/api/WLPush;)V
    //   90: putfield 111	com/worklight/wlclient/api/WLPush:onMessage	Landroid/content/BroadcastReceiver;
    //   93: aload_3
    //   94: ifnonnull +13 -> 107
    //   97: new 113	java/lang/RuntimeException
    //   100: dup
    //   101: ldc 115
    //   103: invokespecial 118	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   106: athrow
    //   107: getstatic 124	android/os/Build$VERSION:SDK_INT	I
    //   110: bipush 8
    //   112: if_icmpge +43 -> 155
    //   115: new 126	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   122: ldc -127
    //   124: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: getstatic 136	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   130: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc -118
    //   135: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore_1
    //   142: aload_1
    //   143: invokestatic 147	com/worklight/common/WLUtils:error	(Ljava/lang/String;)V
    //   146: new 113	java/lang/RuntimeException
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 118	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   154: athrow
    //   155: aload_3
    //   156: invokestatic 153	com/google/android/gcm/GCMRegistrar:checkDevice	(Landroid/content/Context;)V
    //   159: aload_3
    //   160: invokestatic 156	com/google/android/gcm/GCMRegistrar:checkManifest	(Landroid/content/Context;)V
    //   163: aload_3
    //   164: ldc -98
    //   166: ldc -96
    //   168: invokestatic 164	com/worklight/common/WLUtils:getResourceId	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: aload_0
    //   173: aload_1
    //   174: putfield 166	com/worklight/wlclient/api/WLPush:httpContext	Lorg/apache/http/protocol/HttpContext;
    //   177: aload_0
    //   178: aload_2
    //   179: putfield 168	com/worklight/wlclient/api/WLPush:config	Lcom/worklight/common/WLConfig;
    //   182: aload_0
    //   183: aload_3
    //   184: putfield 170	com/worklight/wlclient/api/WLPush:context	Landroid/content/Context;
    //   187: iconst_1
    //   188: invokestatic 176	com/worklight/wlclient/push/GCMIntentService:setAppForeground	(Z)V
    //   191: aload_0
    //   192: invokevirtual 179	com/worklight/wlclient/api/WLPush:unregisterReceivers	()V
    //   195: aload_3
    //   196: aload_0
    //   197: getfield 111	com/worklight/wlclient/api/WLPush:onMessage	Landroid/content/BroadcastReceiver;
    //   200: new 181	android/content/IntentFilter
    //   203: dup
    //   204: new 126	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   211: aload_3
    //   212: invokestatic 185	com/worklight/common/WLUtils:getFullAppName	(Landroid/content/Context;)Ljava/lang/String;
    //   215: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc -69
    //   220: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokespecial 188	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   229: invokevirtual 194	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   232: pop
    //   233: aload_0
    //   234: invokespecial 197	com/worklight/wlclient/api/WLPush:dispatchPending	()V
    //   237: return
    //   238: astore_1
    //   239: new 113	java/lang/RuntimeException
    //   242: dup
    //   243: new 126	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   250: ldc -57
    //   252: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_1
    //   256: invokevirtual 202	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   259: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokespecial 118	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   268: athrow
    //   269: astore_1
    //   270: new 113	java/lang/RuntimeException
    //   273: dup
    //   274: new 126	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   281: ldc -52
    //   283: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_1
    //   287: invokevirtual 202	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   290: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokespecial 118	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   299: athrow
    //   300: astore_1
    //   301: new 113	java/lang/RuntimeException
    //   304: dup
    //   305: ldc -50
    //   307: invokespecial 118	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   310: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	WLPush
    //   0	311	1	paramHttpContext	HttpContext
    //   0	311	2	paramWLConfig	WLConfig
    //   0	311	3	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   155	159	238	java/lang/Exception
    //   159	163	269	java/lang/Exception
    //   163	172	300	java/lang/Exception
  }
  
  private native void cancelAllNotification();
  
  private native void dispatch();
  
  private native void dispatchPending();
  
  private native void dispatchPendings();
  
  private native boolean hasPendings();
  
  private native boolean isAbleToSubscribe(String paramString, boolean paramBoolean);
  
  private native boolean isDeviceSupportPush();
  
  private native void moveQueueToPending();
  
  private native boolean onMessage(WLGCMIntentService.Message paramMessage);
  
  private native void showErrorDialogue(String paramString1, String paramString2, String paramString3);
  
  private native void updateRegisteredEventSources(String paramString1, String paramString2, String paramString3, WLEventSourceListener paramWLEventSourceListener);
  
  private native void updateTokenCallback(String paramString);
  
  public native void clearSubscribedEventSources();
  
  native WLOnReadyToSubscribeListener getOnReadyToSubscribeListener();
  
  public native boolean isForeground();
  
  public native boolean isPushSupported();
  
  public native boolean isSubscribed(String paramString);
  
  public native void registerEventSourceCallback(String paramString1, String paramString2, String paramString3, WLEventSourceListener paramWLEventSourceListener);
  
  public native void setForeground(boolean paramBoolean);
  
  public native void setOnReadyToSubscribeListener(WLOnReadyToSubscribeListener paramWLOnReadyToSubscribeListener);
  
  public native void subscribe(String paramString, WLPushOptions paramWLPushOptions, WLResponseListener paramWLResponseListener);
  
  public native void unregisterReceivers();
  
  public native void unsubscribe(String paramString, WLResponseListener paramWLResponseListener);
  
  public native void updateSubscribedEventSources(JSONArray paramJSONArray);
  
  public native void updateToken(String paramString);
  
  class RegisteredEventSource
  {
    private String adapter;
    private String eventSource;
    private WLEventSourceListener eventSourceListener;
    
    static
    {
      JniLib.a(RegisteredEventSource.class, 1304);
    }
    
    RegisteredEventSource() {}
    
    public native String getAdapter();
    
    public native String getEventSource();
    
    public native WLEventSourceListener getEventSourceListener();
    
    public native void setAdapter(String paramString);
    
    public native void setEventSource(String paramString);
    
    public native void setEventSourceListener(WLEventSourceListener paramWLEventSourceListener);
  }
  
  class SubscribeRequestListener
    implements WLRequestListener
  {
    private String alias;
    
    static
    {
      JniLib.a(SubscribeRequestListener.class, 1305);
    }
    
    public SubscribeRequestListener(String paramString)
    {
      this.alias = paramString;
    }
    
    public native void onFailure(WLFailResponse paramWLFailResponse);
    
    public native void onSuccess(WLResponse paramWLResponse);
  }
  
  class UnSubscribeRequestListener
    implements WLRequestListener
  {
    private String alias;
    
    static
    {
      JniLib.a(UnSubscribeRequestListener.class, 1306);
    }
    
    public UnSubscribeRequestListener(String paramString)
    {
      this.alias = paramString;
    }
    
    public native void onFailure(WLFailResponse paramWLFailResponse);
    
    public native void onSuccess(WLResponse paramWLResponse);
  }
  
  class UpdateTokenListener
    implements WLRequestListener
  {
    static
    {
      JniLib.a(UpdateTokenListener.class, 1307);
    }
    
    public UpdateTokenListener() {}
    
    public native void onFailure(WLFailResponse paramWLFailResponse);
    
    public native void onSuccess(WLResponse paramWLResponse);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */