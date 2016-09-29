package com.alipay.mobilesecuritysdk.datainfo;

import com.bangcle.andjni.JniLib;

public class SdkConfig
{
  private static SdkConfig configSingleton = new SdkConfig();
  private int appInterval;
  private long appLUT;
  private int locateInterval;
  private long locateLUT;
  private int locationMaxLines;
  private int mainSwitchInterval;
  private long mainSwitchLUT;
  private String mainSwitchState;
  
  static
  {
    JniLib.a(SdkConfig.class, 27);
  }
  
  public static native SdkConfig getInstance();
  
  public native int getAppInterval();
  
  public native long getAppLUT();
  
  public native int getLocateInterval();
  
  public native long getLocateLUT();
  
  public native int getLocationMaxLines();
  
  public native int getMainSwitchInterval();
  
  public native long getMainSwitchLUT();
  
  public native String getMainSwitchState();
  
  public native void setAppInterval(int paramInt);
  
  public native void setAppLUT(long paramLong);
  
  public native void setLocateInterval(int paramInt);
  
  public native void setLocateLUT(long paramLong);
  
  public native void setLocationMaxLines(int paramInt);
  
  public native void setMainSwitchInterval(int paramInt);
  
  public native void setMainSwitchLUT(long paramLong);
  
  public native void setMainSwitchState(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\datainfo\SdkConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */