package cn.dbox.core.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.RelativeLayout;

class b$3
  implements DialogInterface.OnDismissListener
{
  b$3(b paramb) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    b.a(this.a).removeView(this.a.b);
    if (b.b(this.a) != null) {
      b.b(this.a).f(this.a.a);
    }
    if ((!b.c(this.a)) && (b.b(this.a) != null)) {
      b.b(this.a).e(this.a.a);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\b$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */