package org.apache.cordova;

import org.apache.cordova.api.LOG;

class CordovaWebView$2
  implements Runnable
{
  CordovaWebView$2(CordovaWebView paramCordovaWebView1, CordovaWebView paramCordovaWebView2, String paramString) {}
  
  public void run()
  {
    this.val$me.stopLoading();
    LOG.e("CordovaWebView", "CordovaWebView: TIMEOUT ERROR!");
    if (this.this$0.viewClient != null) {
      this.this$0.viewClient.onReceivedError(this.val$me, -6, "The connection to the server was unsuccessful.", this.val$url);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CordovaWebView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */