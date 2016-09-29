package cn.domob.wall.core.a;

import android.view.View;
import android.view.View.OnClickListener;
import cn.domob.wall.core.h.d;

class b$5
  implements View.OnClickListener
{
  b$5(b paramb) {}
  
  public void onClick(View paramView)
  {
    try
    {
      b.t(this.a);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        b.b().e(this, "intent " + b.r(this.a) + " error");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */