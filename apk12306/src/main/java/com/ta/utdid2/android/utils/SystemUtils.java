package com.ta.utdid2.android.utils;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.io.File;

public class SystemUtils
{
  static
  {
    JniLib.a(SystemUtils.class, 1066);
  }
  
  public static native String getAppLabel(Context paramContext);
  
  public static native String getCpuInfo();
  
  public static native File getRootFolder(String paramString);
  
  public static native int getSystemVersion();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\android\utils\SystemUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */