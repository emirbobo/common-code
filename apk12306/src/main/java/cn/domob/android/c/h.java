package cn.domob.android.c;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import cn.domob.android.i.f;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

class h
  extends Thread
{
  protected static final String a = "/DomobResDownload/";
  static String b = "sd卡";
  static String c = "内存卡";
  protected static final String d = ".temp";
  static final int e = 2097152;
  static final int f = 5242880;
  private static f g = new f(h.class.getSimpleName());
  private static final String k = "/DomobAppDownload/";
  private i h = null;
  private Context i = null;
  private String j = "/DomobAppDownload/";
  private long l = 0L;
  private String m = "";
  private String n = "";
  private final String o = ".apk";
  private boolean p = false;
  private String q = "";
  private boolean r = true;
  private long s = -1L;
  
  protected h(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, i parami)
  {
    this.h = parami;
    this.i = paramContext;
    this.q = paramString2;
    if (paramInt == 3) {
      if (paramString1.contains("/"))
      {
        paramInt = paramString1.lastIndexOf("/");
        this.m = paramString1.substring(paramInt + 1);
        this.j = paramString1.substring(0, paramInt + 1);
        this.r = false;
      }
    }
    for (;;)
    {
      g.b(String.format("download path currentDownloadPath:%s storageName:%s", new Object[] { this.j, this.m }));
      return;
      if (paramBoolean)
      {
        this.m = paramString1;
        this.j = "/DomobResDownload/";
        this.r = false;
      }
      else
      {
        this.m = (paramString1 + ".apk");
        this.j = "/DomobAppDownload/";
        this.r = true;
      }
    }
  }
  
  private void b()
  {
    try
    {
      this.l = a(this.q);
      if (d()) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        g.a(localException);
        continue;
        if (c()) {}
      }
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
    boolean bool = false;
    String str1 = "";
    try
    {
      this.l = a(this.q);
      if (this.l == -1L)
      {
        this.h.d("连接下载地址信息错误");
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.h.d("连接下载地址错误");
      }
    }
    Object localObject1;
    long l1;
    int i1;
    if (e())
    {
      localObject1 = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l1 = ((StatFs)localObject1).getBlockSize() * ((StatFs)localObject1).getAvailableBlocks();
      g.a(this, "sd availaSize=" + l1 + "softsize=" + this.l);
      if (l1 > this.l + 2097152L)
      {
        localObject1 = Environment.getExternalStorageDirectory() + this.j;
        c((String)localObject1);
        i1 = 1;
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      String str3;
      if (i1 == 0)
      {
        localObject2 = localObject1;
        if (this.r)
        {
          localObject1 = new StatFs(Environment.getDataDirectory().getPath());
          long l2 = ((StatFs)localObject1).getBlockSize() * ((StatFs)localObject1).getAvailableBlocks();
          g.b(this, "rom" + l2);
          if (l2 < this.l + 5242880L)
          {
            this.h.a(this.l, l1, l2);
            break;
            if (this.r) {
              break label513;
            }
            this.h.a(this.l, l1, 0L);
            break;
            if (this.r) {
              break label506;
            }
            this.h.b();
            break;
          }
          localObject2 = this.i.getFilesDir().getAbsolutePath() + this.j;
          c((String)localObject2);
          localObject1 = new File((String)localObject2);
          str3 = "chmod 777 " + ((File)localObject1).getAbsolutePath();
          localObject1 = Runtime.getRuntime();
        }
      }
      try
      {
        i1 = ((Runtime)localObject1).exec(str3).waitFor();
        if (i1 != 0) {
          break label468;
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
      label468:
      this.h.a();
      break;
      label506:
      l1 = 0L;
      i1 = 0;
      continue;
      label513:
      String str2 = "";
      i1 = 0;
    }
  }
  
  private static boolean c(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject1 = g;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((f)localObject1).b("try to create a directory " + paramString);
        try
        {
          localObject1 = new java/io/File;
          ((File)localObject1).<init>(paramString);
          if (((File)localObject1).exists()) {
            continue;
          }
          int i1 = 1;
          if ((!((File)localObject1).mkdirs()) && (i1 <= 3) && (!((File)localObject1).exists()))
          {
            g.d(String.format("the %d time to create a directory failed, %s ", new Object[] { Integer.valueOf(i1), paramString }));
            i1++;
            continue;
          }
          if ((i1 > 3) && (!((File)localObject1).exists())) {
            g.e(String.format("hava tried %d times to create a directory failed, %s ", new Object[] { Integer.valueOf(i1), paramString }));
          }
        }
        catch (Exception paramString)
        {
          g.a(paramString);
          continue;
        }
        return true;
      }
      finally {}
      Object localObject2 = g;
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((f)localObject2).b("the directory is exist, so no need to create again " + paramString);
    }
  }
  
  private boolean d()
  {
    boolean bool1 = true;
    this.n = (Environment.getExternalStorageDirectory() + this.j + this.m);
    g.a(this, "downloadPath: " + this.n);
    if (b(this.n)) {}
    for (;;)
    {
      return bool1;
      this.n = (this.i.getFilesDir().getAbsolutePath() + this.j + this.m);
      boolean bool2 = b(this.n);
      if (!bool2)
      {
        if (!bool2) {
          g.b("Local test results are not downloaded resources");
        }
        bool1 = false;
      }
    }
  }
  
  private static boolean e()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  protected long a(String paramString)
    throws Exception
  {
    long l1;
    if (this.s > 0L)
    {
      this.h.a(this.s);
      l1 = this.s;
    }
    for (;;)
    {
      return l1;
      paramString = new URL(paramString);
      Proxy localProxy = d.b(this.i);
      if (localProxy != null) {}
      for (paramString = (HttpURLConnection)paramString.openConnection(localProxy);; paramString = (HttpURLConnection)paramString.openConnection())
      {
        paramString.setRequestMethod("HEAD");
        int i1 = paramString.getResponseCode();
        if ((i1 < 200) || (i1 >= 300)) {
          break label129;
        }
        this.s = paramString.getContentLength();
        this.h.a(this.s);
        l1 = this.s;
        break;
      }
      label129:
      l1 = -1L;
    }
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */