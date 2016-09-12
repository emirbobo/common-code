package cn.dbox.ui.common;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import cn.dbox.core.h.d;

class e$1
  extends WebViewClient
{
  e$1(e parame) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    e.a().a("onPageFinished");
    if (e.a(this.a)) {
      e.b(this.a);
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.a(e.d(this.a));
      }
      return;
      e.c(this.a);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    e.a().a("onPageStarted");
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    e.a().a("onReceivedError");
    e.a(this.a, true);
    e.b(this.a);
    if (this.a.a != null) {
      this.a.a.b(e.d(this.a));
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = false;
    e.a().b("EBaseWebView shouldOverrideUrlLoading url:" + paramString);
    WebView.HitTestResult localHitTestResult = this.a.getHitTestResult();
    if (localHitTestResult != null)
    {
      int i = localHitTestResult.getType();
      e.a().b("EBaseWebView shouldOverrideUrlLoading hit.getType:" + i);
      if (i == 0) {
        this.a.loadUrl(paramString);
      }
    }
    for (;;)
    {
      return bool;
      if (this.a.b != null) {
        this.a.b.a((e)paramWebView, paramString);
      }
      bool = true;
      continue;
      e.a().b("HitTestResult is null");
      this.a.loadUrl(paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\e$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */