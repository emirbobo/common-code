package cn.domob.ui.item;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import cn.domob.ui.main.Logger;

class AppListItem$4
  implements View.OnClickListener
{
  AppListItem$4(AppListItem paramAppListItem) {}
  
  public void onClick(View paramView)
  {
    AppListItem.access$300().debugLog("detail view dismiss");
    if (AppListItem.access$400(this.a) != null) {
      AppListItem.access$400(this.a).dismiss();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\AppListItem$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */