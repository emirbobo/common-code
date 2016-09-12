package com.worklight.wlclient;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import com.worklight.common.WLConfig;
import com.worklight.wlclient.api.WLRequestOptions;
import com.worklight.wlclient.api.WLResponse;
import java.util.HashMap;
import java.util.List;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HttpContext;

public class WLRequest
{
  private static final String ACCESS_DENIED_ID = "WLClient.accessDenied";
  private static final String AUTH_FAIL_ID = "WLClient.authFailure";
  private static final String CLOSE_BUTTON_ID = "WLClient.close";
  private static final String ERROR_ID = "WLClient.error";
  private static final String RESOURCE_BUNDLE = "com/worklight/wlclient/messages";
  private WLConfig config;
  private Context context;
  private HttpContext httpContext;
  private HttpPost postRequest;
  private WLRequestListener requestListener;
  private WLRequestOptions requestOptions;
  private String requestURL = null;
  private HashMap<String, Object> wlAnswers = new HashMap();
  
  static
  {
    JniLib.a(WLRequest.class, 1285);
  }
  
  public WLRequest(WLRequestListener paramWLRequestListener, HttpContext paramHttpContext, WLRequestOptions paramWLRequestOptions, WLConfig paramWLConfig, Context paramContext)
  {
    this.requestListener = paramWLRequestListener;
    this.httpContext = paramHttpContext;
    this.requestOptions = paramWLRequestOptions;
    this.config = paramWLConfig;
    this.context = paramContext;
  }
  
  private native void addExpectedAnswers(HttpPost paramHttpPost);
  
  private native void addExtraHeaders(HttpPost paramHttpPost);
  
  private native void addHeaders(WLConfig paramWLConfig, HttpPost paramHttpPost);
  
  private native void addParams(WLRequestOptions paramWLRequestOptions, HttpPost paramHttpPost);
  
  private native boolean checkResponseForChallenges(WLResponse paramWLResponse);
  
  private native void checkResponseForSuccesses(WLResponse paramWLResponse);
  
  private native boolean handleCustomChallenges(WLResponse paramWLResponse);
  
  private native boolean isWl401(WLResponse paramWLResponse);
  
  private native boolean isWl403(WLResponse paramWLResponse);
  
  private native void processFailureResponse(WLResponse paramWLResponse);
  
  private native void processSuccessResponse(WLResponse paramWLResponse);
  
  private native void resendIfNeeded();
  
  private native void resendRequest();
  
  private native void sendRequest(String paramString);
  
  private native void setExpectedAnswers(List<String> paramList);
  
  private native void showErrorDialogue(String paramString1, String paramString2, String paramString3);
  
  private native void triggerUnexpectedOnFailure(Exception paramException);
  
  public native WLConfig getConfig();
  
  public native Context getContext();
  
  public native HttpContext getHttpContext();
  
  public native WLRequestOptions getOptions();
  
  public native HttpPost getPostRequest();
  
  public native WLRequestListener getRequestListener();
  
  public native void makeRequest(String paramString);
  
  public native void makeRequest(String paramString, boolean paramBoolean);
  
  public native void removeExpectedAnswer(String paramString);
  
  public native void requestFinished(WLResponse paramWLResponse);
  
  public native void submitAnswer(String paramString, Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\WLRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */