package com.alipay.sdk.app;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;

class H5PayActivity$MyWebChromeClient
  extends WebChromeClient
{
  static
  {
    JniLib.a(MyWebChromeClient.class, 55);
  }
  
  private H5PayActivity$MyWebChromeClient(H5PayActivity paramH5PayActivity) {}
  
  public native boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
  
  public native boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
  
  public native boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\H5PayActivity$MyWebChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */