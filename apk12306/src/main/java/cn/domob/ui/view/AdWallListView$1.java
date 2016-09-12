package cn.domob.ui.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.main.Logger;
import cn.domob.wall.core.bean.AdInfo;
import java.util.List;

class AdWallListView$1
  implements AdapterView.OnItemClickListener
{
  AdWallListView$1(AdWallListView paramAdWallListView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= this.a.getHeaderViewsCount();
    AdWallListView.access$000().debugLog("list item click, pos:" + paramInt);
    if ((this.a.mItemList != null) && (paramInt >= 0) && (paramInt < this.a.mItemList.size()))
    {
      ((AppListItem)this.a.mItemList.get(paramInt)).getAdInfo().setAdActualPosition(paramInt);
      AdWallListView.access$000().debugLog("Start to display detail view: " + paramInt);
      AdWallListView.access$100(this.a, (AppListItem)this.a.mItemList.get(paramInt));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\AdWallListView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */