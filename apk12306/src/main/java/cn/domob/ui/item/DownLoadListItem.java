package cn.domob.ui.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.dm.download.DownLoadManager;
import cn.dm.download.bean.DownloadAppInfo;
import cn.dm.download.listener.DownloadHelperListener;
import cn.domob.ui.main.Constants.DownloadStatus;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DDrawable;
import cn.domob.ui.utility.DId;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.OnImageDownload;

public class DownLoadListItem
  implements DownloadHelperListener
{
  private static Logger mLogger = new Logger(DownLoadListItem.class.getSimpleName());
  private DownLoadManager dm;
  View.OnClickListener downloadClick = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      switch (DownLoadListItem.this.mDownLoadStatus)
      {
      }
      for (;;)
      {
        return;
        DownLoadListItem.this.dm.excuteDownload(DownLoadListItem.this.mAppInfo);
        continue;
        DownLoadListItem.this.dm.excutePause(DownLoadListItem.this.mAppInfo);
        DownLoadListItem.this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(DownLoadListItem.this.mContext, "u_download_continue_icon"));
        continue;
        DownLoadListItem.this.dm.excuteResume(DownLoadListItem.this.mAppInfo);
        DownLoadListItem.this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(DownLoadListItem.this.mContext, "u_downloading_icon"));
        continue;
        DownLoadListItem.this.dm.excuteInstall(DownLoadListItem.this.mContext, DownLoadListItem.this.mAppInfo);
        continue;
        DownLoadListItem.this.dm.excuteOpen(DownLoadListItem.this.mContext, DownLoadListItem.this.mAppInfo);
      }
    }
  };
  private DownloadAppInfo mAppInfo;
  private Handler mChangeHandler;
  private int mChildPosition;
  private Context mContext;
  private DService mDService;
  private int mDownLoadStatus = 0;
  private int mGroupPosition;
  private a mHolder;
  private DownloadItemStatusChangeListener mListener;
  
  public DownLoadListItem(Context paramContext, DownloadItemStatusChangeListener paramDownloadItemStatusChangeListener, Handler paramHandler, DownloadAppInfo paramDownloadAppInfo, DownLoadManager paramDownLoadManager, DService paramDService)
  {
    this.dm = paramDownLoadManager;
    this.mContext = paramContext;
    this.mDService = paramDService;
    this.mAppInfo = paramDownLoadManager.checkAndGetDownloadAppInfo(paramDownloadAppInfo);
    this.mChangeHandler = paramHandler;
    this.mListener = paramDownloadItemStatusChangeListener;
    this.dm.addTask(paramDownloadAppInfo, getClass().getName(), this);
    mLogger.debugLog("init download list:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
  }
  
  private void bindItemView()
  {
    mLogger.debugLog("bindDownloadViewsForDownload:" + this.mAppInfo.getAppName() + ", status:" + this.mAppInfo.getDownloadStatus());
    switch (this.mAppInfo.getDownloadStatus())
    {
    }
    for (;;)
    {
      return;
      this.mDownLoadStatus = 0;
      this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_list_download"));
      this.mHolder.i.setText("下载");
      continue;
      this.mDownLoadStatus = 1;
      this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_list_download"));
      this.mHolder.i.setText("等待中");
      this.mHolder.d.setProgress(getProgressBar(this.mAppInfo));
      continue;
      this.mDownLoadStatus = 2;
      String str = setProgressByte(this.mAppInfo.getCurrentDownloadSize()) + "/";
      mLogger.debugLog("progress:" + str);
      this.mHolder.e.setText(str);
      this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_downloading_icon"));
      this.mHolder.i.setText(getProgressBar(this.mAppInfo) + "%");
      this.mHolder.d.setProgress(getProgressBar(this.mAppInfo));
      continue;
      this.mDownLoadStatus = 3;
      this.mHolder.i.setText("继续");
      this.mHolder.d.setProgress(getProgressBar(this.mAppInfo));
      this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_download_continue_icon"));
      continue;
      this.mDownLoadStatus = 4;
      this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_list_install"));
      this.mHolder.d.setProgress(100);
      this.mHolder.e.setText(setProgressByte(this.mAppInfo.getAppSize()) + "/");
      this.mHolder.i.setText("安装");
      this.mHolder.i.setTextColor(Color.parseColor("#E6421C"));
      continue;
      this.mDownLoadStatus = 5;
      this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_list_open"));
      this.mHolder.i.setText("打开");
      this.mHolder.i.setTextColor(Color.parseColor("#E6421C"));
      continue;
      this.mDownLoadStatus = 6;
      this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_list_download"));
      this.mHolder.i.setText("升级");
      continue;
      this.mDownLoadStatus = 7;
      continue;
      this.mDownLoadStatus = 3;
      this.mHolder.i.setText("继续");
      this.mHolder.d.setProgress(getProgressBar(this.mAppInfo));
      this.mHolder.h.setBackgroundResource(DDrawable.getDrawableInt(this.mContext, "u_download_continue_icon"));
    }
  }
  
  private void bindViewsForAPK()
  {
    if (this.mAppInfo != null)
    {
      this.mHolder.c.setText(this.mAppInfo.getAppName());
      this.mHolder.f.setText(setProgressByte(this.mAppInfo.getAppSize()));
      switch (this.mAppInfo.getDownloadStatus())
      {
      default: 
        this.mHolder.e.setVisibility(0);
        this.mHolder.d.setVisibility(0);
        this.mHolder.e.setText(setProgressByte(this.mAppInfo.getCurrentDownloadSize()) + "/");
      }
    }
    for (;;)
    {
      bindItemView();
      return;
      this.mHolder.e.setVisibility(8);
      this.mHolder.d.setVisibility(8);
    }
  }
  
  private int getProgressBar(DownloadAppInfo paramDownloadAppInfo)
  {
    int i = 0;
    if (paramDownloadAppInfo != null) {
      i = (int)((float)paramDownloadAppInfo.getCurrentDownloadSize() / (float)paramDownloadAppInfo.getAppSize() * 100.0F);
    }
    return i;
  }
  
  private void notifyStatusChange(Constants.DownloadStatus paramDownloadStatus)
  {
    if (this.mListener != null) {
      this.mListener.onDMItemDownloadStatusChanged(paramDownloadStatus);
    }
  }
  
  private String setProgressByte(long paramLong)
  {
    String str = "";
    float f2 = (float)paramLong;
    float f1 = f2;
    if (f2 > 1024.0F)
    {
      f1 = f2 / 1024.0F;
      str = "KB";
    }
    f2 = f1;
    if (f1 > 1024.0F)
    {
      f2 = f1 / 1024.0F;
      str = "M";
    }
    return String.format("%.2f", new Object[] { Float.valueOf(f2) }) + str;
  }
  
  private a setupViewHolder(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null) {}
    for (paramView = (a)localObject;; paramView = (View)localObject)
    {
      return paramView;
      localObject = new a();
      ((a)localObject).a = ((RelativeLayout)paramView.findViewById(DId.getIdInt(this.mContext, "download_list_item_rl_download")));
      ((a)localObject).b = ((ImageView)paramView.findViewById(DId.getIdInt(this.mContext, "iv_logo")));
      ((a)localObject).c = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_app_name")));
      ((a)localObject).g = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_download_time")));
      ((a)localObject).d = ((ProgressBar)paramView.findViewById(DId.getIdInt(this.mContext, "pb_progress")));
      ((a)localObject).f = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_app_size")));
      ((a)localObject).e = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_current_progress")));
      ((a)localObject).f = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_app_size")));
      ((a)localObject).h = ((ImageView)paramView.findViewById(DId.getIdInt(this.mContext, "iv_download_state")));
      ((a)localObject).i = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_state")));
      ((a)localObject).j = ((TextView)paramView.findViewById(DId.getIdInt(this.mContext, "tv_delete")));
      paramView.setTag(localObject);
    }
  }
  
  public void bindViews(View paramView, int paramInt1, int paramInt2)
  {
    this.mGroupPosition = paramInt1;
    this.mChildPosition = paramInt2;
    this.mHolder = setupViewHolder(paramView);
    bindViewsForAPK();
    this.mHolder.b.setImageResource(DDrawable.getDrawableInt(this.mContext, "u_list_logo"));
    this.mHolder.b.setTag(this.mAppInfo.getLogoUrl());
    this.mDService.requestImage(this.mAppInfo.getLogoUrl(), this.mHolder.b, new DService.OnImageDownload()
    {
      public void onDownloadFail(String paramAnonymousString, ImageView paramAnonymousImageView)
      {
        DownLoadListItem.mLogger.errorLog("Get img fails:" + paramAnonymousString);
      }
      
      public void onDownloadSuc(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
      {
        if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
          paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
        }
      }
    });
    this.mHolder.a.setOnClickListener(this.downloadClick);
  }
  
  public DownloadAppInfo getDownloadAppInfo()
  {
    return this.mAppInfo;
  }
  
  public void onDownloadCancel(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onDownloadCancel:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADCANCEL);
  }
  
  public void onDownloadFailed(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onDownloadFailed:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADFAILED);
  }
  
  public void onDownloadPause(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onDownloadPause:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADPAUSE);
  }
  
  public void onDownloadResume(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onDownloadResume:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADRESUME);
  }
  
  public void onDownloadStart(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onDownloadStart:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADSTART);
  }
  
  public void onDownloadSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onDownloadSuccess:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADSUCCESS);
  }
  
  public void onDownloadWaiting(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onDownloadWaiting:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.DOWNLOADWAITING);
  }
  
  public void onInstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onInstallSuccess:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    Bundle localBundle = new Bundle();
    localBundle.putInt("groupPosition", this.mGroupPosition);
    localBundle.putInt("childPosition", this.mChildPosition);
    localBundle.putSerializable("downloadappinfo", paramDownloadAppInfo);
    paramDownloadAppInfo = new Message();
    paramDownloadAppInfo.what = 1;
    paramDownloadAppInfo.setData(localBundle);
    if (this.mChangeHandler != null) {
      this.mChangeHandler.sendMessage(paramDownloadAppInfo);
    }
  }
  
  public void onProgressChange(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onProgressChange:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.PROGRESSCHANGE);
  }
  
  public void onUninstallSuccess(DownloadAppInfo paramDownloadAppInfo)
  {
    mLogger.debugLog("onUninstallSuccess:" + paramDownloadAppInfo.getAppName() + ":" + paramDownloadAppInfo.getDownloadStatus());
    this.mAppInfo = paramDownloadAppInfo;
    notifyStatusChange(Constants.DownloadStatus.UNINSTALLSUCCESS);
  }
  
  public static abstract interface DownloadItemStatusChangeListener
  {
    public abstract void onDMItemDownloadStatusChanged(Constants.DownloadStatus paramDownloadStatus);
  }
  
  static class a
  {
    RelativeLayout a;
    ImageView b;
    TextView c;
    ProgressBar d;
    TextView e;
    TextView f;
    TextView g;
    ImageView h;
    TextView i;
    TextView j;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\DownLoadListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */