package cn.domob.ui.item;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import cn.dm.download.DownLoadManager;
import cn.domob.ui.utility.DDrawable;

class DownLoadListItem$2
  implements View.OnClickListener
{
  DownLoadListItem$2(DownLoadListItem paramDownLoadListItem) {}
  
  public void onClick(View paramView)
  {
    switch (DownLoadListItem.access$100(this.a))
    {
    }
    for (;;)
    {
      return;
      DownLoadListItem.access$300(this.a).excuteDownload(DownLoadListItem.access$200(this.a));
      continue;
      DownLoadListItem.access$300(this.a).excutePause(DownLoadListItem.access$200(this.a));
      DownLoadListItem.access$500(this.a).h.setBackgroundResource(DDrawable.getDrawableInt(DownLoadListItem.access$400(this.a), "u_download_continue_icon"));
      continue;
      DownLoadListItem.access$300(this.a).excuteResume(DownLoadListItem.access$200(this.a));
      DownLoadListItem.access$500(this.a).h.setBackgroundResource(DDrawable.getDrawableInt(DownLoadListItem.access$400(this.a), "u_downloading_icon"));
      continue;
      DownLoadListItem.access$300(this.a).excuteInstall(DownLoadListItem.access$400(this.a), DownLoadListItem.access$200(this.a));
      continue;
      DownLoadListItem.access$300(this.a).excuteOpen(DownLoadListItem.access$400(this.a), DownLoadListItem.access$200(this.a));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\DownLoadListItem$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */