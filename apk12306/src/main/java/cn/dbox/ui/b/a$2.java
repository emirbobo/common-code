package cn.dbox.ui.b;

import android.view.View;
import cn.dbox.core.b.d;
import cn.dbox.core.bean.d;
import cn.dbox.ui.a.g.a;
import java.util.ArrayList;

class a$2
  implements g.a
{
  a$2(a parama, d paramd) {}
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    if (this.b.e != null)
    {
      if (paramInt >= this.b.s.size()) {
        break label75;
      }
      paramView = (cn.dbox.core.bean.a)this.a.l().get(paramInt);
      paramView.a(paramInt);
      this.b.e.a(paramView, b.d.c, this.a.a(), this.a.c());
    }
    for (;;)
    {
      return;
      label75:
      paramView.setBackgroundColor(-789000);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */