package cn.domob.android.j;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.domob.android.i.f;

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
      return;
      e.a(this.a, true);
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
    e.b(this.a, true);
    e.b(this.a);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    e.a().b("webview intercepted url: " + paramString);
    if (this.a.a != null) {
      this.a.a.a(paramString);
    }
    return true;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\e$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */