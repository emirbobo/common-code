package cn.domob.ui.item;

import android.view.View;
import android.view.View.OnClickListener;
import cn.domob.ui.main.Logger;
import cn.domob.wall.core.DService;

class AppListItem$8
  implements View.OnClickListener
{
  AppListItem$8(AppListItem paramAppListItem) {}
  
  public void onClick(View paramView)
  {
    AppListItem.access$300().debugLog("action area clicked");
    switch (AppListItem.9.a[AppListItem.access$600(this.a).getAdActionType().ordinal()])
    {
    }
    for (;;)
    {
      return;
      AppListItem.access$800(this.a, AppListItem.b.a);
      continue;
      AppListItem.access$700(this.a).doClickWallItemButtonReport(AppListItem.access$600(this.a));
      AppListItem.access$1100(this.a);
      continue;
      AppListItem.access$700(this.a).doClickWallItemButtonReport(AppListItem.access$600(this.a));
      AppListItem.access$1200(this.a);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\AppListItem$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */