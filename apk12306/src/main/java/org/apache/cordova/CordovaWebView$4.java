package org.apache.cordova;

class CordovaWebView$4
  implements Runnable
{
  CordovaWebView$4(CordovaWebView paramCordovaWebView1, Runnable paramRunnable, CordovaWebView paramCordovaWebView2, String paramString) {}
  
  public void run()
  {
    new Thread(this.val$timeoutCheck).start();
    this.val$me.loadUrlNow(this.val$url);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CordovaWebView$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */