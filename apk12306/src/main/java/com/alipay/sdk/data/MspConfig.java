package com.alipay.sdk.data;

import android.content.Context;
import com.alipay.sdk.tid.TidInfo;
import com.bangcle.andjni.JniLib;
import java.util.HashMap;

public class MspConfig
{
  private static final String a = "virtualImeiAndImsi";
  private static final String b = "virtual_imei";
  private static final String c = "virtual_imsi";
  private static MspConfig d;
  private String e;
  private String f;
  private String g = "sdk-and-lite";
  private String h;
  
  static
  {
    JniLib.a(MspConfig.class, 100);
  }
  
  public static native MspConfig b();
  
  private native String h();
  
  public native String a();
  
  public native String a(Context paramContext);
  
  public native String a(Context paramContext, HashMap paramHashMap);
  
  public native String a(TidInfo paramTidInfo);
  
  public native void a(String paramString);
  
  public native String b(Context paramContext);
  
  public native void b(String paramString);
  
  public native String c();
  
  public native String c(Context paramContext);
  
  public native String d();
  
  public native String d(Context paramContext);
  
  public native String e();
  
  public native String f();
  
  public native String g();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\data\MspConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */