package cn.domob.ui.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Looper;
import android.widget.Toast;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.main.Logger;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveDetailsDataListener;
import cn.domob.wall.core.bean.AdInfo;
import java.util.List;

class SearchView$b$1
  implements DService.ReceiveDetailsDataListener
{
  private Dialog b;
  
  SearchView$b$1(SearchView.b paramb) {}
  
  public void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString)
  {
    SearchView.access$1100(this.a.a).dismiss();
    SearchView.access$1500().debugLog("onFailReceiveData-->", "errorContent" + paramString);
    Looper.prepare();
    Toast.makeText(SearchView.access$200(this.a.a), "网络不是太给力哦...", 0).show();
    Looper.loop();
  }
  
  public void onSuccessReceiveData(List<AdInfo> paramList)
  {
    SearchView.access$1100(this.a.a).dismiss();
    Looper.prepare();
    if ((paramList.size() > 0) && (paramList != null))
    {
      paramList = (AdInfo)paramList.get(0);
      paramList = new AppListItem(SearchView.access$200(this.a.a), this.a.a, paramList, SearchView.access$1000(this.a.a), SearchView.access$1200(this.a.a), SearchView.access$1300(this.a.a), SearchView.access$1400(this.a.a));
      this.b = new Dialog(SearchView.access$200(this.a.a));
      paramList = paramList.bindDetailsView(this.b);
      this.b.requestWindowFeature(1);
      this.b.setContentView(paramList);
      this.b.show();
    }
    Looper.loop();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\SearchView$b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */