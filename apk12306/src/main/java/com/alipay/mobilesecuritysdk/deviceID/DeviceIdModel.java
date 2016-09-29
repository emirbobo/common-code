package com.alipay.mobilesecuritysdk.deviceID;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.util.Map;

public class DeviceIdModel
{
  public static final String PREFS_NAME = "profiles";
  public static final String PRIVATE_NAME = "deviceid";
  public static final String SERVICEID = "deviceFingerprint";
  public static final String VER = "1";
  public static final String mApdtk = "apdtk";
  public static final String mAppId = "appId";
  public static final String mCheckCode = "checkcode";
  public static final String mDeviceId = "deviceId";
  public static final String mDeviceInfo = "deviceInfo";
  public static final String mPriDeviceId = "priDeviceId";
  public static final String mRule = "rule";
  public static final String mah1 = "AH1";
  public static final String mah10 = "AH10";
  public static final String mah2 = "AH2";
  public static final String mah3 = "AH3";
  public static final String mah4 = "AH4";
  public static final String mah5 = "AH5";
  public static final String mah6 = "AH6";
  public static final String mah7 = "AH7";
  public static final String mah8 = "AH8";
  public static final String mah9 = "AH9";
  public static final String mas1 = "AS1";
  public static final String mas2 = "AS2";
  public static final String mas3 = "AS3";
  public static final String mas4 = "AS4";
  public static final String mtid = "AC1";
  public static final String mtime = "time";
  public static final String mutdid = "AC2";
  private DeviceMetaData dv = new DeviceMetaData();
  private Profile profile = new Profile();
  
  static
  {
    JniLib.a(DeviceIdModel.class, 35);
  }
  
  private native void Log(String paramString);
  
  private native String getCheckCodeString();
  
  private native boolean hasDataInSdcard();
  
  private native boolean hasDataInSettings();
  
  public native boolean CheckPrivateData(Map<String, String> paramMap);
  
  public native Map<String, Object> GetLocalInfo();
  
  public native Map<String, String> GetPrivateData(Context paramContext);
  
  public native Map<String, String> GetShareData(Context paramContext);
  
  public native Map<String, Object> GetUploadInfo();
  
  public native void Init(Context paramContext, Map<String, String> paramMap);
  
  public native String UpdateId(Context paramContext);
  
  public native String UpdateId(Context paramContext, Map<String, String> paramMap);
  
  public native IdResponseInfo UploadData(Context paramContext);
  
  public native void WriteDataToSdCard(String paramString);
  
  public native void WriteDataToSettings(String paramString);
  
  public native void WritePrivateData(Context paramContext, String paramString);
  
  public native boolean checkApdid();
  
  public native boolean checkCheckCode(String paramString1, String paramString2);
  
  public native String generaterCheckCode();
  
  public native boolean hasInPublic();
  
  public native String readDataFromSdCard();
  
  public native String readDataFromSettings();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\DeviceIdModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */