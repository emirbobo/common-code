package cn.domob.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import cn.dm.download.DownLoadManager;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadReportListener;
import cn.domob.ui.adapter.AppListAdapter;
import cn.domob.ui.item.AppListItem.AppItemStatusChangeListener;
import cn.domob.ui.utility.DColor;
import cn.domob.ui.utility.DDrawable;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DLayout;
import cn.domob.ui.utility.DString;
import cn.domob.ui.utility.DUtil;
import cn.domob.ui.view.AdWallListView;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.EWallReportType;
import cn.domob.wall.core.DService.ReportDownLoadType;
import cn.domob.wall.core.bean.AdExtend;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import java.util.List;

public class Home
  implements DownloadReportListener, AppListItem.AppItemStatusChangeListener
{
  private static Logger mLogger = new Logger(Home.class.getSimpleName());
  private String OneListTag = "OneList";
  private final int REFRESHDOWNLOADTOOL = 1;
  private final int REFRESHLIST = 0;
  private String allListTag = "AllList";
  private String appListTag = "AppList";
  private DownLoadManager dlm;
  private String gameListTag = "GameList";
  Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return;
        Home.this.notifyListChanged();
        continue;
        Home.this.initDownloaderTool();
      }
    }
  };
  private ProgressBar home_progress;
  private TextView home_progress_tv;
  private AdResp mAdResp;
  private RadioButton mAdWallRadioButton;
  private AdWallListView mAllappListView;
  private AppListContainer mAppListContainer;
  private AdWallListView mAppsListView;
  private RelativeLayout mBackButton;
  private Context mContext;
  private ControlInfo mControlInfo;
  private DService mDService;
  private RelativeLayout mDownloaderRl;
  private RadioButton mEWallRadioButton;
  private RelativeLayout mEWallRelativeLayout;
  private AdWallListView mGamesListView;
  private RelativeLayout mHomeView;
  private HomeViewListener mHomeViewlistener;
  private RelativeLayout mHome_progress_rl;
  private RelativeLayout mOneListRelativeLayout;
  private AdWallListView mOneListView;
  private ImageView mSearchImageView;
  private String mTAB_ALL;
  private String mTAB_APP;
  private String mTAB_GAME;
  private TabHost mTabHost;
  private ImageView mTab_bg_background_all;
  private ImageView mTab_bg_background_app;
  private ImageView mTab_bg_background_game;
  private RadioGroup mTitleRadioGroup;
  private boolean showEWallEntry = false;
  
  public Home(Context paramContext, DService paramDService)
  {
    this.mContext = paramContext;
    mLogger.ptLog("Start to init home view");
    this.mHomeView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_home"), null));
    mLogger.ptLog("Finish to init home view");
    this.mDService = paramDService;
    this.dlm = DownLoadManager.getInstance(this.mContext);
    this.dlm.setDownloadReportListener(this);
    this.dlm.initAllDownloadAppInfoList();
    this.mAppListContainer = new AppListContainer(paramContext, paramDService, this, this.dlm);
    this.mAdResp = new AdResp();
    initView();
    setHomeViewVisible(a.b);
  }
  
  private void doDownloadReport(DownloadAppInfo paramDownloadAppInfo, DService.ReportDownLoadType paramReportDownLoadType)
  {
    for (;;)
    {
      try
      {
        localObject = DUtil.buildAdInfo(paramDownloadAppInfo);
        if (localObject != null)
        {
          Logger localLogger = mLogger;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localLogger.debugLog("doDownloadReport for: " + paramDownloadAppInfo.getAppName() + " type:" + paramReportDownLoadType.toString());
          this.mDService.doDownLoadReport((AdInfo)localObject, paramReportDownLoadType);
          return;
        }
      }
      catch (Exception paramDownloadAppInfo)
      {
        Object localObject;
        mLogger.errorLog("exception occurs when sending report");
        continue;
      }
      localObject = mLogger;
      paramDownloadAppInfo = new java/lang/StringBuilder;
      paramDownloadAppInfo.<init>();
      ((Logger)localObject).errorLog("fail to send report:" + paramReportDownLoadType.toString());
    }
  }
  
  private void initBackButton()
  {
    this.mBackButton = ((RelativeLayout)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "bar_button")));
    this.mBackButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Home.mLogger.debugLog("backButton clicked");
        if (Home.this.mHomeViewlistener != null) {
          Home.this.mHomeViewlistener.onBackButtonClicked();
        }
      }
    });
  }
  
  private void initDownloaderTool()
  {
    this.mDownloaderRl = ((RelativeLayout)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "rl_download_entrance")));
    refreshDownloadingCount();
    this.mDownloaderRl.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Home.this.mHomeViewlistener != null) {
          Home.this.mHomeViewlistener.onDownloadToolButtonClicked();
        }
      }
    });
  }
  
  private void initLoadingProgress()
  {
    this.mHome_progress_rl = ((RelativeLayout)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "home_progress_rl")));
    this.home_progress = ((ProgressBar)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "home_progress")));
    this.home_progress_tv = ((TextView)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "home_progress_tv")));
  }
  
  private void initOneListView()
  {
    this.mOneListRelativeLayout = ((RelativeLayout)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "onlylistRelativeS")));
    this.mOneListView = ((AdWallListView)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "list_only")));
    this.mOneListView.setDService(this.mDService);
    this.mOneListView.setViewTag(this.OneListTag);
  }
  
  private void initRadioButton()
  {
    this.mEWallRelativeLayout = ((RelativeLayout)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "rl_webview")));
    this.mTitleRadioGroup = ((RadioGroup)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "rg_home_bar")));
    this.mAdWallRadioButton = ((RadioButton)this.mTitleRadioGroup.findViewById(DId.getIdInt(this.mContext, "rb_recommend_Button")));
    this.mEWallRadioButton = ((RadioButton)this.mTitleRadioGroup.findViewById(DId.getIdInt(this.mContext, "rb_electronic_page_Button")));
    this.mTitleRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        paramAnonymousInt = paramAnonymousRadioGroup.getCheckedRadioButtonId();
        if (paramAnonymousInt == Home.this.mAdWallRadioButton.getId()) {
          Home.this.mEWallRelativeLayout.setVisibility(8);
        }
        for (;;)
        {
          return;
          if (paramAnonymousInt == Home.this.mEWallRadioButton.getId())
          {
            Home.mLogger.debugLog("Send report:E_ENTRY_CLICK");
            Home.this.mDService.doEWallReport(DService.EWallReportType.E_ENTRY_CLICK);
            if (Home.this.mEWallRelativeLayout.getChildCount() > 0)
            {
              Home.mLogger.debugLog("Remove child view");
              Home.this.mEWallRelativeLayout.removeAllViews();
            }
            Home.this.mEWallRelativeLayout.addView(Home.this.mDService.getEView(Home.this.mContext));
            Home.this.mEWallRelativeLayout.setVisibility(0);
          }
        }
      }
    });
  }
  
  private void initSearchButton()
  {
    this.mSearchImageView = ((ImageView)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "iv_search_bt")));
    this.mSearchImageView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Home.mLogger.debugLog("searchButton clicked");
        if (Home.this.mHomeViewlistener != null) {
          Home.this.mHomeViewlistener.onSearchButtonClicked();
        }
      }
    });
  }
  
  private void initTabListView()
  {
    mLogger.debugLog("initListView");
    this.mAppsListView = ((AdWallListView)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "list_app")));
    this.mGamesListView = ((AdWallListView)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "list_game")));
    this.mAllappListView = ((AdWallListView)this.mHomeView.findViewById(DId.getIdInt(this.mContext, "list_all")));
    this.mAppsListView.setDService(this.mDService);
    this.mGamesListView.setDService(this.mDService);
    this.mAllappListView.setDService(this.mDService);
    this.mAppsListView.setViewTag(this.appListTag);
    this.mGamesListView.setViewTag(this.gameListTag);
    this.mAllappListView.setViewTag(this.allListTag);
  }
  
  private void initTabView()
  {
    mLogger.debugLog("initTabView");
    this.mTabHost = ((TabHost)this.mHomeView.findViewById(16908306));
    this.mTabHost.setup();
    String str3 = this.mContext.getString(DString.getStringInt(this.mContext, "tab_app"));
    String str2 = this.mContext.getString(DString.getStringInt(this.mContext, "tab_game"));
    String str1 = this.mContext.getString(DString.getStringInt(this.mContext, "tab_all"));
    final Object localObject2 = this.mContext.getString(DString.getStringInt(this.mContext, "tab_app_english"));
    String str4 = this.mContext.getString(DString.getStringInt(this.mContext, "tab_game_english"));
    Object localObject1 = this.mContext.getString(DString.getStringInt(this.mContext, "tab_all_english"));
    View localView1 = LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_home_tab_element"), null);
    this.mTab_bg_background_all = ((ImageView)localView1.findViewById(DId.getIdInt(this.mContext, "tab_bg_select")));
    ((ImageView)localView1.findViewById(DId.getIdInt(this.mContext, "tab_image"))).setImageResource(DDrawable.getDrawableInt(this.mContext, "u_home_tab_all"));
    final TextView localTextView2 = (TextView)localView1.findViewById(DId.getIdInt(this.mContext, "tab_name"));
    localTextView2.setText(str1);
    final TextView localTextView1 = (TextView)localView1.findViewById(DId.getIdInt(this.mContext, "tab_name_english"));
    localTextView1.setText((CharSequence)localObject1);
    ((TextView)localView1.findViewById(DId.getIdInt(this.mContext, "tab_name"))).getPaint().setFakeBoldText(true);
    localObject1 = LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_home_tab_element"), null);
    this.mTab_bg_background_app = ((ImageView)((View)localObject1).findViewById(DId.getIdInt(this.mContext, "tab_bg_select")));
    ((ImageView)((View)localObject1).findViewById(DId.getIdInt(this.mContext, "tab_image"))).setImageResource(DDrawable.getDrawableInt(this.mContext, "u_home_tab_app"));
    final TextView localTextView4 = (TextView)((View)localObject1).findViewById(DId.getIdInt(this.mContext, "tab_name"));
    localTextView4.setText(str3);
    final TextView localTextView3 = (TextView)((View)localObject1).findViewById(DId.getIdInt(this.mContext, "tab_name_english"));
    localTextView3.setText((CharSequence)localObject2);
    ((TextView)((View)localObject1).findViewById(DId.getIdInt(this.mContext, "tab_name"))).getPaint().setFakeBoldText(true);
    View localView2 = LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_home_tab_element"), null);
    this.mTab_bg_background_game = ((ImageView)localView2.findViewById(DId.getIdInt(this.mContext, "tab_bg_select")));
    ((ImageView)localView2.findViewById(DId.getIdInt(this.mContext, "tab_image"))).setImageResource(DDrawable.getDrawableInt(this.mContext, "u_home_tab_game"));
    final TextView localTextView5 = (TextView)localView2.findViewById(DId.getIdInt(this.mContext, "tab_name"));
    localTextView5.setText(str2);
    localObject2 = (TextView)localView2.findViewById(DId.getIdInt(this.mContext, "tab_name_english"));
    ((TextView)localObject2).setText(str4);
    ((TextView)localView2.findViewById(DId.getIdInt(this.mContext, "tab_name"))).getPaint().setFakeBoldText(true);
    this.mTabHost.addTab(this.mTabHost.newTabSpec(str1).setIndicator(localView1).setContent(DId.getIdInt(this.mContext, "list_all")));
    this.mTabHost.addTab(this.mTabHost.newTabSpec(str2).setIndicator(localView2).setContent(DId.getIdInt(this.mContext, "list_game")));
    this.mTabHost.addTab(this.mTabHost.newTabSpec(str3).setIndicator((View)localObject1).setContent(DId.getIdInt(this.mContext, "list_app")));
    setTabVisibility(this.mTab_bg_background_all, this.mTab_bg_background_app, this.mTab_bg_background_game);
    final int j = this.mContext.getResources().getColor(DColor.getColorInt(this.mContext, "tab_default"));
    final int i = this.mContext.getResources().getColor(DColor.getColorInt(this.mContext, "tab_select"));
    localTextView4.setTextColor(j);
    localTextView3.setTextColor(j);
    localTextView2.setTextColor(i);
    localTextView1.setTextColor(i);
    localTextView5.setTextColor(j);
    ((TextView)localObject2).setTextColor(j);
    this.mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
    {
      public void onTabChanged(String paramAnonymousString)
      {
        Home.mLogger.debugLog("tabId:" + paramAnonymousString);
        Home.access$1002(Home.this, Home.this.mContext.getString(DString.getStringInt(Home.this.mContext, "tab_app")));
        Home.access$1102(Home.this, Home.this.mContext.getString(DString.getStringInt(Home.this.mContext, "tab_game")));
        Home.access$1202(Home.this, Home.this.mContext.getString(DString.getStringInt(Home.this.mContext, "tab_all")));
        if (Home.this.mTAB_APP.equals(paramAnonymousString))
        {
          Home.this.setTabVisibility(Home.this.mTab_bg_background_app, Home.this.mTab_bg_background_all, Home.this.mTab_bg_background_game);
          localTextView4.setTextColor(i);
          localTextView3.setTextColor(i);
          localTextView2.setTextColor(j);
          localTextView1.setTextColor(j);
          localTextView5.setTextColor(j);
          localObject2.setTextColor(j);
        }
        for (;;)
        {
          return;
          if (Home.this.mTAB_GAME.equals(paramAnonymousString))
          {
            Home.this.setTabVisibility(Home.this.mTab_bg_background_game, Home.this.mTab_bg_background_all, Home.this.mTab_bg_background_app);
            localTextView4.setTextColor(j);
            localTextView3.setTextColor(j);
            localTextView2.setTextColor(j);
            localTextView1.setTextColor(j);
            localTextView5.setTextColor(i);
            localObject2.setTextColor(i);
          }
          else if (Home.this.mTAB_ALL.equals(paramAnonymousString))
          {
            Home.this.setTabVisibility(Home.this.mTab_bg_background_all, Home.this.mTab_bg_background_app, Home.this.mTab_bg_background_game);
            localTextView4.setTextColor(j);
            localTextView3.setTextColor(j);
            localTextView2.setTextColor(i);
            localTextView1.setTextColor(i);
            localTextView5.setTextColor(j);
            localObject2.setTextColor(j);
          }
        }
      }
    });
  }
  
  private void initTitle()
  {
    initBackButton();
    initRadioButton();
    initSearchButton();
    initDownloaderTool();
  }
  
  private void initView()
  {
    initTitle();
    initLoadingProgress();
    initTabView();
    initTabListView();
    initOneListView();
  }
  
  private void notifyListChanged()
  {
    if (this.mControlInfo != null)
    {
      if (!this.mControlInfo.isClassify()) {
        break label57;
      }
      mLogger.debugLog("notify change for tab");
      this.mAllappListView.getListAdapter().notifyDataSetChanged();
      this.mGamesListView.getListAdapter().notifyDataSetChanged();
      this.mAppsListView.getListAdapter().notifyDataSetChanged();
    }
    for (;;)
    {
      return;
      label57:
      mLogger.debugLog("notify change for list");
      this.mOneListView.getListAdapter().notifyDataSetChanged();
    }
  }
  
  private void refreshEWallView()
  {
    this.mEWallRelativeLayout.removeAllViews();
  }
  
  private void refreshList(AdResp paramAdResp)
  {
    mLogger.ptLog("Start to refresh list");
    this.mAppListContainer.doRefresh(paramAdResp);
    if (this.mControlInfo.isClassify())
    {
      mLogger.debugLog(String.format("Show ad in tab view. list size:%d, banner size:%d", new Object[] { Integer.valueOf(this.mAppListContainer.getAllList().size()), Integer.valueOf(this.mAppListContainer.getBannerList().size()) }));
      if ((this.mControlInfo.isHasBanner()) && (this.mAppListContainer.getBannerList().size() > 0))
      {
        this.mAllappListView.refreshItemListWithBanner(this.mAppListContainer.getAllList(), this.mControlInfo.getShowAdNum(), this.mAppListContainer.getBannerList(), this.mControlInfo.getBannerIntervalTime());
        this.mGamesListView.refreshItemListWithBanner(this.mAppListContainer.getGameList(), this.mControlInfo.getShowAdNum(), this.mAppListContainer.getBannerList(), this.mControlInfo.getBannerIntervalTime());
        this.mAppsListView.refreshItemListWithBanner(this.mAppListContainer.getAppList(), this.mControlInfo.getShowAdNum(), this.mAppListContainer.getBannerList(), this.mControlInfo.getBannerIntervalTime());
      }
      for (;;)
      {
        setHomeViewVisible(a.c);
        mLogger.ptLog("Refresh list done");
        return;
        this.mAllappListView.refreshItemListWithNoBanner(this.mAppListContainer.getAllList(), this.mControlInfo.getShowAdNum());
        this.mGamesListView.refreshItemListWithNoBanner(this.mAppListContainer.getGameList(), this.mControlInfo.getShowAdNum());
        this.mAppsListView.refreshItemListWithNoBanner(this.mAppListContainer.getAppList(), this.mControlInfo.getShowAdNum());
      }
    }
    mLogger.debugLog("Show ad in single list view");
    if ((this.mControlInfo.isHasBanner()) && (this.mAppListContainer.getBannerList().size() > 0)) {
      this.mOneListView.refreshItemListWithBanner(this.mAppListContainer.getAllList(), this.mControlInfo.getShowAdNum(), this.mAppListContainer.getBannerList(), this.mControlInfo.getBannerIntervalTime());
    }
    for (;;)
    {
      setHomeViewVisible(a.d);
      break;
      this.mOneListView.refreshItemListWithNoBanner(this.mAppListContainer.getAllList(), this.mControlInfo.getShowAdNum());
    }
  }
  
  private void refreshTitle(AdResp paramAdResp)
  {
    mLogger.ptLog("Start to refresh title");
    if (paramAdResp.getControlInfo() != null)
    {
      if (!paramAdResp.getControlInfo().isShowSearchEntrance()) {
        break label178;
      }
      this.mSearchImageView.setVisibility(0);
      if ((paramAdResp.getControlInfo() == null) || (paramAdResp.getAdExtend() == null) || (paramAdResp.getAdExtend().size() <= 0) || (!paramAdResp.getControlInfo().isShowEWallEntrance())) {
        break label190;
      }
      paramAdResp = (AdExtend)paramAdResp.getAdExtend().get(0);
      mLogger.debugLog("mAdExtend>>>:" + paramAdResp.toString());
      this.mEWallRadioButton.setVisibility(0);
      this.mEWallRadioButton.setText(paramAdResp.getmLabel());
      this.mAdWallRadioButton.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_bar_type_left_mode"));
      setShowEWallEntry(true);
      this.mTitleRadioGroup.check(this.mAdWallRadioButton.getId());
    }
    for (;;)
    {
      mLogger.ptLog("Refresh title done");
      return;
      label178:
      this.mSearchImageView.setVisibility(8);
      break;
      label190:
      mLogger.debugLog("EWall is disabled");
      this.mEWallRadioButton.setVisibility(8);
      this.mAdWallRadioButton.setBackgroundResource(0);
      setShowEWallEntry(false);
    }
  }
  
  private void setHomeViewVisible(a parama)
  {
    switch (9.a[parama.ordinal()])
    {
    }
    for (;;)
    {
      return;
      this.mOneListRelativeLayout.setVisibility(8);
      this.mHome_progress_rl.setVisibility(8);
      this.mTabHost.setVisibility(0);
      continue;
      this.mOneListRelativeLayout.setVisibility(0);
      this.mHome_progress_rl.setVisibility(8);
      this.mTabHost.setVisibility(8);
      continue;
      this.mOneListRelativeLayout.setVisibility(8);
      this.mHome_progress_rl.setVisibility(0);
      this.mTabHost.setVisibility(8);
    }
  }
  
  private void setTabVisibility(ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3)
  {
    paramImageView1.setVisibility(0);
    paramImageView2.setVisibility(4);
    paramImageView3.setVisibility(4);
  }
  
  public DownLoadManager getDownloadManager()
  {
    return this.dlm;
  }
  
  public View getHomeView()
  {
    return this.mHomeView;
  }
  
  public boolean isShowEWallEntry()
  {
    return this.showEWallEntry;
  }
  
  public void onAppItemDownloadStatusChanged(Constants.DownloadStatus paramDownloadStatus)
  {
    this.handler.sendEmptyMessage(0);
    switch (9.b[paramDownloadStatus.ordinal()])
    {
    }
    for (;;)
    {
      return;
      this.handler.sendEmptyMessage(1);
    }
  }
  
  public void onAutoRunReport(DownloadAppInfo paramDownloadAppInfo)
  {
    doDownloadReport(paramDownloadAppInfo, DService.ReportDownLoadType.AUTO_RUN);
  }
  
  public void onDownloadFailedReport(DownloadAppInfo paramDownloadAppInfo)
  {
    doDownloadReport(paramDownloadAppInfo, DService.ReportDownLoadType.DL_FAILED);
  }
  
  public void onDownloadStartReport(DownloadAppInfo paramDownloadAppInfo)
  {
    doDownloadReport(paramDownloadAppInfo, DService.ReportDownLoadType.DL_START);
  }
  
  public void onDownloadSuccessReport(DownloadAppInfo paramDownloadAppInfo)
  {
    doDownloadReport(paramDownloadAppInfo, DService.ReportDownLoadType.DL_FINISH);
  }
  
  public void onDownloadWaitingReport(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onDownloadWaitingReport");
  }
  
  public void onInstallSuccessReport(DownloadAppInfo paramDownloadAppInfo)
  {
    doDownloadReport(paramDownloadAppInfo, DService.ReportDownLoadType.INSTALL_SUCCESS);
  }
  
  public void refreshAd(AdResp paramAdResp)
  {
    mLogger.debugLog("refresh resp:" + paramAdResp.toString());
    if (paramAdResp != null)
    {
      this.mAdResp = paramAdResp;
      this.mControlInfo = paramAdResp.getControlInfo();
      if (this.mTabHost != null) {
        this.mTabHost.setCurrentTab(0);
      }
      refreshTitle(this.mAdResp);
      refreshList(this.mAdResp);
      refreshEWallView();
    }
  }
  
  public void refreshDownloadingCount()
  {
    TextView localTextView;
    int i;
    if (this.mDownloaderRl != null)
    {
      localTextView = (TextView)this.mDownloaderRl.findViewById(DId.getIdInt(this.mContext, "tv_download_count"));
      i = this.dlm.getDownloadingCount();
      if (i > 0) {
        break label47;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      return;
      label47:
      localTextView.setVisibility(0);
      localTextView.setText(String.valueOf(i));
    }
  }
  
  public void setHomeViewListener(HomeViewListener paramHomeViewListener)
  {
    this.mHomeViewlistener = paramHomeViewListener;
  }
  
  public void setShowEWallEntry(boolean paramBoolean)
  {
    this.showEWallEntry = paramBoolean;
  }
  
  public void showErrorMSG(final String paramString)
  {
    ((Activity)this.mContext).runOnUiThread(new Runnable()
    {
      public void run()
      {
        Home.this.mHome_progress_rl.setVisibility(0);
        Home.this.home_progress.setVisibility(8);
        Home.this.home_progress_tv.setText(paramString);
        Home.this.home_progress_tv.setVisibility(0);
        Home.this.home_progress_tv.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            if (Home.this.mHomeViewlistener != null) {
              Home.this.mHomeViewlistener.onRefreshButtonClicked();
            }
          }
        });
      }
    });
  }
  
  public void showProgressBar()
  {
    ((Activity)this.mContext).runOnUiThread(new Runnable()
    {
      public void run()
      {
        Home.this.mHome_progress_rl.setVisibility(0);
        Home.this.home_progress.setVisibility(0);
        Home.this.home_progress_tv.setVisibility(8);
      }
    });
  }
  
  public static abstract interface HomeViewListener
  {
    public abstract void onBackButtonClicked();
    
    public abstract void onDownloadToolButtonClicked();
    
    public abstract void onRefreshButtonClicked();
    
    public abstract void onSearchButtonClicked();
  }
  
  private static enum a
  {
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\Home.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */