package cn.dm.download;

import android.content.Context;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadHelperListener;
import cn.dm.download.util.Constants;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class a
  implements cn.dm.download.listener.a
{
  private static cn.dm.download.util.b j = new cn.dm.download.util.b(a.class.getSimpleName());
  private cn.dm.download.db.c g;
  private DownloadHelperListener i;
  private d k;
  private String l;
  private String m;
  private Context mContext;
  private cn.dm.download.listener.a n;
  private DownloadAppInfo o;
  private long p = 0L;
  private String q;
  private e r;
  private long s = 0L;
  public int t;
  
  public a(DownloadAppInfo paramDownloadAppInfo, Context paramContext, DownloadHelperListener paramDownloadHelperListener)
  {
    this.mContext = paramContext;
    this.k = new d(paramDownloadAppInfo, this);
    this.n = this;
    this.i = paramDownloadHelperListener;
    this.o = paramDownloadAppInfo;
    this.g = new cn.dm.download.db.c(this.mContext);
    this.q = paramDownloadAppInfo.getDownloadUrl();
  }
  
  private void a(String paramString)
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(paramString);
      paramString = j;
      paramString = new java/lang/StringBuilder;
      paramString.<init>("准备启动文件下载，初始大小和文件大小为：");
      paramString.append(this.s).append("  ,").append(this.p - 1L);
      paramString = new cn/dm/download/e;
      paramString.<init>(this.mContext, localFile, this.s, this.p - 1L, this.n, this.o);
      this.r = paramString;
      this.r.start();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = j;
        new StringBuilder("下载过程中出现错误:").append(localException.getMessage());
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    if (c.k() >= Constants.MaxDownloadThread)
    {
      cn.dm.download.util.b localb = j;
      new StringBuilder("线程池中同时下载线程为：").append(c.k()).append(",超出最大下载线程，终止下载");
      this.o.setDownloadStatus(1);
      this.t = 1;
      c.a(Long.valueOf(this.o.getAppId()), this);
      if (!paramBoolean) {
        break label98;
      }
      this.g.f(this.o);
    }
    for (;;)
    {
      return bool;
      this.o.setDownloadStatus(2);
      this.t = 2;
      bool = false;
      break;
      label98:
      this.g.g(this.o);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.g.f(this.o);
    }
    for (;;)
    {
      return;
      this.g.g(this.o);
    }
  }
  
  private void d()
  {
    g();
  }
  
  private void f()
  {
    Object localObject2 = new File(this.m);
    Object localObject1 = new File(this.m + Constants.Unfinished_Sign);
    if (((File)localObject2).exists())
    {
      localObject1 = j;
      ((File)localObject2).delete();
      this.g.a(this.o.getAppId());
      this.s = 0L;
    }
    for (;;)
    {
      return;
      if (((File)localObject1).exists()) {
        if (Long.valueOf(this.o.getCurrentDownloadSize()).longValue() <= 0L)
        {
          localObject2 = j;
          ((File)localObject1).delete();
          this.s = 0L;
        }
        else
        {
          localObject2 = j;
          this.s = ((File)localObject1).length();
        }
      }
    }
  }
  
  private void g()
  {
    if (this.r != null)
    {
      this.r.G = false;
      this.r.H = false;
    }
  }
  
  private static void h()
  {
    Object localObject = c.v.values().iterator();
    if (!((Iterator)localObject).hasNext()) {}
    for (;;)
    {
      return;
      a locala = (a)((Iterator)localObject).next();
      if (locala.t != 1) {
        break;
      }
      localObject = j;
      locala.b();
    }
  }
  
  private void init()
  {
    this.p = cn.dm.download.util.c.a(this.q, this.mContext);
    this.o.setAppSize(this.p);
    this.l = cn.dm.download.util.c.g(this.mContext);
    this.m = cn.dm.download.util.c.a(this.mContext, this.o);
  }
  
  public final void a(DownloadAppInfo paramDownloadAppInfo)
  {
    cn.dm.download.util.b localb = j;
    try
    {
      c.a(Long.valueOf(paramDownloadAppInfo.getAppId()));
      paramDownloadAppInfo.setDownloadStatus(3);
      this.g.f(paramDownloadAppInfo);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localb = j;
        localException.getMessage();
        this.i.onDownloadPause(paramDownloadAppInfo);
        h();
      }
    }
    finally
    {
      this.i.onDownloadPause(paramDownloadAppInfo);
      h();
    }
  }
  
  public final void b()
  {
    new Thread(new b(this)).start();
  }
  
  public final void b(String paramString)
  {
    cn.dm.download.util.b localb = j;
    new StringBuilder("onDownloadSuccess:").append(paramString);
    try
    {
      c.a(Long.valueOf(this.o.getAppId()));
      this.o.setDownloadStatus(4);
      this.g.f(this.o);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = j;
        localException.getMessage();
        this.i.onDownloadSuccess(this.o);
        h();
      }
    }
    finally
    {
      this.i.onDownloadSuccess(this.o);
      h();
    }
  }
  
  public final void c()
  {
    g();
    if (this.r != null) {
      this.r.G = true;
    }
  }
  
  public final void c(String paramString)
  {
    Object localObject = j;
    new StringBuilder("onDownloadCanceled:").append(paramString);
    try
    {
      c.a(Long.valueOf(this.o.getAppId()));
      cn.dm.download.util.c.s(paramString);
      localObject = j;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("被删除文件名：");
      ((StringBuilder)localObject).append(paramString);
      this.o.setDownloadStatus(0);
      this.o.setCurrentDownloadSize(0L);
      this.g.a(this.o.getAppId());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = j;
        localException.getMessage();
        this.i.onDownloadCancel(this.o);
        h();
      }
    }
    finally
    {
      this.i.onDownloadCancel(this.o);
      h();
    }
  }
  
  public final void e()
  {
    g();
    if (this.r != null) {
      this.r.H = true;
    }
  }
  
  public final boolean i()
  {
    boolean bool = false;
    cn.dm.download.util.b localb = j;
    try
    {
      if (a(false)) {}
      for (;;)
      {
        return bool;
        this.i.onDownloadStart(this.o);
        bool = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localb = j;
        localException.getMessage();
      }
    }
  }
  
  public final boolean j()
  {
    boolean bool = false;
    cn.dm.download.util.b localb = j;
    try
    {
      if (a(true)) {}
      for (;;)
      {
        return bool;
        this.i.onDownloadResume(this.o);
        bool = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localb = j;
        localException.getMessage();
      }
    }
  }
  
  public final void onDownloadFailed(DownloadAppInfo paramDownloadAppInfo)
  {
    try
    {
      c.a(Long.valueOf(paramDownloadAppInfo.getAppId()));
      paramDownloadAppInfo.setDownloadStatus(8);
      this.g.f(paramDownloadAppInfo);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = j;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("下载失败：");
        ((StringBuilder)localObject2).append(localException.getMessage());
        this.i.onDownloadFailed(paramDownloadAppInfo);
        h();
      }
    }
    finally
    {
      this.i.onDownloadFailed(paramDownloadAppInfo);
      h();
    }
  }
  
  public final void onProgressChange(DownloadAppInfo paramDownloadAppInfo)
  {
    this.i.onProgressChange(paramDownloadAppInfo);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */