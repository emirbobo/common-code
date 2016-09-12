package com.alipay.mobilesecuritysdk.deviceID;

import com.bangcle.andjni.JniLib;
import java.util.List;

public class IdResponseInfo
{
  private List<String> arrList;
  private String fuction;
  private String mapdid;
  private String mapdtk;
  private String mcheckcode;
  private String merrorcode;
  private String mrule;
  private boolean msuccess;
  private String mtime;
  private String mversion;
  
  static
  {
    JniLib.a(IdResponseInfo.class, 37);
  }
  
  public native List<String> getArrList();
  
  public native String getFuction();
  
  public native String getMapdid();
  
  public native String getMapdtk();
  
  public native String getMcheckcode();
  
  public native String getMrule();
  
  public native String getMtime();
  
  public native String getMversion();
  
  public native String isMerrorcode();
  
  public native boolean isMsuccess();
  
  public native void setArrList(List<String> paramList);
  
  public native void setFuction(String paramString);
  
  public native void setMapdid(String paramString);
  
  public native void setMapdtk(String paramString);
  
  public native void setMcheckcode(String paramString);
  
  public native void setMerrorcode(String paramString);
  
  public native void setMrule(String paramString);
  
  public native void setMsuccess(boolean paramBoolean);
  
  public native void setMtime(String paramString);
  
  public native void setMversion(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\IdResponseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */