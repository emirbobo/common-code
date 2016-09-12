package cn.domob.ui.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Looper;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.main.Logger;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveDetailsDataListener;
import cn.domob.wall.core.bean.AdInfo;
import java.util.List;

class DownloadView$a$2
  implements DService.ReceiveDetailsDataListener
{
  private Dialog b;
  
  DownloadView$a$2(DownloadView.a parama) {}
  
  public void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString)
  {
    DownloadView.a.c(this.a).dismiss();
    DownloadView.access$100().errorLog("fail to receive detail data.");
  }
  
  public void onSuccessReceiveData(List<AdInfo> paramList)
  {
    DownloadView.a.c(this.a).dismiss();
    Looper.prepare();
    if ((paramList.size() > 0) && (paramList != null))
    {
      paramList = (AdInfo)paramList.get(0);
      paramList = new AppListItem(DownloadView.access$200(this.a.a), this.a.a, paramList, DownloadView.access$1400(this.a.a), DownloadView.access$800(this.a.a), DownloadView.access$1500(this.a.a), DownloadView.access$1600(this.a.a));
      this.b = new Dialog(DownloadView.access$200(this.a.a));
      paramList = paramList.bindDetailsView(this.b);
      this.b.requestWindowFeature(1);
      this.b.setContentView(paramList);
      this.b.show();
    }
    Looper.loop();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\DownloadView$a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */