package cn.domob.ui.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.List;

class SearchView$5
  implements AdapterView.OnItemClickListener
{
  SearchView$5(SearchView paramSearchView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    SearchView.access$700(this.a);
    SearchView.access$900(this.a).setText((CharSequence)SearchView.access$800(this.a).get(paramInt));
    SearchView.access$000(this.a, 1);
    SearchView.access$400(this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\SearchView$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */