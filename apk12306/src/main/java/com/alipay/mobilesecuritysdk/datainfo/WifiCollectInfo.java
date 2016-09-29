package com.alipay.mobilesecuritysdk.datainfo;

import com.bangcle.andjni.JniLib;

public class WifiCollectInfo
{
  private String mbssid;
  private boolean miscurrent = false;
  private int mlevel;
  private String mssid;
  private String time;
  
  static
  {
    JniLib.a(WifiCollectInfo.class, 29);
  }
  
  public native String getMbssid();
  
  public native int getMlevel();
  
  public native String getMssid();
  
  public native String getTime();
  
  public native boolean isMiscurrent();
  
  public native void setMbssid(String paramString);
  
  public native void setMiscurrent(boolean paramBoolean);
  
  public native void setMlevel(int paramInt);
  
  public native void setMssid(String paramString);
  
  public native void setTime(String paramString);
  
  public native boolean validate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\datainfo\WifiCollectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */