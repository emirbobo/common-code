package com.bontai.mobiads.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.DbUtils;
import java.io.File;

public class AppHelp
{
  public static String GT_CDN_AD_URL = "";
  
  static
  {
    JniLib.a(AppHelp.class, 183);
  }
  
  public static native boolean deleteFile(String paramString);
  
  public static native String getAppKey(Context paramContext);
  
  public static native String getBontaiMobiAdsUrl(Context paramContext);
  
  public static native DbUtils getDb(Context paramContext);
  
  public static native String getSplashImgCacheDir(Context paramContext);
  
  public static native void installAPK(Context paramContext, File paramFile, String paramString);
  
  public static native void installDialogInfo(Context paramContext, File paramFile, String paramString);
  
  public static native boolean isFileExit(String paramString);
  
  public static native boolean isNetworkAvailable(Context paramContext);
  
  public static native boolean isNumeric(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\AppHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */