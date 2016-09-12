package cn.domob.android.ads;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import cn.domob.android.c.a;
import cn.domob.android.c.b;
import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.io.UnsupportedEncodingException;

public class q
{
  public static final String b = "url";
  public static final String c = "auto_run";
  public static final String d = "name";
  public static final String e = "pkg";
  public static final String f = "vc";
  public static final String g = "vn";
  public static final int h = 1;
  public static final String i = "alreadyDownload:";
  f a = new f(q.class.getSimpleName());
  private Context j;
  private Uri k;
  private j l;
  private String m;
  private boolean n = false;
  private String o;
  private String p;
  private int q;
  private String r;
  private String s;
  private a t;
  
  public q(Context paramContext, Uri paramUri, j paramj, a parama)
  {
    this.j = paramContext;
    this.k = paramUri;
    this.l = paramj;
    this.t = parama;
  }
  
  q(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, C paramC)
  {
    this(paramContext, paramString1, paramString2, paramString3, paramInt, paramString4, null, paramC);
  }
  
  q(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, C paramC)
  {
    this.j = paramContext;
    this.m = paramString1;
    this.o = paramString2;
    this.p = paramString3;
    this.q = paramInt;
    this.r = paramString4;
    this.s = paramString5;
    this.t = paramC;
  }
  
  private String a(Uri paramUri, String paramString)
    throws UnsupportedEncodingException
  {
    paramUri = paramUri.getQueryParameter(paramString);
    if (paramUri != null) {}
    for (;;)
    {
      return paramUri;
      paramUri = null;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    a.a(paramString1, paramString2, paramContext, new b()
    {
      public void a() {}
      
      public void a(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void a(String paramAnonymousString) {}
      
      public void a(String paramAnonymousString, long paramAnonymousLong) {}
      
      public void b() {}
      
      public void b(String paramAnonymousString, long paramAnonymousLong) {}
    }, paramString2, paramInt);
  }
  
  private void j()
  {
    for (;;)
    {
      try
      {
        this.m = a(this.k, "url");
        if (a(this.k, "auto_run") == null)
        {
          bool = false;
          this.n = bool;
          this.o = a(this.k, "name");
          this.p = a(this.k, "pkg");
          if (a(this.k, "vc") != null) {
            continue;
          }
          i1 = 1;
          this.q = i1;
          this.r = a(this.k, "vn");
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        boolean bool;
        int i1;
        this.a.e("Error happened in getting download info");
        continue;
      }
      bool = Boolean.valueOf(a(this.k, "auto_run")).booleanValue();
      continue;
      i1 = Integer.valueOf(a(this.k, "vc")).intValue();
    }
  }
  
  private void k()
  {
    this.a.b("Start Download url:" + this.m);
    a.a(this.m, this.o, this.p, this.j, new b()
    {
      public void a()
      {
        Toast.makeText(q.b(q.this), "开始下载 。。。", 0).show();
        if (q.a(q.this) != null) {
          q.a(q.this).e(q.this);
        }
      }
      
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        if (q.a(q.this) != null)
        {
          if (paramAnonymousInt != 512) {
            break label34;
          }
          q.a(q.this).g(q.this);
        }
        for (;;)
        {
          return;
          label34:
          if (paramAnonymousInt == 513) {
            q.a(q.this).h(q.this);
          } else {
            q.a(q.this).d(q.this);
          }
        }
      }
      
      public void a(String paramAnonymousString)
      {
        if (q.a(q.this) != null) {
          q.a(q.this).i(q.this);
        }
      }
      
      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        if (q.a(q.this) != null) {
          q.a(q.this).c(q.this);
        }
        if (q.a(q.this) != null) {
          q.a(q.this).j(q.this);
        }
      }
      
      public void b()
      {
        if (q.a(q.this) != null) {
          q.a(q.this).f(q.this);
        }
      }
      
      public void b(String paramAnonymousString, long paramAnonymousLong) {}
    }, this.s, true);
  }
  
  public j a()
  {
    return this.l;
  }
  
  public String b()
  {
    return this.o;
  }
  
  public String c()
  {
    return this.p;
  }
  
  public int d()
  {
    return this.q;
  }
  
  public String e()
  {
    return this.r;
  }
  
  public boolean f()
  {
    return this.n;
  }
  
  public String g()
  {
    return this.m;
  }
  
  public Uri h()
  {
    return this.k;
  }
  
  public void i()
  {
    if (this.k != null) {
      j();
    }
    final Intent localIntent;
    if (this.m.startsWith("alreadyDownload:"))
    {
      localIntent = a.a(this.m.substring("alreadyDownload:".length()));
      if (localIntent != null)
      {
        localIntent.addFlags(268435456);
        if (this.t != null) {
          this.t.j(this);
        }
        this.j.startActivity(localIntent);
      }
    }
    for (;;)
    {
      return;
      if (h.e(this.o)) {
        this.o = "应用";
      }
      localIntent = a.a(this.j, this.m, this.o);
      if (localIntent != null)
      {
        if (this.j != null) {
          new AlertDialog.Builder(this.j).setTitle("安装").setMessage(this.o + "已经下载是否现在安装?").setNegativeButton("否", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }).setPositiveButton("是", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              if (q.a(q.this) != null) {
                q.a(q.this).j(q.this);
              }
              q.b(q.this).startActivity(localIntent);
            }
          }).show();
        }
      }
      else {
        k();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(q paramq);
    
    public abstract void d(q paramq);
    
    public abstract void e(q paramq);
    
    public abstract void f(q paramq);
    
    public abstract void g(q paramq);
    
    public abstract void h(q paramq);
    
    public abstract void i(q paramq);
    
    public abstract void j(q paramq);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */