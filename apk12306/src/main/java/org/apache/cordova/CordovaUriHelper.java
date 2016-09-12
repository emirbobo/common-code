package org.apache.cordova;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginManager;

public class CordovaUriHelper
{
  private static final String CORDOVA_EXEC_URL_PREFIX = "http://cdv_exec/";
  private static final String TAG = "CordovaUriHelper";
  private CordovaWebView appView;
  private CordovaInterface cordova;
  
  CordovaUriHelper(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    this.appView = paramCordovaWebView;
    this.cordova = paramCordovaInterface;
  }
  
  void handleExecUrl(String paramString)
  {
    int m = "http://cdv_exec/".length();
    int k = paramString.indexOf('#', m + 1);
    int i = paramString.indexOf('#', k + 1);
    int j = paramString.indexOf('#', i + 1);
    if ((m == -1) || (k == -1) || (i == -1) || (j == -1)) {
      Log.e("CordovaUriHelper", "Could not decode URL command: " + paramString);
    }
    for (;;)
    {
      return;
      String str2 = paramString.substring(m, k);
      String str3 = paramString.substring(k + 1, i);
      String str1 = paramString.substring(i + 1, j);
      paramString = paramString.substring(j + 1);
      this.appView.pluginManager.exec(str2, str3, str1, paramString);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.appView.pluginManager.onOverrideUrlLoading(paramString)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramString.startsWith("file://") | paramString.startsWith("data:")))
      {
        bool1 = paramString.contains("app_webview");
      }
      else if (Config.isUrlWhiteListed(paramString))
      {
        bool1 = false;
      }
      else
      {
        bool1 = bool2;
        if (Config.isUrlExternallyWhiteListed(paramString)) {
          try
          {
            paramWebView = new android/content/Intent;
            paramWebView.<init>("android.intent.action.VIEW");
            paramWebView.setData(Uri.parse(paramString));
            this.cordova.getActivity().startActivity(paramWebView);
            bool1 = bool2;
          }
          catch (ActivityNotFoundException paramWebView)
          {
            LOG.e("CordovaUriHelper", "Error loading url " + paramString, paramWebView);
            bool1 = bool2;
          }
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CordovaUriHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */