package cn.dbox.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class DBoxManager$7
  implements DialogInterface.OnDismissListener
{
  DBoxManager$7(DBoxManager paramDBoxManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((DBoxManager.h(this.a) != null) && (DBoxManager.h(this.a).equals("flat")) && (DBoxManager.c(this.a) != null)) {
      DBoxManager.c(this.a).c();
    }
    if (DBoxManager.a(this.a) != null) {
      DBoxManager.a(this.a).onDBoxViewClosed();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\DBoxManager$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */