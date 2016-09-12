package cn.domob.android.ads.b;

import android.widget.FrameLayout.LayoutParams;
import cn.domob.android.ads.DomobAdManager.ErrorCode;
import cn.domob.android.ads.a.a;
import cn.domob.android.ads.a.b;
import cn.domob.android.ads.j.c;
import cn.domob.android.ads.k;
import cn.domob.android.i.f;

class a$1
  implements Runnable
{
  a$1(a parama, j.c paramc) {}
  
  public void run()
  {
    m localm = new m(a.a(this.b));
    localm.setLayoutParams(new FrameLayout.LayoutParams(a.b(this.b).a(), a.c(this.b).b()));
    a.a(this.b, localm);
    localm.a(new a.b()
    {
      public void a(cn.domob.android.ads.a paramAnonymousa)
      {
        a.n().a("Finished to load MRAID banner view.");
        a.d(a.1.this.b);
      }
      
      public void b(cn.domob.android.ads.a paramAnonymousa)
      {
        a.n().e("FAILED to load domob banner view.");
        a.b(a.1.this.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load failed.");
      }
      
      public void c(cn.domob.android.ads.a paramAnonymousa)
      {
        a.a(a.1.this.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load timeout.");
      }
    });
    localm.a(new a.a()
    {
      public void a(cn.domob.android.ads.a paramAnonymousa, String paramAnonymousString)
      {
        a.n().b("MRAID WebView 拦截到 URL：" + paramAnonymousString);
        a.a(a.1.this.b, paramAnonymousa, paramAnonymousString, true);
      }
    });
    localm.a(new m.a()
    {
      public void a()
      {
        a.e(a.1.this.b);
        if (a.f(a.1.this.b) == 1) {
          a.g(a.1.this.b);
        }
      }
      
      public void b() {}
    });
    localm.a(this.b);
    localm.a(new m.g()
    {
      public void a(m paramAnonymousm)
      {
        a.e(a.1.this.b);
        if (a.f(a.1.this.b) == 1) {
          a.h(a.1.this.b);
        }
      }
    });
    localm.a(new m.f()
    {
      public void a(m paramAnonymousm, m.l paramAnonymousl)
      {
        a.i(a.1.this.b);
        if (a.f(a.1.this.b) == 0) {
          a.j(a.1.this.b);
        }
      }
    });
    String str = this.a.k();
    if ((str != null) && (str.length() != 0)) {
      if (str.equals("url"))
      {
        a.n().a("Get an MRAID view instance and load with URL:" + this.a.j());
        localm.a(this.a.j(), null);
      }
    }
    for (;;)
    {
      return;
      if (str.equals("content"))
      {
        a.n().a(String.format("Get an MRAID view instance and load data = [%s] with base URL=[%s]", new Object[] { this.a.m(), this.a.l() }));
        localm.a(this.a.l(), this.a.m());
        continue;
        a.n().e("Content type is not available.");
        a.c(this.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Content type is illegal.");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */