package cn.domob.wall.core.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class b$4
  implements View.OnTouchListener
{
  b$4(b paramb) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      b.s(this.a).setBackgroundDrawable(b.a(this.a, b.e(this.a), "a_out_on.png"));
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        b.s(this.a).setBackgroundDrawable(b.a(this.a, b.e(this.a), "a_out.png"));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */