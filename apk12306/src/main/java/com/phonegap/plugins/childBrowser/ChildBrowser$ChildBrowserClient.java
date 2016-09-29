package com.phonegap.plugins.childBrowser;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import com.bangcle.andjni.JniLib;

public class ChildBrowser$ChildBrowserClient
  extends WebViewClient
{
  EditText edittext;
  
  static
  {
    JniLib.a(ChildBrowserClient.class, 1053);
  }
  
  public ChildBrowser$ChildBrowserClient(ChildBrowser paramChildBrowser, EditText paramEditText)
  {
    this.edittext = paramEditText;
  }
  
  public native void onPageFinished(WebView paramWebView, String paramString);
  
  public native void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public native void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);
  
  public native boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\phonegap\plugins\childBrowser\ChildBrowser$ChildBrowserClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */