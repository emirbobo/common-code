package com.alipay.mobilesecuritysdk.deviceID;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.io.File;
import java.util.List;

public class LOG
{
  public static boolean DBG = true;
  private static String TAG = "logger";
  private static File logFileDir;
  private static File logFileName;
  private static Context mcontext = null;
  private static String model;
  private static String pkgName;
  
  static
  {
    JniLib.a(LOG.class, 38);
    logFileDir = null;
    logFileName = null;
    model = null;
    pkgName = null;
  }
  
  private static native long checkLogFile();
  
  private static native boolean doUpload(String paramString);
  
  private static native String getCurLogFileName();
  
  private static native void getInfo(Context paramContext);
  
  public static native String getStackString(Throwable paramThrowable);
  
  public static native void init(Context paramContext);
  
  public static native void logMessage(List<String> paramList);
  
  private static native String toJsonString(String paramString);
  
  public static native void uploadLogFile();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\LOG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */