package cn.domob.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DLayout;
import cn.domob.ui.utility.DRes;
import java.util.List;

class SearchView$a
  extends BaseAdapter
{
  private List<String> b;
  
  public SearchView$a(List<String> paramList)
  {
    List localList;
    this.b = localList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(SearchView.access$200(this.a)).inflate(DLayout.getLayoutInt(SearchView.access$200(this.a), "l_hotsearch_item"), null);
    paramViewGroup = (TextView)localLinearLayout.findViewById(DId.getIdInt(SearchView.access$200(this.a), "tv_arrow_position"));
    paramView = (TextView)localLinearLayout.findViewById(DId.getIdInt(SearchView.access$200(this.a), "tv_hotsearch_item_name"));
    paramViewGroup.setText(paramInt + 1 + "");
    if (paramInt > 2) {
      paramViewGroup.setBackgroundResource(DRes.initGetRes(SearchView.access$200(this.a)).getDrawable("u_arrow_gray"));
    }
    paramView.setText((CharSequence)this.b.get(paramInt));
    return localLinearLayout;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\SearchView$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */