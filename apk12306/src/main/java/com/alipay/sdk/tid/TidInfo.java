package com.alipay.sdk.tid;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class TidInfo
{
  private static TidInfo a;
  private String b;
  private String c;
  
  static
  {
    JniLib.a(TidInfo.class, 125);
  }
  
  public static native TidInfo d();
  
  public static native void e();
  
  public static native String f();
  
  public native String a();
  
  public native void a(Context paramContext);
  
  public native void a(String paramString);
  
  public native String b();
  
  public native void b(String paramString);
  
  public native boolean c();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\tid\TidInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */