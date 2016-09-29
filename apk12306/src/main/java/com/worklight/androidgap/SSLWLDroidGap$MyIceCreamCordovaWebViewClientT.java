package com.worklight.androidgap;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;
import com.customized.webviewclient.MyIceCreamCordovaWebViewClient;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.CordovaInterface;

public class SSLWLDroidGap$MyIceCreamCordovaWebViewClientT
  extends MyIceCreamCordovaWebViewClient
{
  static
  {
    JniLib.a(MyIceCreamCordovaWebViewClientT.class, 1139);
  }
  
  public SSLWLDroidGap$MyIceCreamCordovaWebViewClientT(SSLWLDroidGap paramSSLWLDroidGap, CordovaInterface paramCordovaInterface)
  {
    super(paramCordovaInterface);
  }
  
  public SSLWLDroidGap$MyIceCreamCordovaWebViewClientT(SSLWLDroidGap paramSSLWLDroidGap, CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    super(paramCordovaInterface, paramCordovaWebView);
  }
  
  public native void onPageFinished(WebView paramWebView, String paramString);
  
  public native void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\SSLWLDroidGap$MyIceCreamCordovaWebViewClientT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */