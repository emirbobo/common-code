package cn.domob.wall.core.a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.f;

class b$b
  extends WebViewClient
{
  b$b(b paramb) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    b.b().a("onPageFinished with URL:" + paramString);
    b.b(this.a, true);
    if (b.c(this.a) != null) {
      b.c(this.a).i(this.a.a);
    }
    b.g(this.a);
    b.j(this.a);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    b.b().a("onPageStarted with URL:" + paramString);
    b.f(this.a);
    b.j(this.a);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (b.c(this.a) != null) {
      b.c(this.a).j(this.a.a);
    }
    b.b().e(this.a, String.format("WebView ReceivedError, errorCode=%d, description=%s, failingUrl=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }));
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    b.b().a("Override URL loading in landing page:" + paramString);
    Object localObject2;
    Object localObject1;
    if (paramString.startsWith(f.a()))
    {
      localObject2 = Uri.parse(paramString);
      localObject1 = ((Uri)localObject2).getHost();
      if (((String)localObject1).equals("close")) {
        b.i(this.a);
      }
    }
    label194:
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
          b.b().e("Error happened during loading Landing Page.");
          b.b().a(localException);
        }
      }
      b.b().a("Load landing page with URL:" + (String)localObject1);
      paramWebView.loadUrl((String)localObject1);
      for (;;)
      {
        if (b.c(this.a) == null) {
          break label194;
        }
        b.c(this.a).a(paramString, b.a(this.a), this.a.a);
        break;
        if (paramString.startsWith("http")) {
          paramWebView.loadUrl(paramString);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */