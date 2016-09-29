package cn.dbox.core.a;

import android.view.View;
import android.view.View.OnClickListener;
import cn.dbox.core.h.d;

class c$3
  implements View.OnClickListener
{
  c$3(c paramc) {}
  
  public void onClick(View paramView)
  {
    try
    {
      c.r(this.a);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\c$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */