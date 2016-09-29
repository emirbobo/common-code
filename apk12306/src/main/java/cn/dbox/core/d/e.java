package cn.dbox.core.d;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import cn.dbox.core.bean.a;
import cn.dbox.core.h.d;
import cn.dbox.core.h.f;
import java.io.UnsupportedEncodingException;

public class e
{
  public static final int b = 1;
  private static final String n = "url";
  private static final String o = "auto_run";
  private static final String p = "name";
  private static final String q = "pkg";
  private static final String r = "vc";
  private static final String s = "vn";
  d a = new d(e.class.getSimpleName());
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
  private a m;
  
  public e(Context paramContext, Uri paramUri, a parama, a parama1)
  {
    this.c = paramContext;
    this.m = parama;
    this.l = parama1;
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
        Toast.makeText(e.c(e.this), "开始下载 。。。", 0).show();
        if (e.a(e.this) != null) {
          e.a(e.this).i(e.b(e.this));
        }
      }
      
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        if (e.a(e.this) != null)
        {
          if (paramAnonymousInt != 512) {
            break label37;
          }
          e.a(e.this).k(e.b(e.this));
        }
        for (;;)
        {
          return;
          label37:
          if (paramAnonymousInt == 513) {
            e.a(e.this).l(e.b(e.this));
          } else {
            e.a(e.this).h(e.b(e.this));
          }
        }
      }
      
      public void a(String paramAnonymousString)
      {
        if (e.a(e.this) != null) {
          e.a(e.this).g(e.b(e.this));
        }
        if (e.a(e.this) != null) {
          e.a(e.this).m(e.b(e.this));
        }
      }
      
      public void b()
      {
        if (e.a(e.this) != null) {
          e.a(e.this).j(e.b(e.this));
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
            if (e.a(e.this) != null) {
              e.a(e.this).m(e.b(e.this));
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
    public abstract void g(a parama);
    
    public abstract void h(a parama);
    
    public abstract void i(a parama);
    
    public abstract void j(a parama);
    
    public abstract void k(a parama);
    
    public abstract void l(a parama);
    
    public abstract void m(a parama);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */