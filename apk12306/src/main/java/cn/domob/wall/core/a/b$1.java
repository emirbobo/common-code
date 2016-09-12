package cn.domob.wall.core.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.RelativeLayout;

class b$1
  implements DialogInterface.OnDismissListener
{
  b$1(b paramb) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    b.b(this.a).removeView(b.a(this.a));
    if (b.c(this.a) != null) {
      b.c(this.a).l(this.a.a);
    }
    if ((!b.d(this.a)) && (b.c(this.a) != null)) {
      b.c(this.a).k(this.a.a);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */