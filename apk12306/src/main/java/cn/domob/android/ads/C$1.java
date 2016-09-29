package cn.domob.android.ads;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class C$1
  implements View.OnClickListener
{
  C$1(C paramC, Dialog paramDialog, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (C.a(this.c) != null) {
      C.a(this.c).b(C.b(this.c), C.c(this.c), C.d(this.c));
    }
    if (!this.b.equals("")) {
      C.a(this.c, C.e(this.c), C.f(this.c), C.b(this.c), C.c(this.c), C.d(this.c), null);
    }
    for (;;)
    {
      return;
      C.a(this.c, C.e(this.c), C.f(this.c), C.b(this.c), C.c(this.c), C.d(this.c), this.b);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\C$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */