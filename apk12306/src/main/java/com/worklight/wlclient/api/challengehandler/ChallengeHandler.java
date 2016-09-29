package com.worklight.wlclient.api.challengehandler;

import com.worklight.common.WLConfig;
import com.worklight.common.WLUtils;
import com.worklight.wlclient.AsynchronousRequestSender;
import com.worklight.wlclient.WLRequest;
import com.worklight.wlclient.api.WLClient;
import com.worklight.wlclient.api.WLProcedureInvocationData;
import com.worklight.wlclient.api.WLRequestOptions;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public abstract class ChallengeHandler
  extends BaseChallengeHandler<WLResponse>
  implements WLResponseListener
{
  public ChallengeHandler(String paramString)
  {
    super(paramString);
  }
  
  private void addGetParams(HttpGet paramHttpGet, Map<String, String> paramMap)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    localBasicHttpParams.setParameter("isAjaxRequest", "true");
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBasicHttpParams.setParameter(str, paramMap.get(str));
    }
    paramHttpGet.setParams(localBasicHttpParams);
  }
  
  private void addPostParams(HttpPost paramHttpPost, Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("isAjaxRequest", "true"));
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new BasicNameValuePair(str, (String)paramMap.get(str)));
      }
    }
    try
    {
      paramMap = new UrlEncodedFormEntity(localArrayList, "UTF-8");
      paramHttpPost.setEntity(paramMap);
      return;
    }
    catch (UnsupportedEncodingException paramHttpPost)
    {
      WLUtils.error(paramHttpPost.getMessage(), paramHttpPost);
      throw new RuntimeException(paramHttpPost);
    }
  }
  
  public abstract boolean isCustomResponse(WLResponse paramWLResponse);
  
  public void submitAdapterAuthentication(WLProcedureInvocationData paramWLProcedureInvocationData, WLRequestOptions paramWLRequestOptions)
  {
    WLRequestOptions localWLRequestOptions = paramWLRequestOptions;
    if (paramWLRequestOptions == null) {
      localWLRequestOptions = new WLRequestOptions();
    }
    localWLRequestOptions.setFromChallenge(true);
    WLClient.getInstance().sendInvoke(paramWLProcedureInvocationData, this, localWLRequestOptions);
  }
  
  protected void submitLoginForm(String paramString1, Map<String, String> paramMap1, Map<String, String> paramMap2, int paramInt, String paramString2)
  {
    WLUtils.debug("Request [login]");
    WLClient localWLClient = WLClient.getInstance();
    if ((paramString1.indexOf("http") == 0) && (paramString1.indexOf(":") > 0))
    {
      if (!paramString2.equalsIgnoreCase("post")) {
        break label213;
      }
      paramString1 = new HttpPost(paramString1);
      addPostParams((HttpPost)paramString1, paramMap1);
    }
    for (;;)
    {
      paramString1.addHeader("x-wl-app-version", localWLClient.getConfig().getApplicationVersion());
      if (paramMap2 == null) {
        break label254;
      }
      paramMap1 = paramMap2.keySet().iterator();
      while (paramMap1.hasNext())
      {
        paramString2 = (String)paramMap1.next();
        paramString1.addHeader(paramString2, (String)paramMap2.get(paramString2));
      }
      String str2 = localWLClient.getConfig().getAppURL().toExternalForm();
      String str1 = paramString1;
      if (str2.charAt(str2.length() - 1) == '/')
      {
        str1 = paramString1;
        if (paramString1.length() > 0)
        {
          str1 = paramString1;
          if (paramString1.charAt(0) == '/') {
            str1 = paramString1.substring(1);
          }
        }
      }
      paramString1 = str2 + str1;
      break;
      label213:
      if (!paramString2.equalsIgnoreCase("get")) {
        break label244;
      }
      paramString1 = new HttpGet(paramString1);
      addGetParams((HttpGet)paramString1, paramMap1);
    }
    label244:
    throw new RuntimeException("CustomChallengeHandler.submitLoginForm: invalid request method.");
    label254:
    AsynchronousRequestSender.getInstance().sendCustomRequestAsync(paramString1, paramInt, this);
  }
  
  protected void submitSuccess(WLResponse paramWLResponse)
  {
    try
    {
      this.activeRequest.removeExpectedAnswer(getRealm());
      this.activeRequest = null;
      releaseWaitingList();
      return;
    }
    finally {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\challengehandler\ChallengeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */