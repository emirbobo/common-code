package org.apache.cordova;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.io.File;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
public class InAppBrowser
  extends CordovaPlugin
{
  private static final String CLOSE_BUTTON_CAPTION = "closebuttoncaption";
  private static final String EXIT_EVENT = "exit";
  private static final String LOAD_ERROR_EVENT = "loaderror";
  private static final String LOAD_START_EVENT = "loadstart";
  private static final String LOAD_STOP_EVENT = "loadstop";
  private static final String LOCATION = "location";
  protected static final String LOG_TAG = "InAppBrowser";
  private static final String NULL = "null";
  private static final String SELF = "_self";
  private static final String SYSTEM = "_system";
  private long MAX_QUOTA = 104857600L;
  private String buttonLabel = "Done";
  private CallbackContext callbackContext;
  private Dialog dialog;
  private EditText edittext;
  private WebView inAppWebView;
  private boolean showLocationBar = true;
  
  private void closeDialog()
  {
    this.cordova.getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        InAppBrowser.this.inAppWebView.loadUrl("about:blank");
        if (InAppBrowser.this.dialog != null) {
          InAppBrowser.this.dialog.dismiss();
        }
      }
    });
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("type", "exit");
      sendUpdate(localJSONObject, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.d("InAppBrowser", "Should never happen");
      }
    }
  }
  
  private boolean getShowLocationBar()
  {
    return this.showLocationBar;
  }
  
  private void goBack()
  {
    if (this.inAppWebView.canGoBack()) {
      this.inAppWebView.goBack();
    }
  }
  
  private void goForward()
  {
    if (this.inAppWebView.canGoForward()) {
      this.inAppWebView.goForward();
    }
  }
  
  private void navigate(String paramString)
  {
    ((InputMethodManager)this.cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.edittext.getWindowToken(), 0);
    if ((!paramString.startsWith("http")) && (!paramString.startsWith("file:"))) {
      this.inAppWebView.loadUrl("http://" + paramString);
    }
    for (;;)
    {
      this.inAppWebView.requestFocus();
      return;
      this.inAppWebView.loadUrl(paramString);
    }
  }
  
  private HashMap<String, Boolean> parseFeature(String paramString)
  {
    if (paramString.equals("null"))
    {
      paramString = null;
      return paramString;
    }
    HashMap localHashMap = new HashMap();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    String str;
    for (;;)
    {
      paramString = localHashMap;
      if (!localStringTokenizer.hasMoreElements()) {
        break;
      }
      paramString = new StringTokenizer(localStringTokenizer.nextToken(), "=");
      if (paramString.hasMoreElements())
      {
        str = paramString.nextToken();
        if (!str.equalsIgnoreCase("closebuttoncaption")) {
          break label90;
        }
        this.buttonLabel = paramString.nextToken();
      }
    }
    label90:
    if (paramString.nextToken().equals("no")) {}
    for (paramString = Boolean.FALSE;; paramString = Boolean.TRUE)
    {
      localHashMap.put(str, paramString);
      break;
    }
  }
  
  private void sendUpdate(JSONObject paramJSONObject, boolean paramBoolean)
  {
    sendUpdate(paramJSONObject, paramBoolean, PluginResult.Status.OK);
  }
  
  private void sendUpdate(JSONObject paramJSONObject, boolean paramBoolean, PluginResult.Status paramStatus)
  {
    paramJSONObject = new PluginResult(paramStatus, paramJSONObject);
    paramJSONObject.setKeepCallback(paramBoolean);
    this.callbackContext.sendPluginResult(paramJSONObject);
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    localObject = PluginResult.Status.OK;
    this.callbackContext = paramCallbackContext;
    for (;;)
    {
      try
      {
        if (!paramString.equals("open")) {
          continue;
        }
        String str = paramJSONArray.getString(0);
        localObject = paramJSONArray.optString(1);
        if ((localObject != null) && (!((String)localObject).equals("")))
        {
          paramString = (String)localObject;
          if (!((String)localObject).equals("null")) {}
        }
        else
        {
          paramString = "_self";
        }
        paramJSONArray = parseFeature(paramJSONArray.optString(2));
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        Log.d("InAppBrowser", "target = " + paramString);
        localObject = this.cordova.getActivity();
        Runnable local1 = new org/apache/cordova/InAppBrowser$1;
        local1.<init>(this, paramString, str, paramJSONArray, paramCallbackContext);
        ((Activity)localObject).runOnUiThread(local1);
      }
      catch (JSONException paramString)
      {
        this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
        continue;
        if (!paramString.equals("injectScriptCode")) {
          continue;
        }
        paramJSONArray = paramJSONArray.getString(0);
        paramString = new org/json/JSONArray;
        paramString.<init>();
        paramString.put(paramJSONArray);
        paramString = paramString.toString();
        paramString = paramString.substring(1, paramString.length() - 1);
        paramJSONArray = new java/lang/StringBuilder;
        paramJSONArray.<init>();
        paramJSONArray = "(function(d){var c=d.createElement('script');c.type='text/javascript';c.innerText=" + paramString + ";d.getElementsByTagName('head')[0].appendChild(c);})(document)";
        localObject = this.cordova.getActivity();
        paramString = new org/apache/cordova/InAppBrowser$2;
        paramString.<init>(this, paramJSONArray, paramCallbackContext);
        ((Activity)localObject).runOnUiThread(paramString);
        continue;
        paramString = PluginResult.Status.INVALID_ACTION;
        continue;
      }
      paramString = new org/apache/cordova/api/PluginResult;
      paramString.<init>(PluginResult.Status.OK);
      paramString.setKeepCallback(true);
      this.callbackContext.sendPluginResult(paramString);
      return true;
      if (!paramString.equals("close")) {
        continue;
      }
      closeDialog();
      paramString = new org/apache/cordova/api/PluginResult;
      paramString.<init>(PluginResult.Status.OK);
      paramString.setKeepCallback(false);
      this.callbackContext.sendPluginResult(paramString);
    }
  }
  
  public String openExternal(String paramString)
  {
    for (;;)
    {
      try
      {
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("android.intent.action.VIEW");
        Log.d("InAppBrowser", "InAppBrowser: Error loading url " + paramString + ":" + localActivityNotFoundException1.toString());
      }
      catch (ActivityNotFoundException localActivityNotFoundException1)
      {
        try
        {
          localIntent.setData(Uri.parse(paramString));
          this.cordova.getActivity().startActivity(localIntent);
          paramString = "";
          return paramString;
        }
        catch (ActivityNotFoundException localActivityNotFoundException2)
        {
          for (;;) {}
        }
        localActivityNotFoundException1 = localActivityNotFoundException1;
      }
      paramString = localActivityNotFoundException1.toString();
    }
  }
  
  public String showWebPage(final String paramString, HashMap<String, Boolean> paramHashMap)
  {
    this.showLocationBar = true;
    if (paramHashMap != null)
    {
      paramHashMap = (Boolean)paramHashMap.get("location");
      if (paramHashMap != null) {
        this.showLocationBar = paramHashMap.booleanValue();
      }
    }
    paramString = new Runnable()
    {
      private int dpToPixels(int paramAnonymousInt)
      {
        return (int)TypedValue.applyDimension(1, paramAnonymousInt, InAppBrowser.this.cordova.getActivity().getResources().getDisplayMetrics());
      }
      
      public void run()
      {
        InAppBrowser.access$102(InAppBrowser.this, new Dialog(InAppBrowser.this.cordova.getActivity(), 16973830));
        InAppBrowser.this.dialog.getWindow().getAttributes().windowAnimations = 16973826;
        InAppBrowser.this.dialog.requestWindowFeature(1);
        InAppBrowser.this.dialog.setCancelable(true);
        InAppBrowser.this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
          {
            try
            {
              paramAnonymous2DialogInterface = new org/json/JSONObject;
              paramAnonymous2DialogInterface.<init>();
              paramAnonymous2DialogInterface.put("type", "exit");
              InAppBrowser.this.sendUpdate(paramAnonymous2DialogInterface, false);
              return;
            }
            catch (JSONException paramAnonymous2DialogInterface)
            {
              for (;;)
              {
                Log.d("InAppBrowser", "Should never happen");
              }
            }
          }
        });
        LinearLayout localLinearLayout = new LinearLayout(InAppBrowser.this.cordova.getActivity());
        localLinearLayout.setOrientation(1);
        Object localObject1 = new RelativeLayout(InAppBrowser.this.cordova.getActivity());
        ((RelativeLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, dpToPixels(44)));
        ((RelativeLayout)localObject1).setPadding(dpToPixels(2), dpToPixels(2), dpToPixels(2), dpToPixels(2));
        ((RelativeLayout)localObject1).setHorizontalGravity(3);
        ((RelativeLayout)localObject1).setVerticalGravity(48);
        RelativeLayout localRelativeLayout = new RelativeLayout(InAppBrowser.this.cordova.getActivity());
        localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        localRelativeLayout.setHorizontalGravity(3);
        localRelativeLayout.setVerticalGravity(16);
        localRelativeLayout.setId(1);
        Button localButton = new Button(InAppBrowser.this.cordova.getActivity());
        Object localObject2 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(5);
        localButton.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localButton.setContentDescription("Back Button");
        localButton.setId(2);
        localButton.setText("<");
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            InAppBrowser.this.goBack();
          }
        });
        localObject2 = new Button(InAppBrowser.this.cordova.getActivity());
        Object localObject3 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2);
        ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((Button)localObject2).setContentDescription("Forward Button");
        ((Button)localObject2).setId(3);
        ((Button)localObject2).setText(">");
        ((Button)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            InAppBrowser.this.goForward();
          }
        });
        InAppBrowser.access$502(InAppBrowser.this, new EditText(InAppBrowser.this.cordova.getActivity()));
        localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(1, 1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(0, 5);
        InAppBrowser.this.edittext.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        InAppBrowser.this.edittext.setId(4);
        InAppBrowser.this.edittext.setSingleLine(true);
        InAppBrowser.this.edittext.setText(paramString);
        InAppBrowser.this.edittext.setInputType(16);
        InAppBrowser.this.edittext.setImeOptions(2);
        InAppBrowser.this.edittext.setInputType(0);
        InAppBrowser.this.edittext.setOnKeyListener(new View.OnKeyListener()
        {
          public boolean onKey(View paramAnonymous2View, int paramAnonymous2Int, KeyEvent paramAnonymous2KeyEvent)
          {
            if ((paramAnonymous2KeyEvent.getAction() == 0) && (paramAnonymous2Int == 66)) {
              InAppBrowser.this.navigate(InAppBrowser.this.edittext.getText().toString());
            }
            for (boolean bool = true;; bool = false) {
              return bool;
            }
          }
        });
        localObject3 = new Button(InAppBrowser.this.cordova.getActivity());
        Object localObject4 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject4).addRule(11);
        ((Button)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((Button)localObject2).setContentDescription("Close Button");
        ((Button)localObject3).setId(5);
        ((Button)localObject3).setText(InAppBrowser.this.buttonLabel);
        ((Button)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            InAppBrowser.this.closeDialog();
          }
        });
        InAppBrowser.access$002(InAppBrowser.this, new WebView(InAppBrowser.this.cordova.getActivity()));
        InAppBrowser.this.inAppWebView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        InAppBrowser.this.inAppWebView.setWebChromeClient(new InAppBrowser.InAppChromeClient(InAppBrowser.this));
        localObject4 = new InAppBrowser.InAppBrowserClient(InAppBrowser.this, this.val$thatWebView, InAppBrowser.this.edittext);
        InAppBrowser.this.inAppWebView.setWebViewClient((WebViewClient)localObject4);
        localObject4 = InAppBrowser.this.inAppWebView.getSettings();
        ((WebSettings)localObject4).setJavaScriptEnabled(true);
        ((WebSettings)localObject4).setJavaScriptCanOpenWindowsAutomatically(true);
        ((WebSettings)localObject4).setBuiltInZoomControls(true);
        ((WebSettings)localObject4).setPluginsEnabled(true);
        Bundle localBundle = InAppBrowser.this.cordova.getActivity().getIntent().getExtras();
        if (localBundle == null) {}
        for (boolean bool = true;; bool = localBundle.getBoolean("InAppBrowserStorageEnabled", true))
        {
          if (bool)
          {
            ((WebSettings)localObject4).setDatabasePath(InAppBrowser.this.cordova.getActivity().getApplicationContext().getDir("inAppBrowserDB", 0).getPath());
            ((WebSettings)localObject4).setDatabaseEnabled(true);
          }
          ((WebSettings)localObject4).setDomStorageEnabled(true);
          InAppBrowser.this.inAppWebView.loadUrl(paramString);
          InAppBrowser.this.inAppWebView.setId(6);
          InAppBrowser.this.inAppWebView.getSettings().setLoadWithOverviewMode(true);
          InAppBrowser.this.inAppWebView.getSettings().setUseWideViewPort(true);
          InAppBrowser.this.inAppWebView.requestFocus();
          InAppBrowser.this.inAppWebView.requestFocusFromTouch();
          localRelativeLayout.addView(localButton);
          localRelativeLayout.addView((View)localObject2);
          ((RelativeLayout)localObject1).addView(localRelativeLayout);
          ((RelativeLayout)localObject1).addView(InAppBrowser.this.edittext);
          ((RelativeLayout)localObject1).addView((View)localObject3);
          if (InAppBrowser.this.getShowLocationBar()) {
            localLinearLayout.addView((View)localObject1);
          }
          localLinearLayout.addView(InAppBrowser.this.inAppWebView);
          localObject1 = new WindowManager.LayoutParams();
          ((WindowManager.LayoutParams)localObject1).copyFrom(InAppBrowser.this.dialog.getWindow().getAttributes());
          ((WindowManager.LayoutParams)localObject1).width = -1;
          ((WindowManager.LayoutParams)localObject1).height = -1;
          InAppBrowser.this.dialog.setContentView(localLinearLayout);
          InAppBrowser.this.dialog.show();
          InAppBrowser.this.dialog.getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
          return;
        }
      }
    };
    this.cordova.getActivity().runOnUiThread(paramString);
    return "";
  }
  
  public class InAppBrowserClient
    extends WebViewClient
  {
    EditText edittext;
    CordovaWebView webView;
    
    public InAppBrowserClient(CordovaWebView paramCordovaWebView, EditText paramEditText)
    {
      this.webView = paramCordovaWebView;
      this.edittext = paramEditText;
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      try
      {
        paramWebView = new org/json/JSONObject;
        paramWebView.<init>();
        paramWebView.put("type", "loadstop");
        paramWebView.put("url", paramString);
        InAppBrowser.this.sendUpdate(paramWebView, true);
        return;
      }
      catch (JSONException paramWebView)
      {
        for (;;)
        {
          Log.d("InAppBrowser", "Should never happen");
        }
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      paramBitmap = "";
      if ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("file:"))) {
        paramWebView = paramString;
      }
      for (;;)
      {
        if (!paramWebView.equals(this.edittext.getText().toString())) {
          this.edittext.setText(paramWebView);
        }
        try
        {
          paramString = new org/json/JSONObject;
          paramString.<init>();
          paramString.put("type", "loadstart");
          paramString.put("url", paramWebView);
          InAppBrowser.this.sendUpdate(paramString, true);
          return;
          if (paramString.startsWith("tel:"))
          {
            try
            {
              paramWebView = new android/content/Intent;
              paramWebView.<init>("android.intent.action.DIAL");
              paramWebView.setData(Uri.parse(paramString));
              InAppBrowser.this.cordova.getActivity().startActivity(paramWebView);
              paramWebView = paramBitmap;
            }
            catch (ActivityNotFoundException paramWebView)
            {
              LOG.e("InAppBrowser", "Error dialing " + paramString + ": " + paramWebView.toString());
              paramWebView = paramBitmap;
            }
            continue;
          }
          if ((paramString.startsWith("geo:")) || (paramString.startsWith("mailto:")) || (paramString.startsWith("market:")))
          {
            try
            {
              paramWebView = new android/content/Intent;
              paramWebView.<init>("android.intent.action.VIEW");
              paramWebView.setData(Uri.parse(paramString));
              InAppBrowser.this.cordova.getActivity().startActivity(paramWebView);
              paramWebView = paramBitmap;
            }
            catch (ActivityNotFoundException paramWebView)
            {
              LOG.e("InAppBrowser", "Error with " + paramString + ": " + paramWebView.toString());
              paramWebView = paramBitmap;
            }
            continue;
          }
          if (paramString.startsWith("sms:")) {
            for (;;)
            {
              Intent localIntent;
              int i;
              try
              {
                localIntent = new android/content/Intent;
                localIntent.<init>("android.intent.action.VIEW");
                i = paramString.indexOf('?');
                if (i != -1) {
                  break label454;
                }
                paramWebView = paramString.substring(4);
                localObject = new java/lang/StringBuilder;
                ((StringBuilder)localObject).<init>();
                localIntent.setData(Uri.parse("sms:" + paramWebView));
                localIntent.putExtra("address", paramWebView);
                localIntent.setType("vnd.android-dir/mms-sms");
                InAppBrowser.this.cordova.getActivity().startActivity(localIntent);
                paramWebView = paramBitmap;
              }
              catch (ActivityNotFoundException paramWebView)
              {
                LOG.e("InAppBrowser", "Error sending sms " + paramString + ":" + paramWebView.toString());
                paramWebView = paramBitmap;
              }
              break;
              label454:
              Object localObject = paramString.substring(4, i);
              String str = Uri.parse(paramString).getQuery();
              paramWebView = (WebView)localObject;
              if (str != null)
              {
                paramWebView = (WebView)localObject;
                if (str.startsWith("body="))
                {
                  localIntent.putExtra("sms_body", str.substring(5));
                  paramWebView = (WebView)localObject;
                }
              }
            }
          }
          paramWebView = "http://" + paramString;
        }
        catch (JSONException paramWebView)
        {
          for (;;)
          {
            Log.d("InAppBrowser", "Should never happen");
          }
        }
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      try
      {
        paramWebView = new org/json/JSONObject;
        paramWebView.<init>();
        paramWebView.put("type", "loaderror");
        paramWebView.put("url", paramString2);
        paramWebView.put("code", paramInt);
        paramWebView.put("message", paramString1);
        InAppBrowser.this.sendUpdate(paramWebView, true, PluginResult.Status.ERROR);
        return;
      }
      catch (JSONException paramWebView)
      {
        for (;;)
        {
          Log.d("InAppBrowser", "Should never happen");
        }
      }
    }
  }
  
  public class InAppChromeClient
    extends WebChromeClient
  {
    public InAppChromeClient() {}
    
    public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
    {
      LOG.d("InAppBrowser", "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(paramLong3) });
      if (paramLong2 < InAppBrowser.this.MAX_QUOTA)
      {
        LOG.d("InAppBrowser", "calling quotaUpdater.updateQuota newQuota: %d", new Object[] { Long.valueOf(paramLong2) });
        paramQuotaUpdater.updateQuota(paramLong2);
      }
      for (;;)
      {
        return;
        paramQuotaUpdater.updateQuota(paramLong1);
      }
    }
    
    public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      paramCallback.invoke(paramString, true, false);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\InAppBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */