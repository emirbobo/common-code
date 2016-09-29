package com.alipay.sdk.authjs;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import org.json.JSONException;

public class JsBridge
{
  private IJsCallback a;
  private Context b;
  
  static
  {
    JniLib.a(JsBridge.class, 96);
  }
  
  public JsBridge(Context paramContext, IJsCallback paramIJsCallback)
  {
    this.b = paramContext;
    this.a = paramIJsCallback;
  }
  
  private static native void a(Runnable paramRunnable);
  
  private native void a(String paramString, CallInfo.CallError paramCallError, boolean paramBoolean)
    throws JSONException;
  
  private native CallInfo.CallError b(CallInfo paramCallInfo);
  
  private native void c(CallInfo paramCallInfo);
  
  public native void a(CallInfo paramCallInfo)
    throws JSONException;
  
  public native void a(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\authjs\JsBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */