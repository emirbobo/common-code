package cn.dbox.core.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cn.dbox.core.h.d;

class c$1$1
  implements DialogInterface.OnDismissListener
{
  c$1$1(c.1 param1) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    c.c().b(this.a.a, "Video dialog dismissed.");
    c.a(this.a.a, false);
    c.c(this.a.a);
    if (c.d(this.a.a) == null) {
      this.a.a.b();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\c$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */