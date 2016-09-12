package com.phonegap.plugins.childBrowser;

import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import com.bangcle.andjni.JniLib;

class ChildBrowser$GeoClient
  extends WebChromeClient
{
  static
  {
    JniLib.a(GeoClient.class, 1055);
  }
  
  ChildBrowser$GeoClient(ChildBrowser paramChildBrowser) {}
  
  public native void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\phonegap\plugins\childBrowser\ChildBrowser$GeoClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */