package com.alipay.sdk.protocol;

import com.bangcle.andjni.JniLib;
import org.json.JSONObject;

public class ElementAction
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private boolean f;
  private boolean g = true;
  private boolean h = true;
  private String i;
  private String j;
  private String k;
  private JSONObject l;
  
  static
  {
    JniLib.a(ElementAction.class, 117);
  }
  
  public ElementAction(String paramString)
  {
    this.a = paramString;
  }
  
  public static native ElementAction a(String paramString, ActionType paramActionType);
  
  public static native ElementAction a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString6, String paramString7, String paramString8, JSONObject paramJSONObject);
  
  public static native ElementAction a(JSONObject paramJSONObject);
  
  public static native ElementAction a(JSONObject paramJSONObject, String paramString);
  
  public native JSONObject a();
  
  public native String b();
  
  public native String c();
  
  public native String d();
  
  public native String e();
  
  public native String f();
  
  public native String g();
  
  public native JSONObject h();
  
  public native String i();
  
  public native String j();
  
  public native boolean k();
  
  public native boolean l();
  
  public native boolean m();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\protocol\ElementAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */