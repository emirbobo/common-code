package com.MobileTicket;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import com.bangcle.andjni.JniLib;
import java.io.File;

public class ScreenShotSaveImg
  extends Activity
{
  public static final String NOTIFY_CONTENT = "已保存至手机/Pictures/Screenshots/目录";
  public static final int NOTIFY_ICON = 2130837549;
  public static final int NOTIFY_ID = 100;
  public static final String NOTIFY_MSG = "正在保存图片";
  public static final String NOTIFY_TITLE = "页面截图已保存";
  NotificationManager nM;
  
  static
  {
    JniLib.a(ScreenShotSaveImg.class, 15);
  }
  
  public native void checkStat(File paramFile);
  
  public native void onCreate(Bundle paramBundle);
  
  public native void showNotification(int paramInt, String paramString1, String paramString2, String paramString3, File paramFile);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\ScreenShotSaveImg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */