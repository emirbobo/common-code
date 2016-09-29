package cn.domob.ui.item;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import cn.dm.download.DownLoadManager;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadHelperListener;
import cn.domob.ui.adapter.DetailsGalleryAdapter;
import cn.domob.ui.main.Constants.DownloadStatus;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DColor;
import cn.domob.ui.utility.DDrawable;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DLayout;
import cn.domob.ui.utility.DString;
import cn.domob.ui.utility.DUtil;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.OnImageDownload;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.AdInfo.ClickActionType;
import cn.domob.wall.core.bean.ControlInfo;
import java.text.DecimalFormat;

public class AppListItem
  implements DownloadHelperListener
{
  private static final int SHOW_DOWNLOAD_BAR = 0;
  private static final int SHOW_INSTALL_BAR = 2;
  private static final int SHOW_OPEN_BAR = 3;
  private static final int SHOW_PROGRESS_BAR = 1;
  private static Logger mLogger = new Logger(AppListItem.class.getSimpleName());
  private final String DOWNLOAD_IMG_URL = "u_list_download";
  private final int HANDLER_DOWNLOADFAILED = 0;
  private final int HANDLER_REFRESHDETAILS = 1;
  private final String INSTALL_IMG_URL = "u_list_install";
  private final String LANDING_IMG_URL = "u_list_browser";
  private final String LAUNCH_IMG_URL = "u_list_open";
  private final String TEXT_DOWNLOAD_CONTINUE = "继续";
  private final String TEXT_DOWNLOAD_ONGOING = "下载中";
  private final String TEXT_DOWNLOAD_START = "免费下载";
  private final String TEXT_DOWNLOAD_WAITING = "等待中";
  private final String TEXT_INSTALL = "安装";
  private final String TEXT_LANDING_OPEN = "查看详情";
  private final String TEXT_LAUNCH = "打开";
  private final String TEXT_UPDATE = "升级";
  private DownLoadManager dm;
  private AppItemStatusChangeListener downloadListener;
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
        if (AppListItem.this.mContext != null)
        {
          Toast.makeText(AppListItem.this.mContext, DString.getStringInt(AppListItem.this.mContext, "download_failed"), 0).show();
          continue;
          AppListItem.this.buildDetailsActionArea();
        }
      }
    }
  };
  private ImageView iv_download;
  private ImageView iv_install;
  private ImageView iv_open;
  private AdInfo mAdInfo;
  private a mBannerViewHolder;
  private Context mContext;
  private ControlInfo mControlInfo;
  private DService mDService;
  private Dialog mDetailsDialog;
  private RelativeLayout mDetailsView;
  private DownloadAppInfo mDownloadAppInfo;
  private c mListViewHolder;
  private String mListenerName;
  private int mPosition;
  private ProgressBar pb_progress;
  private RelativeLayout rl_download_operations;
  private RelativeLayout rl_progress_bar;
  private TextView tv_progress;
  
  public AppListItem(Context paramContext, AppItemStatusChangeListener paramAppItemStatusChangeListener, AdInfo paramAdInfo, DService paramDService, DownLoadManager paramDownLoadManager, ControlInfo paramControlInfo, String paramString)
  {
    this.mAdInfo = paramAdInfo;
    this.mContext = paramContext;
    this.mDService = paramDService;
    this.dm = paramDownLoadManager;
    this.downloadListener = paramAppItemStatusChangeListener;
    this.mDownloadAppInfo = this.dm.checkAndGetDownloadAppInfo(DUtil.buildDownLoadAppInfo(this.mAdInfo));
    if (this.mDownloadAppInfo.getDownloadStatus() != 0) {
      this.dm.addTask(this.mDownloadAppInfo, paramString, this);
    }
    this.mControlInfo = paramControlInfo;
    this.mListenerName = paramString;
  }
  
  private void bindDetailsViewsForDownloadAndUpdate()
  {
    int i = 0;
    switch (this.mDownloadAppInfo.getDownloadStatus())
    {
    case 7: 
    default: 
      changeDownloadBarState(0);
    }
    for (;;)
    {
      return;
      changeDownloadBarState(0);
      continue;
      changeDownloadBarState(0);
      continue;
      if (this.mDownloadAppInfo.getAppSize() > 0L) {
        i = (int)((float)this.mDownloadAppInfo.getCurrentDownloadSize() / (float)this.mDownloadAppInfo.getAppSize() * 100.0F);
      }
      changeDownloadBarState(1);
      if ((this.pb_progress != null) && (this.tv_progress != null))
      {
        this.pb_progress.setProgress(i);
        this.tv_progress.setText(i + "%");
        continue;
        changeDownloadBarState(0);
        continue;
        changeDownloadBarState(2);
        continue;
        if (this.mAdInfo.getAdActionType().equals(AdInfo.ClickActionType.DOWNLOAD))
        {
          changeDownloadBarState(3);
        }
        else if (this.mAdInfo.getAdActionType().equals(AdInfo.ClickActionType.UPDATE))
        {
          changeDownloadBarState(0);
          continue;
          changeDownloadBarState(0);
        }
      }
    }
  }
  
  private void bindDetailsViewsForLaunch()
  {
    changeDownloadBarState(3);
  }
  
  private void bindListViewsForDownloadAndUpdate()
  {
    displayApkSize();
    switch (this.mDownloadAppInfo.getDownloadStatus())
    {
    case 7: 
    default: 
      setListActionArea(null, "");
    }
    for (;;)
    {
      return;
      if (this.mAdInfo.getAdActionType().equals(AdInfo.ClickActionType.DOWNLOAD))
      {
        setListActionArea("u_list_download", "免费下载");
      }
      else if (this.mAdInfo.getAdActionType().equals(AdInfo.ClickActionType.UPDATE))
      {
        setListActionArea("u_list_download", "升级");
        continue;
        setListActionArea(null, "等待中");
        continue;
        mLogger.debugLog("show progress for: " + this.mDownloadAppInfo.getAppName());
        int i = 0;
        if (this.mDownloadAppInfo.getAppSize() > 0L) {
          i = (int)((float)this.mDownloadAppInfo.getCurrentDownloadSize() / (float)this.mDownloadAppInfo.getAppSize() * 100.0F);
        }
        setListActionArea(null, String.valueOf(i) + "%");
        continue;
        setListActionArea(null, "继续");
        continue;
        setListActionArea(null, "继续");
        continue;
        setListActionArea("u_list_install", "安装");
        continue;
        if (this.mAdInfo.getAdActionType().equals(AdInfo.ClickActionType.DOWNLOAD))
        {
          setListActionArea("u_list_open", "打开");
        }
        else if (this.mAdInfo.getAdActionType().equals(AdInfo.ClickActionType.UPDATE))
        {
          setListActionArea("u_list_download", "升级");
          continue;
          setListActionArea("u_list_download", "升级");
        }
      }
    }
  }
  
  private void bindListViewsForLanding()
  {
    hideApkSize();
    setListActionArea("u_list_browser", "查看详情");
  }
  
  private void bindListViewsForLaunch()
  {
    hideApkSize();
    setListActionArea("u_list_open", "打开");
  }
  
  private void buildDetailsActionArea()
  {
    AdInfo.ClickActionType localClickActionType = this.mAdInfo.getAdActionType();
    switch (9.a[localClickActionType.ordinal()])
    {
    }
    for (;;)
    {
      return;
      bindDetailsViewsForDownloadAndUpdate();
      continue;
      bindDetailsViewsForLaunch();
    }
  }
  
  private void buildDetailsCommonView()
  {
    this.mDetailsView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_details"), null));
    this.rl_download_operations = ((RelativeLayout)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "dl01")));
    setDetailsActionClickListener();
    this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "details_close")).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppListItem.mLogger.debugLog("detail view dismiss");
        if (AppListItem.this.mDetailsDialog != null) {
          AppListItem.this.mDetailsDialog.dismiss();
        }
      }
    });
    Object localObject2 = (ScrollView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "scroll"));
    if (DUtil.getRealScreenHeight(this.mContext) > DUtil.getRealScreenWidth(this.mContext)) {}
    for (int i = DUtil.getRealScreenHeight(this.mContext);; i = DUtil.getRealScreenWidth(this.mContext))
    {
      if ((int)(i / DUtil.getRealDensity(this.mContext)) <= 500)
      {
        localObject1 = ((ScrollView)localObject2).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(310.0F * DUtil.getRealDensity(this.mContext)));
        ((ScrollView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      Object localObject1 = (Gallery)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "details_gallery_screenshot"));
      ((Gallery)localObject1).setAdapter(new DetailsGalleryAdapter(this.mAdInfo.getScreenshot(), this.mContext, this.mDService));
      ((Gallery)localObject1).setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
      });
      localObject1 = (ImageView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "details_logo"));
      ((ImageView)localObject1).setTag(this.mAdInfo.getAdLogoURL());
      this.mDService.requestImage(this.mAdInfo.getAdLogoURL(), (ImageView)localObject1, new DService.OnImageDownload()
      {
        public void onDownloadFail(String paramAnonymousString, ImageView paramAnonymousImageView)
        {
          AppListItem.mLogger.errorLog("Get img fails" + paramAnonymousString);
        }
        
        public void onDownloadSuc(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
        {
          if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
            paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
          }
        }
      });
      ((TextView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "details_name"))).setText(this.mAdInfo.getAdName());
      ((TextView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "details_versionName"))).setText("版本:" + this.mAdInfo.getAdVersionName());
      localObject1 = (TextView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "details_apkSize"));
      i = this.mAdInfo.getAdSize();
      localObject2 = new DecimalFormat("0.00").format(i / 1024.0F / 1024.0F);
      ((TextView)localObject1).setText("大小:" + (String)localObject2 + "M");
      localObject2 = (TextView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "details_details"));
      localObject1 = new SpannableString("简介：");
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(DColor.getColorInt(this.mContext, "details_text_color"))), 0, 3, 33);
      ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan((int)DUtil.getScreenDensity(this.mContext) * 14), 0, 2, 33);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).append(this.mAdInfo.getAdDetailDescription());
      this.iv_download = ((ImageView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "iv_download")));
      this.iv_install = ((ImageView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "iv_install")));
      this.iv_open = ((ImageView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "iv_open")));
      this.rl_progress_bar = ((RelativeLayout)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "rl_progress_bar")));
      this.pb_progress = ((ProgressBar)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "pb_progress")));
      this.tv_progress = ((TextView)this.mDetailsView.findViewById(DId.getIdInt(this.mContext, "tv_progress")));
      return;
    }
  }
  
  private void buildListActionArea()
  {
    setListActionClickListener();
    AdInfo.ClickActionType localClickActionType = this.mAdInfo.getAdActionType();
    switch (9.a[localClickActionType.ordinal()])
    {
    }
    for (;;)
    {
      return;
      bindListViewsForDownloadAndUpdate();
      continue;
      bindListViewsForLanding();
      continue;
      bindListViewsForLaunch();
    }
  }
  
  private void buildListCommonArea()
  {
    this.mListViewHolder.a.setImageResource(DDrawable.getDrawableInt(this.mContext, "u_list_logo"));
    this.mListViewHolder.a.setTag(this.mAdInfo.getAdLogoURL());
    this.mDService.requestImage(this.mAdInfo.getAdLogoURL(), this.mListViewHolder.a, new DService.OnImageDownload()
    {
      public void onDownloadFail(String paramAnonymousString, ImageView paramAnonymousImageView)
      {
        AppListItem.mLogger.errorLog("Get img fails" + paramAnonymousString);
      }
      
      public void onDownloadSuc(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
      {
        if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
          paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
        }
      }
    });
    if (this.mAdInfo.isNew()) {
      this.mListViewHolder.b.setVisibility(0);
    }
    for (;;)
    {
      this.mListViewHolder.c.setText(this.mAdInfo.getAdTitle());
      this.mListViewHolder.d.setText(this.mAdInfo.getAdBriefText());
      return;
      this.mListViewHolder.b.setVisibility(4);
    }
  }
  
  private c buildViewHolder(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null) {}
    for (paramView = (c)localObject;; paramView = this.mListViewHolder)
    {
      return paramView;
      this.mListViewHolder = new c(null);
      this.mListViewHolder.a = ((ImageView)paramView.findViewById(DId.getIdInt(this.mContext, "lsit_logo")));
      this.mListViewHolder.b = ((ImageView)paramView.findViewById(DId.getIdInt(this.mContext, "lsit_logo_new")));
      this.mListViewHolder.c = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "list_name")));
      this.mListViewHolder.d = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "list_describe")));
      this.mListViewHolder.e = ((LinearLayout)paramView.findViewById(DId.getIdInt(this.mContext, "list_download_ll")));
      this.mListViewHolder.f = ((RelativeLayout)paramView.findViewById(DId.getIdInt(this.mContext, "list_actiontype_bg")));
      this.mListViewHolder.g = ((ImageView)paramView.findViewById(DId.getIdInt(this.mContext, "list_actiontype")));
      this.mListViewHolder.h = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "list_action_des")));
      this.mListViewHolder.i = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "list_apksize")));
      this.mListViewHolder.h.setTextColor(Color.parseColor("#E6421C"));
      paramView.setTag(this.mListViewHolder);
    }
  }
  
  private void changeDownloadBarState(int paramInt)
  {
    if (this.mDetailsView != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return;
      this.rl_download_operations.setVisibility(0);
      this.rl_progress_bar.setVisibility(8);
      continue;
      this.rl_progress_bar.setVisibility(0);
      this.rl_download_operations.setVisibility(8);
      continue;
      this.rl_progress_bar.setVisibility(8);
      this.rl_download_operations.setVisibility(0);
      this.iv_download.setVisibility(8);
      this.iv_install.setVisibility(0);
      this.iv_open.setVisibility(8);
      continue;
      this.rl_progress_bar.setVisibility(8);
      this.rl_download_operations.setVisibility(0);
      this.iv_download.setVisibility(8);
      this.iv_install.setVisibility(8);
      this.iv_open.setVisibility(0);
    }
  }
  
  private void clickActionForDetailsLanding()
  {
    this.mDService.onClickDetailsPageButton(this.mAdInfo);
  }
  
  private void clickActionForDetailsLaunch()
  {
    this.mDService.onClickDetailsPageButton(this.mAdInfo);
  }
  
  private void clickActionForDownloadAndUpdate(b paramb)
  {
    int i = this.mDownloadAppInfo.getDownloadStatus();
    switch (i)
    {
    }
    for (;;)
    {
      return;
      mLogger.debugLog("start to download:" + this.mDownloadAppInfo.getAppName() + " status:" + i);
      if (paramb.equals(b.a)) {
        this.mDService.doClickWallItemButtonReport(this.mAdInfo);
      }
      this.dm.addTask(this.mDownloadAppInfo, this.mListenerName, this);
      this.dm.excuteDownload(this.mDownloadAppInfo);
      continue;
      this.dm.excuteResume(this.mDownloadAppInfo);
      continue;
      this.dm.excuteInstall(this.mContext, this.mDownloadAppInfo);
      continue;
      if (this.mAdInfo.getAdActionType().equals(AdInfo.ClickActionType.DOWNLOAD))
      {
        this.dm.excuteOpen(this.mContext, this.mDownloadAppInfo);
      }
      else if (this.mAdInfo.getAdActionType().equals(AdInfo.ClickActionType.UPDATE))
      {
        this.dm.excuteDownload(this.mDownloadAppInfo);
        continue;
        this.dm.excuteDownload(this.mDownloadAppInfo);
      }
    }
  }
  
  private void clickActionForListLanding()
  {
    this.mDService.onClickWallItemButton(this.mAdInfo);
  }
  
  private void clickActionForListLaunch()
  {
    this.mDService.onClickWallItemButton(this.mAdInfo);
  }
  
  private void displayApkSize()
  {
    String str = new DecimalFormat("0.00").format(this.mAdInfo.getAdSize() / 1024.0F / 1024.0F);
    if (this.mListViewHolder != null)
    {
      this.mListViewHolder.i.setText(str + "M");
      this.mListViewHolder.i.setVisibility(0);
    }
  }
  
  private void hideApkSize()
  {
    if (this.mListViewHolder != null) {
      this.mListViewHolder.i.setVisibility(8);
    }
  }
  
  private void notifyStatusChange(Constants.DownloadStatus paramDownloadStatus)
  {
    if (this.downloadListener != null) {
      this.downloadListener.onAppItemDownloadStatusChanged(paramDownloadStatus);
    }
    this.handler.sendEmptyMessage(1);
  }
  
  private void setDetailsActionClickListener()
  {
    if (this.rl_download_operations != null) {
      this.rl_download_operations.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (AppListItem.this.mDetailsDialog != null) {
            AppListItem.this.mDetailsDialog.dismiss();
          }
          AppListItem.this.mDService.doClickDetailsPageButtonReport(AppListItem.this.mAdInfo);
          switch (AppListItem.9.a[AppListItem.this.mAdInfo.getAdActionType().ordinal()])
          {
          }
          for (;;)
          {
            return;
            AppListItem.this.clickActionForDownloadAndUpdate(AppListItem.b.b);
            continue;
            AppListItem.this.clickActionForDetailsLanding();
            continue;
            AppListItem.this.clickActionForDetailsLaunch();
          }
        }
      });
    }
  }
  
  private void setListActionArea(String paramString1, String paramString2)
  {
    if (this.mListViewHolder != null)
    {
      if (paramString1 == null) {
        break label104;
      }
      this.mListViewHolder.f.setVisibility(0);
      this.mListViewHolder.g.setVisibility(0);
      this.mListViewHolder.g.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, paramString1));
    }
    for (;;)
    {
      this.mListViewHolder.h.setText(paramString2);
      if ((this.mControlInfo != null) && (!this.mControlInfo.isButtonShow()))
      {
        this.mListViewHolder.h.setVisibility(8);
        this.mListViewHolder.f.setVisibility(8);
      }
      return;
      label104:
      this.mListViewHolder.f.setVisibility(8);
      this.mListViewHolder.g.setVisibility(8);
    }
  }
  
  private void setListActionClickListener()
  {
    if (this.mListViewHolder != null) {
      this.mListViewHolder.e.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppListItem.mLogger.debugLog("action area clicked");
          switch (AppListItem.9.a[AppListItem.this.mAdInfo.getAdActionType().ordinal()])
          {
          }
          for (;;)
          {
            return;
            AppListItem.this.clickActionForDownloadAndUpdate(AppListItem.b.a);
            continue;
            AppListItem.this.mDService.doClickWallItemButtonReport(AppListItem.this.mAdInfo);
            AppListItem.this.clickActionForListLanding();
            continue;
            AppListItem.this.mDService.doClickWallItemButtonReport(AppListItem.this.mAdInfo);
            AppListItem.this.clickActionForListLaunch();
          }
        }
      });
    }
  }
  
  public View bindBannerViews(View paramView, int paramInt)
  {
    String str = this.mAdInfo.getAdBannerImageURL();
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_home_gallery"), null);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -2));
      this.mBannerViewHolder = new a(null);
      this.mBannerViewHolder.a = ((ImageView)paramView.findViewById(DId.getIdInt(this.mContext, "gallery_image")));
      paramView.setTag(this.mBannerViewHolder);
    }
    for (;;)
    {
      if ((str != null) && (str != ""))
      {
        this.mBannerViewHolder.a.setTag(str);
        this.mDService.requestImage(str, this.mBannerViewHolder.a, new DService.OnImageDownload()
        {
          public void onDownloadFail(String paramAnonymousString, ImageView paramAnonymousImageView)
          {
            AppListItem.mLogger.errorLog("Get img fails" + paramAnonymousString);
          }
          
          public void onDownloadSuc(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
          {
            if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
              paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
            }
          }
        });
      }
      this.mBannerViewHolder.a.setScaleType(ImageView.ScaleType.FIT_XY);
      return paramView;
      this.mBannerViewHolder = ((a)paramView.getTag());
    }
  }
  
  public View bindDetailsView(Dialog paramDialog)
  {
    this.mDetailsDialog = paramDialog;
    buildDetailsCommonView();
    buildDetailsActionArea();
    return this.mDetailsView;
  }
  
  public void bindListViews(View paramView, int paramInt)
  {
    this.mListViewHolder = buildViewHolder(paramView);
    this.mPosition = paramInt;
    this.mAdInfo.setAdActualPosition(this.mPosition);
    mLogger.ptLog("Start binding list view:" + this.mPosition);
    buildListCommonArea();
    buildListActionArea();
    mLogger.ptLog("Finish binding list view:" + this.mPosition);
  }
  
  public AdInfo getAdInfo()
  {
    return this.mAdInfo;
  }
  
  public void onDownloadCancel(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onDownloadCancel:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADCANCEL);
  }
  
  public void onDownloadFailed(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onDownloadFailed:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADFAILED);
    this.handler.sendEmptyMessage(0);
  }
  
  public void onDownloadPause(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onDownloadPause:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADPAUSE);
  }
  
  public void onDownloadResume(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onDownloadResume:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADRESUME);
  }
  
  public void onDownloadStart(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onDownloadStart:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADSTART);
  }
  
  public void onDownloadSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onDownloadSuccess:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADSUCCESS);
  }
  
  public void onDownloadWaiting(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onDownloadWaiting:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADWAITING);
  }
  
  public void onInstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onInstallSuccess:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.INSTALLSUCCESS);
  }
  
  public void onProgressChange(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onProgressChange:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.PROGRESSCHANGE);
  }
  
  public void onUninstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mDownloadAppInfo = paramDownloadAppInfo;
    mLogger.debugLog("onUninstallSuccess:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    notifyStatusChange(Constants.DownloadStatus.UNINSTALLSUCCESS);
  }
  
  public static abstract interface AppItemStatusChangeListener
  {
    public abstract void onAppItemDownloadStatusChanged(Constants.DownloadStatus paramDownloadStatus);
  }
  
  private class a
  {
    ImageView a;
    
    private a() {}
  }
  
  private static enum b
  {
    private b() {}
  }
  
  private class c
  {
    ImageView a;
    ImageView b;
    TextView c;
    TextView d;
    LinearLayout e;
    RelativeLayout f;
    ImageView g;
    TextView h;
    TextView i;
    
    private c() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\AppListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */