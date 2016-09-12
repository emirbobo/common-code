package cn.domob.wall.core.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class c$5
  implements View.OnTouchListener
{
  c$5(c paramc) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      c.a(this.a, this.a.c, "e_forward_c.png");
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        c.a(this.a, this.a.c, "e_forward.png");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\c$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */