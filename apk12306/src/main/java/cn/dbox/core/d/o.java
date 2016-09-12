package cn.dbox.core.d;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import cn.dbox.core.h.d;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

class o
  extends Thread
{
  protected static final String a = "/DrwResDownload/";
  static String b = "sd卡";
  static String c = "内存卡";
  protected static final String d = ".temp";
  static final int e = 2097152;
  static final int f = 5242880;
  private static d g = new d(o.class.getSimpleName());
  private static final String k = "/DrwAppDownload/";
  private p h = null;
  private Context i = null;
  private String j = "/DrwAppDownload/";
  private long l = 0L;
  private String m = "";
  private String n = "";
  private final String o = ".apk";
  private boolean p = false;
  private String q = "";
  private boolean r = true;
  
  protected o(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, p paramp)
  {
    this.h = paramp;
    this.i = paramContext;
    this.q = paramString2;
    if (paramBoolean)
    {
      this.m = paramString1;
      this.j = "/DrwResDownload/";
    }
    for (this.r = false;; this.r = true)
    {
      return;
      this.m = (paramString1 + ".apk");
      this.j = "/DrwAppDownload/";
    }
  }
  
  private long a(String paramString)
    throws Exception
  {
    paramString = new URL(paramString);
    Proxy localProxy = h.b(this.i);
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
      if (this.h != null)
      {
        this.h.a(paramString);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      if (localFile1.exists())
      {
        g.b(this, paramString + "　download size=" + localFile1.length() + " " + "softSize:" + this.l);
        this.p = true;
        bool1 = bool2;
        if (this.h != null)
        {
          this.h.b(paramString + ".temp");
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
    String str = "";
    long l1 = 0L;
    boolean bool;
    try
    {
      this.l = a(this.q);
      if (this.l != -1L) {
        break label62;
      }
      this.h.d("连接下载地址信息错误");
      bool = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.h.d("连接下载地址错误");
        bool = false;
      }
    }
    return bool;
    label62:
    Object localObject2;
    long l2;
    Object localObject1;
    int i1;
    if (e())
    {
      localObject2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l2 = ((StatFs)localObject2).getBlockSize() * ((StatFs)localObject2).getAvailableBlocks();
      g.a(this, "sd availaSize=" + l2 + "softsize=" + this.l);
      l1 = l2;
      if (l2 > this.l + 2097152L)
      {
        localObject1 = Environment.getExternalStorageDirectory() + this.j;
        c((String)localObject1);
        i1 = 1;
        l1 = l2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      Runtime localRuntime;
      if (i1 == 0)
      {
        localObject2 = localObject1;
        if (this.r)
        {
          localObject1 = new StatFs(Environment.getDataDirectory().getPath());
          l2 = ((StatFs)localObject1).getBlockSize() * ((StatFs)localObject1).getAvailableBlocks();
          g.b(this, "rom" + l2);
          if (l2 < this.l + 5242880L)
          {
            this.h.a(this.l, l1, l2);
            bool = false;
            break;
          }
          localObject2 = this.i.getFilesDir().getAbsolutePath() + this.j;
          c((String)localObject2);
          localObject1 = new File((String)localObject2);
          localObject1 = "chmod 777 " + ((File)localObject1).getAbsolutePath();
          localRuntime = Runtime.getRuntime();
        }
      }
      try
      {
        i1 = localRuntime.exec((String)localObject1).waitFor();
        if (i1 != 0) {
          break label438;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          g.a(localIOException);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          g.a(localInterruptedException);
        }
      }
      this.h.c((String)localObject2 + this.m + ".temp");
      bool = true;
      break;
      label438:
      this.h.a();
      bool = false;
      break;
      i1 = 0;
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
    this.n = (Environment.getExternalStorageDirectory() + this.j + this.m);
    g.a(this, "downloadPath: " + this.n);
    if (b(this.n)) {}
    for (;;)
    {
      return bool;
      this.n = (this.i.getFilesDir().getAbsolutePath() + this.j + this.m);
      if (!b(this.n)) {
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
    g.b(this, "app is download:" + d() + " " + "is not complete:" + this.p);
    Object localObject1 = localObject2;
    if (d()) {
      if (!this.p) {
        break label70;
      }
    }
    label70:
    for (localObject1 = localObject2;; localObject1 = this.n) {
      return (String)localObject1;
    }
  }
  
  public final void run()
  {
    b();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */