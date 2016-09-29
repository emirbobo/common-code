package cn.dbox.core.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.ImageButton;

class c$9
  implements View.OnTouchListener
{
  c$9(c paramc) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (c.i(this.a).canGoBack())
    {
      if (paramMotionEvent.getAction() != 0) {
        break label48;
      }
      c.l(this.a).setBackgroundDrawable(c.a(this.a, c.a(this.a), "a_preview_on.png"));
    }
    for (;;)
    {
      return false;
      label48:
      if (paramMotionEvent.getAction() == 1) {
        c.l(this.a).setBackgroundDrawable(c.a(this.a, c.a(this.a), "a_preview.png"));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\c$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */