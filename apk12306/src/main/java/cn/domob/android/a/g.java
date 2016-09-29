package cn.domob.android.a;

import android.content.Context;
import cn.domob.android.offerwall.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;

public class g
  extends Thread
{
  private static m a = new m(g.class.getSimpleName());
  private static final int b = 10240;
  private static final int l = 40000;
  private static final int m = 60000;
  private static final int n = 30;
  private URL c;
  private File d;
  private long e;
  private long f;
  private long g;
  private boolean h = false;
  private long i = 0L;
  private f.a j;
  private d k;
  private Context o = null;
  
  g(URL paramURL, File paramFile, long paramLong1, long paramLong2, f.a parama, d paramd, Context paramContext)
  {
    this.c = paramURL;
    this.d = paramFile;
    this.e = paramLong1;
    this.g = paramLong1;
    this.f = paramLong2;
    this.j = parama;
    this.k = paramd;
    this.i = paramLong1;
    this.o = paramContext;
    if ((paramLong1 > paramLong2) && (paramLong2 > 0L))
    {
      a.a(this, "Start postition is larger than end position, set finished to true");
      this.h = true;
    }
    a.a(this, "download st:" + paramLong1 + " ed:" + paramLong2);
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public long b()
  {
    return this.i;
  }
  
  public void run()
  {
    localObject2 = new byte['⠀'];
    for (;;)
    {
      try
      {
        localObject1 = e.b(this.o);
        if (localObject1 == null) {
          continue;
        }
        a.a(this, "Proxy exists");
        localObject1 = (HttpURLConnection)this.c.openConnection((Proxy)localObject1);
        ((HttpURLConnection)localObject1).setConnectTimeout(40000);
        ((HttpURLConnection)localObject1).setReadTimeout(60000);
        ((HttpURLConnection)localObject1).setAllowUserInteraction(true);
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((HttpURLConnection)localObject1).setRequestProperty("Range", "bytes=" + this.e + "-" + this.f);
        localObject3 = new java/io/RandomAccessFile;
        ((RandomAccessFile)localObject3).<init>(this.d, "rw");
        if (this.d.getAbsoluteFile().toString().startsWith("/data/data/"))
        {
          localObject4 = a;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          ((m)localObject4).a(this, "download in rom change chmod " + this.d.getAbsolutePath());
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          localObject4 = "chmod 777 " + this.d.getAbsolutePath();
          Runtime.getRuntime().exec((String)localObject4);
        }
        if (((HttpURLConnection)localObject1).getResponseCode() != 206) {
          continue;
        }
        a.b(this, "support range parameter,continue to download");
        ((RandomAccessFile)localObject3).seek(this.e);
        localObject4 = new java/io/BufferedInputStream;
        ((BufferedInputStream)localObject4).<init>(((HttpURLConnection)localObject1).getInputStream());
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        Object localObject1;
        Object localObject4;
        a.e(this, "download SocketTimeoutException ");
        this.k.a("下载过程中网络出现异常");
        continue;
        i1 = ((BufferedInputStream)localObject4).read((byte[])localObject2, 0, 10240);
        if (i1 != -1) {
          continue;
        }
        m localm = a;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localm.a(this, "Total downloadsize: " + this.i);
        this.h = true;
        ((BufferedInputStream)localObject4).close();
        ((RandomAccessFile)localObject3).close();
        continue;
      }
      catch (IOException localIOException)
      {
        Object localObject3;
        a.e(this, "download IOException " + localIOException.getMessage());
        this.k.a("下载过程中出现异常");
        continue;
        ((RandomAccessFile)localObject3).write((byte[])localObject2, 0, i1);
        this.g += i1;
        if (this.g <= this.f) {
          continue;
        }
        this.i += i1 - (this.g - this.f) + 1L;
        try
        {
          Thread.sleep(30L);
        }
        catch (InterruptedException localInterruptedException)
        {
          a.a(localInterruptedException);
          this.k.a("下载过程中出现异常");
        }
        continue;
      }
      catch (Exception localException)
      {
        int i1;
        a.e(this, "download error " + localException.getMessage());
        this.k.a("下载过程中出现异常");
        a.a(localException);
        continue;
        this.i += i1;
        continue;
      }
      if (this.g >= this.f) {
        continue;
      }
      if (!this.j.a) {
        continue;
      }
      return;
      a.a(this, "Proxy is null");
      localObject1 = (HttpURLConnection)this.c.openConnection();
      continue;
      if (this.e > 0L) {
        a.b(this, "don't support range parameter,download from beginning");
      }
      ((RandomAccessFile)localObject3).seek(0L);
      this.i = 0L;
      this.g = 0L;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */