package cn.domob.android.j;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class d$2
  implements View.OnTouchListener
{
  d$2(d paramd, d.a parama) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      d.a(this.b, this.a, true, true);
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        d.a(this.b, this.a, false, true);
        if (d.a(this.b) != null) {
          d.a(this.b).a(d.a.a(this.a));
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\d$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */