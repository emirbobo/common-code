package cn.domob.android.ads;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class C$2
  implements View.OnClickListener
{
  C$2(C paramC, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (C.a(this.b) != null) {
      C.a(this.b).c(C.b(this.b), C.c(this.b), C.d(this.b));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\C$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */