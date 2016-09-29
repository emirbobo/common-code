package cn.domob.ui.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import cn.domob.ui.utility.DRes;
import cn.domob.ui.view.DownloadView;

class DViewManager$4
  implements Runnable
{
  private Dialog b;
  private DownloadView c;
  
  DViewManager$4(DViewManager paramDViewManager) {}
  
  public void run()
  {
    if (((Activity)DViewManager.access$300(this.a)).isFinishing()) {}
    for (;;)
    {
      return;
      this.b = new Dialog(DViewManager.access$300(this.a), DRes.initGetRes(DViewManager.access$300(this.a)).getStyle("Dialog_Fullscreen"));
      this.c = new DownloadView(DViewManager.access$300(this.a), DViewManager.access$400(this.a), this.b, DViewManager.access$900(this.a).getControlInfo(), DViewManager.access$1000(this.a).getDownloadManager());
      View localView = this.c.getDownloadView();
      if (localView != null)
      {
        this.b.setContentView(localView);
        this.b.show();
      }
      this.b.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          DViewManager.access$1000(DViewManager.4.this.a).refreshDownloadingCount();
        }
      });
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewManager$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */