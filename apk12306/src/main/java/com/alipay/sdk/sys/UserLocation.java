package com.alipay.sdk.sys;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class UserLocation
{
  private static double a = -1.0D;
  private static double b = -1.0D;
  
  static
  {
    JniLib.a(UserLocation.class, 123);
  }
  
  public static native double a();
  
  public static native void a(Context paramContext);
  
  public static native double b();
  
  public static native String c();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\sys\UserLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */