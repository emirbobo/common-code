package cn.domob.ui.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import cn.dm.download.DownLoadManager;
import cn.domob.ui.utility.DLayout;
import cn.domob.ui.utility.DRes;
import cn.domob.ui.view.DownloadView;
import cn.domob.ui.view.HandleView;
import cn.domob.ui.view.SearchView;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.EWallReportType;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReportUserActionType;
import cn.domob.wall.core.bean.ControlInfo;

public class DViewManager
  implements DViewAdModel.AdDataListener, Home.HomeViewListener
{
  private static final int CENTER = 1;
  private static final int CENTER_VERTICAL = 0;
  private static final int FETCH_AD_FAILED = 1;
  private static final int FETCH_AD_SUCCESS = 0;
  private static final String HANDLEURL = "mHandleUrl";
  private static final String LAST_REQUEST_NET_TIME = "lastRequestNetTime";
  private static final String MTIMEOUT = "mTimeout";
  private static Logger mLogger = new Logger(DViewManager.class.getSimpleName());
  private AdResp adResp;
  private Context context;
  private DViewAdModel dViewAdModel;
  private View handleView;
  private a handler;
  private Home home;
  private View homeView;
  private boolean isDataReady = false;
  private DService mDService;
  private GetDataListener mGetDataListener;
  private ViewGroup mHandleView = null;
  private ViewGroup mHandleViewGroup = null;
  private Dialog mHomeDialog;
  private SharedPreferences sp;
  
  public DViewManager(Context paramContext, DService paramDService)
  {
    this.mDService = paramDService;
    this.context = paramContext;
    this.adResp = new AdResp();
    this.dViewAdModel = new DViewAdModel(this.mDService);
    this.dViewAdModel.setReceiveAdDataListener(this);
    this.handler = new a();
    this.sp = this.context.getSharedPreferences("domob", 0);
    initView();
  }
  
  public DViewManager(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, new DService(paramContext, paramString1, paramString2));
  }
  
  private RelativeLayout.LayoutParams getHandleViewLayoutParams(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localLayoutParams;
      localLayoutParams.addRule(15, -1);
      localLayoutParams.addRule(14, -1);
      continue;
      localLayoutParams.addRule(15, -1);
      localLayoutParams.addRule(9, -1);
    }
  }
  
  private void initHomeDialogView()
  {
    this.mHomeDialog = new Dialog(this.context, 16973840);
    this.mHomeDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        DViewManager.mLogger.debugLog("dialogView onDismiss");
        DViewManager.mLogger.debugLog("推广墙关闭");
        DViewManager.this.mDService.doUserActionReport(DService.ReportUserActionType.EXIT);
        if (DViewManager.this.mGetDataListener != null)
        {
          DViewManager.this.mGetDataListener.onCloseWall();
          DViewManager.mLogger.debugLog("onCloseWall");
        }
      }
    });
  }
  
  private void initView()
  {
    this.home = new Home(this.context, this.mDService);
    mLogger.debugLog("initHomeView: " + this.home.toString());
    this.home.setHomeViewListener(this);
    this.homeView = this.home.getHomeView();
    initHomeDialogView();
  }
  
  private boolean isDataExpired()
  {
    boolean bool = true;
    long l1 = System.currentTimeMillis();
    long l3 = this.sp.getLong("mTimeout", 86400000L);
    long l2 = this.sp.getLong("lastRequestNetTime", 0L);
    mLogger.debugLog(String.format("current:%d lastRequest:%d timeout:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) }));
    if ((l3 != 0L) && (l1 - l2 >= l3)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void loadData()
  {
    SharedPreferences.Editor localEditor = this.sp.edit();
    localEditor.putLong("lastRequestNetTime", System.currentTimeMillis());
    localEditor.commit();
    this.home.showProgressBar();
    mLogger.ptLog("Start to fetch data");
    this.dViewAdModel.requestAdData();
  }
  
  private void showDownloadDialog()
  {
    ((Activity)this.context).runOnUiThread(new Runnable()
    {
      private Dialog b;
      private DownloadView c;
      
      public void run()
      {
        if (((Activity)DViewManager.this.context).isFinishing()) {}
        for (;;)
        {
          return;
          this.b = new Dialog(DViewManager.this.context, DRes.initGetRes(DViewManager.this.context).getStyle("Dialog_Fullscreen"));
          this.c = new DownloadView(DViewManager.this.context, DViewManager.this.mDService, this.b, DViewManager.this.adResp.getControlInfo(), DViewManager.this.home.getDownloadManager());
          View localView = this.c.getDownloadView();
          if (localView != null)
          {
            this.b.setContentView(localView);
            this.b.show();
          }
          this.b.setOnDismissListener(new DialogInterface.OnDismissListener()
          {
            public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
            {
              DViewManager.this.home.refreshDownloadingCount();
            }
          });
        }
      }
    });
  }
  
  private void showHandleView()
  {
    ((Activity)this.context).runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (DViewManager.this.handleView == null)
        {
          String str = DViewManager.this.sp.getString("mHandleUrl", "");
          DViewManager.mLogger.debugLog("handlerUrl:" + str);
          DViewManager.access$002(DViewManager.this, new HandleView(DViewManager.this.context, DViewManager.this.mDService, str).initHandleView());
        }
        if ((DViewManager.this.mHandleView != null) && (DViewManager.this.handleView.getParent() == null)) {
          DViewManager.this.mHandleView.addView(DViewManager.this.handleView);
        }
        for (;;)
        {
          DViewManager.this.handleView.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              DViewManager.mLogger.debugLog("点击把手");
              DViewManager.this.showWall();
            }
          });
          return;
          if ((DViewManager.this.mHandleViewGroup != null) && (DViewManager.this.handleView.getParent() == null)) {
            DViewManager.this.mHandleViewGroup.addView(DViewManager.this.handleView, DViewManager.this.getHandleViewLayoutParams(0));
          }
        }
      }
    });
  }
  
  private void showSearchDialog()
  {
    ((Activity)this.context).runOnUiThread(new Runnable()
    {
      private SearchView b;
      private Dialog c;
      
      public void run()
      {
        if (((Activity)DViewManager.this.context).isFinishing()) {}
        for (;;)
        {
          return;
          this.c = new Dialog(DViewManager.this.context, DRes.initGetRes(DViewManager.this.context).getStyle("Dialog_Fullscreen"));
          this.b = new SearchView(DViewManager.this.context, DViewManager.this.mDService, this.c, DViewManager.this.adResp.getControlInfo(), DViewManager.this.home.getDownloadManager());
          View localView = this.b.getSearchView();
          if (localView != null)
          {
            this.c.setContentView(localView);
            this.c.show();
          }
        }
      }
    });
  }
  
  public void addView(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    mLogger.debugLog("Start to add handle view");
    if ((DLayout.getLayoutInt(this.context, "l_handle") == -1) || (DLayout.getLayoutInt(this.context, "l_home") == -1)) {
      mLogger.debugLog("尊敬的开发者：", "请参照文档添加res下资源");
    }
    for (;;)
    {
      return;
      this.mHandleViewGroup = paramViewGroup1;
      this.mHandleView = paramViewGroup2;
      showHandleView();
    }
  }
  
  public void onBackButtonClicked()
  {
    mLogger.debugLog("backButtonClicked");
    if (this.mHomeDialog != null) {
      this.mHomeDialog.dismiss();
    }
  }
  
  public void onDownloadToolButtonClicked()
  {
    mLogger.debugLog("downloader clicked");
    showDownloadDialog();
  }
  
  public void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString)
  {
    this.home.getDownloadManager().clearTask();
    mLogger.errorLog("Fail to receive ad data");
    this.isDataReady = false;
    if (this.mGetDataListener != null) {
      this.mGetDataListener.onFailReceiveData(paramErrorCode, paramString);
    }
    this.handler.sendEmptyMessage(1);
  }
  
  public void onRefreshButtonClicked()
  {
    mLogger.debugLog("refreshButtonClicked");
    loadData();
  }
  
  public void onSearchButtonClicked()
  {
    mLogger.debugLog("searchButtonClicked");
    showSearchDialog();
  }
  
  public void onSuccessReceiveData(AdResp paramAdResp)
  {
    this.home.getDownloadManager().clearTask();
    mLogger.debugLog("Receive ad data");
    this.adResp = paramAdResp;
    this.isDataReady = true;
    SharedPreferences.Editor localEditor = this.sp.edit();
    localEditor.putLong("mTimeout", paramAdResp.getControlInfo().getTimeout());
    localEditor.commit();
    if ((paramAdResp.getControlInfo().isChangeEnterPic()) && (paramAdResp.getControlInfo().getEnterPicURL() != null))
    {
      localEditor.putString("mHandleUrl", paramAdResp.getControlInfo().getEnterPicURL());
      localEditor.commit();
    }
    for (;;)
    {
      if (this.mGetDataListener != null) {
        this.mGetDataListener.onSuccessReceiveData(paramAdResp.getControlInfo().getNumberOfNewAd());
      }
      mLogger.ptLog("Fetch data finish");
      this.handler.sendEmptyMessage(0);
      return;
      localEditor.putString("mHandleUrl", "");
      localEditor.commit();
    }
  }
  
  public void preLoad()
  {
    mLogger.debugLog("Start to preLoad");
    loadData();
  }
  
  public void setAddViewListener(GetDataListener paramGetDataListener)
  {
    this.mGetDataListener = paramGetDataListener;
  }
  
  public void showWall()
  {
    mLogger.debugLog("Start to show wall");
    this.mHomeDialog.setContentView(this.homeView);
    this.mHomeDialog.show();
    this.mDService.doUserActionReport(DService.ReportUserActionType.ENTRY);
    if (this.home.isShowEWallEntry())
    {
      mLogger.debugLog("Send report: E_ENTRY_SHOW");
      this.mDService.doEWallReport(DService.EWallReportType.E_ENTRY_SHOW);
    }
    if ((!this.isDataReady) || (isDataExpired()))
    {
      mLogger.debugLog("Need to request new data");
      loadData();
    }
    for (;;)
    {
      return;
      mLogger.debugLog("Data is ready and not expired");
    }
  }
  
  public static abstract interface GetDataListener
  {
    public abstract void onCloseWall();
    
    public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void onSuccessReceiveData(int paramInt);
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        DViewManager.this.home.refreshAd(DViewManager.this.adResp);
        continue;
        DViewManager.this.home.showErrorMSG("网络链接错误，点击看看");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */