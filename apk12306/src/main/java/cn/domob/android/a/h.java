package cn.domob.android.a;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import cn.domob.android.offerwall.m;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

class h
  extends Thread
{
  static String a = "sd卡";
  static String b = "内存卡";
  protected static final String c = ".temp";
  static final int d = 2097152;
  static final int e = 5242880;
  private static m f = new m(h.class.getSimpleName());
  private static final String i = "/DomobOfferWallAppDownload/";
  private i g = null;
  private Context h = null;
  private long j = 0L;
  private String k = "";
  private String l = "";
  private final String m = ".apk";
  private boolean n = false;
  private String o = "";
  
  protected h(Context paramContext, String paramString1, String paramString2, i parami)
  {
    this.g = parami;
    this.h = paramContext;
    this.o = paramString2;
    this.k = (paramString1 + ".apk");
  }
  
  private long a(String paramString)
    throws Exception
  {
    paramString = new URL(paramString);
    Proxy localProxy = e.b(this.h);
    if (localProxy != null)
    {
      paramString = (HttpURLConnection)paramString.openConnection(localProxy);
      paramString.setRequestMethod("HEAD");
      int i1 = paramString.getResponseCode();
      if ((i1 < 200) || (i1 >= 300)) {
        break label77;
      }
    }
    label77:
    for (long l1 = paramString.getContentLength();; l1 = -1L)
    {
      return l1;
      paramString = (HttpURLConnection)paramString.openConnection();
      break;
    }
  }
  
  private void b()
  {
    if (d()) {}
    for (;;)
    {
      return;
      if (!c()) {}
    }
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = true;
    File localFile2 = new File(paramString);
    File localFile1 = new File(paramString + ".temp");
    boolean bool1;
    if (localFile2.exists())
    {
      bool1 = bool2;
      if (this.g != null)
      {
        this.g.a(paramString);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      if (localFile1.exists())
      {
        f.b(this, paramString + "　download size=" + localFile1.length() + " " + "softSize:" + this.j);
        this.n = true;
        bool1 = bool2;
        if (this.g != null)
        {
          this.g.b(paramString + ".temp");
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  private boolean c()
  {
    Object localObject1 = "";
    long l1 = 0L;
    try
    {
      this.j = a(this.o);
      if (!e()) {
        break label437;
      }
      localObject2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l2 = ((StatFs)localObject2).getBlockSize() * ((StatFs)localObject2).getAvailableBlocks();
      f.a(this, "sd availaSize=" + l2 + "softsize=" + this.j);
      l1 = l2;
      if (l2 <= this.j + 2097152L) {
        break label437;
      }
      localObject1 = Environment.getExternalStorageDirectory() + "/DomobOfferWallAppDownload/";
      c((String)localObject1);
      i1 = 1;
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        this.g.d("连接下载地址错误");
        boolean bool = false;
        continue;
        String str = this.h.getFilesDir().getAbsolutePath() + "/DomobOfferWallAppDownload/";
        c(str);
        Object localObject2 = new File(str);
        localObject2 = "chmod 777 " + ((File)localObject2).getAbsolutePath();
        Runtime localRuntime = Runtime.getRuntime();
        try
        {
          i1 = localRuntime.exec((String)localObject2).waitFor();
          if (i1 != 0) {
            break label396;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            f.a(localIOException);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            f.a(localInterruptedException);
          }
        }
        this.g.c(str + this.k + ".temp");
        bool = true;
        continue;
        this.g.a();
        bool = false;
        continue;
        int i1 = 0;
      }
    }
    if (i1 == 0)
    {
      localObject1 = new StatFs(Environment.getDataDirectory().getPath());
      l2 = ((StatFs)localObject1).getBlockSize() * ((StatFs)localObject1).getAvailableBlocks();
      f.b(this, "rom" + l2);
      if (l2 < this.j + 5242880L)
      {
        this.g.a(this.j, l1, l2);
        bool = false;
        return bool;
      }
    }
  }
  
  private boolean c(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (boolean bool = paramString.mkdirs();; bool = true) {
      return bool;
    }
  }
  
  private boolean d()
  {
    boolean bool = true;
    this.l = (Environment.getExternalStorageDirectory() + "/DomobOfferWallAppDownload/" + this.k);
    f.a(this, "downloadPath: " + this.l);
    if (b(this.l)) {}
    for (;;)
    {
      return bool;
      this.l = (this.h.getFilesDir().getAbsolutePath() + "/DomobOfferWallAppDownload/" + this.k);
      if (!b(this.l)) {
        bool = false;
      }
    }
  }
  
  private static boolean e()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  protected String a()
  {
    Object localObject2 = null;
    f.b(this, "app is download:" + d() + " " + "is not complete:" + this.n);
    Object localObject1 = localObject2;
    if (d()) {
      if (!this.n) {
        break label70;
      }
    }
    label70:
    for (localObject1 = localObject2;; localObject1 = this.l) {
      return (String)localObject1;
    }
  }
  
  public final void run()
  {
    b();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */