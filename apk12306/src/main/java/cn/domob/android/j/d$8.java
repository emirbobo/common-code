package cn.domob.android.j;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class d$8
  implements View.OnTouchListener
{
  d$8(d paramd, ImageButton paramImageButton) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (d.c(this.b)) {
        d.a(this.b, this.a, "domob_video_muted_selected.png");
      }
    }
    for (;;)
    {
      return false;
      d.a(this.b, this.a, "domob_video_not_mute_selected.png");
      continue;
      if (paramMotionEvent.getAction() == 1)
      {
        d.d(this.b);
        if (d.c(this.b)) {
          d.a(this.b, this.a, "domob_video_muted_not_selected.png");
        } else {
          d.a(this.b, this.a, "domob_video_not_mute_not_selected.png");
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\d$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */