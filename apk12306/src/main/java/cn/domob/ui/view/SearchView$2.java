package cn.domob.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class SearchView$2
  implements View.OnClickListener
{
  SearchView$2(SearchView paramSearchView) {}
  
  public void onClick(View paramView)
  {
    if (SearchView.access$300(this.a, SearchView.access$200(this.a)) == 0) {
      Toast.makeText(SearchView.access$200(this.a), "网络异常，请检查网络设置！", 0).show();
    }
    for (;;)
    {
      return;
      SearchView.access$400(this.a);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\SearchView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */