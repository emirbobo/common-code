package cn.domob.ui.item;

import android.view.View;
import android.view.View.OnClickListener;
import cn.dm.download.DownLoadManager;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.AdInfo.ClickActionType;

class SearchListItem$2
  implements View.OnClickListener
{
  SearchListItem$2(SearchListItem paramSearchListItem) {}
  
  public void onClick(View paramView)
  {
    switch (SearchListItem.access$200(this.a))
    {
    default: 
      SearchListItem.access$300(this.a).setAdActualPosition(SearchListItem.access$600(this.a));
      SearchListItem.access$700(this.a).doClickWallItemReport(SearchListItem.access$300(this.a));
    }
    for (;;)
    {
      return;
      if ((SearchListItem.access$300(this.a).isDownloadAd()) && (("DOWNLOAD".equals(SearchListItem.access$300(this.a).getAdActionType().name())) || ("UPDATE".equals(SearchListItem.access$300(this.a).getAdActionType().name())))) {
        SearchListItem.access$500(this.a).excuteDownload(SearchListItem.access$400(this.a));
      }
      SearchListItem.access$300(this.a).setAdActualPosition(SearchListItem.access$600(this.a));
      SearchListItem.access$700(this.a).doClickWallItemReport(SearchListItem.access$300(this.a));
      continue;
      SearchListItem.access$500(this.a).excuteResume(SearchListItem.access$400(this.a));
      continue;
      SearchListItem.access$500(this.a).excuteInstall(SearchListItem.access$800(this.a), SearchListItem.access$400(this.a));
      continue;
      SearchListItem.access$500(this.a).excuteOpen(SearchListItem.access$800(this.a), SearchListItem.access$400(this.a));
      continue;
      SearchListItem.access$500(this.a).excuteDownload(SearchListItem.access$400(this.a));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\SearchListItem$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */