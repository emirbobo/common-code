package com.alipay.sdk.protocol;

import com.alipay.sdk.data.Request;
import com.alipay.sdk.data.Response;
import com.bangcle.andjni.JniLib;
import org.json.JSONObject;

public class MiniWindowFrame
  extends WindowData
{
  private int m;
  private boolean n = false;
  
  static
  {
    JniLib.a(MiniWindowFrame.class, 121);
  }
  
  protected MiniWindowFrame(Request paramRequest, Response paramResponse)
  {
    super(paramRequest, paramResponse);
  }
  
  public native void a(JSONObject paramJSONObject);
  
  public native boolean f();
  
  public native int g();
  
  public native String h();
  
  public native boolean i();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\protocol\MiniWindowFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */