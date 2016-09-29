package cn.domob.android.offerwall;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
      return;
      a.a(this.a, true);
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
    a.b(this.a, true);
    a.b(this.a);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (a.d(this.a) != null) {
      a.d(this.a).a((a)paramWebView, paramString);
    }
    if (paramString.startsWith("http")) {
      paramWebView.loadUrl(paramString);
    }
    return true;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */