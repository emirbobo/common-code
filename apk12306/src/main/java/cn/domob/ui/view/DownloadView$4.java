package cn.domob.ui.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import cn.domob.ui.adapter.DownloadManagerListAdapter;
import java.util.ArrayList;
import java.util.List;

class DownloadView$4
  extends Handler
{
  DownloadView$4(DownloadView paramDownloadView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      DownloadView.access$1100(this.a).notifyDataSetChanged();
      continue;
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("groupPosition");
      int j = paramMessage.getInt("childPosition");
      if ((DownloadView.access$700(this.a).size() != 0) && (((List)DownloadView.access$700(this.a).get(i)).size() != 0)) {
        ((List)DownloadView.access$700(this.a).get(i)).remove(j);
      }
      DownloadView.access$1100(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\DownloadView$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */