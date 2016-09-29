package cn.dm.download;

import android.content.Context;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadHelperListener;
import cn.dm.download.listener.DownloadReportListener;
import java.util.ArrayList;
import java.util.Iterator;

public class DownLoadManager
  implements DownloadHelperListener
{
  private static DownLoadManager c;
  private h a;
  private g b;
  private f d;
  private DownloadReportListener e;
  private Context mContext;
  
  private DownLoadManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.a = h.a(this.mContext);
    this.d = new f(paramContext, this);
  }
  
  public static DownLoadManager getInstance(Context paramContext)
  {
    try
    {
      if (c == null)
      {
        DownLoadManager localDownLoadManager = new cn/dm/download/DownLoadManager;
        localDownLoadManager.<init>(paramContext);
        c = localDownLoadManager;
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public void addTask(DownloadAppInfo paramDownloadAppInfo, String paramString, DownloadHelperListener paramDownloadHelperListener)
  {
    this.a.addTask(paramDownloadAppInfo, paramString, paramDownloadHelperListener);
  }
  
  public DownloadAppInfo checkAndGetDownloadAppInfo(DownloadAppInfo paramDownloadAppInfo)
  {
    return this.d.checkAndGetDownloadAppInfo(paramDownloadAppInfo);
  }
  
  public void clearTask()
  {
    this.a.clearTask();
  }
  
  public void excuteCancel(DownloadAppInfo paramDownloadAppInfo)
  {
    excuteDelete(paramDownloadAppInfo);
  }
  
  public void excuteDelete(DownloadAppInfo paramDownloadAppInfo)
  {
    this.d.excuteDelete(paramDownloadAppInfo);
  }
  
  public void excuteDownload(DownloadAppInfo paramDownloadAppInfo)
  {
    this.e.onDownloadWaitingReport(paramDownloadAppInfo);
    this.d.excuteDownload(paramDownloadAppInfo);
  }
  
  public void excuteInstall(Context paramContext, DownloadAppInfo paramDownloadAppInfo)
  {
    this.d.excuteInstall(paramContext, paramDownloadAppInfo);
  }
  
  public void excuteOpen(Context paramContext, DownloadAppInfo paramDownloadAppInfo)
  {
    f localf = this.d;
    f.excuteOpen(paramContext, paramDownloadAppInfo);
  }
  
  public void excutePause(DownloadAppInfo paramDownloadAppInfo)
  {
    f localf = this.d;
    f.excutePause(paramDownloadAppInfo);
  }
  
  public void excuteResume(DownloadAppInfo paramDownloadAppInfo)
  {
    this.d.excuteResume(paramDownloadAppInfo);
  }
  
  public void excuteUninstall(Context paramContext, DownloadAppInfo paramDownloadAppInfo)
  {
    f localf = this.d;
    f.excuteUninstall(paramContext, paramDownloadAppInfo);
  }
  
  public void excuteUpdate(DownloadAppInfo paramDownloadAppInfo)
  {
    this.d.excuteUpdate(paramDownloadAppInfo);
  }
  
  public boolean existTask(DownloadAppInfo paramDownloadAppInfo, String paramString)
  {
    boolean bool = false;
    paramDownloadAppInfo = this.a.c(paramDownloadAppInfo);
    if (paramDownloadAppInfo == null) {}
    for (;;)
    {
      return bool;
      if (paramDownloadAppInfo.e(paramString) != null) {
        bool = true;
      }
    }
  }
  
  public void finishDownloadTool()
  {
    this.d.finishDownloadTool();
  }
  
  public int getDownloadStatus(DownloadAppInfo paramDownloadAppInfo)
  {
    return 0;
  }
  
  public int getDownloadingCount()
  {
    int j = 0;
    Object localObject = initAllDownloadAppInfoList();
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((ArrayList)localObject).size() > 0) {
        localObject = ((ArrayList)localObject).iterator();
      }
    }
    for (i = 0;; i++)
    {
      if (!((Iterator)localObject).hasNext()) {
        return i;
      }
      switch (((DownloadAppInfo)((Iterator)localObject).next()).getDownloadStatus())
      {
      }
    }
  }
  
  public f getInnerDownloadManager()
  {
    return this.d;
  }
  
  public ArrayList initAllDownloadAppInfoList()
  {
    return this.d.initAllDownloadAppInfoList();
  }
  
  public void onDownloadCancel(DownloadAppInfo paramDownloadAppInfo)
  {
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onDownloadCancel(paramDownloadAppInfo);
    }
  }
  
  public void onDownloadFailed(DownloadAppInfo paramDownloadAppInfo)
  {
    this.e.onDownloadFailedReport(paramDownloadAppInfo);
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onDownloadFailed(paramDownloadAppInfo);
    }
  }
  
  public void onDownloadPause(DownloadAppInfo paramDownloadAppInfo)
  {
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onDownloadPause(paramDownloadAppInfo);
    }
  }
  
  public void onDownloadResume(DownloadAppInfo paramDownloadAppInfo)
  {
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onDownloadResume(paramDownloadAppInfo);
    }
  }
  
  public void onDownloadStart(DownloadAppInfo paramDownloadAppInfo)
  {
    this.e.onDownloadStartReport(paramDownloadAppInfo);
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onDownloadStart(paramDownloadAppInfo);
    }
  }
  
  public void onDownloadSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    this.e.onDownloadSuccessReport(paramDownloadAppInfo);
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onDownloadSuccess(paramDownloadAppInfo);
    }
    excuteInstall(this.mContext, paramDownloadAppInfo);
  }
  
  public void onDownloadWaiting(DownloadAppInfo paramDownloadAppInfo)
  {
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onDownloadWaiting(paramDownloadAppInfo);
    }
  }
  
  public void onInstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    this.e.onInstallSuccessReport(paramDownloadAppInfo);
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onInstallSuccess(paramDownloadAppInfo);
    }
    this.e.onAutoRunReport(paramDownloadAppInfo);
    excuteOpen(this.mContext, paramDownloadAppInfo);
  }
  
  public void onProgressChange(DownloadAppInfo paramDownloadAppInfo)
  {
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onProgressChange(paramDownloadAppInfo);
    }
  }
  
  public void onUninstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    this.b = this.a.c(paramDownloadAppInfo);
    if (this.b != null) {
      this.b.onUninstallSuccess(paramDownloadAppInfo);
    }
  }
  
  public void pauseAllDownloadThread()
  {
    f localf = this.d;
    f.pauseAllDownloadThread();
  }
  
  public void removeListener(DownloadAppInfo paramDownloadAppInfo, String paramString)
  {
    paramDownloadAppInfo = this.a.c(paramDownloadAppInfo);
    if (paramDownloadAppInfo != null) {
      paramDownloadAppInfo.d(paramString);
    }
  }
  
  public void removeTask(DownloadAppInfo paramDownloadAppInfo)
  {
    this.a.removeTask(paramDownloadAppInfo);
  }
  
  public void setDownloadReportListener(DownloadReportListener paramDownloadReportListener)
  {
    this.e = paramDownloadReportListener;
  }
  
  public void setMaxDownloadThreadNum(int paramInt)
  {
    f localf = this.d;
    f.setMaxDownloadThreadNum(paramInt);
  }
  
  public void setStorageFileName(String paramString)
  {
    f localf = this.d;
    f.setStorageFileName(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\DownLoadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */