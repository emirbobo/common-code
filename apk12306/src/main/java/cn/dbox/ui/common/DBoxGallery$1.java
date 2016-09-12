package cn.dbox.ui.common;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class DBoxGallery$1
  implements View.OnTouchListener
{
  DBoxGallery$1(DBoxGallery paramDBoxGallery) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      DBoxGallery.access$002(this.a, true);
    }
    for (;;)
    {
      return false;
      if (i == 1) {
        DBoxGallery.access$002(this.a, false);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\DBoxGallery$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */