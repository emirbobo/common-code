package org.apache.cordova;

import android.app.Dialog;
import android.webkit.WebView;

class InAppBrowser$3
  implements Runnable
{
  InAppBrowser$3(InAppBrowser paramInAppBrowser) {}
  
  public void run()
  {
    InAppBrowser.access$000(this.this$0).loadUrl("about:blank");
    if (InAppBrowser.access$100(this.this$0) != null) {
      InAppBrowser.access$100(this.this$0).dismiss();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\InAppBrowser$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */