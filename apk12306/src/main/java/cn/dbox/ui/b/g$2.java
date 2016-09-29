package cn.dbox.ui.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import cn.dbox.core.a.c.a;
import cn.dbox.core.b;
import cn.dbox.core.b.b;
import cn.dbox.core.h.f;
import java.net.URI;

class g$2
  implements c.a
{
  g$2(g paramg) {}
  
  public void a(cn.dbox.core.bean.d paramd)
  {
    if (g.a(this.a))
    {
      this.a.j.a(this.a.g, b.b.b);
      g.a(this.a, true);
    }
  }
  
  public void a(String paramString, WebView paramWebView, cn.dbox.core.bean.d paramd)
  {
    try
    {
      paramd = URI.create(paramString);
      paramWebView = paramd.getScheme();
      paramd = paramd.getHost();
      if (f.a(paramWebView)) {}
      for (;;)
      {
        return;
        if (((!paramWebView.equals("domob")) || (f.a(paramd)) || (!paramd.equals("inapp"))) && (!paramWebView.startsWith("http"))) {
          this.a.j.d(paramString);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        g.f().e("Error while parsing landingpage URL.");
        g.f().a(paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, cn.dbox.core.bean.d paramd)
  {
    try
    {
      paramString1 = Uri.parse(paramString1);
      paramString2 = new android/content/Intent;
      paramString2.<init>("android.intent.action.VIEW", paramString1);
      this.a.f.startActivity(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        g.f().a(paramString1);
      }
    }
  }
  
  public void b(cn.dbox.core.bean.d paramd)
  {
    if (g.a(this.a))
    {
      this.a.j.a(this.a.g, b.b.b);
      g.b(this.a, true);
    }
    if (this.a.y != null) {
      this.a.removeView(this.a.y);
    }
    this.a.addView(this.a.a, this.a.x);
  }
  
  public void c(cn.dbox.core.bean.d paramd)
  {
    if (g.a(this.a))
    {
      this.a.j.a(this.a.g, b.b.d);
      g.c(this.a, true);
    }
  }
  
  public void d(cn.dbox.core.bean.d paramd)
  {
    this.a.j.a(this.a.g, b.b.e);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\g$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */