package cn.domob.wall.core.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class b$6
  implements View.OnTouchListener
{
  b$6(b paramb) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      b.u(this.a).setBackgroundDrawable(b.a(this.a, b.e(this.a), "a_refresh_on.png"));
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        b.u(this.a).setBackgroundDrawable(b.a(this.a, b.e(this.a), "a_refresh.png"));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */