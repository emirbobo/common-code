package com.phonegap.plugins.childBrowser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;

class ChildBrowser$4
  implements Runnable
{
  static
  {
    JniLib.a(4.class, 1042);
  }
  
  ChildBrowser$4(ChildBrowser paramChildBrowser, String paramString) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\phonegap\plugins\childBrowser\ChildBrowser$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */