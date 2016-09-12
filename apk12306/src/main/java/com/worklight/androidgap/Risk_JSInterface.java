package com.worklight.androidgap;

import android.annotation.SuppressLint;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;

public class Risk_JSInterface
{
  static String cur_code = null;
  static String def_code;
  
  static
  {
    JniLib.a(Risk_JSInterface.class, 1137);
    def_code = "javascript:void(0)";
  }
  
  @SuppressLint({"DefaultLocale"})
  public static native void OnFinish(WebView paramWebView);
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public static native void addJS(WebView paramWebView);
  
  @JavascriptInterface
  public native void setRiskUserInfo(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\Risk_JSInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */