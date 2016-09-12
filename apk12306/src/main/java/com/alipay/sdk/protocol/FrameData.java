package com.alipay.sdk.protocol;

import com.alipay.sdk.data.Request;
import com.alipay.sdk.data.Response;
import com.bangcle.andjni.JniLib;
import org.json.JSONObject;

public class FrameData
{
  private Request a;
  private Response b;
  private int c;
  private JSONObject d;
  
  static
  {
    JniLib.a(FrameData.class, 118);
  }
  
  public FrameData() {}
  
  public FrameData(Request paramRequest, Response paramResponse)
  {
    this.a = paramRequest;
    this.b = paramResponse;
  }
  
  public native Request a();
  
  public native void a(Request paramRequest);
  
  public native void a(Response paramResponse);
  
  public native void a(String paramString);
  
  public native void a(JSONObject paramJSONObject);
  
  public native Response b();
  
  public native int c();
  
  public native JSONObject d();
  
  public native void e();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\protocol\FrameData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */