package cn.domob.wall.core.d;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import cn.domob.wall.core.h.d;

class a$1
  extends WebViewClient
{
  a$1(a parama) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    a.a().a("onPageFinished");
    if (a.a(this.a)) {
      a.b(this.a);
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.a((a)paramWebView, paramString);
      }
      return;
      a.c(this.a);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    a.a().a("onPageStarted");
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    a.a().a("onReceivedError");
    a.a(this.a, true);
    a.b(this.a);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = false;
    a.a().b("EBaseWebView shouldOverrideUrlLoading url:" + paramString);
    WebView.HitTestResult localHitTestResult = this.a.getHitTestResult();
    if (localHitTestResult != null)
    {
      int i = localHitTestResult.getType();
      a.a().b("EBaseWebView shouldOverrideUrlLoading hit.getType:" + i);
      if (i == 0) {
        this.a.loadUrl(paramString);
      }
    }
    for (;;)
    {
      return bool;
      if (this.a.b != null) {
        this.a.b.a((a)paramWebView, paramString);
      }
      bool = true;
      continue;
      a.a().b("HitTestResult is null");
      this.a.loadUrl(paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */