package com.alipay.sdk.auth;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.alipay.sdk.authjs.CallInfo;
import com.alipay.sdk.exception.FailOperatingException;
import com.bangcle.andjni.JniLib;
import org.json.JSONObject;

public class AuthActivity
  extends Activity
{
  static final String a = "params";
  static final String b = "redirectUri";
  private WebView c;
  private String d;
  
  static
  {
    JniLib.a(AuthActivity.class, 91);
  }
  
  private native void a();
  
  private native void a(CallInfo paramCallInfo);
  
  private native void a(String paramString);
  
  private native void a(JSONObject paramJSONObject)
    throws FailOperatingException;
  
  private native boolean b(String paramString);
  
  private native void c(String paramString);
  
  private native void d(String paramString);
  
  private native void e(String paramString);
  
  protected native void onCreate(Bundle paramBundle);
  
  protected native void onDestroy();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\auth\AuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */