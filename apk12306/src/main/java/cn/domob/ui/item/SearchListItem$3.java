package cn.domob.ui.item;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import cn.domob.ui.utility.DString;

class SearchListItem$3
  extends Handler
{
  SearchListItem$3(SearchListItem paramSearchListItem) {}
  
  public void handleMessage(Message paramMessage)
  {
    Toast.makeText(SearchListItem.access$800(this.a), DString.getStringInt(SearchListItem.access$800(this.a), "download_failed"), 0).show();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\SearchListItem$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */