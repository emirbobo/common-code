package com.alipay.mobilesecuritysdk.datainfo;

import com.bangcle.andjni.JniLib;
import java.util.List;

public class LocationInfo
{
  private final int DEFINE_NUM = 14400;
  private final double MAX_LATITUDE = 90.0D;
  private final double MAX_LONGITUDE = 180.0D;
  private final double MIN_LATITUDE = -90.0D;
  private final double MIN_LONGITUDE = -180.0D;
  private String cid;
  private String lac;
  private String latitude;
  private String longitude;
  private String mcc;
  private String mnc;
  private String phonetype;
  private List<String> tid;
  private String time;
  private List<WifiCollectInfo> wifi;
  
  static
  {
    JniLib.a(LocationInfo.class, 26);
  }
  
  private native String toString(double paramDouble);
  
  public native String getCid();
  
  public native String getLac();
  
  public native String getLatitude();
  
  public native String getLongitude();
  
  public native String getMcc();
  
  public native String getMnc();
  
  public native String getPhonetype();
  
  public native List<String> getTid();
  
  public native String getTime();
  
  public native List<WifiCollectInfo> getWifi();
  
  public native void setCid(String paramString);
  
  public native void setLac(String paramString);
  
  public native void setLatitude(double paramDouble);
  
  public native void setLatitude(int paramInt);
  
  public native void setLatitude(String paramString);
  
  public native void setLongitude(double paramDouble);
  
  public native void setLongitude(int paramInt);
  
  public native void setLongitude(String paramString);
  
  public native void setMcc(String paramString);
  
  public native void setMnc(String paramString);
  
  public native void setPhonetype(String paramString);
  
  public native void setTid(List<String> paramList);
  
  public native void setTime(String paramString);
  
  public native void setWifi(List<WifiCollectInfo> paramList);
  
  public native boolean validate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\datainfo\LocationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */