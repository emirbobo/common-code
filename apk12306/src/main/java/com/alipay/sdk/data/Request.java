package com.alipay.sdk.data;

import com.bangcle.andjni.JniLib;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class Request
{
  private Envelope a;
  private JSONObject b;
  private JSONObject c;
  private long d;
  private WeakReference e = null;
  private boolean f = true;
  private boolean g = true;
  
  static
  {
    JniLib.a(Request.class, 101);
  }
  
  public Request(Envelope paramEnvelope, JSONObject paramJSONObject, InteractionData paramInteractionData)
  {
    this(paramEnvelope, paramJSONObject, null, paramInteractionData);
  }
  
  public Request(Envelope paramEnvelope, JSONObject paramJSONObject1, JSONObject paramJSONObject2, InteractionData paramInteractionData)
  {
    this.a = paramEnvelope;
    this.b = paramJSONObject1;
    this.c = paramJSONObject2;
    this.e = new WeakReference(paramInteractionData);
  }
  
  public native JSONObject a(String paramString);
  
  public native void a(long paramLong);
  
  public native void a(InteractionData paramInteractionData);
  
  public native void a(JSONObject paramJSONObject);
  
  public native void a(boolean paramBoolean);
  
  public native boolean a();
  
  public native String b();
  
  public native void b(boolean paramBoolean);
  
  public native long c();
  
  public native InteractionData d();
  
  public native boolean e();
  
  public native Envelope f();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\data\Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */