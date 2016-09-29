package cn.dbox.ui.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;

public class e
  extends WebView
{
  private static cn.dbox.core.h.d f = new cn.dbox.core.h.d(e.class.getSimpleName());
  b a;
  a b;
  c c;
  d d;
  Context e;
  private boolean g = false;
  private boolean h = false;
  private cn.dbox.core.bean.d i;
  
  public e(Context paramContext, cn.dbox.core.bean.d paramd)
  {
    super(paramContext);
    this.e = paramContext;
    this.i = paramd;
    b();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setCacheMode(-1);
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginState(WebSettings.PluginState.ON);
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().setDomStorageEnabled(true);
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
          if (e.this.a != null) {
            e.this.a.a(e.d(e.this));
          }
          return;
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
        e.a(e.this, true);
        e.b(e.this);
        if (e.this.a != null) {
          e.this.a.b(e.d(e.this));
        }
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        boolean bool = false;
        e.a().b("EBaseWebView shouldOverrideUrlLoading url:" + paramAnonymousString);
        WebView.HitTestResult localHitTestResult = e.this.getHitTestResult();
        if (localHitTestResult != null)
        {
          int i = localHitTestResult.getType();
          e.a().b("EBaseWebView shouldOverrideUrlLoading hit.getType:" + i);
          if (i == 0) {
            e.this.loadUrl(paramAnonymousString);
          }
        }
        for (;;)
        {
          return bool;
          if (e.this.b != null) {
            e.this.b.a((e)paramAnonymousWebView, paramAnonymousString);
          }
          bool = true;
          continue;
          e.a().b("HitTestResult is null");
          e.this.loadUrl(paramAnonymousString);
        }
      }
    });
    setWebChromeClient(new WebChromeClient()
    {
      public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
      {
        super.onGeolocationPermissionsShowPrompt(paramAnonymousString, paramAnonymousCallback);
        paramAnonymousCallback.invoke(paramAnonymousString, true, false);
      }
      
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
      }
    });
    setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        paramAnonymousString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString1));
        e.this.e.startActivity(paramAnonymousString1);
      }
    });
  }
  
  private void b()
  {
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(true);
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginState(WebSettings.PluginState.ON);
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().setDomStorageEnabled(true);
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
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void a(c paramc)
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
      paramString = (Activity)getContext();
      localObject = new cn/dbox/ui/common/e$4;
      ((4)localObject).<init>(this, str);
      paramString.runOnUiThread((Runnable)localObject);
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
  
  public static abstract interface a
  {
    public abstract void a(e parame, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void a(cn.dbox.core.bean.d paramd);
    
    public abstract void a(String paramString, WebView paramWebView, cn.dbox.core.bean.d paramd);
    
    public abstract void a(String paramString1, String paramString2, cn.dbox.core.bean.d paramd);
    
    public abstract void b(cn.dbox.core.bean.d paramd);
    
    public abstract void c(cn.dbox.core.bean.d paramd);
    
    public abstract void d(cn.dbox.core.bean.d paramd);
  }
  
  public static abstract interface c
  {
    public abstract void a(e parame);
    
    public abstract void b(e parame);
    
    public abstract void c(e parame);
  }
  
  static abstract interface d
  {
    public abstract void a(String paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */