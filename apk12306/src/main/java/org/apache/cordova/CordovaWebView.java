package org.apache.cordova;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import com.worklight.androidgap.Risk_JSInterface;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginManager;
import org.apache.cordova.api.PluginResult;

public class CordovaWebView
  extends WebView
{
  static final FrameLayout.LayoutParams COVER_SCREEN_GRAVITY_CENTER = new FrameLayout.LayoutParams(-1, -1, 17);
  public static final String TAG = "CordovaWebView";
  private boolean bound;
  private CordovaChromeClient chromeClient;
  private CordovaInterface cordova;
  ExposedJsApi exposedJsApi;
  private boolean handleButton = false;
  NativeToJsMessageQueue jsMessageQueue;
  private ArrayList<Integer> keyDownCodes = new ArrayList();
  private ArrayList<Integer> keyUpCodes = new ArrayList();
  private long lastMenuEventTime = 0L;
  int loadUrlTimeout = 0;
  private View mCustomView;
  private WebChromeClient.CustomViewCallback mCustomViewCallback;
  private ActivityResult mResult = null;
  private boolean paused;
  public PluginManager pluginManager;
  private BroadcastReceiver receiver;
  private String url;
  CordovaWebViewClient viewClient;
  
  public CordovaWebView(Context paramContext)
  {
    super(paramContext);
    if (CordovaInterface.class.isInstance(paramContext)) {
      this.cordova = ((CordovaInterface)paramContext);
    }
    for (;;)
    {
      loadConfiguration();
      setup();
      return;
      Log.d("CordovaWebView", "Your activity must implement CordovaInterface to work");
    }
  }
  
  public CordovaWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (CordovaInterface.class.isInstance(paramContext)) {
      this.cordova = ((CordovaInterface)paramContext);
    }
    for (;;)
    {
      setWebChromeClient(new CordovaChromeClient(this.cordova, this));
      initWebViewClient(this.cordova);
      loadConfiguration();
      setup();
      return;
      Log.d("CordovaWebView", "Your activity must implement CordovaInterface to work");
    }
  }
  
  public CordovaWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (CordovaInterface.class.isInstance(paramContext)) {
      this.cordova = ((CordovaInterface)paramContext);
    }
    for (;;)
    {
      setWebChromeClient(new CordovaChromeClient(this.cordova, this));
      loadConfiguration();
      setup();
      return;
      Log.d("CordovaWebView", "Your activity must implement CordovaInterface to work");
    }
  }
  
  @TargetApi(11)
  public CordovaWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt, paramBoolean);
    if (CordovaInterface.class.isInstance(paramContext)) {
      this.cordova = ((CordovaInterface)paramContext);
    }
    for (;;)
    {
      setWebChromeClient(new CordovaChromeClient(this.cordova));
      initWebViewClient(this.cordova);
      loadConfiguration();
      setup();
      return;
      Log.d("CordovaWebView", "Your activity must implement CordovaInterface to work");
    }
  }
  
  private void exposeJsInterface()
  {
    if (Build.VERSION.SDK_INT < 17) {
      Log.i("CordovaWebView", "Disabled addJavascriptInterface() bridge since Android version is old.");
    }
    for (;;)
    {
      return;
      addJavascriptInterface(this.exposedJsApi, "_cordovaNative");
      Risk_JSInterface.addJS(this);
    }
  }
  
  private void initWebViewClient(CordovaInterface paramCordovaInterface)
  {
    if ((Build.VERSION.SDK_INT < 11) || (Build.VERSION.SDK_INT > 17)) {
      setWebViewClient(new CordovaWebViewClient(this.cordova, this));
    }
    for (;;)
    {
      return;
      setWebViewClient(new IceCreamCordovaWebViewClient(this.cordova, this));
    }
  }
  
  private void loadConfiguration()
  {
    if ("true".equals(getProperty("fullscreen", "false")))
    {
      this.cordova.getActivity().getWindow().clearFlags(2048);
      this.cordova.getActivity().getWindow().setFlags(1024, 1024);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void setup()
  {
    setInitialScale(0);
    setVerticalScrollBarEnabled(false);
    requestFocusFromTouch();
    Object localObject1 = getSettings();
    ((WebSettings)localObject1).setJavaScriptEnabled(true);
    ((WebSettings)localObject1).setJavaScriptCanOpenWindowsAutomatically(true);
    ((WebSettings)localObject1).setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    try
    {
      Object localObject2 = WebSettings.class.getMethod("setNavDump", new Class[] { Boolean.TYPE });
      if (Build.VERSION.SDK_INT < 11) {
        ((Method)localObject2).invoke(localObject1, new Object[] { Boolean.valueOf(true) });
      }
      ((WebSettings)localObject1).setSaveFormData(false);
      ((WebSettings)localObject1).setSavePassword(false);
      if (Build.VERSION.SDK_INT > 15) {
        Level16Apis.enableUniversalAccess((WebSettings)localObject1);
      }
      localObject2 = this.cordova.getActivity().getApplicationContext().getDir("database", 0).getPath();
      if (Build.VERSION.SDK_INT < 11)
      {
        ((WebSettings)localObject1).setDatabaseEnabled(true);
        ((WebSettings)localObject1).setDatabasePath((String)localObject2);
      }
      ((WebSettings)localObject1).setGeolocationDatabasePath((String)localObject2);
      ((WebSettings)localObject1).setDomStorageEnabled(true);
      ((WebSettings)localObject1).setGeolocationEnabled(true);
      ((WebSettings)localObject1).setAppCacheMaxSize(5242880L);
      ((WebSettings)localObject1).setAppCachePath(this.cordova.getActivity().getApplicationContext().getDir("database", 0).getPath());
      ((WebSettings)localObject1).setAppCacheEnabled(true);
      updateUserAgentString();
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.intent.action.CONFIGURATION_CHANGED");
      if (this.receiver == null)
      {
        this.receiver = new BroadcastReceiver()
        {
          public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            CordovaWebView.this.updateUserAgentString();
          }
        };
        this.cordova.getActivity().registerReceiver(this.receiver, (IntentFilter)localObject1);
      }
      this.pluginManager = new PluginManager(this, this.cordova);
      this.jsMessageQueue = new NativeToJsMessageQueue(this, this.cordova);
      this.exposedJsApi = new ExposedJsApi(this.pluginManager, this.jsMessageQueue);
      exposeJsInterface();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.d("CordovaWebView", "We are on a modern version of Android, we will deprecate HTC 2.3 devices in 2.8");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.d("CordovaWebView", "Doing the NavDump failed with bad arguments");
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.d("CordovaWebView", "This should never happen: IllegalAccessException means this isn't Android anymore");
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.d("CordovaWebView", "This should never happen: InvocationTargetException means this isn't Android anymore.");
      }
    }
  }
  
  private void updateUserAgentString()
  {
    getSettings().getUserAgentString();
  }
  
  public boolean backHistory()
  {
    if (super.canGoBack())
    {
      printBackForwardList();
      super.goBack();
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void bindButton(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.keyDownCodes.add(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      return;
      this.keyUpCodes.add(Integer.valueOf(paramInt));
    }
  }
  
  public void bindButton(String paramString, boolean paramBoolean)
  {
    if (paramString.compareTo("volumeup") == 0) {
      this.keyDownCodes.add(Integer.valueOf(24));
    }
    for (;;)
    {
      return;
      if (paramString.compareTo("volumedown") == 0) {
        this.keyDownCodes.add(Integer.valueOf(25));
      }
    }
  }
  
  public void bindButton(boolean paramBoolean)
  {
    this.bound = paramBoolean;
  }
  
  public String getProperty(String paramString1, String paramString2)
  {
    Bundle localBundle = this.cordova.getActivity().getIntent().getExtras();
    if (localBundle == null) {}
    for (;;)
    {
      return paramString2;
      paramString1 = localBundle.get(paramString1);
      if (paramString1 != null) {
        paramString2 = paramString1.toString();
      }
    }
  }
  
  public CordovaChromeClient getWebChromeClient()
  {
    return this.chromeClient;
  }
  
  public boolean hadKeyEvent()
  {
    return this.handleButton;
  }
  
  public void handleDestroy()
  {
    loadUrlIntoView("javascript:try{cordova.require('cordova/channel').onDestroy.fire();}catch(e){console.log('exception firing destroy event from native');};");
    loadUrl("about:blank");
    if (this.pluginManager != null) {
      this.pluginManager.onDestroy();
    }
    if (this.receiver != null) {}
    try
    {
      this.cordova.getActivity().unregisterReceiver(this.receiver);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("CordovaWebView", "Error unregistering configuration receiver: " + localException.getMessage(), localException);
      }
    }
  }
  
  public void handlePause(boolean paramBoolean)
  {
    LOG.d("CordovaWebView", "Handle the pause");
    loadUrl("javascript:try{cordova.fireDocumentEvent('pause');}catch(e){console.log('exception firing pause event from native');};");
    if (this.pluginManager != null) {
      this.pluginManager.onPause(paramBoolean);
    }
    if (!paramBoolean) {
      pauseTimers();
    }
    this.paused = true;
  }
  
  public void handleResume(boolean paramBoolean1, boolean paramBoolean2)
  {
    loadUrl("javascript:try{cordova.fireDocumentEvent('resume');}catch(e){console.log('exception firing resume event from native');};");
    if (this.pluginManager != null) {
      this.pluginManager.onResume(paramBoolean1);
    }
    resumeTimers();
    this.paused = false;
  }
  
  public void hideCustomView()
  {
    Log.d("CordovaWebView", "Hidding Custom View");
    if (this.mCustomView == null) {}
    for (;;)
    {
      return;
      this.mCustomView.setVisibility(8);
      ((ViewGroup)getParent()).removeView(this.mCustomView);
      this.mCustomView = null;
      this.mCustomViewCallback.onCustomViewHidden();
      setVisibility(0);
    }
  }
  
  public boolean isBackButtonBound()
  {
    return this.bound;
  }
  
  public boolean isCustomViewShowing()
  {
    if (this.mCustomView != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isPaused()
  {
    return this.paused;
  }
  
  public void loadUrl(String paramString)
  {
    if ((paramString.equals("about:blank")) || (paramString.startsWith("javascript:"))) {
      loadUrlNow(paramString);
    }
    for (;;)
    {
      return;
      loadUrlIntoView(paramString);
    }
  }
  
  @Deprecated
  public void loadUrl(String paramString, int paramInt)
  {
    if (paramString == null) {
      loadUrlIntoView(Config.getStartUrl());
    }
    for (;;)
    {
      return;
      loadUrlIntoView(paramString);
    }
  }
  
  public void loadUrlIntoView(final String paramString)
  {
    LOG.d("CordovaWebView", ">>> loadUrl(" + paramString + ")");
    this.url = paramString;
    this.pluginManager.init();
    final int i = this.loadUrlTimeout;
    final Runnable local3 = new Runnable()
    {
      public void run()
      {
        jdField_this.stopLoading();
        LOG.e("CordovaWebView", "CordovaWebView: TIMEOUT ERROR!");
        if (CordovaWebView.this.viewClient != null) {
          CordovaWebView.this.viewClient.onReceivedError(jdField_this, -6, "The connection to the server was unsuccessful.", paramString);
        }
      }
    }
    {
      public void run()
      {
        for (;;)
        {
          try {}catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            continue;
          }
          try
          {
            wait(this.val$loadUrlTimeoutValue);
            if (jdField_this.loadUrlTimeout == i) {
              jdField_this.cordova.getActivity().runOnUiThread(this.val$loadError);
            }
            return;
          }
          finally {}
        }
      }
    };
    this.cordova.getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        new Thread(local3).start();
        jdField_this.loadUrlNow(paramString);
      }
    });
  }
  
  public void loadUrlIntoView(String paramString, int paramInt)
  {
    if ((paramString.startsWith("javascript:")) || (canGoBack())) {}
    for (;;)
    {
      loadUrlIntoView(paramString);
      return;
      LOG.d("CordovaWebView", "DroidGap.loadUrl(%s, %d)", new Object[] { paramString, Integer.valueOf(paramInt) });
      postMessage("splashscreen", "show");
    }
  }
  
  void loadUrlNow(String paramString)
  {
    if ((LOG.isLoggable(3)) && (!paramString.startsWith("javascript:"))) {
      LOG.d("CordovaWebView", ">>> loadUrlNow()");
    }
    if ((paramString.startsWith("file://")) || (paramString.startsWith("javascript:")) || (Config.isUrlWhiteListed(paramString))) {
      super.loadUrl(paramString);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (this.keyDownCodes.contains(Integer.valueOf(paramInt))) {
      if (paramInt == 25)
      {
        LOG.d("CordovaWebView", "Down Key Hit");
        loadUrl("javascript:cordova.fireDocumentEvent('volumedownbutton');");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      if (paramInt == 24)
      {
        LOG.d("CordovaWebView", "Up Key Hit");
        loadUrl("javascript:cordova.fireDocumentEvent('volumeupbutton');");
        bool1 = bool2;
      }
      else
      {
        bool1 = super.onKeyDown(paramInt, paramKeyEvent);
        continue;
        if (paramInt == 4)
        {
          if ((!startOfHistory()) || (this.bound)) {
            bool1 = true;
          }
        }
        else if (paramInt == 82)
        {
          paramKeyEvent = getFocusedChild();
          bool1 = bool2;
          if (paramKeyEvent != null)
          {
            ((InputMethodManager)this.cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(paramKeyEvent.getWindowToken(), 0);
            this.cordova.getActivity().openOptionsMenu();
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = super.onKeyDown(paramInt, paramKeyEvent);
        }
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt == 4) {
      if (this.mCustomView != null)
      {
        hideCustomView();
        bool = super.onKeyUp(paramInt, paramKeyEvent);
      }
    }
    for (;;)
    {
      return bool;
      if (this.bound)
      {
        loadUrl("javascript:cordova.fireDocumentEvent('backbutton');");
      }
      else if (!backHistory())
      {
        this.cordova.getActivity().finish();
        break;
        if (paramInt == 82)
        {
          if (this.lastMenuEventTime < paramKeyEvent.getEventTime()) {
            loadUrl("javascript:cordova.fireDocumentEvent('menubutton');");
          }
          this.lastMenuEventTime = paramKeyEvent.getEventTime();
          bool = super.onKeyUp(paramInt, paramKeyEvent);
        }
        else if (paramInt == 84)
        {
          loadUrl("javascript:cordova.fireDocumentEvent('searchbutton');");
        }
        else
        {
          if (!this.keyUpCodes.contains(Integer.valueOf(paramInt))) {
            break;
          }
          bool = super.onKeyUp(paramInt, paramKeyEvent);
        }
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (this.pluginManager != null) {
      this.pluginManager.onNewIntent(paramIntent);
    }
  }
  
  public void postMessage(String paramString, Object paramObject)
  {
    if (this.pluginManager != null) {
      this.pluginManager.postMessage(paramString, paramObject);
    }
  }
  
  public void printBackForwardList()
  {
    WebBackForwardList localWebBackForwardList = copyBackForwardList();
    int j = localWebBackForwardList.getSize();
    for (int i = 0; i < j; i++)
    {
      String str = localWebBackForwardList.getItemAtIndex(i).getUrl();
      LOG.d("CordovaWebView", "The URL at index: " + Integer.toString(i) + "is " + str);
    }
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    paramBundle = super.restoreState(paramBundle);
    Log.d("CordovaWebView", "WebView restoration crew now restoring!");
    this.pluginManager.init();
    return paramBundle;
  }
  
  public void sendJavascript(String paramString)
  {
    this.jsMessageQueue.addJavaScript(paramString);
  }
  
  public void sendPluginResult(PluginResult paramPluginResult, String paramString)
  {
    this.jsMessageQueue.addPluginResult(paramPluginResult, paramString);
  }
  
  public void setWebChromeClient(CordovaChromeClient paramCordovaChromeClient)
  {
    this.chromeClient = paramCordovaChromeClient;
    super.setWebChromeClient(paramCordovaChromeClient);
  }
  
  public void setWebViewClient(CordovaWebViewClient paramCordovaWebViewClient)
  {
    this.viewClient = paramCordovaWebViewClient;
    super.setWebViewClient(paramCordovaWebViewClient);
  }
  
  public void showCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    Log.d("CordovaWebView", "showing Custom View");
    if (this.mCustomView != null) {
      paramCustomViewCallback.onCustomViewHidden();
    }
    for (;;)
    {
      return;
      this.mCustomView = paramView;
      this.mCustomViewCallback = paramCustomViewCallback;
      paramCustomViewCallback = (ViewGroup)getParent();
      paramCustomViewCallback.addView(paramView, COVER_SCREEN_GRAVITY_CENTER);
      setVisibility(8);
      paramCustomViewCallback.setVisibility(0);
      paramCustomViewCallback.bringToFront();
    }
  }
  
  public void showWebPage(String paramString, boolean paramBoolean1, boolean paramBoolean2, HashMap<String, Object> paramHashMap)
  {
    LOG.d("CordovaWebView", "showWebPage(%s, %b, %b, HashMap", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2) {
      clearHistory();
    }
    if (!paramBoolean1) {
      if ((paramString.startsWith("file://")) || (Config.isUrlWhiteListed(paramString))) {
        loadUrl(paramString);
      }
    }
    for (;;)
    {
      return;
      LOG.w("CordovaWebView", "showWebPage: Cannot load URL into webview since it is not in white list.  Loading into browser instead. (URL=" + paramString + ")");
      try
      {
        paramHashMap = new android/content/Intent;
        paramHashMap.<init>("android.intent.action.VIEW");
        paramHashMap.setData(Uri.parse(paramString));
        this.cordova.getActivity().startActivity(paramHashMap);
      }
      catch (ActivityNotFoundException paramHashMap)
      {
        LOG.e("CordovaWebView", "Error loading url " + paramString, paramHashMap);
      }
      continue;
      try
      {
        paramHashMap = new android/content/Intent;
        paramHashMap.<init>("android.intent.action.VIEW");
        paramHashMap.setData(Uri.parse(paramString));
        this.cordova.getActivity().startActivity(paramHashMap);
      }
      catch (ActivityNotFoundException paramHashMap)
      {
        LOG.e("CordovaWebView", "Error loading url " + paramString, paramHashMap);
      }
    }
  }
  
  public boolean startOfHistory()
  {
    boolean bool = false;
    Object localObject = copyBackForwardList().getItemAtIndex(0);
    if (localObject != null)
    {
      localObject = ((WebHistoryItem)localObject).getUrl();
      String str = getUrl();
      LOG.d("CordovaWebView", "The current URL is: " + str);
      LOG.d("CordovaWebView", "The URL at item 0 is:" + (String)localObject);
      bool = str.equals(localObject);
    }
    return bool;
  }
  
  public void storeResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mResult = new ActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  class ActivityResult
  {
    Intent incoming;
    int request;
    int result;
    
    public ActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.request = paramInt1;
      this.result = paramInt2;
      this.incoming = paramIntent;
    }
  }
  
  @TargetApi(16)
  private static class Level16Apis
  {
    static void enableUniversalAccess(WebSettings paramWebSettings)
    {
      paramWebSettings.setAllowUniversalAccessFromFileURLs(true);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CordovaWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */