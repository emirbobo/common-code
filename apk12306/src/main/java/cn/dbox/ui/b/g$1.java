package cn.dbox.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import cn.dbox.core.a.c;
import cn.dbox.core.bean.d;

class g$1
  implements View.OnClickListener
{
  g$1(g paramg, d paramd) {}
  
  public void onClick(View paramView)
  {
    if (this.b.a != null) {
      this.b.removeView(this.b.a);
    }
    this.b.y.a(this.a.g());
    this.b.addView(this.b.y);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\g$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */