package cn.dbox.core.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class c$7
  implements View.OnTouchListener
{
  c$7(c paramc) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      c.j(this.a).setBackgroundDrawable(c.a(this.a, c.a(this.a), "a_exit_on.png"));
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        c.j(this.a).setBackgroundDrawable(c.a(this.a, c.a(this.a), "a_exit.png"));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\c$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */