package org.apache.cordova;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DroidGap$4
  implements Runnable
{
  DroidGap$4(DroidGap paramDroidGap1, DroidGap paramDroidGap2, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      AlertDialog.Builder localBuilder = new android/app/AlertDialog$Builder;
      localBuilder.<init>(this.val$me);
      localBuilder.setMessage(this.val$message);
      localBuilder.setTitle(this.val$title);
      localBuilder.setCancelable(false);
      String str = this.val$button;
      DialogInterface.OnClickListener local1 = new org/apache/cordova/DroidGap$4$1;
      local1.<init>(this);
      localBuilder.setPositiveButton(str, local1);
      localBuilder.create();
      localBuilder.show();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.this$0.finish();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\DroidGap$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */