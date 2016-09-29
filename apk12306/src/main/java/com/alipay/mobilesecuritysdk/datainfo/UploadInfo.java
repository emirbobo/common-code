package com.alipay.mobilesecuritysdk.datainfo;

import com.bangcle.andjni.JniLib;
import java.util.ArrayList;
import java.util.List;

public class UploadInfo
{
  private List<AppInfo> appinfos = new ArrayList();
  private List<LocationInfo> locates = new ArrayList();
  private List<String> tid;
  
  static
  {
    JniLib.a(UploadInfo.class, 28);
  }
  
  public native List<AppInfo> getAppinfos();
  
  public native List<LocationInfo> getLocates();
  
  public native List<String> getTid();
  
  public native void setAppinfos(List<AppInfo> paramList);
  
  public native void setLocates(List<LocationInfo> paramList);
  
  public native void setTid(List<String> paramList);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\datainfo\UploadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */