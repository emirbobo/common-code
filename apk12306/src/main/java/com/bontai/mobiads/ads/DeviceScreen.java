package com.bontai.mobiads.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bangcle.andjni.JniLib;

public class DeviceScreen
{
  static
  {
    JniLib.a(DeviceScreen.class, 186);
  }
  
  public static native int getAdHeight(Context paramContext);
  
  public static native String getAdSize(Context paramContext);
  
  public static native DisplayMetrics getMetric(Context paramContext);
  
  public static native int getScreenHeight(Context paramContext);
  
  public static native int getScreenWidth(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\DeviceScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */