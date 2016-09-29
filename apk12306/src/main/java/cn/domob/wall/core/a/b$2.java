package cn.domob.wall.core.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.ImageButton;

class b$2
  implements View.OnTouchListener
{
  b$2(b paramb) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (b.a(this.a).canGoForward())
    {
      if (paramMotionEvent.getAction() != 0) {
        break label48;
      }
      b.p(this.a).setBackgroundDrawable(b.a(this.a, b.e(this.a), "a_next_on.png"));
    }
    for (;;)
    {
      return false;
      label48:
      if (paramMotionEvent.getAction() == 1) {
        b.p(this.a).setBackgroundDrawable(b.a(this.a, b.e(this.a), "a_next.png"));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */