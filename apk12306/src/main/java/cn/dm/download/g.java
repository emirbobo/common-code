package cn.dm.download;

import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadHelperListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private HashMap L = new HashMap();
  
  public g(String paramString, DownloadHelperListener paramDownloadHelperListener)
  {
    this.L.put(paramString, paramDownloadHelperListener);
  }
  
  private List n()
  {
    ArrayList localArrayList;
    Iterator localIterator;
    if (this.L != null)
    {
      localArrayList = new ArrayList();
      localIterator = this.L.values().iterator();
      if (localIterator.hasNext()) {}
    }
    for (;;)
    {
      return localArrayList;
      localArrayList.add((DownloadHelperListener)localIterator.next());
      break;
      localArrayList = null;
    }
  }
  
  public final void a(String paramString, DownloadHelperListener paramDownloadHelperListener)
  {
    if (this.L != null) {
      this.L.put(paramString, paramDownloadHelperListener);
    }
  }
  
  public final void d(String paramString)
  {
    if (this.L != null) {
      this.L.remove(paramString);
    }
  }
  
  public final DownloadHelperListener e(String paramString)
  {
    if (this.L != null) {}
    for (paramString = (DownloadHelperListener)this.L.get(paramString);; paramString = null) {
      return paramString;
    }
  }
  
  public final void o()
  {
    if (this.L != null)
    {
      this.L.clear();
      this.L = null;
    }
  }
  
  public final void onDownloadCancel(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onDownloadCancel(paramDownloadAppInfo);
    }
  }
  
  public final void onDownloadFailed(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onDownloadFailed(paramDownloadAppInfo);
    }
  }
  
  public final void onDownloadPause(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onDownloadPause(paramDownloadAppInfo);
    }
  }
  
  public final void onDownloadResume(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onDownloadResume(paramDownloadAppInfo);
    }
  }
  
  public final void onDownloadStart(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onDownloadStart(paramDownloadAppInfo);
    }
  }
  
  public final void onDownloadSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onDownloadSuccess(paramDownloadAppInfo);
    }
  }
  
  public final void onDownloadWaiting(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onDownloadWaiting(paramDownloadAppInfo);
    }
  }
  
  public final void onInstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onInstallSuccess(paramDownloadAppInfo);
    }
  }
  
  public final void onProgressChange(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onProgressChange(paramDownloadAppInfo);
    }
  }
  
  public final void onUninstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject = n();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      ((DownloadHelperListener)((Iterator)localObject).next()).onUninstallSuccess(paramDownloadAppInfo);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */