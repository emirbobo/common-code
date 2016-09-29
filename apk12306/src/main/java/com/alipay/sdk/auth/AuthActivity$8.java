package com.alipay.sdk.auth;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.bangcle.andjni.JniLib;

class AuthActivity$8
  extends WebChromeClient
{
  static
  {
    JniLib.a(8.class, 89);
  }
  
  AuthActivity$8(AuthActivity paramAuthActivity) {}
  
  public native boolean onConsoleMessage(ConsoleMessage paramConsoleMessage);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\auth\AuthActivity$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */