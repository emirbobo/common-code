package cn.domob.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cn.domob.ui.item.SearchListItem;
import cn.domob.ui.utility.DLayout;
import cn.domob.wall.core.DService;
import java.util.List;

public class SearchResultListAdapter
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private List<SearchListItem> mListItems;
  
  public SearchResultListAdapter(Context paramContext, DService paramDService, List<SearchListItem> paramList)
  {
    this.mContext = paramContext;
    this.mListItems = paramList;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    return this.mListItems.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mListItems.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.mInflater.inflate(DLayout.getLayoutInt(this.mContext, "l_search_result_item"), null);
    }
    ((SearchListItem)this.mListItems.get(paramInt)).bindViews(paramViewGroup, paramInt);
    return paramViewGroup;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\adapter\SearchResultListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */