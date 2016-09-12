package com.worklight.androidgap;

import android.content.Context;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import com.bangcle.andjni.JniLib;
import java.io.File;
import org.apache.cordova.CordovaWebView;

public class WLWebView
  extends CordovaWebView
{
  static
  {
    JniLib.a(WLWebView.class, 1149);
  }
  
  public WLWebView(Context paramContext)
  {
    super(paramContext);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setDefaultTextEncodingName("utf-8");
    localWebSettings.setDatabaseEnabled(true);
    paramContext = paramContext.getApplicationContext().getDir("database", 0).getPath();
    if (paramContext != null) {
      localWebSettings.setDatabasePath(paramContext);
    }
  }
  
  public native boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\WLWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */