package cn.domob.android.ads.a;

import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class d$8
  extends WebChromeClient
{
  d$8(d paramd) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    paramCallback.invoke(paramString, true, false);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    d.j(this.a);
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */