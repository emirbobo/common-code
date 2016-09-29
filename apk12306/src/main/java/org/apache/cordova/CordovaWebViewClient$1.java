package org.apache.cordova;

import android.app.Activity;
import org.apache.cordova.api.CordovaInterface;

class CordovaWebViewClient$1
  implements Runnable
{
  CordovaWebViewClient$1(CordovaWebViewClient paramCordovaWebViewClient) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(2000L);
      Activity localActivity = this.this$0.cordova.getActivity();
      Runnable local1 = new org/apache/cordova/CordovaWebViewClient$1$1;
      local1.<init>(this);
      localActivity.runOnUiThread(local1);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CordovaWebViewClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */