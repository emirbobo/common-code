package cn.dbox.core.d;

import android.content.Context;
import cn.dbox.core.h.d;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

class g
  extends Thread
{
  private static d d = new d(g.class.getSimpleName());
  String a;
  String b;
  String c;
  private int e = 0;
  private int f;
  private int g;
  private int h = 1;
  private int i = 0;
  private f j = null;
  private boolean k;
  private long l = 0L;
  private a m = new a();
  private Context n = null;
  
  public g(String paramString1, String paramString2, long paramLong, f paramf, Context paramContext)
  {
    this.a = paramString1;
    this.c = paramString2;
    this.l = paramLong;
    this.j = paramf;
    this.n = paramContext;
    d.b(g.class.getSimpleName(), "build DownloadTask url=" + paramString1 + ",fileName=" + paramString2);
  }
  
  protected boolean a()
  {
    return this.k;
  }
  
  protected void b()
  {
    this.m.a = true;
  }
  
  public void run()
  {
    i[] arrayOfi = new i[this.h];
    for (;;)
    {
      int i1;
      try
      {
        localURL = new java/net/URL;
        localURL.<init>(this.a);
        localObject1 = h.b(this.n);
        if (localObject1 != null)
        {
          d.a(this, "Use Proxy");
          localObject1 = (HttpURLConnection)localURL.openConnection((Proxy)localObject1);
          ((HttpURLConnection)localObject1).setRequestMethod("HEAD");
          i1 = ((HttpURLConnection)localObject1).getResponseCode();
          if ((i1 < 200) || (i1 >= 300)) {
            continue;
          }
          this.e = ((HttpURLConnection)localObject1).getContentLength();
          localObject3 = d;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((d)localObject3).a(this, "Total file size: " + this.e);
          if (this.e > 0) {
            continue;
          }
          this.j.a("下载连接过程中出现错误");
          return;
        }
      }
      catch (Exception localException)
      {
        URL localURL;
        Object localObject1;
        d.a(localException);
        this.j.a("下载过程中出现错误");
        continue;
        Object localObject2 = d;
        Object localObject3 = g.class.getSimpleName();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        ((d)localObject2).b(localObject3, "fileSize:" + this.e + " downloadSizeMore:" + this.g);
        this.f = (this.e / this.h);
        this.g = (this.e % this.h);
        localObject3 = new java/io/File;
        ((File)localObject3).<init>(this.c);
        i1 = 0;
        if (i1 >= this.h) {
          continue;
        }
        if (i1 == this.h - 1) {
          continue;
        }
        long l3 = this.f * i1;
        long l2 = this.l;
        long l1 = (i1 + 1) * this.f - 1;
        localObject2 = new cn/dbox/core/d/i;
        ((i)localObject2).<init>(localURL, (File)localObject3, l3 + l2, l1, this.m, this.j, this.n);
        if (!((i)localObject2).a()) {
          continue;
        }
        this.j.a(100);
        continue;
        localObject2 = new i(localURL, (File)localObject3, this.f * i1 + this.l, (i1 + 1) * this.f - 1 + this.g, this.m, this.j, this.n);
        continue;
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        ((i)localObject2).setName("Thread" + i1);
        ((i)localObject2).start();
        arrayOfi[i1] = localObject2;
        i1++;
        continue;
        this.k = false;
      }
      d.a(this, "Proxy is null");
      localObject1 = (HttpURLConnection)localURL.openConnection();
      continue;
      this.j.a("下载连接过程中出现错误");
      continue;
      while ((!this.k) && (!this.m.a))
      {
        this.i = this.g;
        this.k = true;
        for (i1 = 0; i1 < arrayOfi.length; i1++)
        {
          this.i = ((int)(this.i + arrayOfi[i1].b()));
          if (!arrayOfi[i1].a()) {
            this.k = false;
          }
        }
        if ((this.j != null) && (!this.m.a))
        {
          i1 = Double.valueOf(this.i * 1.0D / this.e * 100.0D).intValue();
          this.j.a(i1);
        }
        sleep(1000L);
      }
    }
  }
  
  protected class a
  {
    protected boolean a = false;
    
    protected a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */