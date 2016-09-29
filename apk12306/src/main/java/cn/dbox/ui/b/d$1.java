package cn.dbox.ui.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import cn.dbox.core.a.c.c;
import cn.dbox.core.b;
import cn.dbox.core.b.b;
import cn.dbox.core.h.f;
import java.net.URI;

class d$1
  implements c.c
{
  d$1(d paramd) {}
  
  public void a(String paramString)
  {
    if (d.a(this.a))
    {
      this.a.e.a(this.a.c, b.b.b, "http://srp.12306.moxz.net/landing/");
      d.a(this.a, true);
    }
  }
  
  public void a(String paramString1, WebView paramWebView, String paramString2)
  {
    try
    {
      paramString2 = URI.create(paramString1);
      paramWebView = paramString2.getScheme();
      paramString2 = paramString2.getHost();
      if (f.a(paramWebView)) {}
      for (;;)
      {
        return;
        if (((!paramWebView.equals("domob")) || (f.a(paramString2)) || (!paramString2.equals("inapp"))) && (!paramWebView.startsWith("http"))) {
          this.a.e.d(paramString1);
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        d.a().e("Error while parsing landingpage URL.");
        d.a().a(paramString1);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = Uri.parse(paramString1);
      paramString2 = new android/content/Intent;
      paramString2.<init>("android.intent.action.VIEW", paramString1);
      d.b(this.a).startActivity(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        d.a().a(paramString1);
      }
    }
  }
  
  public void b(String paramString)
  {
    if (d.a(this.a))
    {
      this.a.e.a(this.a.c, b.b.b, "http://srp.12306.moxz.net/landing/");
      d.b(this.a, true);
    }
  }
  
  public void c(String paramString)
  {
    if (d.a(this.a))
    {
      this.a.e.a(this.a.c, b.b.d, "http://srp.12306.moxz.net/landing/");
      d.c(this.a, true);
    }
  }
  
  public void d(String paramString)
  {
    this.a.e.a(this.a.c, b.b.e, "http://srp.12306.moxz.net/landing/");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\d$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */