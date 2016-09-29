package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.ArrayList;

class SlidingPaneLayout$DisableLayerRunnable
  implements Runnable
{
  final View mChildView;
  
  SlidingPaneLayout$DisableLayerRunnable(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    this.mChildView = paramView;
  }
  
  public void run()
  {
    if (this.mChildView.getParent() == this.this$0)
    {
      ViewCompat.setLayerType(this.mChildView, 0, null);
      SlidingPaneLayout.access$900(this.this$0, this.mChildView);
    }
    SlidingPaneLayout.access$1000(this.this$0).remove(this);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\widget\SlidingPaneLayout$DisableLayerRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */