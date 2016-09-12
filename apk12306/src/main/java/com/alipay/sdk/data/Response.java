package com.alipay.sdk.data;

import com.bangcle.andjni.JniLib;
import org.apache.http.Header;
import org.json.JSONObject;

public class Response
{
  public static final int a = 1000;
  public static final int b = 503;
  public static final int c = 0;
  Envelope d = null;
  Header[] e = null;
  private int f = 0;
  private String g = "";
  private long h = 0L;
  private String i = "";
  private String j = null;
  private String k = null;
  private JSONObject l = null;
  private String m;
  private boolean n = true;
  private boolean o = true;
  
  static
  {
    JniLib.a(Response.class, 102);
  }
  
  private native String o();
  
  public native Envelope a();
  
  public native void a(int paramInt);
  
  public native void a(long paramLong);
  
  public native void a(Envelope paramEnvelope);
  
  public native void a(String paramString);
  
  public native void a(JSONObject paramJSONObject);
  
  public native void a(boolean paramBoolean);
  
  public native void a(Header[] paramArrayOfHeader);
  
  public native void b(String paramString);
  
  public native void b(boolean paramBoolean);
  
  public native boolean b();
  
  public native void c(String paramString);
  
  public native boolean c();
  
  public native JSONObject d();
  
  public native void d(String paramString);
  
  public native long e();
  
  public native void e(String paramString);
  
  public native boolean f();
  
  public native String g();
  
  public native String h();
  
  public native int i();
  
  public native String j();
  
  public native String k();
  
  public native String l();
  
  public native String m();
  
  public native Header[] n();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\data\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */