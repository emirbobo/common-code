package org.apache.cordova;

class DroidGap$2
  implements Runnable
{
  DroidGap$2(DroidGap paramDroidGap1, DroidGap paramDroidGap2, String paramString) {}
  
  public void run()
  {
    this.val$me.spinnerStop();
    this.val$me.appView.showWebPage(this.val$errorUrl, false, true, null);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\DroidGap$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */