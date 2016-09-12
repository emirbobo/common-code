package cn.domob.android.ads;

import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

final class C$4
  implements View.OnTouchListener
{
  C$4(GradientDrawable paramGradientDrawable1, GradientDrawable paramGradientDrawable2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView.setBackgroundDrawable(this.a);
      ((Button)paramView).setTextColor(-16777216);
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        paramView.setBackgroundDrawable(this.b);
        ((Button)paramView).setTextColor(-1);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\C$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */