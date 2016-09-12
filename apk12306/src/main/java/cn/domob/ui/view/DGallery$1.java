package cn.domob.ui.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class DGallery$1
  implements View.OnTouchListener
{
  DGallery$1(DGallery paramDGallery) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      DGallery.access$002(this.a, true);
    }
    for (;;)
    {
      return false;
      if (i == 1) {
        DGallery.access$002(this.a, false);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\DGallery$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */