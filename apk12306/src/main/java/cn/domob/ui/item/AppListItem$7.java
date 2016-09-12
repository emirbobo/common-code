package cn.domob.ui.item;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import cn.domob.wall.core.DService;

class AppListItem$7
  implements View.OnClickListener
{
  AppListItem$7(AppListItem paramAppListItem) {}
  
  public void onClick(View paramView)
  {
    if (AppListItem.access$400(this.a) != null) {
      AppListItem.access$400(this.a).dismiss();
    }
    AppListItem.access$700(this.a).doClickDetailsPageButtonReport(AppListItem.access$600(this.a));
    switch (AppListItem.9.a[AppListItem.access$600(this.a).getAdActionType().ordinal()])
    {
    }
    for (;;)
    {
      return;
      AppListItem.access$800(this.a, AppListItem.b.b);
      continue;
      AppListItem.access$900(this.a);
      continue;
      AppListItem.access$1000(this.a);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\AppListItem$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */