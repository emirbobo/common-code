package cn.domob.android.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class v$2
  implements View.OnTouchListener
{
  v$2(v paramv, ImageButton paramImageButton) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      v.a(this.b, this.a, "btn_close_interstitial_pressed.png");
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1) {
        v.a(this.b, this.a, "btn_close_interstitial.png");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\v$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */