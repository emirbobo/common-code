package com.alipay.mobilesecuritysdk.datainfo;

import com.bangcle.andjni.JniLib;

public class AppInfo
{
  private String pkeyhash;
  private String pkgName;
  
  static
  {
    JniLib.a(AppInfo.class, 24);
  }
  
  public native String getPkeyhash();
  
  public native String getPkgName();
  
  public native void setPkeyhash(String paramString);
  
  public native void setPkgName(String paramString);
  
  public native boolean validate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\datainfo\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */