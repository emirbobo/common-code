package cn.domob.android.offerwall;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class a
  extends WebView
{
  protected static final int a = -1;
  private static m b = new m(a.class.getSimpleName());
  private static final int k = 10;
  private a c;
  private b d;
  private c e;
  private int f;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext);
    b();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setCacheMode(-1);
    this.f = 10;
    if (paramInt != -1)
    {
      b.a("Init DomobWebView with custom background color.");
      setBackgroundColor(paramInt);
    }
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
          return;
          a.a(a.this, true);
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
        a.b(a.this, true);
        a.b(a.this);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (a.d(a.this) != null) {
          a.d(a.this).a((a)paramAnonymousWebView, paramAnonymousString);
        }
        if (paramAnonymousString.startsWith("http")) {
          paramAnonymousWebView.loadUrl(paramAnonymousString);
        }
        return true;
      }
    });
    setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        if (a.e(a.this) != null) {
          a.e(a.this).a(paramAnonymousString1);
        }
      }
    });
  }
  
  private void b()
  {
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollbarOverlay(true);
    getSettings().setSupportZoom(false);
  }
  
  private void c()
  {
    if ((this.d != null) && (!this.j))
    {
      this.j = true;
      b.a("WebView finish callback.");
      this.d.a(this);
    }
  }
  
  private void d()
  {
    if ((this.d != null) && (!this.j))
    {
      this.j = true;
      b.a("WebView failed callback.");
      this.d.b(this);
    }
  }
  
  private void e()
  {
    if ((this.d != null) && (!this.j))
    {
      this.j = true;
      b.a("WebView timeout callback.");
      this.d.c(this);
    }
  }
  
  protected void a(int paramInt)
  {
    b.a("WebView's timeout is set as :" + paramInt);
    this.f = paramInt;
  }
  
  protected void a(a parama)
  {
    this.c = parama;
  }
  
  protected void a(b paramb)
  {
    this.d = paramb;
  }
  
  protected void a(c paramc)
  {
    this.e = paramc;
  }
  
  protected void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      String str = "javascript:" + paramString;
      b.b(String.format("BaseWebView instance executes js: %s", new Object[] { str }));
      localObject = (Activity)getContext();
      paramString = new cn/domob/android/offerwall/a$3;
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
  
  protected void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    b.a(String.format("loadData() is called with data = %s.", new Object[] { paramString1 }));
    loadDataWithBaseURL(null, paramString1, paramString2, paramString3, null);
  }
  
  static abstract interface a
  {
    public abstract void a(a parama, String paramString);
  }
  
  static abstract interface b
  {
    public abstract void a(a parama);
    
    public abstract void b(a parama);
    
    public abstract void c(a parama);
  }
  
  static abstract interface c
  {
    public abstract void a(String paramString);
  }
  
  class d
    extends Thread
  {
    private int b = 0;
    
    d() {}
    
    public void run()
    {
      while ((this.b < a.f(a.this)) && (!a.g(a.this))) {
        try
        {
          Thread.sleep(1000L);
          this.b += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          a.a().a(localInterruptedException);
        }
      }
      if ((this.b == a.f(a.this)) && (!a.g(a.this)) && (!a.a(a.this)))
      {
        a.a().e("WebView 加载超时");
        a.b(a.this, true);
        a.h(a.this);
        if (a.i(a.this)) {
          ((Activity)a.this.getContext()).runOnUiThread(new Runnable()
          {
            public void run()
            {
              a.this.stopLoading();
            }
          });
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */