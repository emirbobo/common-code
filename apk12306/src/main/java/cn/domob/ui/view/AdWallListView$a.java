package cn.domob.ui.view;

import android.app.Activity;
import cn.domob.ui.main.Logger;
import java.util.TimerTask;

class AdWallListView$a
  extends TimerTask
{
  private AdWallListView$a(AdWallListView paramAdWallListView) {}
  
  public void run()
  {
    if ((AdWallListView.access$700(this.a) != null) && (AdWallListView.access$700(this.a).hasWindowFocus()) && (AdWallListView.access$800(this.a).getFirstVisiblePosition() == 0) && (!AdWallListView.access$700(this.a).isOnGalleryTouch()))
    {
      AdWallListView.access$000().debugLog("start auto scroll: " + toString());
      ((Activity)AdWallListView.access$900(this.a)).runOnUiThread(new Runnable()
      {
        public void run()
        {
          AdWallListView.access$700(AdWallListView.a.this.a).onKeyDown(22, null);
        }
      });
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\AdWallListView$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */