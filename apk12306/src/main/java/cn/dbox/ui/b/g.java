package cn.dbox.ui.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.LinearLayout.LayoutParams;
import cn.dbox.core.a.c.a;
import cn.dbox.core.a.c.e;
import cn.dbox.core.b.b;
import cn.dbox.core.h.f;
import java.net.URI;

public class g
  extends b
{
  private static cn.dbox.core.h.d A = new cn.dbox.core.h.d(g.class.getSimpleName());
  private boolean B = false;
  private boolean C = false;
  private boolean D = false;
  private boolean E = false;
  View a;
  LinearLayout.LayoutParams x;
  cn.dbox.core.a.c y;
  a z;
  
  public g(Context paramContext, final cn.dbox.core.bean.d paramd, cn.dbox.core.b paramb, boolean paramBoolean)
  {
    super(paramContext, paramd, paramb, paramBoolean);
    g();
    this.E = paramBoolean;
    if (this.d != null) {
      addView(this.d);
    }
    if (this.h != null) {
      addView(this.h);
    }
    this.x = new LinearLayout.LayoutParams(-1, -1);
    this.a = LayoutInflater.from(this.f).inflate(cn.dbox.ui.e.d.a(this.f, "dbox_error"), null);
    this.a.findViewById(cn.dbox.ui.e.c.a(paramContext, "error_image")).setBackgroundResource(cn.dbox.ui.e.b.a(paramContext, "dbox_error_landing"));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (g.this.a != null) {
          g.this.removeView(g.this.a);
        }
        g.this.y.a(paramd.g());
        g.this.addView(g.this.y);
      }
    });
    if ((this.h == null) && ((paramd.g() == null) || ("".equals(paramd.g())))) {
      if (this.i != null) {
        addView(this.i);
      }
    }
    for (;;)
    {
      return;
      a(paramContext, paramd, paramb);
      addView(this.y);
    }
  }
  
  private void g()
  {
    this.B = false;
    this.C = false;
    this.D = false;
  }
  
  private boolean h()
  {
    if ((!this.B) && (!this.D) && (!this.C)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a(Context paramContext, cn.dbox.core.bean.d paramd, cn.dbox.core.b paramb)
  {
    this.y = new cn.dbox.core.a.c(paramContext, paramd.g(), paramd.g(), new c.a()
    {
      public void a(cn.dbox.core.bean.d paramAnonymousd)
      {
        if (g.a(g.this))
        {
          g.this.j.a(g.this.g, b.b.b);
          g.a(g.this, true);
        }
      }
      
      public void a(String paramAnonymousString, WebView paramAnonymousWebView, cn.dbox.core.bean.d paramAnonymousd)
      {
        try
        {
          paramAnonymousd = URI.create(paramAnonymousString);
          paramAnonymousWebView = paramAnonymousd.getScheme();
          paramAnonymousd = paramAnonymousd.getHost();
          if (f.a(paramAnonymousWebView)) {}
          for (;;)
          {
            return;
            if (((!paramAnonymousWebView.equals("domob")) || (f.a(paramAnonymousd)) || (!paramAnonymousd.equals("inapp"))) && (!paramAnonymousWebView.startsWith("http"))) {
              g.this.j.d(paramAnonymousString);
            }
          }
        }
        catch (Exception paramAnonymousString)
        {
          for (;;)
          {
            g.f().e("Error while parsing landingpage URL.");
            g.f().a(paramAnonymousString);
          }
        }
      }
      
      public void a(String paramAnonymousString1, String paramAnonymousString2, cn.dbox.core.bean.d paramAnonymousd)
      {
        try
        {
          paramAnonymousString1 = Uri.parse(paramAnonymousString1);
          paramAnonymousString2 = new android/content/Intent;
          paramAnonymousString2.<init>("android.intent.action.VIEW", paramAnonymousString1);
          g.this.f.startActivity(paramAnonymousString2);
          return;
        }
        catch (Exception paramAnonymousString1)
        {
          for (;;)
          {
            g.f().a(paramAnonymousString1);
          }
        }
      }
      
      public void b(cn.dbox.core.bean.d paramAnonymousd)
      {
        if (g.a(g.this))
        {
          g.this.j.a(g.this.g, b.b.b);
          g.b(g.this, true);
        }
        if (g.this.y != null) {
          g.this.removeView(g.this.y);
        }
        g.this.addView(g.this.a, g.this.x);
      }
      
      public void c(cn.dbox.core.bean.d paramAnonymousd)
      {
        if (g.a(g.this))
        {
          g.this.j.a(g.this.g, b.b.d);
          g.c(g.this, true);
        }
      }
      
      public void d(cn.dbox.core.bean.d paramAnonymousd)
      {
        g.this.j.a(g.this.g, b.b.e);
      }
    }, paramd, this.E);
    this.y.a(new c.e()
    {
      public void a()
      {
        if (g.this.z != null) {
          g.this.z.a();
        }
      }
      
      public void a(String paramAnonymousString) {}
      
      public void b() {}
    });
  }
  
  public void a(a parama)
  {
    this.z = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */