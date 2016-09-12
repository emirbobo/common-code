package cn.domob.android.ads;

import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;

class a$2
  extends WebChromeClient
{
  a$2(a parama) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    paramCallback.invoke(paramString, true, false);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */