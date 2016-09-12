package cn.dm.download.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

public final class a
{
  private static a aw;
  private static int ax = 0;
  private Context mContext;
  private NotificationManager mNotificationManager;
  
  private a(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNotificationManager = ((NotificationManager)paramContext.getSystemService("notification"));
  }
  
  private void a(int paramInt)
  {
    if (this.mNotificationManager == null) {
      this.mNotificationManager = ((NotificationManager)this.mContext.getSystemService("notification"));
    }
    ax += 1;
    new Notification(paramInt, ax + "个应用正在下载", System.currentTimeMillis()).flags = 16;
  }
  
  private static a c(Context paramContext)
  {
    if (aw == null) {
      aw = new a(paramContext);
    }
    return aw;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */