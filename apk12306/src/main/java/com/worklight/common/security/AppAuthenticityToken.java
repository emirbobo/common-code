package com.worklight.common.security;

import android.content.Context;

public class AppAuthenticityToken
{
  public AppAuthenticityToken()
  {
    System.loadLibrary("authjni");
  }
  
  public native String a1(Context paramContext, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\security\AppAuthenticityToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */