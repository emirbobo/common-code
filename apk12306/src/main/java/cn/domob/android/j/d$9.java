package cn.domob.android.j;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class d$9
  implements View.OnTouchListener
{
  d$9(d paramd) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (d.e(this.a))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label79;
      }
      if (d.f(this.a) != null)
      {
        if (!d.f(this.a).equals("domob_video_not_full_not_selected.png")) {
          break label60;
        }
        d.a(this.a, d.g(this.a), "domob_video_not_full_selected.png");
      }
    }
    for (;;)
    {
      return false;
      label60:
      d.a(this.a, d.g(this.a), "domob_video_full_selected.png");
      continue;
      label79:
      if ((paramMotionEvent.getAction() == 1) && (d.a(this.a) != null)) {
        d.a(this.a).i();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\d$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */