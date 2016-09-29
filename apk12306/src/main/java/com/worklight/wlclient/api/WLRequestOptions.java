package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

public class WLRequestOptions
{
  private boolean fromChallenge;
  private ArrayList<Header> headers = new ArrayList();
  private Object invocationContext;
  private Map<String, String> parameters = new HashMap();
  private WLResponseListener responseListener;
  private int timeout = 10000;
  
  static
  {
    JniLib.a(WLRequestOptions.class, 1310);
  }
  
  native void addHeader(String paramString1, String paramString2);
  
  native void addHeader(Header paramHeader);
  
  native void addParameter(String paramString1, String paramString2);
  
  native void addParameters(Map<String, String> paramMap);
  
  public native ArrayList<Header> getHeaders();
  
  public native Object getInvocationContext();
  
  native String getParameter(String paramString);
  
  public native Map<String, String> getParameters();
  
  native WLResponseListener getResponseListener();
  
  public native int getTimeout();
  
  public native boolean isFromChallenge();
  
  public native void setFromChallenge(boolean paramBoolean);
  
  native void setHeaders(ArrayList<Header> paramArrayList);
  
  public native void setInvocationContext(Object paramObject);
  
  native void setResponseListener(WLResponseListener paramWLResponseListener);
  
  public native void setTimeout(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLRequestOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */