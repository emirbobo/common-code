package cn.domob.ui.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import cn.dm.download.bean.DownloadAppInfo;
import cn.domob.ui.adapter.SearchResultListAdapter;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.item.SearchListItem;
import cn.domob.ui.main.Logger;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveDetailsDataListener;
import cn.domob.wall.core.bean.AdInfo;
import java.util.List;

class SearchView$b
  implements AdapterView.OnItemClickListener
{
  private SearchView$b(SearchView paramSearchView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (SearchListItem)SearchView.access$100(this.a).getItem(paramInt);
    paramView = paramAdapterView.getDownloadAppInfo();
    paramAdapterView.getmAdInfo().setAdActualPosition(paramInt);
    SearchView.access$1000(this.a).doClickWallItemReport(paramAdapterView.getmAdInfo());
    SearchView.access$1102(this.a, new ProgressDialog(SearchView.access$200(this.a)));
    SearchView.access$1100(this.a).setMessage("数据加载中...");
    SearchView.access$1100(this.a).show();
    SearchView.access$1000(this.a).setReceiveDetailsDataListener(new DService.ReceiveDetailsDataListener()
    {
      private Dialog b;
      
      public void onFailReceiveData(DService.ErrorCode paramAnonymousErrorCode, String paramAnonymousString)
      {
        SearchView.access$1100(SearchView.b.this.a).dismiss();
        SearchView.access$1500().debugLog("onFailReceiveData-->", "errorContent" + paramAnonymousString);
        Looper.prepare();
        Toast.makeText(SearchView.access$200(SearchView.b.this.a), "网络不是太给力哦...", 0).show();
        Looper.loop();
      }
      
      public void onSuccessReceiveData(List<AdInfo> paramAnonymousList)
      {
        SearchView.access$1100(SearchView.b.this.a).dismiss();
        Looper.prepare();
        if ((paramAnonymousList.size() > 0) && (paramAnonymousList != null))
        {
          paramAnonymousList = (AdInfo)paramAnonymousList.get(0);
          paramAnonymousList = new AppListItem(SearchView.access$200(SearchView.b.this.a), SearchView.b.this.a, paramAnonymousList, SearchView.access$1000(SearchView.b.this.a), SearchView.access$1200(SearchView.b.this.a), SearchView.access$1300(SearchView.b.this.a), SearchView.access$1400(SearchView.b.this.a));
          this.b = new Dialog(SearchView.access$200(SearchView.b.this.a));
          paramAnonymousList = paramAnonymousList.bindDetailsView(this.b);
          this.b.requestWindowFeature(1);
          this.b.setContentView(paramAnonymousList);
          this.b.show();
        }
        Looper.loop();
      }
    });
    paramAdapterView = Long.toString(paramView.getAppId());
    SearchView.access$1000(this.a).requestDetailsDataAsyn(paramAdapterView);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\SearchView$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */