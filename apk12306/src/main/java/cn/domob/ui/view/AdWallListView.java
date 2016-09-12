package cn.domob.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.domob.ui.adapter.AppListAdapter;
import cn.domob.ui.adapter.AppListAdapter.ListItemShowListener;
import cn.domob.ui.adapter.HomeGalleryAdapter;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DDrawable;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DLayout;
import cn.domob.ui.utility.DUtil;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.ReportUserActionType;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.AdInfo.ClickActionType;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AdWallListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private static Logger mLogger = new Logger(AdWallListView.class.getSimpleName());
  private final String MORE = "更多";
  private final String RETURNTOP = "点击返回顶部";
  private int SHOW_NUMBER_ONCE = 15;
  private AdWallListView mAdWallListView;
  private int mBannerIntervalTime = 0;
  List<AppListItem> mBannerList;
  private Context mContext;
  private DService mDService;
  private Dialog mDetailsDialog;
  private boolean mDisplayBanner = false;
  private TextView mFooterTextView;
  private View mFooterView;
  private HomeGalleryAdapter mGalleryAdapter;
  private int mGalleryPositon = 0;
  private DGallery mGalleryView;
  private View mHeaderView;
  List<AppListItem> mItemList;
  private int mLastItem;
  private AppListAdapter mListAdapter;
  private boolean mListAdapterSet = false;
  private LinearLayout mPointLinear;
  private a mTask;
  private Timer mTimer;
  private String viewTag = "";
  
  public AdWallListView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initListView();
  }
  
  public AdWallListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    initListView();
  }
  
  public AdWallListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initListView();
  }
  
  private void changeHomePointView(int paramInt)
  {
    Object localObject1 = this.mPointLinear.getChildAt(this.mGalleryPositon);
    Object localObject2 = this.mPointLinear.getChildAt(paramInt);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = (ImageView)localObject1;
      localObject2 = (ImageView)localObject2;
      ((ImageView)localObject1).setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_point_default"));
      ((ImageView)localObject2).setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_point_select"));
      this.mGalleryPositon = paramInt;
    }
  }
  
  private void initHomeGalleryPointView()
  {
    this.mPointLinear.removeAllViews();
    int i = (int)DUtil.getScreenDensity(this.mContext);
    int j = (int)DUtil.getScreenDensity(this.mContext);
    int k = (int)DUtil.getScreenDensity(this.mContext) * 9;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i * 9, j * 9);
    localLayoutParams.leftMargin = k;
    localLayoutParams.rightMargin = k;
    i = 0;
    if (i < this.mBannerList.size())
    {
      ImageView localImageView = new ImageView(this.mContext);
      if (i == 0) {
        localImageView.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_point_select"));
      }
      for (;;)
      {
        localImageView.setLayoutParams(localLayoutParams);
        this.mPointLinear.addView(localImageView);
        i++;
        break;
        localImageView.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_point_default"));
      }
    }
  }
  
  private void processItemClick(AppListItem paramAppListItem)
  {
    AdInfo.ClickActionType localClickActionType = paramAppListItem.getAdInfo().getAdActionType();
    this.mDService.doClickWallItemReport(paramAppListItem.getAdInfo());
    switch (6.a[localClickActionType.ordinal()])
    {
    }
    for (;;)
    {
      return;
      this.mDService.onClickWallItem(paramAppListItem.getAdInfo());
      continue;
      showDetailsDialogView(paramAppListItem);
    }
  }
  
  private void refreshBannerList(List<AppListItem> paramList, int paramInt)
  {
    this.mBannerList = paramList;
    if ((this.mGalleryView != null) && (this.mGalleryAdapter != null) && (this.mBannerList != null))
    {
      this.mGalleryView.setSelection(0);
      this.mGalleryAdapter.setBannerList(this.mBannerList);
      this.mGalleryAdapter.notifyDataSetChanged();
      setAutoScroll(paramInt);
      initHomeGalleryPointView();
    }
  }
  
  private void refreshItemList(List<AppListItem> paramList)
  {
    this.mItemList = paramList;
    if (!this.mListAdapterSet)
    {
      setAdapter(this.mListAdapter);
      this.mListAdapterSet = true;
    }
    if ((this.mListAdapter != null) && (this.mItemList != null))
    {
      this.mListAdapter.setItemList(this.mItemList, this.SHOW_NUMBER_ONCE);
      this.mListAdapter.notifyDataSetChanged();
    }
    this.mFooterTextView.setText("更多");
    if ((getFooterViewsCount() > 0) && (this.mItemList.size() < 8)) {
      removeFooterView(this.mFooterView);
    }
  }
  
  private void sendListImpReports(int paramInt1, int paramInt2)
  {
    mLogger.debugLog("Start to send imp reports,start:" + paramInt1 + ", len:" + paramInt2 + " tag:" + this.viewTag);
    ArrayList localArrayList = new ArrayList();
    for (int i = paramInt1; (i < paramInt1 + paramInt2) && (i < this.mItemList.size()); i++)
    {
      AdInfo localAdInfo = ((AppListItem)this.mItemList.get(i)).getAdInfo();
      localAdInfo.setAdActualPosition(i);
      localArrayList.add(localAdInfo);
    }
    this.mDService.doImpReports(localArrayList);
  }
  
  private void setAutoScroll(int paramInt)
  {
    mLogger.debugLog("autoscroll:" + paramInt);
    this.mBannerIntervalTime = paramInt;
    if ((this.mBannerIntervalTime <= 5) && (this.mBannerIntervalTime > 0)) {
      this.mBannerIntervalTime = 5;
    }
    if (this.mBannerIntervalTime > 0)
    {
      if (this.mTimer != null) {
        this.mTimer.cancel();
      }
      this.mTimer = new Timer();
      this.mTask = new a(null);
      this.mTimer.scheduleAtFixedRate(this.mTask, 0L, this.mBannerIntervalTime * 1000);
    }
  }
  
  private void setDisplayBanner(boolean paramBoolean)
  {
    mLogger.debugLog("setDisplayBanner: " + paramBoolean);
    mLogger.debugLog("current version:" + Build.VERSION.SDK_INT);
    if ((this.mListAdapterSet) && (Build.VERSION.SDK_INT <= 10))
    {
      mLogger.debugLog("list adapter is already set, do not add/removew banner view dynamically");
      return;
    }
    this.mDisplayBanner = paramBoolean;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (getHeaderViewsCount() == 0) {
          addHeaderView(this.mHeaderView);
        }
        Logger localLogger = mLogger;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localLogger.debugLog("header count:" + getHeaderViewsCount());
      }
      catch (Exception localException)
      {
        mLogger.errorLog("Error occurs when adding/removing views");
        mLogger.printStackTrace(localException);
      }
      break;
      removeHeaderView(this.mHeaderView);
    }
  }
  
  private void setShowNumber(int paramInt)
  {
    if (paramInt > 0) {
      this.SHOW_NUMBER_ONCE = paramInt;
    }
  }
  
  private void showDetailsDialogView(AppListItem paramAppListItem)
  {
    this.mDetailsDialog = new Dialog(this.mContext);
    paramAppListItem = paramAppListItem.bindDetailsView(this.mDetailsDialog);
    this.mDetailsDialog.requestWindowFeature(1);
    this.mDetailsDialog.setContentView(paramAppListItem);
    this.mDetailsDialog.show();
  }
  
  public DService getDService()
  {
    return this.mDService;
  }
  
  public HomeGalleryAdapter getGalleryAdapter()
  {
    return this.mGalleryAdapter;
  }
  
  public AppListAdapter getListAdapter()
  {
    return this.mListAdapter;
  }
  
  public String getViewTag()
  {
    return this.viewTag;
  }
  
  public void initListView()
  {
    mLogger.debugLog("initListView");
    this.mAdWallListView = this;
    this.mFooterView = LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_home_list_footer"), null);
    this.mFooterTextView = ((TextView)this.mFooterView.findViewById(DId.getIdInt(this.mContext, "more_textview")));
    this.mFooterTextView.setText("更多");
    addFooterView(this.mFooterView);
    setOnScrollListener(this);
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousInt -= AdWallListView.this.getHeaderViewsCount();
        AdWallListView.mLogger.debugLog("list item click, pos:" + paramAnonymousInt);
        if ((AdWallListView.this.mItemList != null) && (paramAnonymousInt >= 0) && (paramAnonymousInt < AdWallListView.this.mItemList.size()))
        {
          ((AppListItem)AdWallListView.this.mItemList.get(paramAnonymousInt)).getAdInfo().setAdActualPosition(paramAnonymousInt);
          AdWallListView.mLogger.debugLog("Start to display detail view: " + paramAnonymousInt);
          AdWallListView.this.processItemClick((AppListItem)AdWallListView.this.mItemList.get(paramAnonymousInt));
        }
      }
    });
    this.mHeaderView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_home_banner"), null));
    this.mGalleryView = ((DGallery)this.mHeaderView.findViewById(DId.getIdInt(this.mContext, "gallery1")));
    this.mPointLinear = ((LinearLayout)this.mHeaderView.findViewById(DId.getIdInt(this.mContext, "gallery_point_linear")));
    this.mGalleryAdapter = new HomeGalleryAdapter(this.mContext);
    this.mGalleryView.setAdapter(this.mGalleryAdapter);
    this.mGalleryView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (AdWallListView.this.mBannerList != null)
        {
          paramAnonymousInt %= AdWallListView.this.mBannerList.size();
          AdWallListView.mLogger.debugLog("gallery item clicked: " + paramAnonymousInt);
          ((AppListItem)AdWallListView.this.mBannerList.get(paramAnonymousInt)).getAdInfo().setAdActualPosition(paramAnonymousInt);
          AdWallListView.this.processItemClick((AppListItem)AdWallListView.this.mBannerList.get(paramAnonymousInt));
        }
      }
    });
    this.mGalleryView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AdWallListView.mLogger.debugLog("onItemSelected:" + paramAnonymousInt);
        if ((AdWallListView.this.mBannerList != null) && (paramAnonymousInt < AdWallListView.this.mBannerList.size()))
        {
          paramAnonymousAdapterView = new ArrayList();
          paramAnonymousAdapterView.add(((AppListItem)AdWallListView.this.mBannerList.get(paramAnonymousInt)).getAdInfo());
          AdWallListView.this.mDService.doImpReports(paramAnonymousAdapterView);
          AdWallListView.mLogger.debugLog("Start to send imp reports：" + paramAnonymousInt);
        }
        AdWallListView.this.changeHomePointView(paramAnonymousInt % AdWallListView.this.mBannerList.size());
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
        AdWallListView.mLogger.debugLog("onNothingSelected");
      }
    });
    this.mListAdapter = new AppListAdapter(this.mContext);
    this.mListAdapter.setListItemShowListener(new AppListAdapter.ListItemShowListener()
    {
      public void onListItemStartToShow()
      {
        AdWallListView.this.sendListImpReports(0, AdWallListView.this.mListAdapter.getCount());
      }
    });
  }
  
  public boolean isDisplayBanner()
  {
    return this.mDisplayBanner;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLastItem = (paramInt1 + paramInt2 - 1 - getHeaderViewsCount());
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    mLogger.debugLog("onScrollStateChanged:" + paramInt);
    mLogger.debugLog("lastItem:" + this.mLastItem);
    if ((this.mLastItem == this.mListAdapter.getCount()) && (paramInt == 0))
    {
      if (this.mListAdapter.getCount() + this.SHOW_NUMBER_ONCE < this.mListAdapter.getItemSize()) {
        break label201;
      }
      this.mListAdapter.setCount(this.mListAdapter.getItemSize());
      this.mFooterTextView.setText("点击返回顶部");
      if ((this.mDService != null) && (this.mLastItem < this.mListAdapter.getCount()))
      {
        mLogger.debugLog("send PGDN report");
        this.mDService.doUserActionReport(DService.ReportUserActionType.PGDN);
        sendListImpReports(this.mLastItem, this.mListAdapter.getCount() - this.mLastItem);
      }
      this.mFooterView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AdWallListView.this.setSelection(0);
        }
      });
    }
    for (;;)
    {
      this.mListAdapter.notifyDataSetChanged();
      return;
      label201:
      this.mFooterTextView.setText("更多");
      paramInt = this.mListAdapter.getCount();
      this.mListAdapter.setCount(paramInt + this.SHOW_NUMBER_ONCE);
      if (this.mDService != null)
      {
        mLogger.debugLog("send PGDN report");
        this.mDService.doUserActionReport(DService.ReportUserActionType.PGDN);
        sendListImpReports(this.mLastItem, this.mListAdapter.getCount() - this.mLastItem);
      }
    }
  }
  
  public void refreshItemListWithBanner(List<AppListItem> paramList1, int paramInt1, List<AppListItem> paramList2, int paramInt2)
  {
    setShowNumber(paramInt1);
    setDisplayBanner(true);
    refreshItemList(paramList1);
    refreshBannerList(paramList2, paramInt2);
  }
  
  public void refreshItemListWithNoBanner(List<AppListItem> paramList, int paramInt)
  {
    setShowNumber(paramInt);
    setDisplayBanner(false);
    refreshItemList(paramList);
  }
  
  public void setDService(DService paramDService)
  {
    this.mDService = paramDService;
  }
  
  public void setViewTag(String paramString)
  {
    this.viewTag = paramString;
  }
  
  private class a
    extends TimerTask
  {
    private a() {}
    
    public void run()
    {
      if ((AdWallListView.this.mGalleryView != null) && (AdWallListView.this.mGalleryView.hasWindowFocus()) && (AdWallListView.this.mAdWallListView.getFirstVisiblePosition() == 0) && (!AdWallListView.this.mGalleryView.isOnGalleryTouch()))
      {
        AdWallListView.mLogger.debugLog("start auto scroll: " + toString());
        ((Activity)AdWallListView.this.mContext).runOnUiThread(new Runnable()
        {
          public void run()
          {
            AdWallListView.this.mGalleryView.onKeyDown(22, null);
          }
        });
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\AdWallListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */