package com.alipay.mobilesecuritysdk.datainfo;

import com.bangcle.andjni.JniLib;

public class GeoResponseInfo
{
  private int appInterval;
  private boolean isSuccess;
  private int locateInterval;
  private int locationMaxLines;
  private int mainSwitchInterval;
  private String mainSwitchState;
  
  static
  {
    JniLib.a(GeoResponseInfo.class, 25);
  }
  
  public native int getAppInterval();
  
  public native int getLocateInterval();
  
  public native int getLocationMaxLines();
  
  public native int getMainSwitchInterval();
  
  public native String getMainSwitchState();
  
  public native boolean isSuccess();
  
  public native void setAppInterval(int paramInt);
  
  public native void setLocateInterval(int paramInt);
  
  public native void setLocationMaxLines(int paramInt);
  
  public native void setMainSwitchInterval(int paramInt);
  
  public native void setMainSwitchState(String paramString);
  
  public native void setSuccess(boolean paramBoolean);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\datainfo\GeoResponseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */