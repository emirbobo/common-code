package com.alipay.sdk.auth;

import com.bangcle.andjni.JniLib;

public class APAuthInfo
{
  private String a;
  private String b;
  private String c;
  private String d;
  
  static
  {
    JniLib.a(APAuthInfo.class, 74);
  }
  
  public APAuthInfo(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null);
  }
  
  public APAuthInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramString3;
    this.c = paramString4;
  }
  
  public native String getAppId();
  
  public native String getPid();
  
  public native String getProductId();
  
  public native String getRedirectUri();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\auth\APAuthInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */