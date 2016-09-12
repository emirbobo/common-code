package cn.dm.download;

import android.content.Context;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadHelperListener;
import java.util.HashMap;

public final class h
{
  private static h N;
  private HashMap M = new HashMap();
  private g b = null;
  
  public static h a(Context paramContext)
  {
    if (N == null) {
      N = new h();
    }
    return N;
  }
  
  private static String d(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDownloadAppInfo != null)
    {
      localObject1 = localObject2;
      if (!f(paramDownloadAppInfo.getPkgName())) {
        localObject1 = paramDownloadAppInfo.getPkgName();
      }
    }
    return (String)localObject1;
  }
  
  private static boolean f(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void a(DownloadAppInfo paramDownloadAppInfo, String paramString)
  {
    paramDownloadAppInfo = c(paramDownloadAppInfo);
    if (paramDownloadAppInfo != null) {
      paramDownloadAppInfo.d(paramString);
    }
  }
  
  public final void addTask(DownloadAppInfo paramDownloadAppInfo, String paramString, DownloadHelperListener paramDownloadHelperListener)
  {
    if (this.M == null) {
      this.M = new HashMap();
    }
    paramDownloadAppInfo = d(paramDownloadAppInfo);
    if (paramDownloadAppInfo == null) {}
    for (;;)
    {
      return;
      this.b = ((g)this.M.get(paramDownloadAppInfo));
      if (this.b == null)
      {
        this.b = new g(paramString, paramDownloadHelperListener);
        this.M.put(paramDownloadAppInfo, this.b);
      }
      else
      {
        this.b.a(paramString, paramDownloadHelperListener);
      }
    }
  }
  
  public final g c(DownloadAppInfo paramDownloadAppInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.M != null)
    {
      localObject1 = localObject2;
      if (d(paramDownloadAppInfo) != null) {
        localObject1 = (g)this.M.get(d(paramDownloadAppInfo));
      }
    }
    return (g)localObject1;
  }
  
  public final void clearTask()
  {
    if (this.M != null)
    {
      this.M.clear();
      this.M = null;
    }
  }
  
  public final void removeTask(DownloadAppInfo paramDownloadAppInfo)
  {
    g localg = c(paramDownloadAppInfo);
    if (localg != null)
    {
      localg.o();
      if ((!f(d(paramDownloadAppInfo))) && (this.M != null)) {
        this.M.remove(d(paramDownloadAppInfo));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */