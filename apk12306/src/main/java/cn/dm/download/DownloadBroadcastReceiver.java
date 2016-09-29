package cn.dm.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadHelperListener;
import cn.dm.download.util.b;
import java.util.ArrayList;
import java.util.Iterator;

public class DownloadBroadcastReceiver
  extends BroadcastReceiver
{
  private static b f = new b(DownloadBroadcastReceiver.class.getSimpleName());
  private Context context;
  private f d;
  private cn.dm.download.db.c g;
  private ArrayList h;
  private DownloadHelperListener i;
  
  public DownloadBroadcastReceiver() {}
  
  public DownloadBroadcastReceiver(Context paramContext, f paramf, DownloadHelperListener paramDownloadHelperListener, cn.dm.download.db.c paramc)
  {
    this.context = paramContext;
    this.i = paramDownloadHelperListener;
    this.d = paramf;
    this.g = paramc;
    this.i = paramDownloadHelperListener;
  }
  
  public final void a()
  {
    try
    {
      localObject = new android/content/IntentFilter;
      ((IntentFilter)localObject).<init>();
      ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_ADDED");
      ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REMOVED");
      ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REPLACED");
      ((IntentFilter)localObject).addDataScheme("package");
      this.context.registerReceiver(this, (IntentFilter)localObject);
      localObject = f;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = f;
        localException.getMessage();
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    localObject1 = DownLoadManager.getInstance(paramContext);
    this.i = ((DownloadHelperListener)localObject1);
    this.d = ((DownLoadManager)localObject1).getInnerDownloadManager();
    this.g = new cn.dm.download.db.c(paramContext);
    localObject1 = paramIntent.getAction();
    localObject2 = f;
    for (;;)
    {
      try
      {
        this.h = this.d.initAllDownloadAppInfoList();
        paramIntent = paramIntent.getDataString();
        if (!"android.intent.action.PACKAGE_ADDED".equals(localObject1)) {
          continue;
        }
        paramContext = f;
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>("检测到安装完成，安装包名：");
        paramContext.append(paramIntent);
        localObject1 = this.h.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramIntent = f;
        paramContext.getMessage();
        continue;
        if (!"android.intent.action.PACKAGE_REMOVED".equals(localObject1)) {
          continue;
        }
        localObject1 = f;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("检测到包被卸载，包名：");
        ((StringBuilder)localObject1).append(paramIntent);
        Iterator localIterator = this.h.iterator();
        if (localIterator.hasNext()) {
          continue;
        }
        paramContext = new cn/dm/download/bean/DownloadAppInfo;
        paramContext.<init>();
        paramContext.setPkgName(paramIntent.substring(8));
        paramContext.setDownloadStatus(0);
        this.i.onUninstallSuccess(paramContext);
        paramContext = f;
        continue;
        localObject1 = (DownloadAppInfo)localIterator.next();
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("package:");
        if (!((DownloadAppInfo)localObject1).getPkgName().equals(paramIntent)) {
          continue;
        }
        paramIntent = f;
        paramIntent = new java/lang/StringBuilder;
        paramIntent.<init>("已卸载包名在数据库中存在，更新数据库！包名：");
        paramIntent.append(((DownloadAppInfo)localObject1).getPkgName());
        if (((DownloadAppInfo)localObject1).getIsUpdate() != 1) {
          continue;
        }
        paramContext = f;
        continue;
        ((DownloadAppInfo)localObject1).setDownloadStatus(0);
        this.g.a(((DownloadAppInfo)localObject1).getAppId());
        cn.dm.download.util.c.s(cn.dm.download.util.c.a(paramContext, (DownloadAppInfo)localObject1));
        this.i.onUninstallSuccess((DownloadAppInfo)localObject1);
        paramContext = f;
        continue;
        if (!"android.intent.action.PACKAGE_REPLACED".equals(localObject1)) {
          continue;
        }
        paramContext = f;
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>("检测到包被更新，包名：");
        paramContext.append(paramIntent);
        localObject2 = this.h.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        paramContext = (DownloadAppInfo)((Iterator)localObject2).next();
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("package:");
        if (!paramContext.getPkgName().equals(paramIntent)) {
          continue;
        }
        paramIntent = f;
        paramIntent = new java/lang/StringBuilder;
        paramIntent.<init>("已更新包名在数据库中存在，包名：");
        paramIntent.append(paramContext.getPkgName());
        continue;
      }
      paramContext = (DownloadAppInfo)((Iterator)localObject1).next();
      localObject2 = f;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("数据库包名：");
      ((StringBuilder)localObject2).append(paramContext.getPkgName());
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("package:");
      if (paramContext.getPkgName().equals(paramIntent))
      {
        paramIntent = f;
        paramContext.setDownloadStatus(5);
        this.g.f(paramContext);
        this.i.onInstallSuccess(paramContext);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\DownloadBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */