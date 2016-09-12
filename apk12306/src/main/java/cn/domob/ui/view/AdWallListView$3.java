package cn.domob.ui.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.main.Logger;
import cn.domob.wall.core.DService;
import java.util.ArrayList;
import java.util.List;

class AdWallListView$3
  implements AdapterView.OnItemSelectedListener
{
  AdWallListView$3(AdWallListView paramAdWallListView) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AdWallListView.access$000().debugLog("onItemSelected:" + paramInt);
    if ((this.a.mBannerList != null) && (paramInt < this.a.mBannerList.size()))
    {
      paramAdapterView = new ArrayList();
      paramAdapterView.add(((AppListItem)this.a.mBannerList.get(paramInt)).getAdInfo());
      AdWallListView.access$200(this.a).doImpReports(paramAdapterView);
      AdWallListView.access$000().debugLog("Start to send imp reports：" + paramInt);
    }
    AdWallListView.access$300(this.a, paramInt % this.a.mBannerList.size());
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AdWallListView.access$000().debugLog("onNothingSelected");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\AdWallListView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */