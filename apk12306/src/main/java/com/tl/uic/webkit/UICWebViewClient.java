package com.tl.uic.webkit;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bangcle.andjni.JniLib;

public class UICWebViewClient
  extends WebViewClient
{
  static
  {
    JniLib.a(UICWebViewClient.class, 1135);
  }
  
  public native boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\webkit\UICWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */