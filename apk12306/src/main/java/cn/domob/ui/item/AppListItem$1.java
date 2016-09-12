package cn.domob.ui.item;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import cn.domob.ui.utility.DString;

class AppListItem$1
  extends Handler
{
  AppListItem$1(AppListItem paramAppListItem) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      if (AppListItem.access$000(this.a) != null)
      {
        Toast.makeText(AppListItem.access$000(this.a), DString.getStringInt(AppListItem.access$000(this.a), "download_failed"), 0).show();
        continue;
        AppListItem.access$100(this.a);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\AppListItem$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */