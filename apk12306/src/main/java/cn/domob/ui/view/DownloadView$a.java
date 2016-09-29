package cn.domob.ui.view;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import cn.dm.download.DownLoadManager;
import cn.dm.download.bean.DownloadAppInfo;
import cn.domob.ui.adapter.DownloadManagerListAdapter;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.item.DownLoadListItem;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DId;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveDetailsDataListener;
import cn.domob.wall.core.bean.AdInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DownloadView$a
  implements View.OnClickListener
{
  private int b;
  private int c;
  private ProgressDialog d;
  
  public DownloadView$a(DownloadView paramDownloadView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == DId.getIdInt(DownloadView.access$200(this.a), "rl_menu_delete"))
    {
      paramView = new AlertDialog.Builder(DownloadView.access$200(this.a));
      paramView.setTitle("温馨提示");
      paramView.setIcon(17301659);
      paramView.setMessage("您确定要删除该条下载吗？");
      paramView.setPositiveButton("确定", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
          DownloadView.access$100().debugLog("confirmdialog clicked, groupPosition:" + DownloadView.a.a(DownloadView.a.this));
          if (DownloadView.a.a(DownloadView.a.this) == 1)
          {
            paramAnonymousDialogInterface = (DownLoadListItem)((List)DownloadView.access$700(DownloadView.a.this.a).get(DownloadView.a.a(DownloadView.a.this))).remove(DownloadView.a.b(DownloadView.a.this));
            DownloadView.access$800(DownloadView.a.this.a).excuteDelete(paramAnonymousDialogInterface.getDownloadAppInfo());
            DownloadView.access$900(DownloadView.a.this.a).remove(paramAnonymousDialogInterface);
            if (DownloadView.access$900(DownloadView.a.this.a).size() == 0)
            {
              DownloadView.access$1000(DownloadView.a.this.a).remove(DownloadView.a.a(DownloadView.a.this));
              DownloadView.access$700(DownloadView.a.this.a).remove(DownloadView.a.a(DownloadView.a.this));
            }
          }
          for (;;)
          {
            if (DownloadView.a.this.a.viewStub != null)
            {
              DownloadView.a.this.a.vsOperations.setVisibility(8);
              DownloadView.a.this.a.viewStub.setVisibility(8);
              DownloadView.access$300(DownloadView.a.this.a).clear();
            }
            DownloadView.access$1100(DownloadView.a.this.a).setGroupList(DownloadView.access$1000(DownloadView.a.this.a));
            DownloadView.access$1100(DownloadView.a.this.a).setChildList(DownloadView.access$700(DownloadView.a.this.a));
            DownloadView.access$1100(DownloadView.a.this.a).notifyDataSetChanged();
            return;
            if (DownloadView.a.a(DownloadView.a.this) == 0)
            {
              paramAnonymousDialogInterface = (DownLoadListItem)((List)DownloadView.access$700(DownloadView.a.this.a).get(DownloadView.a.a(DownloadView.a.this))).remove(DownloadView.a.b(DownloadView.a.this));
              if (((String)DownloadView.access$1100(DownloadView.a.this.a).getGroupList().get(DownloadView.a.a(DownloadView.a.this))).toString().equals("下载中"))
              {
                DownloadView.access$800(DownloadView.a.this.a).excuteDelete(paramAnonymousDialogInterface.getDownloadAppInfo());
                DownloadView.access$1200(DownloadView.a.this.a).remove(paramAnonymousDialogInterface);
                if (DownloadView.access$1200(DownloadView.a.this.a).size() == 0)
                {
                  DownloadView.access$1000(DownloadView.a.this.a).remove(DownloadView.a.a(DownloadView.a.this));
                  DownloadView.access$700(DownloadView.a.this.a).remove(DownloadView.a.a(DownloadView.a.this));
                }
              }
              else if (((String)DownloadView.access$1100(DownloadView.a.this.a).getGroupList().get(DownloadView.a.a(DownloadView.a.this))).toString().equals("已下载"))
              {
                DownloadView.access$800(DownloadView.a.this.a).excuteDelete(paramAnonymousDialogInterface.getDownloadAppInfo());
                DownloadView.access$900(DownloadView.a.this.a).remove(paramAnonymousDialogInterface);
                if (DownloadView.access$900(DownloadView.a.this.a).size() == 0)
                {
                  DownloadView.access$1000(DownloadView.a.this.a).remove(DownloadView.a.a(DownloadView.a.this));
                  DownloadView.access$700(DownloadView.a.this.a).remove(DownloadView.a.a(DownloadView.a.this));
                }
              }
            }
          }
        }
      }).setNegativeButton("取消", null);
      paramView.show();
    }
    for (;;)
    {
      return;
      if (paramView.getId() == DId.getIdInt(DownloadView.access$200(this.a), "rl_menu_detail"))
      {
        paramView = ((DownLoadListItem)((List)DownloadView.access$1100(this.a).getChildList().get(this.b)).get(this.c)).getDownloadAppInfo();
        this.d = new ProgressDialog(DownloadView.access$200(this.a));
        this.d.setMessage("数据加载中...");
        this.d.show();
        DownloadView.access$1400(this.a).setReceiveDetailsDataListener(new DService.ReceiveDetailsDataListener()
        {
          private Dialog b;
          
          public void onFailReceiveData(DService.ErrorCode paramAnonymousErrorCode, String paramAnonymousString)
          {
            DownloadView.a.c(DownloadView.a.this).dismiss();
            DownloadView.access$100().errorLog("fail to receive detail data.");
          }
          
          public void onSuccessReceiveData(List<AdInfo> paramAnonymousList)
          {
            DownloadView.a.c(DownloadView.a.this).dismiss();
            Looper.prepare();
            if ((paramAnonymousList.size() > 0) && (paramAnonymousList != null))
            {
              paramAnonymousList = (AdInfo)paramAnonymousList.get(0);
              paramAnonymousList = new AppListItem(DownloadView.access$200(DownloadView.a.this.a), DownloadView.a.this.a, paramAnonymousList, DownloadView.access$1400(DownloadView.a.this.a), DownloadView.access$800(DownloadView.a.this.a), DownloadView.access$1500(DownloadView.a.this.a), DownloadView.access$1600(DownloadView.a.this.a));
              this.b = new Dialog(DownloadView.access$200(DownloadView.a.this.a));
              paramAnonymousList = paramAnonymousList.bindDetailsView(this.b);
              this.b.requestWindowFeature(1);
              this.b.setContentView(paramAnonymousList);
              this.b.show();
            }
            Looper.loop();
          }
        });
        paramView = Long.toString(paramView.getAppId());
        DownloadView.access$1400(this.a).requestDetailsDataAsyn(paramView);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\DownloadView$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */