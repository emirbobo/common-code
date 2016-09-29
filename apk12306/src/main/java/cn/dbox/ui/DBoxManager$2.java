package cn.dbox.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class DBoxManager$2
  implements DialogInterface.OnShowListener
{
  DBoxManager$2(DBoxManager paramDBoxManager) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (DBoxManager.a(this.a) != null) {
      DBoxManager.a(this.a).onDBoxViewPresent();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\DBoxManager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */