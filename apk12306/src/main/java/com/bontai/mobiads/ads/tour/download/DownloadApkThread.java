package com.bontai.mobiads.ads.tour.download;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import com.bangcle.andjni.JniLib;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class DownloadApkThread
  extends Thread
{
  DownloadFileCallback callback = new DownloadFileCallback()
  {
    static
    {
      JniLib.a(2.class, 248);
    }
    
    public native void downloadError(String paramAnonymousString);
  };
  private Context context;
  private DownLoadUtil downLoadUtil;
  private final int downloadError = 3;
  private final int downloadSuccess = 2;
  private String downloadUrl;
  private String fileName;
  Handler handler = new Handler()
  {
    static
    {
      JniLib.a(1.class, 247);
    }
    
    public native void handleMessage(Message paramAnonymousMessage);
  };
  NotificationCompat.Builder mBuilder;
  private final int notificationID = 10000001;
  private NotificationManager notificationManager;
  private File saveFile;
  private TimerTask task;
  private Timer timer;
  private final int updateProgress = 1;
  
  static
  {
    JniLib.a(DownloadApkThread.class, 250);
  }
  
  public DownloadApkThread(String paramString1, File paramFile, String paramString2, Context paramContext)
  {
    this.downloadUrl = paramString1;
    this.saveFile = paramFile;
    this.context = paramContext;
    this.fileName = paramString2;
  }
  
  private native void handlerTask();
  
  private native void initNofication();
  
  public native PendingIntent getDefalutIntent(int paramInt);
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\tour\download\DownloadApkThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */