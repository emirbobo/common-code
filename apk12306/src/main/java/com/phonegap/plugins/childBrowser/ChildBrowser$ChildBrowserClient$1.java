package com.phonegap.plugins.childBrowser;

import android.webkit.WebView;
import com.bangcle.andjni.JniLib;

class ChildBrowser$ChildBrowserClient$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 1052);
  }
  
  ChildBrowser$ChildBrowserClient$1(ChildBrowser.ChildBrowserClient paramChildBrowserClient, String paramString, WebView paramWebView) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\phonegap\plugins\childBrowser\ChildBrowser$ChildBrowserClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */