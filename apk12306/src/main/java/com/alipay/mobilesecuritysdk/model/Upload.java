package com.alipay.mobilesecuritysdk.model;

import android.content.Context;
import com.alipay.mobilesecuritysdk.datainfo.GeoResponseInfo;
import com.alipay.mobilesecuritysdk.datainfo.SdkConfig;
import com.alipay.mobilesecuritysdk.datainfo.UploadInfo;
import com.bangcle.andjni.JniLib;
import java.util.List;

public class Upload
{
  private UploadInfo info;
  private Context mcontext;
  private DataProfile profile = new DataProfile();
  
  static
  {
    JniLib.a(Upload.class, 46);
  }
  
  public Upload(Context paramContext)
  {
    this.mcontext = paramContext;
  }
  
  public native GeoResponseInfo communicateSwitch();
  
  public native UploadInfo getInfo();
  
  public native void setInfo(UploadInfo paramUploadInfo);
  
  public native GeoResponseInfo uploadCollectedData(String paramString1, String paramString2, String paramString3);
  
  public native GeoResponseInfo uploadData(List<String> paramList, SdkConfig paramSdkConfig);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\model\Upload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */