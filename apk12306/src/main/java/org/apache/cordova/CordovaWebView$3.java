package org.apache.cordova;

import android.app.Activity;
import org.apache.cordova.api.CordovaInterface;

class CordovaWebView$3
  implements Runnable
{
  CordovaWebView$3(CordovaWebView paramCordovaWebView1, int paramInt1, CordovaWebView paramCordovaWebView2, int paramInt2, Runnable paramRunnable) {}
  
  public void run()
  {
    for (;;)
    {
      try {}catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      try
      {
        wait(this.val$loadUrlTimeoutValue);
        if (this.val$me.loadUrlTimeout == this.val$currentLoadUrlTimeout) {
          CordovaWebView.access$100(this.val$me).getActivity().runOnUiThread(this.val$loadError);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CordovaWebView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */