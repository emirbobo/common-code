package cn.domob.android.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.ViewGroup;

class v$4
  implements DialogInterface.OnDismissListener
{
  v$4(v paramv, View paramView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ((ViewGroup)this.a.getParent()).removeAllViews();
    if (v.e.y(v.b(this.b)) != null) {
      v.e.y(v.b(this.b)).a();
    }
    if (v.e.a(v.b(this.b)) != null) {
      v.e.a(v.b(this.b)).c();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\v$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */