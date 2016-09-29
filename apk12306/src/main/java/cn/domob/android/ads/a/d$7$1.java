package cn.domob.android.ads.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cn.domob.android.i.f;

class d$7$1
  implements DialogInterface.OnDismissListener
{
  d$7$1(d.7 param7) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    d.b().b(this.a.a, "Video dialog dismissed.");
    d.a(this.a.a, false);
    d.g(this.a.a);
    if (d.h(this.a.a) == null) {
      d.i(this.a.a);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d$7$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */