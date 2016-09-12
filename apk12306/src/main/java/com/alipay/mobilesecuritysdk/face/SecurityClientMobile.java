package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.util.List;
import java.util.Map;

public class SecurityClientMobile
{
  private static boolean isDebug = false;
  private static boolean isError;
  private static Thread workThread;
  
  static
  {
    JniLib.a(SecurityClientMobile.class, 42);
    isError = false;
  }
  
  public static native String GetApdid(Context paramContext, Map<String, String> paramMap);
  
  public static native boolean isDebug();
  
  public static native void setDebug(boolean paramBoolean);
  
  public static native void setError(boolean paramBoolean);
  
  public static native void start(Context paramContext, List<String> paramList, boolean paramBoolean);
  
  public static native void stop();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\face\SecurityClientMobile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */