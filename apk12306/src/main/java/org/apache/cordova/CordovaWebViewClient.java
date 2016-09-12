package org.apache.cordova;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Hashtable;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginManager;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaWebViewClient
  extends WebViewClient
{
  private static final String CORDOVA_EXEC_URL_PREFIX = "http://cdv_exec/";
  private static final String TAG = "Cordova";
  CordovaWebView appView;
  private Hashtable<String, AuthenticationToken> authenticationTokens = new Hashtable();
  CordovaInterface cordova;
  private boolean doClearHistory = false;
  CordovaUriHelper helper;
  
  public CordovaWebViewClient(CordovaInterface paramCordovaInterface)
  {
    this.cordova = paramCordovaInterface;
  }
  
  public CordovaWebViewClient(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    this.cordova = paramCordovaInterface;
    this.appView = paramCordovaWebView;
    this.helper = new CordovaUriHelper(paramCordovaInterface, paramCordovaWebView);
  }
  
  public void clearAuthenticationTokens()
  {
    this.authenticationTokens.clear();
  }
  
  public AuthenticationToken getAuthenticationToken(String paramString1, String paramString2)
  {
    AuthenticationToken localAuthenticationToken = (AuthenticationToken)this.authenticationTokens.get(paramString1.concat(paramString2));
    Object localObject = localAuthenticationToken;
    if (localAuthenticationToken == null)
    {
      localObject = (AuthenticationToken)this.authenticationTokens.get(paramString1);
      paramString1 = (String)localObject;
      if (localObject == null) {
        paramString1 = (AuthenticationToken)this.authenticationTokens.get(paramString2);
      }
      localObject = paramString1;
      if (paramString1 == null) {
        localObject = (AuthenticationToken)this.authenticationTokens.get("");
      }
    }
    return (AuthenticationToken)localObject;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    LOG.d("Cordova", "onPageFinished(" + paramString + ")");
    if (this.doClearHistory)
    {
      paramWebView.clearHistory();
      this.doClearHistory = false;
    }
    paramWebView = this.appView;
    paramWebView.loadUrlTimeout += 1;
    if (!paramString.equals("about:blank"))
    {
      LOG.d("Cordova", "Trying to fire onNativeReady");
      this.appView.loadUrl("javascript:try{ cordova.require('cordova/channel').onNativeReady.fire();}catch(e){_nativeReady = true;}");
      this.appView.postMessage("onNativeReady", null);
    }
    this.appView.postMessage("onPageFinished", paramString);
    if (this.appView.getVisibility() == 4) {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            Thread.sleep(2000L);
            Activity localActivity = CordovaWebViewClient.this.cordova.getActivity();
            Runnable local1 = new org/apache/cordova/CordovaWebViewClient$1$1;
            local1.<init>(this);
            localActivity.runOnUiThread(local1);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
        }
      }).start();
    }
    if (paramString.equals("about:blank")) {
      this.appView.postMessage("exit", null);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.appView.jsMessageQueue.reset();
    this.appView.postMessage("onPageStarted", paramString);
    if (this.appView.pluginManager != null) {
      this.appView.pluginManager.onReset();
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    LOG.d("Cordova", "CordovaWebViewClient.onReceivedError: Error code=%s Description=%s URL=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    paramWebView = this.appView;
    paramWebView.loadUrlTimeout += 1;
    paramWebView = new JSONObject();
    try
    {
      paramWebView.put("errorCode", paramInt);
      paramWebView.put("description", paramString1);
      paramWebView.put("url", paramString2);
      this.appView.postMessage("onReceivedError", paramWebView);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    AuthenticationToken localAuthenticationToken = getAuthenticationToken(paramString1, paramString2);
    if (localAuthenticationToken != null) {
      paramHttpAuthHandler.proceed(localAuthenticationToken.getUserName(), localAuthenticationToken.getPassword());
    }
    for (;;)
    {
      return;
      super.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
    }
  }
  
  @TargetApi(8)
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    String str = this.cordova.getActivity().getPackageName();
    PackageManager localPackageManager = this.cordova.getActivity().getPackageManager();
    try
    {
      if ((localPackageManager.getApplicationInfo(str, 128).flags & 0x2) != 0) {
        paramSslErrorHandler.proceed();
      }
      for (;;)
      {
        return;
        super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      }
    }
  }
  
  public AuthenticationToken removeAuthenticationToken(String paramString1, String paramString2)
  {
    return (AuthenticationToken)this.authenticationTokens.remove(paramString1.concat(paramString2));
  }
  
  public void setAuthenticationToken(AuthenticationToken paramAuthenticationToken, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.authenticationTokens.put(str.concat(paramString1), paramAuthenticationToken);
  }
  
  public void setWebView(CordovaWebView paramCordovaWebView)
  {
    this.appView = paramCordovaWebView;
    this.helper = new CordovaUriHelper(this.cordova, paramCordovaWebView);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return this.helper.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CordovaWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */