package cn.domob.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.domob.ui.item.DownLoadListItem;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DLayout;
import cn.domob.wall.core.DService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DownloadManagerListAdapter
  extends BaseExpandableListAdapter
{
  private static Logger mLogger = new Logger(DownloadManagerListAdapter.class.getSimpleName());
  private ArrayList<List<DownLoadListItem>> mChildList;
  private Context mContext;
  private ArrayList<String> mGroupList;
  private int[] mPos;
  private View mSlidingMenu;
  private View mViewStub;
  private Map<int[], View> mViewStubMap;
  
  public DownloadManagerListAdapter(Context paramContext, DService paramDService, ArrayList<String> paramArrayList, ArrayList<List<DownLoadListItem>> paramArrayList1, Map<int[], View> paramMap)
  {
    this.mContext = paramContext;
    this.mChildList = paramArrayList1;
    this.mGroupList = paramArrayList;
    this.mViewStubMap = paramMap;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((List)this.mChildList.get(paramInt1)).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public ArrayList<List<DownLoadListItem>> getChildList()
  {
    return this.mChildList;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      mLogger.debugLog("convertView is null");
      paramViewGroup = (LinearLayout)LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_download_list_item"), null);
    }
    this.mSlidingMenu = paramViewGroup.findViewById(DId.getIdInt(this.mContext, "ll_sliding_menu"));
    paramView = this.mViewStubMap.entrySet().iterator();
    while (paramView.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramView.next();
      this.mPos = ((int[])localEntry.getKey());
      this.mViewStub = ((View)localEntry.getValue());
    }
    if (this.mPos != null)
    {
      if ((this.mPos[0] != paramInt1) || (this.mPos[1] != paramInt2)) {
        this.mSlidingMenu.setVisibility(8);
      }
      if ((this.mPos[0] == paramInt1) && (this.mPos[1] == paramInt2)) {
        this.mViewStub.setVisibility(8);
      }
    }
    ((DownLoadListItem)((List)this.mChildList.get(paramInt1)).get(paramInt2)).bindViews(paramViewGroup, paramInt1, paramInt2);
    return paramViewGroup;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((List)this.mChildList.get(paramInt)).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.mGroupList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.mGroupList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public ArrayList<String> getGroupList()
  {
    return this.mGroupList;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (LinearLayout)LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_download_group_item"), null);
    ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_download"))).setText(getGroup(paramInt).toString());
    return paramView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void setChildList(ArrayList<List<DownLoadListItem>> paramArrayList)
  {
    this.mChildList = paramArrayList;
  }
  
  public void setGroupList(ArrayList<String> paramArrayList)
  {
    this.mGroupList = paramArrayList;
  }
  
  static class a
  {
    ImageView a;
    TextView b;
    ProgressBar c;
    TextView d;
    TextView e;
    ImageView f;
    TextView g;
    TextView h;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\adapter\DownloadManagerListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */