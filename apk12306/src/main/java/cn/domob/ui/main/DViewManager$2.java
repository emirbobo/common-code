package cn.domob.ui.main;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.ReportUserActionType;

class DViewManager$2
  implements DialogInterface.OnDismissListener
{
  DViewManager$2(DViewManager paramDViewManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DViewManager.access$200().debugLog("dialogView onDismiss");
    DViewManager.access$200().debugLog("推广墙关闭");
    DViewManager.access$400(this.a).doUserActionReport(DService.ReportUserActionType.EXIT);
    if (DViewManager.access$800(this.a) != null)
    {
      DViewManager.access$800(this.a).onCloseWall();
      DViewManager.access$200().debugLog("onCloseWall");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewManager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */