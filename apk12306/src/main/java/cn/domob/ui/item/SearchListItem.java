package cn.domob.ui.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.dm.download.DownLoadManager;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadHelperListener;
import cn.domob.ui.main.Constants.DownloadStatus;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DColor;
import cn.domob.ui.utility.DDrawable;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DString;
import cn.domob.ui.utility.DUtil;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.OnImageDownload;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.AdInfo.ClickActionType;
import cn.domob.wall.core.bean.ControlInfo;
import java.text.DecimalFormat;

public class SearchListItem
  implements DownloadHelperListener
{
  private static Logger mLogger = new Logger(SearchListItem.class.getSimpleName());
  private DownLoadManager dm;
  View.OnClickListener downloadClick = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      switch (SearchListItem.this.mDownLoadStatus)
      {
      default: 
        SearchListItem.this.mAdInfo.setAdActualPosition(SearchListItem.this.mPosition);
        SearchListItem.this.mDService.doClickWallItemReport(SearchListItem.this.mAdInfo);
      }
      for (;;)
      {
        return;
        if ((SearchListItem.this.mAdInfo.isDownloadAd()) && (("DOWNLOAD".equals(SearchListItem.this.mAdInfo.getAdActionType().name())) || ("UPDATE".equals(SearchListItem.this.mAdInfo.getAdActionType().name())))) {
          SearchListItem.this.dm.excuteDownload(SearchListItem.this.mAppInfo);
        }
        SearchListItem.this.mAdInfo.setAdActualPosition(SearchListItem.this.mPosition);
        SearchListItem.this.mDService.doClickWallItemReport(SearchListItem.this.mAdInfo);
        continue;
        SearchListItem.this.dm.excuteResume(SearchListItem.this.mAppInfo);
        continue;
        SearchListItem.this.dm.excuteInstall(SearchListItem.this.mContext, SearchListItem.this.mAppInfo);
        continue;
        SearchListItem.this.dm.excuteOpen(SearchListItem.this.mContext, SearchListItem.this.mAppInfo);
        continue;
        SearchListItem.this.dm.excuteDownload(SearchListItem.this.mAppInfo);
      }
    }
  };
  private Handler errorHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Toast.makeText(SearchListItem.this.mContext, DString.getStringInt(SearchListItem.this.mContext, "download_failed"), 0).show();
    }
  };
  private AdInfo mAdInfo;
  private DownloadAppInfo mAppInfo;
  private Context mContext;
  private ControlInfo mControlInfo;
  private DService mDService;
  private int mDownLoadStatus = 0;
  private SearchItemStatusChangeListener mDownloadStatusChangeListener;
  private int mPosition;
  private int mProgress = 0;
  private a mViewHolder;
  
  public SearchListItem(Context paramContext, SearchItemStatusChangeListener paramSearchItemStatusChangeListener, AdInfo paramAdInfo, DService paramDService, DownLoadManager paramDownLoadManager, ControlInfo paramControlInfo)
  {
    this.mDownloadStatusChangeListener = paramSearchItemStatusChangeListener;
    this.dm = paramDownLoadManager;
    this.mContext = paramContext;
    this.mAdInfo = paramAdInfo;
    this.mAppInfo = this.dm.checkAndGetDownloadAppInfo(DUtil.buildDownLoadAppInfo(paramAdInfo));
    this.dm.addTask(this.mAppInfo, SearchListItem.class.getName(), this);
    this.mDService = paramDService;
    this.mControlInfo = paramControlInfo;
  }
  
  private void bindViewsForAPK(a parama, int paramInt)
  {
    if (this.mAppInfo != null)
    {
      parama.d.setOnClickListener(this.downloadClick);
      parama.b.setText(this.mAdInfo.getAdTitle());
      parama.h.setText(this.mAdInfo.getAdVersionName());
      parama.a.setImageResource(DDrawable.getDrawableInt(this.mContext, "u_list_logo"));
      parama.a.setTag(this.mAdInfo.getAdLogoURL());
      this.mDService.requestImage(this.mAdInfo.getAdLogoURL(), parama.a, new DService.OnImageDownload()
      {
        public void onDownloadFail(String paramAnonymousString, ImageView paramAnonymousImageView)
        {
          SearchListItem.mLogger.errorLog("Get img fails:" + paramAnonymousString);
        }
        
        public void onDownloadSuc(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
        {
          if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
            paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
          }
        }
      });
      if (this.mControlInfo.isButtonShow()) {
        break label135;
      }
      this.mViewHolder.e.setVisibility(4);
      this.mViewHolder.g.setVisibility(4);
    }
    for (;;)
    {
      return;
      label135:
      Object localObject = this.mAdInfo.getAdActionType();
      if (((AdInfo.ClickActionType)localObject).equals(AdInfo.ClickActionType.DOWNLOAD))
      {
        bindViewsForDownload(parama, (AdInfo.ClickActionType)localObject);
        localObject = new DecimalFormat("0.00").format(this.mAdInfo.getAdSize() / 1024.0F / 1024.0F);
        parama.c.setText((String)localObject + "M");
      }
      else if (((AdInfo.ClickActionType)localObject).equals(AdInfo.ClickActionType.UPDATE))
      {
        bindViewsForDownload(parama, (AdInfo.ClickActionType)localObject);
        localObject = new DecimalFormat("0.00").format(this.mAdInfo.getAdSize() / 1024.0F / 1024.0F);
        parama.c.setText((String)localObject + "M");
      }
      else if (((AdInfo.ClickActionType)localObject).equals(AdInfo.ClickActionType.INTERNAL_BROWSER))
      {
        pullData(parama, "u_list_browser", "查看详情", "", 4);
      }
      else if (((AdInfo.ClickActionType)localObject).equals(AdInfo.ClickActionType.EXTERNAL_BROWSER))
      {
        pullData(parama, "u_list_browser", "查看详情", "", 4);
      }
      else if (((AdInfo.ClickActionType)localObject).equals("LAUNCH"))
      {
        parama.c.setVisibility(4);
      }
    }
  }
  
  private void bindViewsForDownload(a parama, AdInfo.ClickActionType paramClickActionType)
  {
    if (this.mAppInfo != null) {
      switch (this.mAppInfo.getDownloadStatus())
      {
      }
    }
    for (;;)
    {
      return;
      this.mDownLoadStatus = 0;
      if ((paramClickActionType.equals(AdInfo.ClickActionType.UPDATE)) && (this.mControlInfo.isShowUpdate())) {}
      for (paramClickActionType = "升级";; paramClickActionType = "免费下载")
      {
        pullData(parama, "u_list_download", paramClickActionType, "", 0);
        break;
      }
      this.mDownLoadStatus = 1;
      parama.f.setVisibility(8);
      parama.e.setVisibility(8);
      parama.g.setText("等待中");
      parama.g.setTextColor(DColor.getColorInt(this.mContext, "list_download"));
      parama.c.setVisibility(0);
      continue;
      this.mDownLoadStatus = 2;
      parama.f.setVisibility(8);
      parama.e.setVisibility(8);
      this.mProgress = ((int)((float)this.mAppInfo.getCurrentDownloadSize() / (float)this.mAppInfo.getAppSize() * 100.0F));
      parama.g.setText(this.mProgress + "%");
      parama.g.setTextColor(DColor.getColorInt(this.mContext, "list_download"));
      parama.c.setVisibility(0);
      continue;
      this.mDownLoadStatus = 3;
      parama.f.setVisibility(8);
      parama.e.setVisibility(8);
      parama.g.setText("继续");
      parama.g.setTextColor(DColor.getColorInt(this.mContext, "list_download"));
      parama.c.setVisibility(0);
      continue;
      this.mDownLoadStatus = 4;
      pullData(parama, "u_list_install", "安装", "", 0);
      continue;
      this.mDownLoadStatus = 5;
      pullData(parama, "u_list_open", "打开", "", 0);
      continue;
      this.mDownLoadStatus = 6;
      pullData(parama, "u_list_download", "升级", "", 0);
      continue;
      this.mDownLoadStatus = 3;
      parama.f.setVisibility(8);
      parama.e.setVisibility(8);
      parama.g.setText("继续");
      parama.g.setTextColor(DColor.getColorInt(this.mContext, "list_download"));
      parama.c.setVisibility(0);
    }
  }
  
  private void notifyStatusChange(Constants.DownloadStatus paramDownloadStatus)
  {
    if (this.mDownloadStatusChangeListener != null) {
      this.mDownloadStatusChangeListener.onSearchItemDownloadStatusChanged(paramDownloadStatus);
    }
  }
  
  private void pullData(a parama, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    parama.e.setVisibility(0);
    parama.f.setVisibility(0);
    parama.f.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, paramString1));
    parama.g.setText(paramString2);
    parama.g.setTextColor(Color.parseColor("#E6421C"));
    parama.c.setVisibility(paramInt);
  }
  
  private a setupViewHolder(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null) {}
    for (paramView = (a)localObject;; paramView = this.mViewHolder)
    {
      return paramView;
      this.mViewHolder = new a(null);
      this.mViewHolder.a = ((ImageView)paramView.findViewById(DId.getIdInt(this.mContext, "iv_app_logo")));
      this.mViewHolder.b = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_app_name")));
      this.mViewHolder.c = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_app_size")));
      this.mViewHolder.h = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_app_version")));
      this.mViewHolder.d = ((LinearLayout)paramView.findViewById(DId.getIdInt(this.mContext, "list_download_ll")));
      this.mViewHolder.e = ((RelativeLayout)paramView.findViewById(DId.getIdInt(this.mContext, "list_actiontype_bg")));
      this.mViewHolder.f = ((ImageView)paramView.findViewById(DId.getIdInt(this.mContext, "list_actiontype")));
      this.mViewHolder.g = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "list_action_des")));
      paramView.setTag(this.mViewHolder);
    }
  }
  
  public void bindViews(View paramView, int paramInt)
  {
    this.mPosition = paramInt;
    this.mViewHolder = setupViewHolder(paramView);
    bindViewsForAPK(this.mViewHolder, paramInt);
  }
  
  public DownloadAppInfo getDownloadAppInfo()
  {
    return this.mAppInfo;
  }
  
  public AdInfo getmAdInfo()
  {
    return this.mAdInfo;
  }
  
  public void onDownloadCancel(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADCANCEL);
  }
  
  public void onDownloadFailed(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    this.errorHandler.sendEmptyMessage(0);
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADFAILED);
  }
  
  public void onDownloadPause(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADPAUSE);
  }
  
  public void onDownloadResume(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADRESUME);
  }
  
  public void onDownloadStart(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADSTART);
  }
  
  public void onDownloadSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADSUCCESS);
  }
  
  public void onDownloadWaiting(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADWAITING);
  }
  
  public void onInstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.INSTALLSUCCESS);
  }
  
  public void onProgressChange(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.PROGRESSCHANGE);
  }
  
  public void onUninstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.UNINSTALLSUCCESS);
  }
  
  public static abstract interface SearchItemStatusChangeListener
  {
    public abstract void onSearchItemDownloadStatusChanged(Constants.DownloadStatus paramDownloadStatus);
  }
  
  private class a
  {
    ImageView a;
    TextView b;
    TextView c;
    LinearLayout d;
    RelativeLayout e;
    ImageView f;
    TextView g;
    TextView h;
    
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\SearchListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */