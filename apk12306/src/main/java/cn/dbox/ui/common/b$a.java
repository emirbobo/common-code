package cn.dbox.ui.common;

import android.app.Activity;
import cn.dbox.core.h.d;
import java.util.TimerTask;

class b$a
  extends TimerTask
{
  private b$a(b paramb) {}
  
  public void run()
  {
    if ((b.e(this.a) != null) && (b.e(this.a).hasWindowFocus()) && (!b.e(this.a).isOnGalleryTouch()))
    {
      b.b().b("start auto scroll: " + toString());
      ((Activity)b.f(this.a)).runOnUiThread(new Runnable()
      {
        public void run()
        {
          b.e(b.a.this.a).onKeyDown(22, null);
        }
      });
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\b$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */