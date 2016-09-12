package com.alipay.mobilesecuritysdk.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.alipay.mobilesecuritysdk.datainfo.AppInfo;
import com.alipay.mobilesecuritysdk.datainfo.LocationInfo;
import com.alipay.mobilesecuritysdk.datainfo.WifiCollectInfo;
import com.bangcle.andjni.JniLib;
import java.util.List;

public class CollectedInfo
{
  private final int MODULUS_FIX = 8;
  private DataProfile profile = new DataProfile();
  
  static
  {
    JniLib.a(CollectedInfo.class, 43);
  }
  
  private native List<WifiCollectInfo> GetWifiInfos(Context paramContext);
  
  private native void SetPhoneType(TelephonyManager paramTelephonyManager, LocationInfo paramLocationInfo, int paramInt);
  
  private native String getSignatureHash(byte[] paramArrayOfByte);
  
  public native String GetLocationInfo(Context paramContext, List<String> paramList);
  
  public native List<LocationInfo> collectLocateInfos(Context paramContext);
  
  public native List<AppInfo> collectappInfos(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\model\CollectedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */