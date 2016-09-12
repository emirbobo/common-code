package com.alipay.mobilesecuritysdk.deviceID;

import android.provider.BaseColumns;
import com.bangcle.andjni.JniLib;

public class DeviceMetaData
  implements BaseColumns
{
  public static final String AUTH = "content://com.alipay.mobilesecuritysdk.deviceID.DeviceContentProvider";
  public static final String DATABASE_NAME = "device.db";
  public static final int DATABASE_VER = 1;
  public static final String DEVICE_TABLE_NAME = "devices";
  private String mah1 = null;
  private String mah10 = null;
  private String mah2 = null;
  private String mah3 = null;
  private String mah4 = null;
  private String mah5 = null;
  private String mah6 = null;
  private String mah7 = null;
  private String mah8 = null;
  private String mah9 = null;
  private String mapdtk;
  private String mappId = null;
  private String mas1 = null;
  private String mas2 = null;
  private String mas3 = null;
  private String mas4 = null;
  private String mcheckCode;
  private String mdeviceId;
  private String mpriDeviceId;
  private String mrule;
  private String mtid = null;
  private String mtime = null;
  private String mutdid = null;
  
  static
  {
    JniLib.a(DeviceMetaData.class, 36);
  }
  
  public native String getMah1();
  
  public native String getMah10();
  
  public native String getMah2();
  
  public native String getMah3();
  
  public native String getMah4();
  
  public native String getMah5();
  
  public native String getMah6();
  
  public native String getMah7();
  
  public native String getMah8();
  
  public native String getMah9();
  
  public native String getMapdtk();
  
  public native String getMappId();
  
  public native String getMas1();
  
  public native String getMas2();
  
  public native String getMas3();
  
  public native String getMas4();
  
  public native String getMcheckCode();
  
  public native String getMdeviceId();
  
  public native String getMpriDeviceId();
  
  public native String getMrule();
  
  public native String getMtid();
  
  public native String getMtime();
  
  public native String getMutdid();
  
  public native void setMah1(String paramString);
  
  public native void setMah10(String paramString);
  
  public native void setMah2(String paramString);
  
  public native void setMah3(String paramString);
  
  public native void setMah4(String paramString);
  
  public native void setMah5(String paramString);
  
  public native void setMah6(String paramString);
  
  public native void setMah7(String paramString);
  
  public native void setMah8(String paramString);
  
  public native void setMah9(String paramString);
  
  public native void setMapdtk(String paramString);
  
  public native void setMappId(String paramString);
  
  public native void setMas1(String paramString);
  
  public native void setMas2(String paramString);
  
  public native void setMas3(String paramString);
  
  public native void setMas4(String paramString);
  
  public native void setMcheckCode(String paramString);
  
  public native void setMdeviceId(String paramString);
  
  public native void setMpriDeviceId(String paramString);
  
  public native void setMrule(String paramString);
  
  public native void setMtid(String paramString);
  
  public native void setMtime(String paramString);
  
  public native void setMutdid(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\DeviceMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */