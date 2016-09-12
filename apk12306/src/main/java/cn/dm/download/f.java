package cn.dm.download;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadHelperListener;
import cn.dm.download.util.Constants;
import cn.dm.download.util.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class f
{
  private static b j = new b(f.class.getSimpleName());
  private ArrayList I;
  private ArrayList J;
  private DownloadBroadcastReceiver K;
  private Context context;
  private cn.dm.download.db.c g;
  private DownloadHelperListener i;
  
  public f(Context paramContext, DownloadHelperListener paramDownloadHelperListener)
  {
    this.context = paramContext;
    this.g = new cn.dm.download.db.c(paramContext);
    this.i = paramDownloadHelperListener;
    this.K = new DownloadBroadcastReceiver(paramContext.getApplicationContext(), this, paramDownloadHelperListener, this.g);
    this.K.a();
  }
  
  private void b(DownloadAppInfo paramDownloadAppInfo)
  {
    b localb = j;
    new StringBuilder("downloadAppInfo id:").append(paramDownloadAppInfo.getAppId());
    if (c.b(Long.valueOf(paramDownloadAppInfo.getAppId())) == null)
    {
      if (paramDownloadAppInfo.getDownloadStatus() == 6)
      {
        localb = j;
        paramDownloadAppInfo.setIsUpdate(1);
      }
      paramDownloadAppInfo.setDownloadStatus(1);
      this.i.onDownloadWaiting(paramDownloadAppInfo);
      new a(paramDownloadAppInfo, this.context, this.i).b();
    }
    for (;;)
    {
      return;
      paramDownloadAppInfo = j;
    }
  }
  
  public static void excuteOpen(Context paramContext, DownloadAppInfo paramDownloadAppInfo)
  {
    new Intent();
    paramDownloadAppInfo = paramContext.getPackageManager().getLaunchIntentForPackage(paramDownloadAppInfo.getPkgName());
    if (paramDownloadAppInfo != null)
    {
      paramDownloadAppInfo.addCategory("android.intent.category.LAUNCHER");
      paramContext.startActivity(paramDownloadAppInfo);
    }
  }
  
  public static void excutePause(DownloadAppInfo paramDownloadAppInfo)
  {
    paramDownloadAppInfo = c.b(Long.valueOf(paramDownloadAppInfo.getAppId()));
    if (paramDownloadAppInfo != null) {
      paramDownloadAppInfo.c();
    }
    for (;;)
    {
      return;
      paramDownloadAppInfo = j;
    }
  }
  
  public static void excuteUninstall(Context paramContext, DownloadAppInfo paramDownloadAppInfo)
  {
    paramContext.startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + paramDownloadAppInfo.getPkgName())));
  }
  
  private static void l() {}
  
  private void m()
  {
    this.context.unregisterReceiver(this.K);
  }
  
  public static void pauseAllDownloadThread()
  {
    Object localObject = c.v.values().iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        localObject = j;
        return;
      }
      ((a)((Iterator)localObject).next()).c();
    }
  }
  
  public static void setMaxDownloadThreadNum(int paramInt)
  {
    Constants.MaxDownloadThread = paramInt;
  }
  
  public static void setStorageFileName(String paramString)
  {
    Constants.DefaultStorageFile = paramString;
  }
  
  public final DownloadAppInfo checkAndGetDownloadAppInfo(DownloadAppInfo paramDownloadAppInfo)
  {
    try
    {
      localObject1 = cn.dm.download.util.c.a(this.context, paramDownloadAppInfo);
      if (this.I == null) {
        break label571;
      }
      localObject3 = this.I.iterator();
      if (((Iterator)localObject3).hasNext()) {
        break label75;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        label75:
        int k;
        int m;
        label534:
        Object localObject2 = j;
        new StringBuilder("checkAndGetDownloadAppInfo::").append(localException2.getMessage());
        continue;
        label571:
        b localb = j;
        continue;
        localObject2 = (DownloadAppInfo)localb.next();
        if (paramDownloadAppInfo.getPkgName().equals(((DownloadAppInfo)localObject2).getPkgName()))
        {
          paramDownloadAppInfo.setIsThirdInstalled(1);
          paramDownloadAppInfo.setDownloadStatus(5);
          continue;
          label619:
          m = k;
        }
      }
    }
    if (this.J == null) {
      this.J = cn.dm.download.util.c.h(this.context);
    }
    localObject1 = this.J.iterator();
    if (!((Iterator)localObject1).hasNext()) {
      for (;;)
      {
        return paramDownloadAppInfo;
        localObject2 = (DownloadAppInfo)((Iterator)localObject3).next();
        if (paramDownloadAppInfo.getAppId() != ((DownloadAppInfo)localObject2).getAppId()) {
          break;
        }
        k = ((DownloadAppInfo)localObject2).getDownloadStatus();
        if (k == 0)
        {
          localObject1 = j;
        }
        else
        {
          boolean bool1;
          if ((k == 2) || (k == 3) || (k == 1) || (k == 8))
          {
            if ((k != 2) || (c.b(Long.valueOf(paramDownloadAppInfo.getAppId())) != null)) {
              break label619;
            }
            localObject2 = j;
            paramDownloadAppInfo.setDownloadStatus(3);
            this.g.f(paramDownloadAppInfo);
            m = 3;
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>(String.valueOf(localObject1));
            boolean bool2 = cn.dm.download.util.c.r(Constants.Unfinished_Sign);
            localObject2 = j;
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>("数据库有记录，应用为下载开始或暂停或等待中：");
            ((StringBuilder)localObject2).append(m).append("  ，本地有存文件?").append(bool2);
            k = m;
            bool1 = bool2;
            if (bool2)
            {
              localObject2 = j;
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>("数据库有记录，应用为下载开始或暂停或等待中，本地有存文件大小为");
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>(String.valueOf(localObject1));
              ((StringBuilder)localObject2).append(cn.dm.download.util.c.q(Constants.Unfinished_Sign));
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>(String.valueOf(localObject1));
              paramDownloadAppInfo.setCurrentDownloadSize(cn.dm.download.util.c.q(Constants.Unfinished_Sign));
              bool1 = bool2;
              k = m;
            }
          }
          for (;;)
          {
            if ((bool1) || (!cn.dm.download.util.c.s())) {
              break label534;
            }
            this.g.a(paramDownloadAppInfo.getAppId());
            paramDownloadAppInfo.setDownloadStatus(0);
            localObject1 = j;
            break;
            if (k == 4)
            {
              bool1 = cn.dm.download.util.c.r((String)localObject1);
              localObject1 = j;
              localObject1 = new java/lang/StringBuilder;
              ((StringBuilder)localObject1).<init>("数据库有记录，下载状态为下载完成，本地有存文件？");
              ((StringBuilder)localObject1).append(bool1);
            }
            else if (k == 5)
            {
              localObject1 = this.context.getPackageManager();
              try
              {
                localObject1 = ((PackageManager)localObject1).getPackageInfo(paramDownloadAppInfo.getPkgName(), 0);
                localObject2 = j;
                localObject2 = new java/lang/StringBuilder;
                ((StringBuilder)localObject2).<init>("数据库有记录，应用已经安装，获取本地安装包名为：");
                ((StringBuilder)localObject2).append(paramDownloadAppInfo.getPkgName()).append("  ,根据包名获取到的包信息为：").append(localObject1);
                if (localObject1 != null) {
                  bool1 = true;
                }
              }
              catch (Exception localException1)
              {
                localObject2 = j;
                localObject2 = new java/lang/StringBuilder;
                ((StringBuilder)localObject2).<init>("已安装检查异常::");
                ((StringBuilder)localObject2).append(localException1.getMessage());
              }
            }
            else
            {
              bool1 = false;
            }
          }
          paramDownloadAppInfo.setDownloadStatus(k);
        }
      }
    }
  }
  
  public final void excuteDelete(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = c.b(Long.valueOf(paramDownloadAppInfo.getAppId()));
    if ((localObject != null) && (((a)localObject).t != 1))
    {
      paramDownloadAppInfo = j;
      ((a)localObject).e();
    }
    for (;;)
    {
      return;
      if ((localObject != null) && (((a)localObject).t == 1)) {
        c.a(Long.valueOf(paramDownloadAppInfo.getAppId()));
      }
      localObject = j;
      localObject = cn.dm.download.util.c.a(this.context, paramDownloadAppInfo) + Constants.Unfinished_Sign;
      if (paramDownloadAppInfo.getDownloadStatus() == 4) {
        localObject = cn.dm.download.util.c.a(this.context, paramDownloadAppInfo);
      }
      cn.dm.download.util.c.s((String)localObject);
      b localb = j;
      new StringBuilder("被删除文件名：").append((String)localObject);
      paramDownloadAppInfo.setDownloadStatus(0);
      paramDownloadAppInfo.setCurrentDownloadSize(0L);
      this.g.a(paramDownloadAppInfo.getAppId());
      this.i.onDownloadCancel(paramDownloadAppInfo);
    }
  }
  
  public final void excuteDownload(DownloadAppInfo paramDownloadAppInfo)
  {
    b(paramDownloadAppInfo);
  }
  
  public final void excuteInstall(Context paramContext, DownloadAppInfo paramDownloadAppInfo)
  {
    try
    {
      if (cn.dm.download.util.c.a(paramContext, paramDownloadAppInfo.getPkgName()) > 0)
      {
        localObject = j;
        paramDownloadAppInfo.setIsUpdate(1);
        this.g.f(paramDownloadAppInfo);
      }
      Object localObject = cn.dm.download.util.c.a(paramContext, paramDownloadAppInfo);
      paramDownloadAppInfo = new android/content/Intent;
      paramDownloadAppInfo.<init>("android.intent.action.VIEW");
      File localFile = new java/io/File;
      localFile.<init>((String)localObject);
      paramDownloadAppInfo.setDataAndType(Uri.fromFile(localFile), "application/vnd.android.package-archive");
      paramDownloadAppInfo.addFlags(268435456);
      paramContext.startActivity(paramDownloadAppInfo);
      return;
    }
    catch (Exception paramDownloadAppInfo)
    {
      for (;;)
      {
        paramContext = j;
        new StringBuilder("安装时有异常：").append(paramDownloadAppInfo.getMessage());
      }
    }
  }
  
  public final void excuteResume(DownloadAppInfo paramDownloadAppInfo)
  {
    b(paramDownloadAppInfo);
  }
  
  public final void excuteUpdate(DownloadAppInfo paramDownloadAppInfo)
  {
    paramDownloadAppInfo.setDownloadStatus(6);
    b(paramDownloadAppInfo);
  }
  
  public final void finishDownloadTool()
  {
    try
    {
      pauseAllDownloadThread();
      this.context.unregisterReceiver(this.K);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b localb = j;
        localException.getMessage();
      }
    }
  }
  
  public final ArrayList initAllDownloadAppInfoList()
  {
    this.I = this.g.q();
    b localb = j;
    new StringBuilder("initAllDownloadAppInfoList，数据库中存的应用数量：").append(this.I.size());
    return this.I;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */