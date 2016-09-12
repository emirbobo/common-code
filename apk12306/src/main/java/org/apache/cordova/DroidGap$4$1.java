package org.apache.cordova;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DroidGap$4$1
  implements DialogInterface.OnClickListener
{
  DroidGap$4$1(DroidGap.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.this$1.val$exit) {
      this.this$1.val$me.endActivity();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\DroidGap$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */