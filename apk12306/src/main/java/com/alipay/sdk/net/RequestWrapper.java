package com.alipay.sdk.net;

import android.content.Context;
import com.alipay.sdk.data.InteractionData;
import com.alipay.sdk.data.Request;
import com.alipay.sdk.data.Response;
import com.alipay.sdk.exception.AppErrorException;
import com.alipay.sdk.exception.FailOperatingException;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.exception.UnZipException;
import com.alipay.sdk.protocol.FrameData;
import com.bangcle.andjni.JniLib;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestWrapper
{
  private int a = 0;
  private InteractionData b;
  
  static
  {
    JniLib.a(RequestWrapper.class, 116);
  }
  
  public RequestWrapper() {}
  
  public RequestWrapper(InteractionData paramInteractionData)
  {
    this.b = paramInteractionData;
  }
  
  private native String a(Context paramContext, String paramString1, String paramString2, InteractionData paramInteractionData, Response paramResponse)
    throws NetErrorException;
  
  private native JSONObject a(Context paramContext, Request paramRequest, Response paramResponse, String paramString1, String paramString2)
    throws JSONException, AppErrorException, NetErrorException, FailOperatingException;
  
  private native JSONObject a(Request paramRequest, Response paramResponse, String paramString)
    throws JSONException, AppErrorException;
  
  private native JSONObject a(String paramString, Request paramRequest, Response paramResponse)
    throws JSONException, AppErrorException;
  
  private native void a(JSONObject paramJSONObject);
  
  public native FrameData a(Context paramContext, Request paramRequest, boolean paramBoolean)
    throws NetErrorException, FailOperatingException, AppErrorException, UnZipException;
  
  protected native String a(String paramString);
  
  public native JSONObject a(Context paramContext, Request paramRequest, Response paramResponse)
    throws NetErrorException, FailOperatingException, AppErrorException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\net\RequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */