package org.apache.cordova;

class DroidGap$3
  implements Runnable
{
  DroidGap$3(DroidGap paramDroidGap1, boolean paramBoolean, DroidGap paramDroidGap2, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.val$exit)
    {
      this.val$me.appView.setVisibility(8);
      this.val$me.displayError("Application Error", this.val$description + " (" + this.val$failingUrl + ")", "OK", this.val$exit);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\DroidGap$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */