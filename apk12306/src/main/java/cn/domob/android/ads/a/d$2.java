package cn.domob.android.ads.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.ImageButton;

class d$2
  implements View.OnTouchListener
{
  d$2(d paramd) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (d.a(this.a).canGoForward())
    {
      if (paramMotionEvent.getAction() != 0) {
        break label48;
      }
      d.p(this.a).setBackgroundDrawable(d.a(this.a, d.e(this.a), "domob_next_on.png"));
    }
    for (;;)
    {
      return false;
      label48:
      if (paramMotionEvent.getAction() == 1) {
        d.p(this.a).setBackgroundDrawable(d.a(this.a, d.e(this.a), "domob_next.png"));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */