package cn.domob.ui.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.main.Logger;
import cn.domob.wall.core.bean.AdInfo;
import java.util.List;

class AdWallListView$2
  implements AdapterView.OnItemClickListener
{
  AdWallListView$2(AdWallListView paramAdWallListView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.mBannerList != null)
    {
      paramInt %= this.a.mBannerList.size();
      AdWallListView.access$000().debugLog("gallery item clicked: " + paramInt);
      ((AppListItem)this.a.mBannerList.get(paramInt)).getAdInfo().setAdActualPosition(paramInt);
      AdWallListView.access$100(this.a, (AppListItem)this.a.mBannerList.get(paramInt));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\AdWallListView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */