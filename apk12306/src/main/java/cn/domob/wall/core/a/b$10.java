package cn.domob.wall.core.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class b$10
  implements View.OnTouchListener
{
  b$10(b paramb) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      b.k(this.a).setBackgroundDrawable(b.a(this.a, b.e(this.a), "a_exit_on.png"));
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        b.k(this.a).setBackgroundDrawable(b.a(this.a, b.e(this.a), "a_exit.png"));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */