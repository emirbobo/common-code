package cn.domob.ui.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

class SearchView$9
  extends Handler
{
  SearchView$9(SearchView paramSearchView) {}
  
  public void handleMessage(Message paramMessage)
  {
    SearchView.access$1900(this.a).setAdapter(new SearchView.a(this.a, SearchView.access$800(this.a)));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\SearchView$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */