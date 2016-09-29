package cn.domob.wall.core.d;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cn.domob.wall.core.DService.EWallReportType;
import cn.domob.wall.core.h.d;

public class b
  extends RelativeLayout
{
  private static d d = new d(b.class.getSimpleName());
  Context a;
  a b;
  c c;
  private a e;
  
  public b(final cn.domob.wall.core.b paramb, Context paramContext, String paramString, a parama)
  {
    super(paramContext);
    this.a = paramContext;
    this.e = new a(paramContext);
    this.b = parama;
    setBackgroundColor(-1);
    this.e.a(new a.a()
    {
      public void a(a paramAnonymousa, String paramAnonymousString)
      {
        b.b().b("EWallDetailsView onURLIntercepted URL:" + paramAnonymousString);
        paramAnonymousa.loadUrl(paramAnonymousString);
        cn.domob.wall.core.f.a.a().a(paramb, DService.EWallReportType.E_PAGE_CLICK, paramAnonymousString);
      }
    });
    this.e.a(new a.b()
    {
      public void a(a paramAnonymousa, String paramAnonymousString)
      {
        b.this.a();
      }
    });
    this.e.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        b.this.c.a(paramAnonymousInt);
        b.b().b("newProgress:" + paramAnonymousInt);
      }
    });
    this.e.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0)) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    });
    this.e.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
    this.c = new c(this.a, paramString, new c.a()
    {
      public void a()
      {
        if (b.this.b != null) {
          b.this.b.a();
        }
        b.a(b.this).loadUrl("");
        b.b().b("you click close button");
      }
      
      public void b()
      {
        if (b.a(b.this).canGoBack())
        {
          b.a(b.this).goBack();
          b.b().b("webView canGoBack");
        }
        for (;;)
        {
          b.this.a();
          b.b().b("you click back button");
          return;
          if (b.this.b != null) {
            b.this.b.a();
          }
        }
      }
      
      public void c()
      {
        if (b.a(b.this).canGoForward()) {
          b.a(b.this).goForward();
        }
        b.this.a();
        b.b().b("you click forward button");
      }
      
      public void d()
      {
        b.a(b.this).reload();
        b.this.a();
        b.b().b("you click refresh button");
      }
    });
    paramContext = this.c.f();
    paramContext.setId(11);
    paramb = new RelativeLayout.LayoutParams(-1, -2);
    paramb.addRule(3, 11);
    this.e.setLayoutParams(paramb);
    addView(paramContext);
    addView(this.e, paramb);
  }
  
  public void a()
  {
    if (this.e.canGoBack()) {
      if (this.e.canGoForward()) {
        this.c.a(true, true);
      }
    }
    for (;;)
    {
      return;
      this.c.a(true, false);
      continue;
      if (this.e.canGoForward()) {
        this.c.a(false, true);
      } else {
        this.c.a(false, false);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.e.loadUrl(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */