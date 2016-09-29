package cn.dm.download.listener;

import cn.dm.download.bean.DownloadAppInfo;

public abstract interface DownloadReportListener
{
  public abstract void onAutoRunReport(DownloadAppInfo paramDownloadAppInfo);
  
  public abstract void onDownloadFailedReport(DownloadAppInfo paramDownloadAppInfo);
  
  public abstract void onDownloadStartReport(DownloadAppInfo paramDownloadAppInfo);
  
  public abstract void onDownloadSuccessReport(DownloadAppInfo paramDownloadAppInfo);
  
  public abstract void onDownloadWaitingReport(DownloadAppInfo paramDownloadAppInfo);
  
  public abstract void onInstallSuccessReport(DownloadAppInfo paramDownloadAppInfo);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\listener\DownloadReportListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */