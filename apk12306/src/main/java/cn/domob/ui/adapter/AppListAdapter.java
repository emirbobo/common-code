package cn.domob.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DLayout;
import java.util.ArrayList;
import java.util.List;

public class AppListAdapter
  extends BaseAdapter
{
  private static Logger mLogger = new Logger(AppListAdapter.class.getSimpleName());
  private Context mContext;
  private int mCount = 0;
  private List<AppListItem> mItemList = new ArrayList();
  private ListItemShowListener mListItemShowListener;
  private boolean mNeedNotify = true;
  
  public AppListAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int getCount()
  {
    if (this.mCount < this.mItemList.size()) {}
    for (int i = this.mCount;; i = this.mItemList.size()) {
      return i;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.mItemList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemSize()
  {
    return this.mItemList.size();
  }
  
  public ListItemShowListener getListItemShowListener()
  {
    return this.mListItemShowListener;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    mLogger.debugLog("getListView: " + paramInt);
    mLogger.ptLog("Start to get view " + paramInt);
    if ((this.mNeedNotify) && (this.mListItemShowListener != null))
    {
      this.mListItemShowListener.onListItemStartToShow();
      this.mNeedNotify = false;
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      mLogger.ptLog("Start to init convertView " + paramInt);
      paramViewGroup = (RelativeLayout)LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_home_list_element"), null);
      mLogger.ptLog("Finish to init convertView " + paramInt);
    }
    ((AppListItem)this.mItemList.get(paramInt)).bindListViews(paramViewGroup, paramInt);
    mLogger.ptLog("Finish to get view " + paramInt);
    return paramViewGroup;
  }
  
  public void setCount(int paramInt)
  {
    if (paramInt < this.mItemList.size()) {}
    for (;;)
    {
      this.mCount = paramInt;
      return;
      paramInt = this.mItemList.size();
    }
  }
  
  public void setItemList(List<AppListItem> paramList, int paramInt)
  {
    this.mItemList = paramList;
    this.mNeedNotify = true;
    if (paramList.size() > paramInt) {}
    for (;;)
    {
      this.mCount = paramInt;
      return;
      paramInt = paramList.size();
    }
  }
  
  public void setListItemShowListener(ListItemShowListener paramListItemShowListener)
  {
    this.mListItemShowListener = paramListItemShowListener;
  }
  
  public static abstract interface ListItemShowListener
  {
    public abstract void onListItemStartToShow();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\adapter\AppListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */