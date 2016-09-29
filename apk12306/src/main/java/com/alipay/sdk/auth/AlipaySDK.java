package com.alipay.sdk.auth;

import android.app.Activity;
import com.bangcle.andjni.JniLib;

public class AlipaySDK
{
  static
  {
    JniLib.a(AlipaySDK.class, 75);
  }
  
  public static native void auth(Activity paramActivity, APAuthInfo paramAPAuthInfo);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\auth\AlipaySDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */