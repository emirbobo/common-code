package com.phonegap.plugins.childBrowser;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bangcle.andjni.JniLib;
import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

public class ChildBrowser
  extends Plugin
{
  private static final String ALIPAY_ORDER_FLAG_1 = "https://wappaygw.alipay.com/home/exterfaceAssign.htm?";
  private static final String ALIPAY_ORDER_FLAG_2 = "https://mclient.alipay.com/home/exterfaceAssign.htm?";
  private static final String ALIPAY_ORDER_FLAG_3 = "http://mcashier.stable.alipay.net/home/exterfaceAssign.htm?";
  private static final String ALIPAY_ORDER_FLAG_4 = "http://mobileclientgw.stable.alipay.net/home/exterfaceAssign.htm?";
  private static final String ALIPAY_RETURN_URL = "&return_url=";
  private static int CLOSE_EVENT = 0;
  private static int DIALOGOK_EVENT = 4;
  private static int LOCATION_CHANGED_EVENT = 0;
  protected static final String LOG_TAG = "ChildBrowser";
  private static int ORDERCOMPLETE_EVENT;
  private static int ORDERLIST_EVENT;
  private static int event_flag;
  private AlertDialog aDialog;
  private RelativeLayout adsView;
  private String appId = "";
  private String browserCallbackId = null;
  private String counterMsg = "";
  private Dialog dialog;
  private EditText edittext;
  private String interfaceName = "";
  private String interfaceVersion = "";
  private String mAlipayResult;
  private String merSignMsg = "";
  private ProgressDialog spinnerDialog;
  private TextView textView;
  private String tranData = "";
  private String transType = "";
  private WebView webview;
  
  static
  {
    JniLib.a(ChildBrowser.class, 1057);
    CLOSE_EVENT = 0;
    LOCATION_CHANGED_EVENT = 1;
    event_flag = 0;
    ORDERLIST_EVENT = 2;
    ORDERCOMPLETE_EVENT = 3;
  }
  
  private native void closeDialog();
  
  private native void sendUpdate(JSONObject paramJSONObject, boolean paramBoolean);
  
  public native PluginResult execute(String paramString1, JSONArray paramJSONArray, String paramString2);
  
  public native String openDialog(JSONObject paramJSONObject);
  
  public native String openExternal(String paramString, boolean paramBoolean);
  
  public native String replaceAdUrl(String paramString, Context paramContext);
  
  public native void sendTicketInfo(String paramString);
  
  public native String showAdsWebPage(String paramString1, String paramString2, JSONObject paramJSONObject);
  
  public native void showAndroidDialog(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener);
  
  public native void showDialog(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public native void showErrorDialog();
  
  public native String showTaoBaoView(String paramString1, String paramString2, JSONObject paramJSONObject);
  
  public native String showTpcWebView(String paramString1, String paramString2, JSONObject paramJSONObject);
  
  public native String showWebPage(String paramString, JSONObject paramJSONObject);
  
  public native String updateDialog(String paramString);
  
  class AlipayResult
  {
    String memo;
    String result;
    String resultStatus;
    
    static
    {
      JniLib.a(AlipayResult.class, 1051);
    }
    
    public AlipayResult(String paramString)
    {
      this$1 = paramString.split(";");
      int j = ChildBrowser.this.length;
      for (int i = 0;; i++)
      {
        if (i >= j) {
          return;
        }
        paramString = ChildBrowser.this[i];
        if (paramString.startsWith("resultStatus")) {
          this.resultStatus = gatValue(paramString, "resultStatus");
        }
        if (paramString.startsWith("result")) {
          this.result = gatValue(paramString, "result");
        }
        if (paramString.startsWith("memo")) {
          this.memo = gatValue(paramString, "memo");
        }
      }
    }
    
    public native String gatValue(String paramString1, String paramString2);
    
    public native String toString();
  }
  
  public class ChildBrowserClient
    extends WebViewClient
  {
    EditText edittext;
    
    static
    {
      JniLib.a(ChildBrowserClient.class, 1053);
    }
    
    public ChildBrowserClient(EditText paramEditText)
    {
      this.edittext = paramEditText;
    }
    
    public native void onPageFinished(WebView paramWebView, String paramString);
    
    public native void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
    
    public native void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError);
    
    public native boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
  }
  
  final class DemoJavaScriptInterface
  {
    static
    {
      JniLib.a(DemoJavaScriptInterface.class, 1054);
    }
    
    DemoJavaScriptInterface() {}
    
    public native String isInstallCashier(String paramString);
  }
  
  class GeoClient
    extends WebChromeClient
  {
    static
    {
      JniLib.a(GeoClient.class, 1055);
    }
    
    GeoClient() {}
    
    public native void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback);
  }
  
  private class MyWebViewDownLoadListener
    implements DownloadListener
  {
    static
    {
      JniLib.a(MyWebViewDownLoadListener.class, 1056);
    }
    
    private MyWebViewDownLoadListener() {}
    
    public native void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\phonegap\plugins\childBrowser\ChildBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */