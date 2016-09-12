package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.widget.Loading;
import com.bangcle.andjni.JniLib;

public class H5PayActivity
  extends Activity
{
  private static final String a = "sdklite://h5quit?result=";
  private static final String b = "sdklite://h5quit";
  private static final String c = "http://m.alipay.com/?action=h5quit";
  private static final String d = "&end_code=";
  private static final String e = "&return_url=\"";
  private static final String f = "&return_url=";
  private WebView g;
  private Loading h;
  private Handler i = new Handler();
  private boolean j;
  private Runnable k = new H5PayActivity.1(this);
  
  static
  {
    JniLib.a(H5PayActivity.class, 58);
  }
  
  private native void a();
  
  private native void b();
  
  private native void c();
  
  public native void finish();
  
  public native void onBackPressed();
  
  public native void onConfigurationChanged(Configuration paramConfiguration);
  
  protected native void onCreate(Bundle paramBundle);
  
  private class MyWebChromeClient
    extends WebChromeClient
  {
    static
    {
      JniLib.a(MyWebChromeClient.class, 55);
    }
    
    private MyWebChromeClient() {}
    
    public native boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
    
    public native boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
    
    public native boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult);
  }
  
  private class MyWebViewClient
    extends WebViewClient
  {
    static
    {
      JniLib.a(MyWebViewClient.class, 57);
    }
    
    private MyWebViewClient() {}
    
    public native void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2);
    
    public native void onLoadResource(WebView paramWebView, String paramString);
    
    public native void onPageFinished(WebView paramWebView, String paramString);
    
    public native void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
    
    public native void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
    
    public native void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);
    
    public native boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\H5PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */