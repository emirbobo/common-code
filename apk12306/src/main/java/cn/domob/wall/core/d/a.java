package cn.domob.wall.core.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import cn.domob.wall.core.h.d;

class a
  extends WebView
{
  private static d f = new d(a.class.getSimpleName());
  b a;
  a b;
  c c;
  d d;
  Context e;
  private boolean g = false;
  private boolean h = false;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
    b();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setCacheMode(-1);
    setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        a.a().a("onPageFinished");
        if (a.a(a.this)) {
          a.b(a.this);
        }
        for (;;)
        {
          if (a.this.a != null) {
            a.this.a.a((a)paramAnonymousWebView, paramAnonymousString);
          }
          return;
          a.c(a.this);
        }
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        a.a().a("onPageStarted");
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        a.a().a("onReceivedError");
        a.a(a.this, true);
        a.b(a.this);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        boolean bool = false;
        a.a().b("EBaseWebView shouldOverrideUrlLoading url:" + paramAnonymousString);
        WebView.HitTestResult localHitTestResult = a.this.getHitTestResult();
        if (localHitTestResult != null)
        {
          int i = localHitTestResult.getType();
          a.a().b("EBaseWebView shouldOverrideUrlLoading hit.getType:" + i);
          if (i == 0) {
            a.this.loadUrl(paramAnonymousString);
          }
        }
        for (;;)
        {
          return bool;
          if (a.this.b != null) {
            a.this.b.a((a)paramAnonymousWebView, paramAnonymousString);
          }
          bool = true;
          continue;
          a.a().b("HitTestResult is null");
          a.this.loadUrl(paramAnonymousString);
        }
      }
    });
    setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        paramAnonymousString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString1));
        a.this.e.startActivity(paramAnonymousString1);
      }
    });
  }
  
  private void b()
  {
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(true);
    getSettings().setSupportZoom(false);
  }
  
  private void c()
  {
    if ((this.c != null) && (!this.h))
    {
      this.h = true;
      f.a("WebView finish callback.");
      this.c.a(this);
    }
  }
  
  private void d()
  {
    if ((this.c != null) && (!this.h))
    {
      this.h = true;
      f.a("WebView failed callback.");
      this.c.b(this);
    }
  }
  
  private void e()
  {
    if ((this.c != null) && (!this.h))
    {
      this.h = true;
      f.a("WebView timeout callback.");
      this.c.c(this);
    }
  }
  
  protected void a(int paramInt)
  {
    f.a("WebView's timeout is set as :" + paramInt);
  }
  
  protected void a(a parama)
  {
    this.b = parama;
  }
  
  protected void a(b paramb)
  {
    this.a = paramb;
  }
  
  protected void a(c paramc)
  {
    this.c = paramc;
  }
  
  protected void a(d paramd)
  {
    this.d = paramd;
  }
  
  protected void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      String str = "javascript:" + paramString;
      f.b(String.format("EBaseWebView instance executes js: %s", new Object[] { str }));
      localObject = (Activity)getContext();
      paramString = new cn/domob/wall/core/d/a$3;
      paramString.<init>(this, str);
      ((Activity)localObject).runOnUiThread(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    f.a(String.format("loadData() is called with data = %s.", new Object[] { paramString1 }));
    loadDataWithBaseURL(null, paramString1, paramString2, paramString3, null);
  }
  
  static abstract interface a
  {
    public abstract void a(a parama, String paramString);
  }
  
  static abstract interface b
  {
    public abstract void a(a parama, String paramString);
  }
  
  static abstract interface c
  {
    public abstract void a(a parama);
    
    public abstract void b(a parama);
    
    public abstract void c(a parama);
  }
  
  static abstract interface d
  {
    public abstract void a(String paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */