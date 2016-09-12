package cn.domob.wall.core.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cn.domob.wall.core.h.d;

class b$7$1
  implements DialogInterface.OnDismissListener
{
  b$7$1(b.7 param7) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    b.b().b(this.a.a, "Video dialog dismissed.");
    b.a(this.a.a, false);
    b.g(this.a.a);
    if (b.h(this.a.a) == null) {
      b.i(this.a.a);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$7$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */