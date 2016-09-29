package cn.domob.android.c;

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
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import cn.domob.android.ads.DomobActivity;
import cn.domob.android.i.d;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
{
  private static final int A = 1000;
  private static int B = 0;
  private static Hashtable<String, Integer> C;
  private static Vector<String> D = new Vector();
  private static final int G = 5;
  private static final int H = 100;
  private static boolean N = true;
  private static ExecutorService R;
  private static final int S = 5;
  public static Hashtable<String, a> a;
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
  public static final int p = 3;
  public static final int q = -1;
  private static cn.domob.android.i.f r = new cn.domob.android.i.f(a.class.getSimpleName());
  private static Context s = null;
  private static Context t = null;
  private final int E = 30;
  private int F = 0;
  private String I = "";
  private String J = "";
  private String K = "";
  private String L = null;
  private boolean M = false;
  private boolean O = false;
  private long P = -1L;
  private int Q = 2;
  private PendingIntent T;
  private Handler U = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject2 = null;
      super.handleMessage(paramAnonymousMessage);
      if ((paramAnonymousMessage.what - a.a(a.this) < 5) && (paramAnonymousMessage.what != 100)) {}
      do
      {
        return;
        a.a(a.this, paramAnonymousMessage.what);
        a.b(a.this, paramAnonymousMessage.what);
        if (a.b(a.this))
        {
          a.e(a.this).setLatestEventInfo(a.b(), a.c(a.this) + "正在下载", "已下载" + paramAnonymousMessage.what + "%", a.d(a.this));
          a.g(a.this).notify(a.f(a.this), a.e(a.this));
        }
      } while (a.h(a.this) != 100);
      a.c().a(a.class, a.c(a.this) + " download success");
      File localFile = new File(a.i(a.this));
      if (a.i(a.this).endsWith(".temp"))
      {
        a.a(a.this, a.i(a.this).substring(0, a.i(a.this).length() - ".temp".length()));
        paramAnonymousMessage = new File(a.i(a.this));
        a.c().a(a.class, a.c(a.this) + "FileName change to " + paramAnonymousMessage);
        localFile.renameTo(paramAnonymousMessage);
      }
      if (a.j(a.this) == 0)
      {
        localObject1 = BitmapFactory.decodeFile(localFile.getAbsolutePath());
        int i = 0;
        paramAnonymousMessage = null;
        while ((i < 2) && (paramAnonymousMessage == null))
        {
          paramAnonymousMessage = MediaStore.Images.Media.insertImage(a.b().getContentResolver(), (Bitmap)localObject1, localFile.getName(), localFile.getName());
          i++;
        }
        a.c().b("fetch picture ablum path " + paramAnonymousMessage);
        localObject1 = paramAnonymousMessage;
        if (paramAnonymousMessage == null)
        {
          a.c().b("insert " + localFile.getAbsolutePath() + " failed, change the resType to other");
          a.c(a.this, 1);
        }
      }
      for (Object localObject1 = paramAnonymousMessage;; localObject1 = null)
      {
        a.a.remove(a.k(a.this));
        if (a.l(a.this) != null) {
          a.l(a.this).a(a.i(a.this), a.m(a.this));
        }
        a.b(a.this, 0);
        if (!a.b(a.this)) {
          break;
        }
        a.e(a.this).icon = 17301634;
        a.e(a.this).tickerText = (a.c(a.this) + "下载完毕");
        a.e(a.this).flags = 16;
        if (a.n(a.this)) {
          if (a.j(a.this) == 0) {
            paramAnonymousMessage = a.c((String)localObject1);
          }
        }
        for (;;)
        {
          a.a(a.this, PendingIntent.getActivity(a.b(), a.f(a.this), paramAnonymousMessage, 134217728));
          a.e(a.this).setLatestEventInfo(a.b(), a.c(a.this) + "下载完毕", "", a.d(a.this));
          a.g(a.this).notify(a.f(a.this), a.e(a.this));
          if ((a.o(a.this) == null) || (a.o(a.this).equalsIgnoreCase(d.a(a.i(a.this))))) {
            break label825;
          }
          a.l(a.this).a(a.k(a.this));
          a.c().b(a.b(), "md5 authorized failed");
          a.g(a.this).cancel(a.f(a.this));
          break;
          paramAnonymousMessage = new Intent();
          continue;
          paramAnonymousMessage = a.a(a.i(a.this));
        }
        label825:
        if (a.n(a.this)) {
          if (a.j(a.this) == 0) {
            paramAnonymousMessage = a.c((String)localObject1);
          }
        }
        for (;;)
        {
          if (paramAnonymousMessage == null) {
            break label980;
          }
          paramAnonymousMessage.addFlags(268435456);
          a.b().startActivity(paramAnonymousMessage);
          break;
          new AlertDialog.Builder(a.d()).setTitle("确认").setMessage(a.c(a.this) + "已被下载到路径:" + a.i(a.this)).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          }).show();
          a.g(a.this).cancel(a.f(a.this));
          paramAnonymousMessage = (Message)localObject2;
          continue;
          paramAnonymousMessage = a.a(a.i(a.this));
        }
        label980:
        break;
      }
    }
  };
  private f V;
  private Notification u = null;
  private NotificationManager v = null;
  private int w = 0;
  private int x = 0;
  private b y = null;
  private String z = "";
  
  static
  {
    B = 0;
    a = new Hashtable();
    C = new Hashtable();
    b = new Hashtable();
  }
  
  private a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Context paramContext, int paramInt, boolean paramBoolean)
  {
    t = paramContext;
    s = paramContext.getApplicationContext();
    this.O = paramBoolean;
    this.I = paramString1;
    this.J = paramString2;
    this.K = paramString3;
    if (paramInt != 2) {
      this.M = true;
    }
    this.Q = paramInt;
    this.L = paramString5;
    r.a(a.class, "Start to download. appName: " + paramString2 + " pkgName: " + paramString4 + " fileName: " + paramString3);
    if (!C.containsKey(paramString3))
    {
      B += 1;
      C.put(paramString3, Integer.valueOf(B));
    }
    for (this.w = B;; this.w = ((Integer)C.get(paramString3)).intValue())
    {
      r.a(a.class, paramString2 + " notification_id is " + this.w);
      if (paramString4 != null)
      {
        b.put(paramString4, Integer.valueOf(this.w));
        D.add(paramString4);
        if (D.size() > 30)
        {
          r.a(a.class, "Remove " + (String)D.get(0) + " from AppPkgMapping");
          b.remove(D.get(0));
          D.remove(0);
        }
      }
      i();
      return;
      r.a(a.class, " notification_id for " + paramString3 + "already exists");
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
      paramContext = new h(paramContext, str1, paramString1, paramBoolean, -1, null).a();
      if (paramContext != null) {
        break label124;
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
      try
      {
        str1 = localUri.getLastPathSegment();
      }
      catch (Error localError)
      {
        r.a(localError);
        String str2 = str3;
      }
      break;
      label124:
      if (!paramBoolean)
      {
        r.a(a.class.getSimpleName(), paramString2 + "  exists");
        paramContext = a(paramContext);
      }
      else
      {
        r.a(a.class.getSimpleName(), paramString3 + "  exists");
        paramContext = e(paramContext);
      }
    }
  }
  
  public static Intent a(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + paramString), "application/vnd.android.package-archive");
    return localIntent;
  }
  
  public static void a(int paramInt)
  {
    try
    {
      Iterator localIterator = a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)((Map.Entry)localIterator.next()).getKey();
        localObject = (a)a.get(localObject);
        if (((a)localObject).Q == paramInt)
        {
          ((a)localObject).a(false);
          localIterator.remove();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      r.a(localException);
    }
  }
  
  private void a(b paramb)
  {
    this.y = paramb;
  }
  
  private void a(String paramString, long paramLong)
  {
    r.b(this, "begin download in " + paramString);
    this.V = new f(this.I, paramString, paramLong, new c()
    {
      public void a(int paramAnonymousInt)
      {
        a.p(a.this).sendEmptyMessage(paramAnonymousInt);
      }
      
      public void a(String paramAnonymousString)
      {
        a.c().c(a.this, a.c(a.this) + "下载线程出错，错误原因：" + paramAnonymousString + "; fileName: " + a.k(a.this));
        a.this.a(true);
        a.b(a.this, paramAnonymousString);
        if (a.l(a.this) != null) {
          a.l(a.this).a(6, paramAnonymousString);
        }
      }
    }, s);
    if ((R != null) && (!a.containsKey(this.K)))
    {
      a.put(this.K, this);
      R.execute(this.V);
    }
  }
  
  public static void a(String paramString1, Context paramContext, b paramb, String paramString2)
  {
    a(paramString1, "", null, paramContext, paramb, null, false, paramString2, 1);
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext, b paramb, String paramString3, int paramInt)
  {
    a(paramString1, paramString2, null, paramContext, paramb, null, true, paramString3, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Context paramContext, b paramb)
  {
    a(paramString1, paramString2, paramString3, paramContext, paramb, null, N, null, 2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Context paramContext, b paramb, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramContext, paramb, paramString4, paramBoolean, null, 2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Context paramContext, b paramb, String paramString4, boolean paramBoolean, String paramString5, int paramInt)
  {
    r.a(a.class, "Download url: " + paramString1);
    Uri localUri = Uri.parse(paramString1);
    String str2 = localUri.getHost() + localUri.getPath();
    r.a(a.class, "Download uri path: " + localUri.getPath());
    r.a(a.class, "Download uri host: " + localUri.getHost());
    String str1 = "";
    if (paramInt != 2) {
      if (paramString5 != null) {}
    }
    for (;;)
    {
      try
      {
        paramString5 = localUri.getLastPathSegment();
        r.a(a.class, "Download filename(md5) " + paramString5);
        if (!a.containsKey(paramString5)) {
          break label297;
        }
        paramb.a(512, "当前应用已在下载,fileName: " + paramString5);
        r.a(a.class, "App " + paramString2 + " is downloading");
        return;
      }
      catch (Error paramString5)
      {
        r.a(paramString5);
        paramb.a(516, "当前文件的下载地址有误");
        paramString5 = str1;
        continue;
      }
      continue;
      paramString5 = b(str2);
      continue;
      label297:
      if (a.size() == 1000)
      {
        paramb.a(513, "最大下载数为1000个");
        r.a(a.class, "Maximum download number is 1000");
      }
      else
      {
        paramString1 = new a(paramString1, paramString2, paramString5, paramString3, paramString4, paramContext, paramInt, paramBoolean);
        paramString1.a(paramb);
        if (paramBoolean) {
          paramString1.e();
        }
        paramString1.h();
        paramb.a();
      }
    }
  }
  
  public static String b(String paramString)
  {
    return d.b(paramString);
  }
  
  private void d(String paramString)
  {
    if (!this.O) {}
    for (;;)
    {
      return;
      paramString = PendingIntent.getActivity(s, this.w, new Intent(), 134217728);
      this.u.icon = 17301624;
      this.u.tickerText = (this.J + "下载失败");
      this.u.setLatestEventInfo(s, this.J + "下载失败", "", paramString);
      this.u.flags = 16;
      this.v.notify(this.w, this.u);
    }
  }
  
  private static Intent e(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse(paramString), "image/*");
    t.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse(paramString)));
    return localIntent;
  }
  
  private void e()
  {
    this.u = new Notification();
    this.u.icon = 17301633;
    this.u.tickerText = (this.J + "正在下载，请稍候...");
    this.T = PendingIntent.getActivity(s, this.w, g(), 134217728);
    this.u.setLatestEventInfo(s, this.J + "正在下载，请稍候...", "", this.T);
    this.v = ((NotificationManager)s.getSystemService("notification"));
    f();
  }
  
  private void f()
  {
    this.v.notify(this.w, this.u);
  }
  
  private Intent g()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(s, DomobActivity.class);
    localIntent.putExtra("appName", this.J);
    localIntent.putExtra("appId", this.K);
    localIntent.putExtra("actType", "typeCancel");
    localIntent.putExtra("DomobActivityType", 2);
    return localIntent;
  }
  
  private void h()
  {
    new h(s, this.K, this.I, this.M, this.Q, new i()
    {
      public void a()
      {
        Log.e(cn.domob.android.i.f.b(), a.c(a.this) + "rom can't chmod");
        if (a.l(a.this) != null) {
          a.l(a.this).a(5, "sd卡不存在");
        }
        a.b(a.this, "sd卡不存在");
      }
      
      public void a(long paramAnonymousLong)
      {
        if (paramAnonymousLong <= 0L) {}
        for (;;)
        {
          return;
          a.a(a.this, paramAnonymousLong);
        }
      }
      
      public void a(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        Log.e(cn.domob.android.i.f.b(), a.c(a.this) + "not enough size sdsize=" + paramAnonymousLong2 + " romsize=" + paramAnonymousLong3);
        if (a.l(a.this) != null) {
          a.l(a.this).a(1, "空间不足");
        }
        a.b(a.this, "空间不足");
      }
      
      public void a(String paramAnonymousString)
      {
        a.c().a(a.class, a.c(a.this) + " already exists in " + paramAnonymousString);
        if (a.j(a.this) == 3) {
          if (a.l(a.this) != null) {
            a.l(a.this).b(paramAnonymousString, a.m(a.this));
          }
        }
        for (;;)
        {
          return;
          a.a(a.this, paramAnonymousString);
          a.a(a.this, a.i(a.this), 0L);
        }
      }
      
      public void b()
      {
        if (a.l(a.this) != null) {
          a.l(a.this).a(7, "sd卡不存在");
        }
        a.b(a.this, "sd卡不存在");
      }
      
      public void b(String paramAnonymousString)
      {
        a.c().a(a.class, a.c(a.this) + " is download but not finished in " + paramAnonymousString);
        a.a(a.this, paramAnonymousString);
        paramAnonymousString = new File(a.i(a.this));
        a.a(a.this, a.i(a.this), paramAnonymousString.length());
      }
      
      public void c(String paramAnonymousString)
      {
        a.c().a(a.class, a.c(a.this) + " is  not download,it will download in " + paramAnonymousString);
        a.a(a.this, paramAnonymousString);
        a.a(a.this, a.i(a.this), 0L);
      }
      
      public void d(String paramAnonymousString)
      {
        Log.e(cn.domob.android.i.f.b(), a.c(a.this) + paramAnonymousString);
        if (a.l(a.this) != null) {
          a.l(a.this).a(5, a.c(a.this) + paramAnonymousString + "filename: " + a.k(a.this));
        }
        a.b(a.this, paramAnonymousString);
      }
    }).start();
  }
  
  private void i()
  {
    if (R == null) {
      R = Executors.newFixedThreadPool(5);
    }
  }
  
  public b a()
  {
    return this.y;
  }
  
  public void a(boolean paramBoolean)
  {
    r.a(a.class.getSimpleName(), "Stop download  and cancel notify if is UI mode " + this.w);
    if (this.V != null) {
      this.V.b();
    }
    if (this.O) {
      this.v.cancel(this.w);
    }
    if (paramBoolean) {
      a.remove(this.K);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */