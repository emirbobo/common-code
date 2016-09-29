package cn.domob.ui.view;

import cn.domob.ui.adapter.AppListAdapter;
import cn.domob.ui.adapter.AppListAdapter.ListItemShowListener;

class AdWallListView$4
  implements AppListAdapter.ListItemShowListener
{
  AdWallListView$4(AdWallListView paramAdWallListView) {}
  
  public void onListItemStartToShow()
  {
    AdWallListView.access$500(this.a, 0, AdWallListView.access$400(this.a).getCount());
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\AdWallListView$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */