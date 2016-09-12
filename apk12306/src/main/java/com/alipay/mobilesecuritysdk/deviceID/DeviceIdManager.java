package com.alipay.mobilesecuritysdk.deviceID;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.util.Map;

public class DeviceIdManager
{
  public static Map<String, String> strMap = null;
  private final Context mcontext;
  
  static
  {
    JniLib.a(DeviceIdManager.class, 34);
  }
  
  public DeviceIdManager(Context paramContext)
  {
    this.mcontext = paramContext;
    LOG.init(paramContext);
  }
  
  private native void Update(Context paramContext, Map<String, String> paramMap);
  
  private native void UpdateLog();
  
  public native String GetApDid(Map<String, String> paramMap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\DeviceIdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */