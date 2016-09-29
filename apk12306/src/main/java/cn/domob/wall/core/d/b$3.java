package cn.domob.wall.core.d;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import cn.domob.wall.core.h.d;

class b$3
  extends WebChromeClient
{
  b$3(b paramb) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    this.a.c.a(paramInt);
    b.b().b("newProgress:" + paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\b$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */