package cn.domob.android.ads;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.domob.android.i.f;

class a$1
  extends WebViewClient
{
  a$1(a parama) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    a.b().a("onPageFinished");
    if (a.a(this.a)) {
      a.b(this.a);
    }
    for (;;)
    {
      return;
      a.a(this.a, true);
      a.c(this.a);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    a.b().a("onPageStarted");
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    a.b().a("onReceivedError");
    a.b(this.a, true);
    a.b(this.a);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    a.b().b("WebView url:%s", paramString);
    if (this.a.a != null) {
      this.a.a.a((a)paramWebView, paramString);
    }
    return true;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\A$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */