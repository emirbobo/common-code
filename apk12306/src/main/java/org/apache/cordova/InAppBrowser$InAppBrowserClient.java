package org.apache.cordova;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppBrowser$InAppBrowserClient
  extends WebViewClient
{
  EditText edittext;
  CordovaWebView webView;
  
  public InAppBrowser$InAppBrowserClient(InAppBrowser paramInAppBrowser, CordovaWebView paramCordovaWebView, EditText paramEditText)
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
      InAppBrowser.access$200(this.this$0, paramWebView, true);
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
        InAppBrowser.access$200(this.this$0, paramString, true);
        return;
        if (paramString.startsWith("tel:"))
        {
          try
          {
            paramWebView = new android/content/Intent;
            paramWebView.<init>("android.intent.action.DIAL");
            paramWebView.setData(Uri.parse(paramString));
            this.this$0.cordova.getActivity().startActivity(paramWebView);
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
            this.this$0.cordova.getActivity().startActivity(paramWebView);
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
              this.this$0.cordova.getActivity().startActivity(localIntent);
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
      InAppBrowser.access$1100(this.this$0, paramWebView, true, PluginResult.Status.ERROR);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\InAppBrowser$InAppBrowserClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */