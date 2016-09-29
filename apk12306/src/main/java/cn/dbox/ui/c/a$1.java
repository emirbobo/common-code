package cn.dbox.ui.c;

import android.view.View;
import android.view.View.OnClickListener;

class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.a(paramView);
    if (a.a(this.a) != null) {
      a.a(this.a).a(i, paramView, paramView.getTag());
    }
    this.a.b(i);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\c\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */