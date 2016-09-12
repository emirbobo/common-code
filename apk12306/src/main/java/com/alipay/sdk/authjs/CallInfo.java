package com.alipay.sdk.authjs;

import com.bangcle.andjni.JniLib;
import org.json.JSONException;
import org.json.JSONObject;

public class CallInfo
{
  public static final String a = "CallInfo";
  public static final String b = "call";
  public static final String c = "callback";
  public static final String d = "bundleName";
  public static final String e = "clientId";
  public static final String f = "param";
  public static final String g = "func";
  public static final String h = "msgType";
  private String i;
  private String j;
  private String k;
  private String l;
  private JSONObject m;
  private boolean n = false;
  
  static
  {
    JniLib.a(CallInfo.class, 93);
  }
  
  public CallInfo(String paramString)
  {
    d(paramString);
  }
  
  public static final native String a(CallError paramCallError);
  
  public native void a(String paramString);
  
  public native void a(JSONObject paramJSONObject);
  
  public native void a(boolean paramBoolean);
  
  public native boolean a();
  
  public native String b();
  
  public native void b(String paramString);
  
  public native String c();
  
  public native void c(String paramString);
  
  public native String d();
  
  public native void d(String paramString);
  
  public native String e();
  
  public native JSONObject f();
  
  public native String g()
    throws JSONException;
  
  public static enum CallError {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\authjs\CallInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */