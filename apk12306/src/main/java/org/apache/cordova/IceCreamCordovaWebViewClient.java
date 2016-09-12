package org.apache.cordova;

import android.app.Activity;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.IOException;
import java.io.InputStream;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginManager;

public class IceCreamCordovaWebViewClient
  extends CordovaWebViewClient
{
  private static final String TAG = "IceCreamCordovaWebViewClient";
  private CordovaUriHelper helper;
  
  public IceCreamCordovaWebViewClient(CordovaInterface paramCordovaInterface)
  {
    super(paramCordovaInterface);
  }
  
  public IceCreamCordovaWebViewClient(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    super(paramCordovaInterface, paramCordovaWebView);
  }
  
  private WebResourceResponse generateWebResourceResponse(String paramString)
  {
    String str;
    if (paramString.startsWith("file:///android_asset/"))
    {
      str = paramString.replaceFirst("file:///android_asset/", "");
      if (str.contains("?"))
      {
        paramString = str.split("\\?")[0];
        str = null;
        if (paramString.endsWith(".html")) {
          str = "text/html";
        }
      }
    }
    for (;;)
    {
      try
      {
        InputStream localInputStream = this.cordova.getActivity().getAssets().open(Uri.parse(paramString).getPath(), 2);
        paramString = new android/webkit/WebResourceResponse;
        paramString.<init>(str, "UTF-8", localInputStream);
        return paramString;
      }
      catch (IOException paramString)
      {
        LOG.e("generateWebResourceResponse", paramString.getMessage(), paramString);
      }
      paramString = str;
      if (!str.contains("#")) {
        break;
      }
      paramString = str.split("#")[0];
      break;
      paramString = null;
    }
  }
  
  private boolean isUrlHarmful(String paramString)
  {
    if ((!Config.isUrlWhiteListed(paramString)) || (paramString.contains("app_webview"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean needsIceCreamSpaceInAssetUrlFix(String paramString)
  {
    boolean bool = false;
    if (!paramString.contains("%20")) {}
    for (;;)
    {
      return bool;
      switch (Build.VERSION.SDK_INT)
      {
      default: 
        break;
      case 14: 
      case 15: 
        bool = true;
      }
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    WebResourceResponse localWebResourceResponse = super.shouldInterceptRequest(paramWebView, paramString);
    if (isUrlHarmful(paramString))
    {
      LOG.w("IceCreamCordovaWebViewClient", "URL blocked by whitelist: " + paramString);
      paramWebView = new WebResourceResponse("text/plain", "UTF-8", null);
      return paramWebView;
    }
    if ((localWebResourceResponse == null) && ((paramString.contains("?")) || (paramString.contains("#")) || (needsIceCreamSpaceInAssetUrlFix(paramString)))) {
      paramWebView = generateWebResourceResponse(paramString);
    }
    for (;;)
    {
      break;
      paramWebView = localWebResourceResponse;
      if (localWebResourceResponse == null)
      {
        paramWebView = localWebResourceResponse;
        if (this.appView.pluginManager != null) {
          paramWebView = this.appView.pluginManager.shouldInterceptRequest(paramString);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\IceCreamCordovaWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */