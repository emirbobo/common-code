package cn.domob.ui.main;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import cn.domob.ui.utility.DRes;
import cn.domob.ui.view.SearchView;

class DViewManager$3
  implements Runnable
{
  private SearchView b;
  private Dialog c;
  
  DViewManager$3(DViewManager paramDViewManager) {}
  
  public void run()
  {
    if (((Activity)DViewManager.access$300(this.a)).isFinishing()) {}
    for (;;)
    {
      return;
      this.c = new Dialog(DViewManager.access$300(this.a), DRes.initGetRes(DViewManager.access$300(this.a)).getStyle("Dialog_Fullscreen"));
      this.b = new SearchView(DViewManager.access$300(this.a), DViewManager.access$400(this.a), this.c, DViewManager.access$900(this.a).getControlInfo(), DViewManager.access$1000(this.a).getDownloadManager());
      View localView = this.b.getSearchView();
      if (localView != null)
      {
        this.c.setContentView(localView);
        this.c.show();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewManager$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */