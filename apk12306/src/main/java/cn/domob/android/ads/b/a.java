package cn.domob.android.ads.b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import cn.domob.android.ads.DomobAdManager.ErrorCode;
import cn.domob.android.ads.a.a;
import cn.domob.android.ads.a.b;
import cn.domob.android.ads.a.d.b;
import cn.domob.android.ads.g;
import cn.domob.android.ads.j;
import cn.domob.android.ads.j.c;
import cn.domob.android.ads.k;
import cn.domob.android.ads.n;
import cn.domob.android.ads.w;
import cn.domob.android.ads.w.c;
import cn.domob.android.ads.w.h;
import cn.domob.android.i.c;
import cn.domob.android.i.f;
import java.net.URI;
import java.util.HashMap;

public class a
  extends n
  implements d.b
{
  private static f g = new f(a.class.getSimpleName());
  private static final String m = "mraid";
  private static final String n = "open";
  private static final String o = "expand";
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private Handler k = new Handler(Looper.getMainLooper());
  private int l = 0;
  
  public a(Context paramContext, k paramk, j paramj, g paramg)
  {
    super(paramContext, paramk, paramj, paramg);
    g.b("New DomobMRAIDAdAdapter instance.");
  }
  
  private boolean a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    bool2 = false;
    for (;;)
    {
      try
      {
        if (!paramString.startsWith("mraid")) {
          continue;
        }
        bool1 = bool2;
        if ("mraid".equals(Uri.parse(paramString).getScheme()))
        {
          g.a("Scheme MRAID");
          bool1 = b(paramWebView, paramString, paramBoolean);
        }
      }
      catch (Exception paramWebView)
      {
        Object localObject;
        g.a(paramWebView);
        boolean bool1 = bool2;
        continue;
        paramWebView = new android/content/Intent;
        paramWebView.<init>("android.intent.action.VIEW", Uri.parse(paramString));
        paramWebView.addFlags(268435456);
        try
        {
          this.a.startActivity(paramWebView);
          l();
          bool1 = true;
        }
        catch (ActivityNotFoundException paramWebView)
        {
          paramWebView = f.b();
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          Log.w(paramWebView, "Could not handle intent with URI: " + paramString + ". Is this intent unsupported on your phone?");
          bool1 = bool2;
        }
        continue;
        g.a("Handle unknown intents.");
        if (!paramBoolean) {
          continue;
        }
        p();
        paramWebView = new android/content/Intent;
        paramWebView.<init>("android.intent.action.VIEW", Uri.parse(paramString));
        paramWebView.addFlags(268435456);
        try
        {
          this.a.startActivity(paramWebView);
          l();
          bool1 = true;
        }
        catch (ActivityNotFoundException paramWebView)
        {
          paramWebView = f.b();
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          Log.w(paramWebView, "Could not handle intent with URI: " + paramString + ". Is this intent unsupported on your phone?");
          bool1 = bool2;
        }
        continue;
      }
      return bool1;
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("tel:")) && (!paramString.startsWith("voicemail:")) && (!paramString.startsWith("sms:")) && (!paramString.startsWith("mailto:")) && (!paramString.startsWith("geo:")) && (!paramString.startsWith("tel:"))) {
        continue;
      }
      g.a("Handle other phone intents.");
      if (paramBoolean) {
        p();
      }
      if (!paramString.startsWith("http")) {
        continue;
      }
      localObject = c.a(this.a, Uri.parse(paramString));
      paramWebView = (WebView)localObject;
      if (localObject == null)
      {
        paramWebView = new android/content/Intent;
        paramWebView.<init>("android.intent.action.VIEW", Uri.parse(paramString));
      }
      l();
      this.a.startActivity(paramWebView);
      bool1 = bool2;
    }
  }
  
  private void b(String paramString)
  {
    b(paramString, null);
  }
  
  private void b(String paramString1, String paramString2)
  {
    w localw = new w(this.a, this.d.n());
    localw.getClass();
    w.c localc = new w.c(localw);
    localc.a = this.c.d().r();
    if (paramString2 != null) {
      localc.h = paramString2;
    }
    localw.a(this.c.d().q(), w.h.c, paramString1, localc, null);
  }
  
  private boolean b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      if ((localUri.getHost().equals("expand")) || (localUri.getHost().equals("open")))
      {
        v();
        g.b("do click report for mraid scheme");
        p();
      }
      paramBoolean = ((m)paramWebView).a(URI.create(paramString));
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        g.a(paramWebView);
        paramBoolean = false;
      }
    }
    return paramBoolean;
  }
  
  private void o()
  {
    final j.c localc = this.c.d();
    this.k.post(new Runnable()
    {
      public void run()
      {
        m localm = new m(a.a(a.this));
        localm.setLayoutParams(new FrameLayout.LayoutParams(a.b(a.this).a(), a.c(a.this).b()));
        a.a(a.this, localm);
        localm.a(new a.b()
        {
          public void a(cn.domob.android.ads.a paramAnonymous2a)
          {
            a.n().a("Finished to load MRAID banner view.");
            a.d(a.this);
          }
          
          public void b(cn.domob.android.ads.a paramAnonymous2a)
          {
            a.n().e("FAILED to load domob banner view.");
            a.b(a.this, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load failed.");
          }
          
          public void c(cn.domob.android.ads.a paramAnonymous2a)
          {
            a.a(a.this, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load timeout.");
          }
        });
        localm.a(new a.a()
        {
          public void a(cn.domob.android.ads.a paramAnonymous2a, String paramAnonymous2String)
          {
            a.n().b("MRAID WebView 拦截到 URL：" + paramAnonymous2String);
            a.a(a.this, paramAnonymous2a, paramAnonymous2String, true);
          }
        });
        localm.a(new m.a()
        {
          public void a()
          {
            a.e(a.this);
            if (a.f(a.this) == 1) {
              a.g(a.this);
            }
          }
          
          public void b() {}
        });
        localm.a(a.this);
        localm.a(new m.g()
        {
          public void a(m paramAnonymous2m)
          {
            a.e(a.this);
            if (a.f(a.this) == 1) {
              a.h(a.this);
            }
          }
        });
        localm.a(new m.f()
        {
          public void a(m paramAnonymous2m, m.l paramAnonymous2l)
          {
            a.i(a.this);
            if (a.f(a.this) == 0) {
              a.j(a.this);
            }
          }
        });
        String str = localc.k();
        if ((str != null) && (str.length() != 0)) {
          if (str.equals("url"))
          {
            a.n().a("Get an MRAID view instance and load with URL:" + localc.j());
            localm.a(localc.j(), null);
          }
        }
        for (;;)
        {
          return;
          if (str.equals("content"))
          {
            a.n().a(String.format("Get an MRAID view instance and load data = [%s] with base URL=[%s]", new Object[] { localc.m(), localc.l() }));
            localm.a(localc.l(), localc.m());
            continue;
            a.n().e("Content type is not available.");
            a.c(a.this, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Content type is illegal.");
          }
        }
      }
    });
  }
  
  private void p()
  {
    this.d.a(this.c);
    h();
  }
  
  private boolean q()
  {
    if ((!this.h) && (!this.j) && (!this.i)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void v()
  {
    this.h = false;
    this.i = false;
    this.j = false;
  }
  
  public void a()
  {
    g.b("Start to load DomobMRAID adapter.");
    o();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(String paramString, WebView paramWebView)
  {
    if (this.c.d().B()) {
      b("lp_url", paramString);
    }
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(HashMap<String, String> paramHashMap, String paramString, long paramLong) {}
  
  public void d()
  {
    if ((this.f != null) && ((this.f instanceof m))) {
      ((m)this.f).l();
    }
  }
  
  public void e() {}
  
  public void f()
  {
    g.a("Destroy Domob MRAID WebViews.");
    if ((this.f != null) && ((this.f instanceof cn.domob.android.ads.a)))
    {
      ((cn.domob.android.ads.a)this.f).destroy();
      this.f = null;
    }
  }
  
  public void r()
  {
    if (q())
    {
      b("load_success");
      this.h = true;
    }
  }
  
  public void s()
  {
    if (q())
    {
      b("load_failed");
      this.j = true;
    }
  }
  
  public void t()
  {
    if (q())
    {
      b("load_cancel");
      this.i = true;
    }
  }
  
  public void u()
  {
    this.l -= 1;
    g.a("BrowserClosed mOverlayCount = " + this.l);
    if (this.l == 0) {
      k();
    }
    b("close_lp");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */