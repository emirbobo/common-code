package cn.domob.android.ads.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.RelativeLayout;

class d$1
  implements DialogInterface.OnDismissListener
{
  d$1(d paramd) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    d.b(this.a).removeView(d.a(this.a));
    if (d.c(this.a) != null) {
      d.c(this.a).u();
    }
    if ((!d.d(this.a)) && (d.c(this.a) != null)) {
      d.c(this.a).t();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */