package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import org.apache.http.HttpResponse;

public class WLFailResponse
  extends WLResponse
{
  private static final String JSON_KEY_ERROR_CODE = "errorCode";
  private static final String JSON_KEY_ERROR_MSG = "errorMsg";
  WLErrorCode errorCode;
  String errorMsg;
  
  static
  {
    JniLib.a(WLFailResponse.class, 1294);
  }
  
  public WLFailResponse(WLErrorCode paramWLErrorCode, String paramString, WLRequestOptions paramWLRequestOptions)
  {
    super(500, "", paramWLRequestOptions);
    setErrorCode(paramWLErrorCode);
    setErrorMsg(paramString);
  }
  
  public WLFailResponse(WLResponse paramWLResponse)
  {
    super(paramWLResponse);
    parseErrorFromResponse();
  }
  
  WLFailResponse(HttpResponse paramHttpResponse)
  {
    super(paramHttpResponse);
    parseErrorFromResponse();
  }
  
  private native void parseErrorFromResponse();
  
  public native WLErrorCode getErrorCode();
  
  public native String getErrorMsg();
  
  native void setErrorCode(WLErrorCode paramWLErrorCode);
  
  native void setErrorMsg(String paramString);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLFailResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */