package com.bontai.mobiads.ads;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.bangcle.andjni.JniLib;

public class RunJavaScript
{
  private Context context;
  
  static
  {
    JniLib.a(RunJavaScript.class, 192);
  }
  
  public RunJavaScript(Context paramContext)
  {
    this.context = paramContext;
  }
  
  @JavascriptInterface
  public native void onClickAdsImage(String paramString1, String paramString2);
  
  @JavascriptInterface
  public native void showTourMainpage();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\RunJavaScript.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */