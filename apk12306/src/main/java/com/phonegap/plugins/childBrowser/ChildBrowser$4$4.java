package com.phonegap.plugins.childBrowser;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;

class ChildBrowser$4$4
  extends WebChromeClient
{
  static
  {
    JniLib.a(4.class, 1041);
  }
  
  ChildBrowser$4$4(ChildBrowser.4 param4) {}
  
  public native void onReceivedTitle(WebView paramWebView, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\phonegap\plugins\childBrowser\ChildBrowser$4$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */