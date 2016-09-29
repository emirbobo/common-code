package com.alipay.sdk.data;

import com.bangcle.andjni.JniLib;

public class Envelope
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g = "com.alipay.mcpay";
  
  static
  {
    JniLib.a(Envelope.class, 97);
  }
  
  private native String h(String paramString);
  
  public native String a();
  
  public native void a(String paramString);
  
  public native String b();
  
  public native void b(String paramString);
  
  public native String c();
  
  public native void c(String paramString);
  
  public native String d();
  
  public native void d(String paramString);
  
  public native String e();
  
  public native void e(String paramString);
  
  public native String f();
  
  public native void f(String paramString);
  
  public native String g();
  
  public native void g(String paramString);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\data\Envelope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */