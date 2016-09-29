package cn.dbox.core.a;

import android.view.View;
import android.view.View.OnClickListener;
import cn.dbox.core.h.d;

class c$12
  implements View.OnClickListener
{
  c$12(c paramc) {}
  
  public void onClick(View paramView)
  {
    try
    {
      c.o(this.a);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        c.c().e(this, "intent " + c.p(this.a) + " error");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\c$12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */