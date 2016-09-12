package cn.dbox.core.d;

import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import java.io.File;
import java.util.Hashtable;
import java.util.Vector;

public class b
{
  private static Hashtable<String, Integer> A;
  private static Vector<String> B = new Vector();
  private static final int E = 5;
  private static final int F = 100;
  private static boolean L = true;
  private static boolean M = true;
  public static Hashtable<String, b> a;
  public static Hashtable<String, Integer> b;
  public static final String c = "typeCancel";
  public static final String d = "typeInstall";
  public static final String e = "actType";
  public static final String f = "appName";
  public static final String g = "appId";
  public static final String h = "notifyId";
  public static final String i = "downloadPath";
  public static final int j = 512;
  public static final int k = 513;
  public static final int l = 516;
  public static final int m = 0;
  public static final int n = 1;
  public static final int o = 2;
  private static cn.dbox.core.h.d p = new cn.dbox.core.h.d(b.class.getSimpleName());
  private static final int y = 1000;
  private static int z = 0;
  private final int C = 30;
  private int D = 0;
  private String G = "";
  private String H = "";
  private String I = "";
  private String J = null;
  private boolean K = false;
  private int N = 2;
  private PendingIntent O;
  private Handler P = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject2 = null;
      super.handleMessage(paramAnonymousMessage);
      if ((paramAnonymousMessage.what - b.a(b.this) < 5) && (paramAnonymousMessage.what != 100)) {}
      do
      {
        return;
        b.a(b.this, paramAnonymousMessage.what);
        b.b(b.this, paramAnonymousMessage.what);
        if (b.c())
        {
          b.e(b.this).setLatestEventInfo(b.b(b.this), b.c(b.this) + "正在下载", "已下载" + paramAnonymousMessage.what + "%", b.d(b.this));
          b.g(b.this).notify(b.f(b.this), b.e(b.this));
        }
      } while (b.h(b.this) != 100);
      b.d().a(b.class, b.c(b.this) + " download success");
      File localFile = new File(b.i(b.this));
      if (b.i(b.this).endsWith(".temp"))
      {
        b.a(b.this, b.i(b.this).substring(0, b.i(b.this).length() - ".temp".length()));
        paramAnonymousMessage = new File(b.i(b.this));
        b.d().a(b.class, b.c(b.this) + "FileName change to " + paramAnonymousMessage);
        localFile.renameTo(paramAnonymousMessage);
      }
      if (b.j(b.this) == 0)
      {
        localObject1 = BitmapFactory.decodeFile(localFile.getAbsolutePath());
        int i = 0;
        paramAnonymousMessage = null;
        while ((i < 2) && (paramAnonymousMessage == null))
        {
          paramAnonymousMessage = MediaStore.Images.Media.insertImage(b.b(b.this).getContentResolver(), (Bitmap)localObject1, localFile.getName(), localFile.getName());
          i++;
        }
        b.d().b("fetch picture ablum path " + paramAnonymousMessage);
        localObject1 = paramAnonymousMessage;
        if (paramAnonymousMessage == null)
        {
          b.d().b("insert " + localFile.getAbsolutePath() + " failed, change the resType to other");
          b.c(b.this, 1);
        }
      }
      for (Object localObject1 = paramAnonymousMessage;; localObject1 = null)
      {
        b.a.remove(b.k(b.this));
        if (b.l(b.this) != null) {
          b.l(b.this).a(b.i(b.this));
        }
        b.b(b.this, 0);
        if (!b.c()) {
          break;
        }
        b.e(b.this).icon = 17301634;
        b.e(b.this).tickerText = (b.c(b.this) + "下载完毕");
        b.e(b.this).flags = 16;
        if (b.m(b.this)) {
          if (b.j(b.this) == 0) {
            paramAnonymousMessage = b.b(b.this, (String)localObject1);
          }
        }
        for (;;)
        {
          b.a(b.this, PendingIntent.getActivity(b.b(b.this), b.f(b.this), paramAnonymousMessage, 134217728));
          b.e(b.this).setLatestEventInfo(b.b(b.this), b.c(b.this) + "下载完毕", "", b.d(b.this));
          b.g(b.this).notify(b.f(b.this), b.e(b.this));
          if ((b.n(b.this) == null) || (b.n(b.this).equalsIgnoreCase(cn.dbox.core.h.f.d(b.i(b.this))))) {
            break label815;
          }
          b.d().b(b.b(b.this), "md5 authorized failed");
          b.g(b.this).cancel(b.f(b.this));
          break;
          paramAnonymousMessage = new Intent();
          continue;
          paramAnonymousMessage = b.a(b.i(b.this));
        }
        label815:
        if (b.m(b.this)) {
          if (b.j(b.this) == 0) {
            paramAnonymousMessage = b.b(b.this, (String)localObject1);
          }
        }
        for (;;)
        {
          if (paramAnonymousMessage == null) {
            break label982;
          }
          paramAnonymousMessage.addFlags(268435456);
          b.b(b.this).startActivity(paramAnonymousMessage);
          break;
          new AlertDialog.Builder(b.o(b.this)).setTitle("确认").setMessage(b.c(b.this) + "已被下载到路径:" + b.i(b.this)).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          }).show();
          b.g(b.this).cancel(b.f(b.this));
          paramAnonymousMessage = (Message)localObject2;
          continue;
          paramAnonymousMessage = b.a(b.i(b.this));
        }
        label982:
        break;
      }
    }
  };
  private g Q;
  private Context q = null;
  private Context r = null;
  private Notification s = null;
  private NotificationManager t = null;
  private int u = 0;
  private int v = 0;
  private c w = null;
  private String x = "";
  
  static
  {
    a = new Hashtable();
    A = new Hashtable();
    b = new Hashtable();
  }
  
  private b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Context paramContext, int paramInt)
  {
    this.r = paramContext;
    this.q = paramContext.getApplicationContext();
    this.G = paramString1;
    this.H = paramString2;
    this.I = paramString3;
    if (paramInt != 2) {
      this.K = true;
    }
    this.N = paramInt;
    this.J = paramString5;
    p.a(b.class, "Start to download. appName: " + paramString2 + " pkgName: " + paramString4 + " fileName: " + paramString3);
    if (!A.containsKey(paramString3))
    {
      z += 1;
      A.put(paramString3, Integer.valueOf(z));
    }
    for (this.u = z;; this.u = ((Integer)A.get(paramString3)).intValue())
    {
      p.a(b.class, paramString2 + " notification_id is " + this.u);
      if (paramString4 != null)
      {
        b.put(paramString4, Integer.valueOf(this.u));
        B.add(paramString4);
        if (B.size() > 30)
        {
          p.a(b.class, "Remove " + (String)B.get(0) + " from AppPkgMapping");
          b.remove(B.get(0));
          B.remove(0);
        }
      }
      return;
      p.a(b.class, " notification_id for " + paramString3 + "already exists");
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, false, null);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    Object localObject = null;
    Uri localUri = Uri.parse(paramString1);
    String str3 = b(localUri.getHost() + localUri.getPath());
    String str1;
    if ((paramBoolean) && (paramString3 != null))
    {
      str1 = paramString3;
      str1 = new o(paramContext, str1, paramString1, paramBoolean, null).a();
      if (str1 != null) {
        break label125;
      }
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      return paramContext;
      str1 = str3;
      if (!paramBoolean) {
        break;
      }
      str1 = str3;
      if (paramString3 != null) {
        break;
      }
      String str2;
      try
      {
        str1 = localUri.getLastPathSegment();
      }
      catch (Error localError)
      {
        p.a(localError);
        str2 = str3;
      }
      break;
      label125:
      if (!paramBoolean)
      {
        p.a(b.class.getSimpleName(), paramString2 + "  exists");
        paramContext = a(str2);
      }
      else
      {
        p.a(b.class.getSimpleName(), paramString3 + "  exists");
        paramString1 = new Intent("android.intent.action.VIEW");
        paramString1.setDataAndType(Uri.parse(str2), "image/*");
        paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse(str2)));
        paramContext = paramString1;
      }
    }
  }
  
  static Intent a(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + paramString), "application/vnd.android.package-archive");
    return localIntent;
  }
  
  private void a(c paramc)
  {
    this.w = paramc;
  }
  
  private void a(String paramString, long paramLong)
  {
    p.b(this, "begin download in " + paramString);
    this.Q = new g(this.G, paramString, paramLong, new f()
    {
      public void a(int paramAnonymousInt)
      {
        b.p(b.this).sendEmptyMessage(paramAnonymousInt);
      }
      
      public void a(String paramAnonymousString)
      {
        b.d().c(b.this, b.c(b.this) + "下载线程出错，错误原因：" + paramAnonymousString);
        b.this.b();
        if (b.c()) {
          b.c(b.this, paramAnonymousString);
        }
        if (b.l(b.this) != null) {
          b.l(b.this).a(6, paramAnonymousString);
        }
      }
    }, this.q);
    this.Q.start();
    a.put(this.I, this);
  }
  
  public static void a(String paramString1, Context paramContext, c paramc, String paramString2)
  {
    a(paramString1, "", null, paramContext, paramc, null, false, paramString2, 1);
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext, c paramc, String paramString3, int paramInt)
  {
    a(paramString1, paramString2, null, paramContext, paramc, null, true, paramString3, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Context paramContext, c paramc)
  {
    a(paramString1, paramString2, paramString3, paramContext, paramc, null, L, null, 2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Context paramContext, c paramc, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramContext, paramc, paramString4, paramBoolean, null, 2);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, Context paramContext, c paramc, String paramString4, boolean paramBoolean, String paramString5, int paramInt)
  {
    p.a(b.class, "Download url: " + paramString1);
    Uri localUri = Uri.parse(paramString1);
    String str2 = localUri.getHost() + localUri.getPath();
    p.a(b.class, "Download uri path: " + localUri.getPath());
    p.a(b.class, "Download uri host: " + localUri.getHost());
    String str1 = "";
    if (paramInt != 2) {
      if (paramString5 != null) {}
    }
    for (;;)
    {
      try
      {
        paramString5 = localUri.getLastPathSegment();
        p.a(b.class, "Download filename(md5) " + paramString5);
        M = paramBoolean;
        if (!a.containsKey(paramString5)) {
          break label284;
        }
        paramc.a(512, "当前应用已在下载");
        p.a(b.class, "App " + paramString2 + " is downloading");
        return;
      }
      catch (Error paramString5)
      {
        p.a(paramString5);
        paramc.a(516, "当前文件的下载地址有误");
        paramString5 = str1;
        continue;
      }
      continue;
      paramString5 = b(str2);
      continue;
      label284:
      if (a.size() == 1000)
      {
        paramc.a(513, "最大下载数为1000个");
        p.a(b.class, "Maximum download number is 1000");
      }
      else
      {
        paramString1 = new b(paramString1, paramString2, paramString5, paramString3, paramString4, paramContext, paramInt);
        paramString1.a(paramc);
        if (M) {
          paramString1.e();
        }
        paramString1.h();
        paramc.a();
      }
    }
  }
  
  private static String b(String paramString)
  {
    return cn.dbox.core.h.f.c(paramString);
  }
  
  private void c(String paramString)
  {
    paramString = PendingIntent.getActivity(this.q, this.u, new Intent(), 134217728);
    this.s.icon = 17301624;
    this.s.tickerText = (this.H + "下载失败");
    this.s.setLatestEventInfo(this.q, this.H + "下载失败", "", paramString);
    this.s.flags = 16;
    this.t.notify(this.u, this.s);
  }
  
  private Intent d(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse(paramString), "image/*");
    this.r.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse(paramString)));
    return localIntent;
  }
  
  private void e()
  {
    this.s = new Notification();
    this.s.icon = 17301633;
    this.s.tickerText = (this.H + "正在下载，请稍候...");
    this.O = PendingIntent.getActivity(this.q, this.u, g(), 134217728);
    this.s.setLatestEventInfo(this.q, this.H + "正在下载，请稍候...", "", this.O);
    this.t = ((NotificationManager)this.q.getSystemService("notification"));
    f();
  }
  
  private void f()
  {
    this.t.notify(this.u, this.s);
  }
  
  private Intent g()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.q, d.class);
    localIntent.putExtra("appName", this.H);
    localIntent.putExtra("appId", this.I);
    localIntent.putExtra("actType", "typeCancel");
    localIntent.putExtra("ActivityType", 2);
    return localIntent;
  }
  
  private void h()
  {
    new o(this.q, this.I, this.G, this.K, new p()
    {
      public void a()
      {
        Log.e("DrwSDK", b.c(b.this) + "rom can't chmod");
        if (b.l(b.this) != null) {
          b.l(b.this).a(5, "sd卡不存在");
        }
        b.c(b.this, "sd卡不存在");
      }
      
      public void a(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        Log.e("DrwSDK", b.c(b.this) + "not enough size sdsize=" + paramAnonymousLong2 + " romsize=" + paramAnonymousLong3);
        if (b.l(b.this) != null) {
          b.l(b.this).a(1, "空间不足");
        }
        b.c(b.this, "空间不足");
      }
      
      public void a(String paramAnonymousString)
      {
        b.d().a(b.class, b.c(b.this) + " already exists in " + paramAnonymousString);
        b.a(b.this, paramAnonymousString);
        b.a(b.this, b.i(b.this), 0L);
      }
      
      public void b(String paramAnonymousString)
      {
        b.d().a(b.class, b.c(b.this) + " is download but not finished in " + paramAnonymousString);
        b.a(b.this, paramAnonymousString);
        paramAnonymousString = new File(b.i(b.this));
        b.a(b.this, b.i(b.this), paramAnonymousString.length());
      }
      
      public void c(String paramAnonymousString)
      {
        b.d().a(b.class, b.c(b.this) + " is  not download,it will download in " + paramAnonymousString);
        b.a(b.this, paramAnonymousString);
        b.a(b.this, b.i(b.this), 0L);
      }
      
      public void d(String paramAnonymousString)
      {
        Log.e("DrwSDK", b.c(b.this) + paramAnonymousString);
        if (b.l(b.this) != null) {
          b.l(b.this).a(5, b.c(b.this) + paramAnonymousString);
        }
        b.c(b.this, paramAnonymousString);
      }
    }).start();
  }
  
  public c a()
  {
    return this.w;
  }
  
  public void b()
  {
    p.a(b.class.getSimpleName(), "Stop download  and cancel notify if is UI mode " + this.u);
    if (this.Q != null) {
      this.Q.b();
    }
    this.t.cancel(this.u);
    a.remove(this.I);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */