package com.tl.uic.webkit;

import android.webkit.WebView;
import com.bangcle.andjni.JniLib;

class UICWebChromeClient$1
  extends Thread
{
  static
  {
    JniLib.a(1.class, 1132);
  }
  
  UICWebChromeClient$1(UICWebChromeClient paramUICWebChromeClient, WebView paramWebView) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\webkit\UICWebChromeClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */