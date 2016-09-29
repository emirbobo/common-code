package cn.domob.ui.view;

import android.os.Handler;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveHotSearchDataListener;
import java.util.List;

class SearchView$8
  implements DService.ReceiveHotSearchDataListener
{
  SearchView$8(SearchView paramSearchView) {}
  
  public void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString)
  {
    SearchView.access$1600(this.a).sendEmptyMessage(5);
  }
  
  public void onSuccessReceiveData(List<String> paramList)
  {
    SearchView.access$802(this.a, paramList);
    this.a.showHotStringHandler.sendEmptyMessage(0);
    SearchView.access$1600(this.a).sendEmptyMessage(2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\SearchView$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */