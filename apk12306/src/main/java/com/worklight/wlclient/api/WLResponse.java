package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import com.worklight.common.WLUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class WLResponse
{
  private Header[] headers;
  private HttpResponse httpResponseCache;
  private WLRequestOptions requestOptions;
  private JSONObject responseJSON;
  protected String responseText;
  private int status;
  
  static
  {
    JniLib.a(WLResponse.class, 1293);
  }
  
  WLResponse(int paramInt, String paramString, WLRequestOptions paramWLRequestOptions)
  {
    this.status = paramInt;
    this.requestOptions = paramWLRequestOptions;
    this.responseText = paramString;
    responseTextToJSON(paramString);
  }
  
  WLResponse(WLResponse paramWLResponse)
  {
    this.status = paramWLResponse.status;
    this.requestOptions = paramWLResponse.requestOptions;
    this.responseText = paramWLResponse.responseText;
    this.responseJSON = paramWLResponse.responseJSON;
    this.httpResponseCache = paramWLResponse.httpResponseCache;
  }
  
  public WLResponse(HttpResponse paramHttpResponse)
  {
    this.status = paramHttpResponse.getStatusLine().getStatusCode();
    this.headers = paramHttpResponse.getAllHeaders();
    this.httpResponseCache = paramHttpResponse;
    try
    {
      if (paramHttpResponse.getHeaders("Content-Encoding").length > 0)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        WLUtils.error("Content encoding is " + paramHttpResponse.getHeaders("Content-Encoding")[0].getValue());
        if (paramHttpResponse.getHeaders("Content-Encoding")[0].getValue().equalsIgnoreCase("gzip"))
        {
          this.responseText = WLUtils.convertGZIPStreamToString(paramHttpResponse.getEntity().getContent());
          WLUtils.log("Content encoding is gzip", 0);
        }
        for (;;)
        {
          responseTextToJSON(this.responseText);
          return;
          this.responseText = WLUtils.convertStreamToString(paramHttpResponse.getEntity().getContent());
        }
      }
    }
    catch (Exception paramHttpResponse)
    {
      for (;;)
      {
        WLUtils.error("Response from Worklight server failed because could not read text from response " + paramHttpResponse.getMessage(), paramHttpResponse);
        continue;
        WLUtils.error("No Content-Encoding header");
        this.responseText = WLUtils.convertStreamToString(paramHttpResponse.getEntity().getContent());
      }
    }
  }
  
  private native void responseTextToJSON(String paramString);
  
  public native Header getHeader(String paramString);
  
  public native Header[] getHeaders();
  
  public native Object getInvocationContext();
  
  native WLRequestOptions getOptions();
  
  public native JSONObject getResponseJSON();
  
  public native String getResponseText();
  
  public native int getStatus();
  
  native void setInvocationContext(Object paramObject);
  
  public native void setOptions(WLRequestOptions paramWLRequestOptions);
  
  native void setResponseHeader(String paramString1, String paramString2);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */