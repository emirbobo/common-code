package com.worklight.androidgap;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;
import com.customized.webviewclient.MyCordovaWebViewClient;
import com.customized.webviewclient.MyIceCreamCordovaWebViewClient;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.CordovaInterface;

public class SSLWLDroidGap
  extends WLDroidGap
{
  public static final int HONEYCOMB = 11;
  private String absolutePathToExternalAppFiles;
  WebViewListener mWebViewListener;
  
  static
  {
    JniLib.a(SSLWLDroidGap.class, 10);
  }
  
  protected native void bindBrowser(CordovaWebView paramCordovaWebView, boolean paramBoolean);
  
  public native String getAbsolutePathToExternalAppFiles();
  
  public native String getAbsolutePathToExternalWWWAppFiles();
  
  public native void init();
  
  public native void setWebViewListener(WebViewListener paramWebViewListener);
  
  public class MyCordovaWebViewClientT
    extends MyCordovaWebViewClient
  {
    static
    {
      JniLib.a(MyCordovaWebViewClientT.class, 1138);
    }
    
    public MyCordovaWebViewClientT(CordovaInterface paramCordovaInterface)
    {
      super();
    }
    
    public MyCordovaWebViewClientT(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
    {
      super(paramCordovaWebView);
    }
    
    public native void onPageFinished(WebView paramWebView, String paramString);
    
    public native void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  }
  
  public class MyIceCreamCordovaWebViewClientT
    extends MyIceCreamCordovaWebViewClient
  {
    static
    {
      JniLib.a(MyIceCreamCordovaWebViewClientT.class, 1139);
    }
    
    public MyIceCreamCordovaWebViewClientT(CordovaInterface paramCordovaInterface)
    {
      super();
    }
    
    public MyIceCreamCordovaWebViewClientT(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
    {
      super(paramCordovaWebView);
    }
    
    public native void onPageFinished(WebView paramWebView, String paramString);
    
    public native void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  }
  
  public static abstract interface WebViewListener
  {
    public abstract void onPageFinished();
    
    public abstract void onPageStart();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\SSLWLDroidGap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */