package cn.domob.android.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.domob.android.i.f;

public class e
  extends WebView
{
  private static f c = new f(e.class.getSimpleName());
  private static final int i = 20;
  public a a;
  public b b;
  private int d;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  public e(Context paramContext)
  {
    super(paramContext);
    b();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginState(WebSettings.PluginState.ON);
    getSettings().setCacheMode(-1);
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.d = 20;
    setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        e.a().a("onPageFinished");
        if (e.a(e.this)) {
          e.b(e.this);
        }
        for (;;)
        {
          return;
          e.a(e.this, true);
          e.c(e.this);
        }
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        e.a().a("onPageStarted");
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        e.a().a("onReceivedError");
        e.b(e.this, true);
        e.b(e.this);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        e.a().b("webview intercepted url: " + paramAnonymousString);
        if (e.this.a != null) {
          e.this.a.a(paramAnonymousString);
        }
        return true;
      }
    });
    setWebChromeClient(new WebChromeClient()
    {
      public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
      {
        super.onGeolocationPermissionsShowPrompt(paramAnonymousString, paramAnonymousCallback);
        paramAnonymousCallback.invoke(paramAnonymousString, true, false);
      }
    });
  }
  
  private void b()
  {
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(false);
    getSettings().setSupportZoom(false);
  }
  
  private void c()
  {
    if ((this.b != null) && (!this.h))
    {
      this.h = true;
      c.a("WebView finish callback.");
      this.b.a(this);
    }
  }
  
  private void d()
  {
    if ((this.b != null) && (!this.h))
    {
      this.h = true;
      c.a("WebView failed callback.");
      this.b.b(this);
    }
  }
  
  private void e()
  {
    if ((this.b != null) && (!this.h))
    {
      this.h = true;
      c.a("WebView timeout callback.");
      this.b.c(this);
    }
  }
  
  public void a(int paramInt)
  {
    c.a("WebView's timeout is set as :" + paramInt);
    this.d = paramInt;
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void a(b paramb)
  {
    this.b = paramb;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = "javascript:" + paramString;
      c.b(String.format("DomobWebView instance executes js: %s", new Object[] { localObject }));
      paramString = (Activity)getContext();
      Runnable local3 = new cn/domob/android/j/e$3;
      local3.<init>(this, (String)localObject);
      paramString.runOnUiThread(local3);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void loadUrl(String paramString)
  {
    super.loadUrl(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void a(e parame);
    
    public abstract void b(e parame);
    
    public abstract void c(e parame);
  }
  
  class c
    extends Thread
  {
    private int b = 0;
    
    c() {}
    
    public void run()
    {
      while ((this.b < e.d(e.this)) && (!e.e(e.this))) {
        try
        {
          Thread.sleep(1000L);
          this.b += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          e.a().a(localInterruptedException);
        }
      }
      if ((this.b == e.d(e.this)) && (!e.e(e.this)) && (!e.a(e.this)))
      {
        e.a().e("WebView 加载超时");
        e.b(e.this, true);
        e.f(e.this);
        if (e.g(e.this)) {
          ((Activity)e.this.getContext()).runOnUiThread(new Runnable()
          {
            public void run()
            {
              try
              {
                e.this.stopLoading();
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  e.a().a(localException);
                }
              }
            }
          });
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */