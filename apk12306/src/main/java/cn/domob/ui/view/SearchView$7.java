package cn.domob.ui.view;

import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;
import cn.domob.ui.adapter.SearchResultListAdapter;
import cn.domob.ui.item.SearchListItem;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveSearchDataListener;
import cn.domob.wall.core.bean.AdInfo;
import java.util.List;

class SearchView$7
  implements DService.ReceiveSearchDataListener
{
  SearchView$7(SearchView paramSearchView) {}
  
  public void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString)
  {
    SearchView.access$1600(this.a).sendEmptyMessage(5);
  }
  
  public void onSuccessReceiveData(List<AdInfo> paramList1, List<AdInfo> paramList2)
  {
    
    if (SearchView.access$1700(this.a) != null) {
      SearchView.access$1700(this.a).clear();
    }
    int i;
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      for (i = 0; i < paramList1.size(); i++)
      {
        paramList2 = (AdInfo)paramList1.get(i);
        paramList2 = new SearchListItem(SearchView.access$200(this.a), this.a, paramList2, SearchView.access$1000(this.a), SearchView.access$1200(this.a), SearchView.access$1300(this.a));
        SearchView.access$1700(this.a).add(paramList2);
      }
      if (SearchView.access$100(this.a) == null)
      {
        SearchView.access$102(this.a, new SearchResultListAdapter(SearchView.access$200(this.a), SearchView.access$1000(this.a), SearchView.access$1700(this.a)));
        SearchView.access$1800(this.a).setAdapter(SearchView.access$100(this.a));
      }
      SearchView.access$1600(this.a).sendEmptyMessage(3);
    }
    for (;;)
    {
      Looper.loop();
      return;
      if ((paramList2 != null) && (paramList2.size() != 0))
      {
        for (i = 0; i < paramList2.size(); i++)
        {
          paramList1 = (AdInfo)paramList2.get(i);
          paramList1 = new SearchListItem(SearchView.access$200(this.a), this.a, paramList1, SearchView.access$1000(this.a), SearchView.access$1200(this.a), SearchView.access$1300(this.a));
          SearchView.access$1700(this.a).add(paramList1);
        }
        if (SearchView.access$100(this.a) == null)
        {
          SearchView.access$102(this.a, new SearchResultListAdapter(SearchView.access$200(this.a), SearchView.access$1000(this.a), SearchView.access$1700(this.a)));
          SearchView.access$1800(this.a).setAdapter(SearchView.access$100(this.a));
        }
        SearchView.access$1600(this.a).sendEmptyMessage(4);
      }
      else
      {
        SearchView.access$1600(this.a).sendEmptyMessage(6);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\SearchView$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */