package cn.domob.android.c;

import android.content.Context;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

class f
  extends Thread
{
  private static cn.domob.android.i.f d = new cn.domob.android.i.f(f.class.getSimpleName());
  String a;
  String b;
  String c;
  private int e = 0;
  private int f;
  private int g;
  private int h = 1;
  private int i = 0;
  private c j = null;
  private boolean k;
  private long l = 0L;
  private a m = new a();
  private Context n = null;
  
  public f(String paramString1, String paramString2, long paramLong, c paramc, Context paramContext)
  {
    this.a = paramString1;
    this.c = paramString2;
    this.l = paramLong;
    this.j = paramc;
    this.n = paramContext;
    d.b(f.class.getSimpleName(), "build DownloadTask url=" + paramString1 + ",fileName=" + paramString2);
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
    g[] arrayOfg = new g[this.h];
    for (;;)
    {
      int i1;
      try
      {
        localURL = new java/net/URL;
        localURL.<init>(this.a);
        localObject1 = d.b(this.n);
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
          localObject1 = d;
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          ((cn.domob.android.i.f)localObject1).a(this, "Total file size: " + this.e);
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
        Object localObject3 = d;
        Object localObject2 = f.class.getSimpleName();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        ((cn.domob.android.i.f)localObject3).b(localObject2, "fileSize:" + this.e + " downloadSizeMore:" + this.g);
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
        long l1 = this.l;
        long l2 = (i1 + 1) * this.f - 1;
        localObject2 = new cn/domob/android/c/g;
        ((g)localObject2).<init>(localURL, (File)localObject3, l3 + l1, l2, this.m, this.j, this.n);
        if (!((g)localObject2).a()) {
          continue;
        }
        this.j.a(100);
        continue;
        localObject2 = new g(localURL, (File)localObject3, this.f * i1 + this.l, (i1 + 1) * this.f - 1 + this.g, this.m, this.j, this.n);
        continue;
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        ((g)localObject2).setName("Thread" + i1);
        ((g)localObject2).start();
        arrayOfg[i1] = localObject2;
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
        for (i1 = 0; i1 < arrayOfg.length; i1++)
        {
          this.i = ((int)(this.i + arrayOfg[i1].b()));
          if (!arrayOfg[i1].a()) {
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */