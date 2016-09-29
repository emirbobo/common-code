package com.alipay.sdk.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bangcle.andjni.JniLib;

public class DeviceInfo
{
  public static final String a = "com.alipay.android.app";
  public static final String b = "com.eg.android.AlipayGphone";
  public static final String c = "com.eg.android.AlipayGphoneRC";
  public static final String d = "android";
  static DeviceInfo e = null;
  private static final String f = "00:00:00:00:00:00";
  private String g;
  private String h;
  private String i;
  private String j;
  
  static
  {
    JniLib.a(DeviceInfo.class, 128);
  }
  
  private DeviceInfo(Context paramContext)
  {
    try
    {
      localObject = paramContext.getPackageName();
      this.i = paramContext.getPackageManager().getPackageInfo((String)localObject, 128).versionName;
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
          b(((TelephonyManager)localObject).getDeviceId());
          a(((TelephonyManager)localObject).getSubscriberId());
          try
          {
            this.j = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return;
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              LogUtils.a(paramContext);
              if (TextUtils.isEmpty(this.j)) {
                this.j = "00:00:00:00:00:00";
              }
            }
          }
          finally
          {
            if (!TextUtils.isEmpty(this.j)) {
              break;
            }
            this.j = "00:00:00:00:00:00";
          }
          localException1 = localException1;
          LogUtils.a(localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          LogUtils.a(localException2);
        }
      }
    }
  }
  
  public static native DeviceInfo a(Context paramContext);
  
  public static native NetConnectionType b(Context paramContext);
  
  public static native boolean c(Context paramContext);
  
  public static native String d(Context paramContext);
  
  public static native boolean f();
  
  public static native String g();
  
  public native String a();
  
  public native void a(String paramString);
  
  public native String b();
  
  public native void b(String paramString);
  
  public native String c();
  
  public native String d();
  
  public native String e();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */