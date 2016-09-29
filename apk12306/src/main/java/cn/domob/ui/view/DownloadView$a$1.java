package cn.domob.ui.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import cn.dm.download.DownLoadManager;
import cn.domob.ui.adapter.DownloadManagerListAdapter;
import cn.domob.ui.item.DownLoadListItem;
import cn.domob.ui.main.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DownloadView$a$1
  implements DialogInterface.OnClickListener
{
  DownloadView$a$1(DownloadView.a parama) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DownloadView.access$100().debugLog("confirmdialog clicked, groupPosition:" + DownloadView.a.a(this.a));
    if (DownloadView.a.a(this.a) == 1)
    {
      paramDialogInterface = (DownLoadListItem)((List)DownloadView.access$700(this.a.a).get(DownloadView.a.a(this.a))).remove(DownloadView.a.b(this.a));
      DownloadView.access$800(this.a.a).excuteDelete(paramDialogInterface.getDownloadAppInfo());
      DownloadView.access$900(this.a.a).remove(paramDialogInterface);
      if (DownloadView.access$900(this.a.a).size() == 0)
      {
        DownloadView.access$1000(this.a.a).remove(DownloadView.a.a(this.a));
        DownloadView.access$700(this.a.a).remove(DownloadView.a.a(this.a));
      }
    }
    for (;;)
    {
      if (this.a.a.viewStub != null)
      {
        this.a.a.vsOperations.setVisibility(8);
        this.a.a.viewStub.setVisibility(8);
        DownloadView.access$300(this.a.a).clear();
      }
      DownloadView.access$1100(this.a.a).setGroupList(DownloadView.access$1000(this.a.a));
      DownloadView.access$1100(this.a.a).setChildList(DownloadView.access$700(this.a.a));
      DownloadView.access$1100(this.a.a).notifyDataSetChanged();
      return;
      if (DownloadView.a.a(this.a) == 0)
      {
        paramDialogInterface = (DownLoadListItem)((List)DownloadView.access$700(this.a.a).get(DownloadView.a.a(this.a))).remove(DownloadView.a.b(this.a));
        if (((String)DownloadView.access$1100(this.a.a).getGroupList().get(DownloadView.a.a(this.a))).toString().equals("下载中"))
        {
          DownloadView.access$800(this.a.a).excuteDelete(paramDialogInterface.getDownloadAppInfo());
          DownloadView.access$1200(this.a.a).remove(paramDialogInterface);
          if (DownloadView.access$1200(this.a.a).size() == 0)
          {
            DownloadView.access$1000(this.a.a).remove(DownloadView.a.a(this.a));
            DownloadView.access$700(this.a.a).remove(DownloadView.a.a(this.a));
          }
        }
        else if (((String)DownloadView.access$1100(this.a.a).getGroupList().get(DownloadView.a.a(this.a))).toString().equals("已下载"))
        {
          DownloadView.access$800(this.a.a).excuteDelete(paramDialogInterface.getDownloadAppInfo());
          DownloadView.access$900(this.a.a).remove(paramDialogInterface);
          if (DownloadView.access$900(this.a.a).size() == 0)
          {
            DownloadView.access$1000(this.a.a).remove(DownloadView.a.a(this.a));
            DownloadView.access$700(this.a.a).remove(DownloadView.a.a(this.a));
          }
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\DownloadView$a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */