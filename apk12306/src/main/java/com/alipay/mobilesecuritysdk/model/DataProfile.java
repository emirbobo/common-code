package com.alipay.mobilesecuritysdk.model;

import com.alipay.mobilesecuritysdk.datainfo.AppInfo;
import com.alipay.mobilesecuritysdk.datainfo.GeoResponseInfo;
import com.alipay.mobilesecuritysdk.datainfo.LocationInfo;
import com.alipay.mobilesecuritysdk.datainfo.SdkConfig;
import com.alipay.mobilesecuritysdk.datainfo.WifiCollectInfo;
import com.bangcle.andjni.JniLib;
import java.util.List;
import org.json.JSONArray;

public class DataProfile
{
  private List<String> tid;
  
  static
  {
    JniLib.a(DataProfile.class, 44);
  }
  
  private native SdkConfig GetDefaultConfig();
  
  private native JSONArray GetWifiToJson(List<WifiCollectInfo> paramList);
  
  public native String AppToString(String paramString, List<AppInfo> paramList);
  
  public native JSONArray GetJsonFromFile(String paramString);
  
  public native JSONArray GetTIDJson();
  
  public native String LocationToString(String paramString, List<LocationInfo> paramList);
  
  public native GeoResponseInfo analysisServerRespond(String paramString);
  
  public native void cleanUploadFiles(String paramString);
  
  public native SdkConfig getConfigs(String paramString);
  
  public native List<String> getTid();
  
  public native void saveConfigs(SdkConfig paramSdkConfig, String paramString);
  
  public native void setTid(List<String> paramList);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\model\DataProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */