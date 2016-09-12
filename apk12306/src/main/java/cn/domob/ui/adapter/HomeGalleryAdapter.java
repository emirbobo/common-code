package cn.domob.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cn.domob.ui.item.AppListItem;
import java.util.ArrayList;
import java.util.List;

public class HomeGalleryAdapter
  extends BaseAdapter
{
  private List<AppListItem> mBannerList = new ArrayList();
  private Context mContext;
  
  public HomeGalleryAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public List<AppListItem> getBannerList()
  {
    return this.mBannerList;
  }
  
  public int getCount()
  {
    return Integer.MAX_VALUE;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.mBannerList.size() == 0) {}
    for (Object localObject = null;; localObject = this.mBannerList.get(paramInt % this.mBannerList.size())) {
      return localObject;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (this.mBannerList.size() > 0)
    {
      paramInt %= this.mBannerList.size();
      paramViewGroup = ((AppListItem)this.mBannerList.get(paramInt)).bindBannerViews(paramView, paramInt);
    }
    return paramViewGroup;
  }
  
  public Context getmContext()
  {
    return this.mContext;
  }
  
  public void setBannerList(List<AppListItem> paramList)
  {
    this.mBannerList = paramList;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\adapter\HomeGalleryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */