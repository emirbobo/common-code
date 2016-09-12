package cn.domob.android.ads.a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.domob.android.i.f;

class d$a
  extends WebViewClient
{
  d$a(d paramd) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    d.b().a("onPageFinished with URL:" + paramString);
    d.b(this.a, true);
    if (d.c(this.a) != null) {
      d.c(this.a).r();
    }
    d.g(this.a);
    d.j(this.a);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    d.b().a("onPageStarted with URL:" + paramString);
    d.f(this.a);
    d.j(this.a);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (d.c(this.a) != null) {
      d.c(this.a).s();
    }
    d.b().e(this.a, String.format("WebView ReceivedError, errorCode=%d, description=%s, failingUrl=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }));
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    d.b().a("Override URL loading in landing page:" + paramString);
    Object localObject2;
    Object localObject1;
    if (paramString.startsWith("domob"))
    {
      localObject2 = Uri.parse(paramString);
      localObject1 = ((Uri)localObject2).getHost();
      if (((String)localObject1).equals("close")) {
        d.i(this.a);
      }
    }
    label186:
    for (;;)
    {
      return true;
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
          d.b().e("Error happened during loading Landing Page.");
          d.b().a(localException);
        }
      }
      d.b().a("Load landing page with URL:" + (String)localObject1);
      paramWebView.loadUrl((String)localObject1);
      for (;;)
      {
        if (d.c(this.a) == null) {
          break label186;
        }
        d.c(this.a).a(paramString, d.a(this.a));
        break;
        if (paramString.startsWith("http")) {
          paramWebView.loadUrl(paramString);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */