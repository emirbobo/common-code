package cn.dbox.core.a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.dbox.core.h.d;
import cn.dbox.core.h.f;

class c$d
  extends WebViewClient
{
  c$d(c paramc) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    c.c().a("onPageFinished with URL:" + paramString);
    if (this.a.a != null) {
      this.a.a.b();
    }
    if (c.e(this.a) != null) {
      c.e(this.a).c(this.a.b);
    }
    if (c.f(this.a) != null) {
      c.f(this.a).a(this.a.c);
    }
    if (c.g(this.a) != null) {
      c.g(this.a).a(this.a.d);
    }
    c.c(this.a);
    c.h(this.a);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    c.c().a("onPageStarted with URL:" + paramString);
    c.b(this.a);
    c.h(this.a);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (c.e(this.a) != null) {
      c.e(this.a).d(this.a.b);
    }
    if (c.f(this.a) != null) {
      c.f(this.a).b(this.a.c);
    }
    if (c.g(this.a) != null) {
      c.g(this.a).b(this.a.d);
    }
    c.c().e(this.a, String.format("WebView ReceivedError, errorCode=%d, description=%s, failingUrl=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }));
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    c.c().a("Override URL loading in landing page:" + paramString);
    if (paramString.startsWith(f.a()))
    {
      Object localObject2 = Uri.parse(paramString);
      Object localObject1 = ((Uri)localObject2).getHost();
      if (((String)localObject1).equals("close"))
      {
        this.a.b();
        return true;
      }
      if (((String)localObject1).equals("inapp")) {
        localObject1 = null;
      }
      try
      {
        localObject2 = ((Uri)localObject2).getQueryParameter("url");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          c.c().e("Error happened during loading Landing Page.");
          c.c().a(localException);
        }
      }
      c.c().a("Load landing page with URL:" + (String)localObject1);
      paramWebView.loadUrl((String)localObject1);
    }
    for (;;)
    {
      if (c.e(this.a) != null) {
        c.e(this.a).a(paramString, c.i(this.a), this.a.b);
      }
      if (c.f(this.a) != null) {
        c.f(this.a).a(paramString, c.i(this.a), this.a.c);
      }
      if (c.g(this.a) == null) {
        break;
      }
      c.g(this.a).a(paramString, c.i(this.a), this.a.d);
      break;
      if (paramString.startsWith("http")) {
        paramWebView.loadUrl(paramString);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\c$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */