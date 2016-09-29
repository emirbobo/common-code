package cn.domob.wall.core.d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class c$3
  implements View.OnTouchListener
{
  c$3(c paramc) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      c.a(this.a, this.a.b, "e_back_c.png");
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        c.a(this.a, this.a.b, "e_back.png");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\c$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */