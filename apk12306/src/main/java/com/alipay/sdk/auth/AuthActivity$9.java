package com.alipay.sdk.auth;

import android.webkit.DownloadListener;
import com.bangcle.andjni.JniLib;

class AuthActivity$9
  implements DownloadListener
{
  static
  {
    JniLib.a(9.class, 90);
  }
  
  AuthActivity$9(AuthActivity paramAuthActivity) {}
  
  public native void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\auth\AuthActivity$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */