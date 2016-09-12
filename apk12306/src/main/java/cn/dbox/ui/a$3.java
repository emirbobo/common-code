package cn.dbox.ui;

import android.view.View;
import android.view.View.OnClickListener;
import cn.dbox.core.h.d;
import cn.dbox.ui.d.f;

class a$3
  implements View.OnClickListener
{
  a$3(a parama) {}
  
  public void onClick(View paramView)
  {
    a.e().b("refresh view");
    if (this.a.j != null) {
      this.a.removeView(this.a.j);
    }
    this.a.addView(this.a.i, a.a(this.a));
    if (a.b(this.a) != null) {
      a.b(this.a).a();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */