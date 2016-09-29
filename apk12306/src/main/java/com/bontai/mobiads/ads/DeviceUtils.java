package com.bontai.mobiads.ads;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class DeviceUtils
{
  static
  {
    JniLib.a(DeviceUtils.class, 187);
  }
  
  public static native String getDeviceId(Context paramContext);
  
  public static native String getUUID(Context paramContext);
  
  private static native boolean isEmpty(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */