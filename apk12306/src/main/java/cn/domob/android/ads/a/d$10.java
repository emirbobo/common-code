package cn.domob.android.ads.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class d$10
  implements View.OnTouchListener
{
  d$10(d paramd) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      d.k(this.a).setBackgroundDrawable(d.a(this.a, d.e(this.a), "domob_exit_on.png"));
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        d.k(this.a).setBackgroundDrawable(d.a(this.a, d.e(this.a), "domob_exit.png"));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */