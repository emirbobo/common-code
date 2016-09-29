package cn.domob.android.j;

import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;

class e$2
  extends WebChromeClient
{
  e$2(e parame) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    paramCallback.invoke(paramString, true, false);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\e$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */