package cn.dbox.core.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.ImageButton;

class c$11
  implements View.OnTouchListener
{
  c$11(c paramc) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (c.i(this.a).canGoForward())
    {
      if (paramMotionEvent.getAction() != 0) {
        break label48;
      }
      c.n(this.a).setBackgroundDrawable(c.a(this.a, c.a(this.a), "a_next_on.png"));
    }
    for (;;)
    {
      return false;
      label48:
      if (paramMotionEvent.getAction() == 1) {
        c.n(this.a).setBackgroundDrawable(c.a(this.a, c.a(this.a), "a_next.png"));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\c$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */