package cn.domob.wall.core;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import cn.domob.wall.core.bean.AdExtend;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import cn.domob.wall.core.c.d.a;
import cn.domob.wall.core.c.d.b;
import cn.domob.wall.core.c.d.c;
import cn.domob.wall.core.c.d.d;
import cn.domob.wall.core.c.d.e;
import cn.domob.wall.core.c.e;
import cn.domob.wall.core.c.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b
{
  private static cn.domob.wall.core.h.d a = new cn.domob.wall.core.h.d(b.class.getSimpleName());
  private static final String r = "details";
  private static final String s = "0";
  private static final String t = "1";
  private static final String u = "q";
  private static final String v = "ids";
  private Context b;
  private DService.ReceiveDataListener c;
  private DService.ReceiveListDataListener d;
  private DService.ReceiveSearchDataListener e;
  private DService.ReceiveDetailsDataListener f;
  private DService.ReceiveHotSearchDataListener g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private String m = null;
  private String n = null;
  private String o = null;
  private boolean p = false;
  private ExecutorService q;
  private AdExtend w;
  private cn.domob.wall.core.d.d x;
  
  b(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.n = paramString2;
    this.m = paramString1;
    this.q = Executors.newSingleThreadExecutor();
  }
  
  private boolean k()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!this.p)
    {
      if ((cn.domob.wall.core.h.f.g(this.m)) || (cn.domob.wall.core.h.f.g(this.n))) {
        break label63;
      }
      if (cn.domob.wall.core.h.f.a(this.b))
      {
        this.p = true;
        bool1 = bool2;
      }
    }
    else
    {
      return bool1;
    }
    Log.w("DrwSDK", "Permission denied.");
    for (;;)
    {
      bool1 = false;
      break;
      label63:
      Log.w("DrwSDK", "Please set your publisherID and placementID first.");
    }
  }
  
  public View a(Context paramContext)
  {
    if (this.x == null) {
      this.x = new cn.domob.wall.core.d.d(this, paramContext, this.w);
    }
    return this.x;
  }
  
  public void a()
  {
    if (!k()) {}
    for (;;)
    {
      return;
      if (this.h)
      {
        a.d("requestDataAsynting....");
      }
      else
      {
        this.h = true;
        new Thread()
        {
          public void run()
          {
            try
            {
              if (!cn.domob.wall.core.c.a.a)
              {
                localObject = new cn/domob/wall/core/c/a;
                ((cn.domob.wall.core.c.a)localObject).<init>(b.this);
                ((cn.domob.wall.core.c.a)localObject).a();
              }
              Object localObject = new java/util/HashMap;
              ((HashMap)localObject).<init>();
              ((HashMap)localObject).put("details", "0");
              cn.domob.wall.core.c.d locald = new cn/domob/wall/core/c/d;
              locald.<init>(b.this);
              d.a local1 = new cn/domob/wall/core/b$1$1;
              local1.<init>(this);
              locald.a(local1, (HashMap)localObject);
              return;
            }
            catch (cn.domob.wall.core.e.a locala)
            {
              for (;;)
              {
                b.j().d("Config request is ongoing, Thread will sleep 1 seconds, and then restart to request");
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                b.j().a(localException);
                b.a(b.this, false);
              }
            }
          }
        }.start();
      }
    }
  }
  
  public void a(DService.ReceiveDataListener paramReceiveDataListener)
  {
    this.c = paramReceiveDataListener;
  }
  
  public void a(DService.ReceiveDetailsDataListener paramReceiveDetailsDataListener)
  {
    this.f = paramReceiveDetailsDataListener;
  }
  
  public void a(DService.ReceiveHotSearchDataListener paramReceiveHotSearchDataListener)
  {
    this.g = paramReceiveHotSearchDataListener;
  }
  
  public void a(DService.ReceiveListDataListener paramReceiveListDataListener)
  {
    this.d = paramReceiveListDataListener;
  }
  
  public void a(DService.ReceiveSearchDataListener paramReceiveSearchDataListener)
  {
    this.e = paramReceiveSearchDataListener;
  }
  
  public void a(final String paramString)
  {
    if (!k()) {}
    for (;;)
    {
      return;
      if (this.j)
      {
        a.d("requestSearchDataAsyning....");
      }
      else
      {
        this.j = true;
        new Thread()
        {
          public void run()
          {
            try
            {
              if (!cn.domob.wall.core.c.a.a)
              {
                localObject = new cn/domob/wall/core/c/a;
                ((cn.domob.wall.core.c.a)localObject).<init>(b.this);
                ((cn.domob.wall.core.c.a)localObject).a();
              }
              Object localObject = new java/util/HashMap;
              ((HashMap)localObject).<init>();
              ((HashMap)localObject).put("q", paramString);
              cn.domob.wall.core.c.d locald = new cn/domob/wall/core/c/d;
              locald.<init>(b.this);
              d.e local1 = new cn/domob/wall/core/b$3$1;
              local1.<init>(this);
              locald.a(local1, (HashMap)localObject);
              return;
            }
            catch (cn.domob.wall.core.e.a locala)
            {
              for (;;)
              {
                b.j().d("Config request is ongoing, Thread will sleep 1 seconds, and then restart to request");
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                b.j().a(localException);
                b.c(b.this, false);
              }
            }
          }
        }.start();
      }
    }
  }
  
  public void a(List<AdExtend> paramList)
  {
    this.w = null;
    this.x = null;
    if ((paramList != null) && (paramList.size() >= 1) && (paramList.get(0) != null))
    {
      this.w = ((AdExtend)paramList.get(0));
      a.b("eWallInfo:" + ((AdExtend)paramList.get(0)).toString());
      if (this.w.ismPreload()) {
        ((Activity)this.b).runOnUiThread(new Runnable()
        {
          public void run()
          {
            b.a(b.this, new cn.domob.wall.core.d.d(b.this, b.f(b.this), b.g(b.this)));
          }
        });
      }
    }
  }
  
  public void b()
  {
    if (!k()) {}
    for (;;)
    {
      return;
      if (this.i)
      {
        a.d("requestListsDataAsynting....");
      }
      else
      {
        this.i = true;
        new Thread()
        {
          public void run()
          {
            try
            {
              if (!cn.domob.wall.core.c.a.a)
              {
                localObject = new cn/domob/wall/core/c/a;
                ((cn.domob.wall.core.c.a)localObject).<init>(b.this);
                ((cn.domob.wall.core.c.a)localObject).a();
              }
              Object localObject = new java/util/HashMap;
              ((HashMap)localObject).<init>();
              ((HashMap)localObject).put("details", "1");
              cn.domob.wall.core.c.d locald = new cn/domob/wall/core/c/d;
              locald.<init>(b.this);
              d.d local1 = new cn/domob/wall/core/b$2$1;
              local1.<init>(this);
              locald.a(local1, (HashMap)localObject);
              return;
            }
            catch (cn.domob.wall.core.e.a locala)
            {
              for (;;)
              {
                b.j().d("Config request is ongoing, Thread will sleep 1 seconds, and then restart to request");
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                b.j().a(localException);
                b.b(b.this, false);
              }
            }
          }
        }.start();
      }
    }
  }
  
  public void b(final String paramString)
  {
    if (!k()) {}
    for (;;)
    {
      return;
      if (this.k)
      {
        a.d("requestDetailsDataAsyning....");
      }
      else
      {
        this.k = true;
        new Thread()
        {
          public void run()
          {
            try
            {
              if (!cn.domob.wall.core.c.a.a)
              {
                localObject = new cn/domob/wall/core/c/a;
                ((cn.domob.wall.core.c.a)localObject).<init>(b.this);
                ((cn.domob.wall.core.c.a)localObject).a();
              }
              Object localObject = new java/util/HashMap;
              ((HashMap)localObject).<init>();
              ((HashMap)localObject).put("ids", paramString);
              cn.domob.wall.core.c.d locald = new cn/domob/wall/core/c/d;
              locald.<init>(b.this);
              d.b local1 = new cn/domob/wall/core/b$4$1;
              local1.<init>(this);
              locald.a(local1, (HashMap)localObject);
              return;
            }
            catch (cn.domob.wall.core.e.a locala)
            {
              for (;;)
              {
                b.j().d("Config request is ongoing, Thread will sleep 1 seconds, and then restart to request");
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                b.j().a(localException);
                b.d(b.this, false);
              }
            }
          }
        }.start();
      }
    }
  }
  
  public void c()
  {
    if (!k()) {}
    for (;;)
    {
      return;
      if (this.l)
      {
        a.d("requestHotStringDataAsyning....");
      }
      else
      {
        this.l = true;
        new Thread()
        {
          public void run()
          {
            try
            {
              if (!cn.domob.wall.core.c.a.a)
              {
                localObject = new cn/domob/wall/core/c/a;
                ((cn.domob.wall.core.c.a)localObject).<init>(b.this);
                ((cn.domob.wall.core.c.a)localObject).a();
              }
              cn.domob.wall.core.c.d locald = new cn/domob/wall/core/c/d;
              locald.<init>(b.this);
              Object localObject = new cn/domob/wall/core/b$5$1;
              ((1)localObject).<init>(this);
              locald.a((d.c)localObject, null);
              return;
            }
            catch (cn.domob.wall.core.e.a locala)
            {
              for (;;)
              {
                b.j().d("Config request is ongoing, Thread will sleep 1 seconds, and then restart to request");
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                b.j().a(localException);
                b.e(b.this, false);
              }
            }
          }
        }.start();
      }
    }
  }
  
  public String d()
  {
    return this.m;
  }
  
  public String e()
  {
    return this.n;
  }
  
  public String f()
  {
    return this.o;
  }
  
  public Context g()
  {
    return this.b;
  }
  
  public ExecutorService h()
  {
    return this.q;
  }
  
  public AdExtend i()
  {
    return this.w;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */