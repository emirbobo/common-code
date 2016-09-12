package cn.dbox.ui.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import cn.dbox.core.a.c;
import cn.dbox.core.a.c.c;
import cn.dbox.core.a.c.e;
import cn.dbox.core.b;
import cn.dbox.core.b.b;
import cn.dbox.core.h.f;
import java.net.URI;

public class d
  extends LinearLayout
{
  private static cn.dbox.core.h.d g = new cn.dbox.core.h.d(d.class.getSimpleName());
  LinearLayout.LayoutParams a;
  c b;
  String c;
  final String d = "http://srp.12306.moxz.net/landing/";
  public b e;
  a f;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private Context k;
  
  public d(Context paramContext, String paramString, b paramb)
  {
    super(paramContext);
    this.c = paramString;
    this.k = paramContext;
    this.e = paramb;
    b();
    this.a = new LinearLayout.LayoutParams(-1, -1);
    a(paramContext, paramString, paramb);
  }
  
  private void b()
  {
    this.h = false;
    this.i = false;
    this.j = false;
  }
  
  private boolean c()
  {
    if ((!this.h) && (!this.j) && (!this.i)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a(Context paramContext, String paramString, b paramb)
  {
    this.b = new c(paramContext, paramString, paramString, new c.c()
    {
      public void a(String paramAnonymousString)
      {
        if (d.a(d.this))
        {
          d.this.e.a(d.this.c, b.b.b, "http://srp.12306.moxz.net/landing/");
          d.a(d.this, true);
        }
      }
      
      public void a(String paramAnonymousString1, WebView paramAnonymousWebView, String paramAnonymousString2)
      {
        try
        {
          paramAnonymousString2 = URI.create(paramAnonymousString1);
          paramAnonymousWebView = paramAnonymousString2.getScheme();
          paramAnonymousString2 = paramAnonymousString2.getHost();
          if (f.a(paramAnonymousWebView)) {}
          for (;;)
          {
            return;
            if (((!paramAnonymousWebView.equals("domob")) || (f.a(paramAnonymousString2)) || (!paramAnonymousString2.equals("inapp"))) && (!paramAnonymousWebView.startsWith("http"))) {
              d.this.e.d(paramAnonymousString1);
            }
          }
        }
        catch (Exception paramAnonymousString1)
        {
          for (;;)
          {
            d.a().e("Error while parsing landingpage URL.");
            d.a().a(paramAnonymousString1);
          }
        }
      }
      
      public void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        try
        {
          paramAnonymousString1 = Uri.parse(paramAnonymousString1);
          paramAnonymousString2 = new android/content/Intent;
          paramAnonymousString2.<init>("android.intent.action.VIEW", paramAnonymousString1);
          d.b(d.this).startActivity(paramAnonymousString2);
          return;
        }
        catch (Exception paramAnonymousString1)
        {
          for (;;)
          {
            d.a().a(paramAnonymousString1);
          }
        }
      }
      
      public void b(String paramAnonymousString)
      {
        if (d.a(d.this))
        {
          d.this.e.a(d.this.c, b.b.b, "http://srp.12306.moxz.net/landing/");
          d.b(d.this, true);
        }
      }
      
      public void c(String paramAnonymousString)
      {
        if (d.a(d.this))
        {
          d.this.e.a(d.this.c, b.b.d, "http://srp.12306.moxz.net/landing/");
          d.c(d.this, true);
        }
      }
      
      public void d(String paramAnonymousString)
      {
        d.this.e.a(d.this.c, b.b.e, "http://srp.12306.moxz.net/landing/");
      }
    }, paramString, true);
    this.b.a(new c.e()
    {
      public void a()
      {
        if (d.this.f != null) {
          d.this.f.a();
        }
        d.this.e.a(d.this.c, b.b.e, "http://srp.12306.moxz.net/landing/");
      }
      
      public void a(String paramAnonymousString) {}
      
      public void b() {}
    });
    this.b.a(paramString);
    addView(this.b, this.a);
  }
  
  public void a(a parama)
  {
    this.f = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */