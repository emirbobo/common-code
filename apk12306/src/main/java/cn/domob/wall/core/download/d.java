package cn.domob.wall.core.download;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.h.f;
import java.io.UnsupportedEncodingException;

public class d
{
  public static final int b = 1;
  private static final String n = "url";
  private static final String o = "auto_run";
  private static final String p = "name";
  private static final String q = "pkg";
  private static final String r = "vc";
  private static final String s = "vn";
  cn.domob.wall.core.h.d a = new cn.domob.wall.core.h.d(d.class.getSimpleName());
  private Context c;
  private Uri d;
  private String e;
  private boolean f = false;
  private String g;
  private String h;
  private int i;
  private String j;
  private String k;
  private a l;
  private AdInfo m;
  
  public d(Context paramContext, Uri paramUri, AdInfo paramAdInfo, a parama)
  {
    this.c = paramContext;
    this.m = paramAdInfo;
    this.l = parama;
    this.d = paramUri;
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
  
  private void h()
  {
    for (;;)
    {
      try
      {
        this.e = a(this.d, "url");
        if (a(this.d, "auto_run") == null)
        {
          bool = false;
          this.f = bool;
          this.g = a(this.d, "name");
          this.h = a(this.d, "pkg");
          if (a(this.d, "vc") != null) {
            continue;
          }
          i1 = 1;
          this.i = i1;
          this.j = a(this.d, "vn");
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
      bool = Boolean.valueOf(a(this.d, "auto_run")).booleanValue();
      continue;
      i1 = Integer.valueOf(a(this.d, "vc")).intValue();
    }
  }
  
  private void i()
  {
    this.a.b("Start Download url:" + this.e);
    b.a(this.e, this.g, this.h, this.c, new c()
    {
      public void a()
      {
        Toast.makeText(d.c(d.this), "开始下载 。。。", 0).show();
        if (d.a(d.this) != null) {
          d.a(d.this).o(d.b(d.this));
        }
      }
      
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        if (d.a(d.this) != null)
        {
          if (paramAnonymousInt != 512) {
            break label37;
          }
          d.a(d.this).q(d.b(d.this));
        }
        for (;;)
        {
          return;
          label37:
          if (paramAnonymousInt == 513) {
            d.a(d.this).r(d.b(d.this));
          } else {
            d.a(d.this).n(d.b(d.this));
          }
        }
      }
      
      public void a(String paramAnonymousString)
      {
        if (d.a(d.this) != null) {
          d.a(d.this).m(d.b(d.this));
        }
        if (d.a(d.this) != null) {
          d.a(d.this).s(d.b(d.this));
        }
      }
      
      public void b()
      {
        if (d.a(d.this) != null) {
          d.a(d.this).p(d.b(d.this));
        }
      }
    }, this.k, true);
  }
  
  public String a()
  {
    return this.g;
  }
  
  public void a(final Context paramContext)
  {
    if (this.d != null) {
      h();
    }
    if (f.g(this.g)) {
      this.g = "应用";
    }
    final Intent localIntent = b.a(paramContext, this.e, this.g);
    if (localIntent != null) {
      if (paramContext != null) {
        new AlertDialog.Builder(paramContext).setTitle("安装").setMessage(this.g + "已经下载是否现在安装?").setNegativeButton("否", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }).setPositiveButton("是", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            if (d.a(d.this) != null) {
              d.a(d.this).s(d.b(d.this));
            }
            paramContext.startActivity(localIntent);
          }
        }).show();
      }
    }
    for (;;)
    {
      return;
      i();
    }
  }
  
  public String b()
  {
    return this.h;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public String d()
  {
    return this.j;
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.e;
  }
  
  public Uri g()
  {
    return this.d;
  }
  
  public static abstract interface a
  {
    public abstract void m(AdInfo paramAdInfo);
    
    public abstract void n(AdInfo paramAdInfo);
    
    public abstract void o(AdInfo paramAdInfo);
    
    public abstract void p(AdInfo paramAdInfo);
    
    public abstract void q(AdInfo paramAdInfo);
    
    public abstract void r(AdInfo paramAdInfo);
    
    public abstract void s(AdInfo paramAdInfo);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */