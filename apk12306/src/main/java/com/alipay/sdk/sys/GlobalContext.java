package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.data.MspConfig;
import com.bangcle.andjni.JniLib;

public class GlobalContext
{
  private static GlobalContext a;
  private static String d;
  private Context b;
  private int c;
  private MspConfig e;
  
  static
  {
    JniLib.a(GlobalContext.class, 122);
  }
  
  public static native GlobalContext a();
  
  public static native String a(String[] paramArrayOfString);
  
  private native boolean a(String paramString);
  
  public static native boolean f();
  
  public static native String h();
  
  public static native String i();
  
  public native void a(int paramInt);
  
  public native void a(Context paramContext, MspConfig paramMspConfig);
  
  public native Context b();
  
  public native String b(int paramInt);
  
  public native MspConfig c();
  
  public native boolean d();
  
  public native int e();
  
  public native float g();
  
  public native String j();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\sys\GlobalContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */