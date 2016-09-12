package cn.domob.android.ads.a;

import android.widget.FrameLayout.LayoutParams;
import cn.domob.android.ads.DomobAdManager.ErrorCode;
import cn.domob.android.ads.a;
import cn.domob.android.ads.a.a;
import cn.domob.android.ads.a.b;
import cn.domob.android.ads.g;
import cn.domob.android.ads.j;
import cn.domob.android.ads.j.c;
import cn.domob.android.ads.j.c.a;
import cn.domob.android.ads.k;
import cn.domob.android.i.f;

class c$1
  implements Runnable
{
  c$1(c paramc, j.c paramc1) {}
  
  public void run()
  {
    e locale = new e(c.a(this.b), "banner", 0);
    locale.setLayoutParams(new FrameLayout.LayoutParams(c.b(this.b).a(), c.c(this.b).b()));
    c.a(this.b, locale);
    if (c.d(this.b).G()) {
      locale.a(c.e(this.b).d().J() / 1000);
    }
    locale.a(new a.b()
    {
      public void a(a paramAnonymousa)
      {
        c.v().a("Finished to load domob banner view.");
        paramAnonymousa = c.f(c.1.this.b).d().n();
        if (paramAnonymousa != null)
        {
          c.a(c.1.this.b, new e(c.g(c.1.this.b), "expandable", 0));
          c.v().b("There is expandable part in current creative.");
          c.a(c.1.this.b, c.h(c.1.this.b), paramAnonymousa, paramAnonymousa.g());
          if (!paramAnonymousa.g()) {}
        }
        label147:
        for (;;)
        {
          return;
          c.v().b("Expandable preload is disabled in current creative. Show Ad.");
          for (;;)
          {
            if (c.i(c.1.this.b).G()) {
              break label147;
            }
            c.j(c.1.this.b);
            break;
            c.v().b("Banner is ready and there is no expandable part in current creative. Show Ad.");
          }
        }
      }
      
      public void b(a paramAnonymousa)
      {
        c.v().e("FAILED to load domob banner view.");
        c.b(c.1.this.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load failed.");
      }
      
      public void c(a paramAnonymousa)
      {
        c.a(c.1.this.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load timeout.");
      }
    });
    locale.a(new a.a()
    {
      public void a(a paramAnonymousa, String paramAnonymousString)
      {
        c.v().b("Banner BaseWebView 拦截到 URL：" + paramAnonymousString);
        c.1.this.b.a(paramAnonymousa, paramAnonymousString, true);
      }
    });
    String str = this.a.k();
    if ((str != null) && (str.length() != 0)) {
      if (str.equals("url"))
      {
        c.v().a("Get an DomobWebView instance and load with URL:" + this.a.j());
        locale.a(this.a.j(), null);
      }
    }
    for (;;)
    {
      return;
      if (str.equals("content"))
      {
        c.v().a(String.format("Get an DomobWebView instance and load data = [%s] with base URL=[%s]", new Object[] { this.a.m(), this.a.l() }));
        locale.a(this.a.l(), this.a.m());
        continue;
        c.v().e("Content type is not available.");
        c.c(this.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Content type is illegal.");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\c$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */