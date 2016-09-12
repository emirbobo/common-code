package cn.domob.android.ads;

import android.app.Dialog;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;

class C$3
  implements View.OnClickListener
{
  C$3(C paramC, Dialog paramDialog, SharedPreferences.Editor paramEditor) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (C.a(this.c) != null) {
      C.a(this.c).d(C.b(this.c), C.c(this.c), C.d(this.c));
    }
    this.b.putString("skip_vc", C.g(this.c));
    this.b.commit();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\C$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */