package cn.domob.ui.view;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.dm.download.DownLoadManager;
import cn.dm.download.bean.DownloadAppInfo;
import cn.domob.ui.adapter.DownloadManagerListAdapter;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.item.AppListItem.AppItemStatusChangeListener;
import cn.domob.ui.item.DownLoadListItem;
import cn.domob.ui.item.DownLoadListItem.DownloadItemStatusChangeListener;
import cn.domob.ui.main.Constants.DownloadStatus;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DLayout;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveDetailsDataListener;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DownloadView
  implements AppListItem.AppItemStatusChangeListener, DownLoadListItem.DownloadItemStatusChangeListener
{
  public static final int DM_INSTALLSUCCESS = 1;
  public static final int DM_REFRESHLIST = 0;
  private static final String DownloadType1 = "下载中";
  private static final String DownloadType2 = "已下载";
  public static final int Downloaded = 2;
  public static final int Downloading = 1;
  private static Logger mLogger = new Logger(DownloadView.class.getSimpleName());
  private DownloadManagerListAdapter adapter;
  private List<DownloadAppInfo> appInfoList;
  private ArrayList<List<DownLoadListItem>> childList;
  int[] childPos2D = new int[0];
  private List<DownLoadListItem> downloadedItemList;
  private List<DownLoadListItem> downloadingItemList;
  private ArrayList<String> groupList;
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
        DownloadView.this.adapter.notifyDataSetChanged();
        continue;
        paramAnonymousMessage = paramAnonymousMessage.getData();
        int i = paramAnonymousMessage.getInt("groupPosition");
        int j = paramAnonymousMessage.getInt("childPosition");
        if ((DownloadView.this.childList.size() != 0) && (((List)DownloadView.this.childList.get(i)).size() != 0)) {
          ((List)DownloadView.this.childList.get(i)).remove(j);
        }
        DownloadView.this.adapter.notifyDataSetChanged();
      }
    }
  };
  private String listenerName = "DMItem";
  private Context mContext;
  private ControlInfo mControlInfo;
  private DService mDService;
  private Dialog mDialog;
  private DownLoadManager mDownLoadManager;
  View viewStub;
  private Map<int[], View> viewStubMap = new HashMap();
  View vsOperations;
  
  public DownloadView(Context paramContext, DService paramDService, Dialog paramDialog, ControlInfo paramControlInfo, DownLoadManager paramDownLoadManager)
  {
    this.mContext = paramContext;
    this.mDService = paramDService;
    this.mDialog = paramDialog;
    this.mDownLoadManager = paramDownLoadManager;
    this.appInfoList = this.mDownLoadManager.initAllDownloadAppInfoList();
    this.mControlInfo = paramControlInfo;
  }
  
  private boolean arrayEquals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
      bool1 = bool2;
    }
    label50:
    for (;;)
    {
      return bool1;
      int i = 0;
      bool1 = false;
      for (;;)
      {
        if (i >= paramArrayOfInt1.length) {
          break label50;
        }
        bool1 = bool2;
        if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
          break;
        }
        bool1 = true;
        i++;
      }
    }
  }
  
  private void initGrop(List<DownloadAppInfo> paramList)
  {
    this.groupList = new ArrayList();
    this.childList = new ArrayList();
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.downloadingItemList = new ArrayList();
      this.downloadedItemList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (DownloadAppInfo)localIterator.next();
        if (5 != paramList.getDownloadStatus()) {
          switch (paramList.getDownloadStatus())
          {
          default: 
            this.downloadingItemList.add(new DownLoadListItem(this.mContext, this, this.handler, paramList, this.mDownLoadManager, this.mDService));
            break;
          case 4: 
            this.downloadedItemList.add(new DownLoadListItem(this.mContext, this, this.handler, paramList, this.mDownLoadManager, this.mDService));
            break;
          case 5: 
            this.downloadedItemList.add(new DownLoadListItem(this.mContext, this, this.handler, paramList, this.mDownLoadManager, this.mDService));
          }
        }
      }
      if ((this.downloadingItemList.size() > 0) && (this.downloadedItemList.size() > 0))
      {
        this.groupList.add("下载中");
        this.groupList.add("已下载");
        this.childList.add(this.downloadingItemList);
        this.childList.add(this.downloadedItemList);
      }
    }
    for (;;)
    {
      return;
      if ((this.downloadingItemList.size() == 0) && (this.downloadedItemList.size() > 0))
      {
        this.groupList.add("已下载");
        this.childList.add(this.downloadedItemList);
      }
      else if ((this.downloadingItemList.size() > 0) && (this.downloadedItemList.size() == 0))
      {
        this.childList.add(this.downloadingItemList);
        this.groupList.add("下载中");
        continue;
        mLogger.debugLog("***************", "无下载");
      }
    }
  }
  
  public View getDownloadView()
  {
    initGrop(this.appInfoList);
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_download_main"), null);
    ((RelativeLayout)localLinearLayout.findViewById(DId.getIdInt(this.mContext, "rl_back"))).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DownloadView.this.mDialog.dismiss();
      }
    });
    ExpandableListView localExpandableListView = (ExpandableListView)localLinearLayout.findViewById(DId.getIdInt(this.mContext, "expandableListView"));
    localExpandableListView.setEmptyView((TextView)localLinearLayout.findViewById(DId.getIdInt(this.mContext, "tv_empty")));
    this.adapter = new DownloadManagerListAdapter(this.mContext, this.mDService, this.groupList, this.childList, this.viewStubMap);
    localExpandableListView.setAdapter(this.adapter);
    int j = localExpandableListView.getCount();
    for (int i = 0; i < j; i++) {
      localExpandableListView.expandGroup(i);
    }
    localExpandableListView.setGroupIndicator(null);
    localExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      public boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        return true;
      }
    });
    localExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
    {
      private RelativeLayout b;
      private RelativeLayout c;
      
      public boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        DownloadView.mLogger.debugLog("onChildClick: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        DownloadView.this.viewStub = null;
        DownloadView.this.vsOperations = paramAnonymousView.findViewById(DId.getIdInt(DownloadView.this.mContext, "ll_sliding_menu"));
        paramAnonymousView = new int[2];
        paramAnonymousView[0] = paramAnonymousInt1;
        paramAnonymousView[1] = paramAnonymousInt2;
        paramAnonymousExpandableListView = new int[2];
        paramAnonymousExpandableListView[0] = paramAnonymousInt1;
        paramAnonymousExpandableListView[1] = paramAnonymousInt2;
        DownloadView.a locala = new DownloadView.a(DownloadView.this, paramAnonymousInt1, paramAnonymousInt2);
        if (DownloadView.this.viewStubMap.size() == 0) {
          if (DownloadView.this.vsOperations.getVisibility() == 8)
          {
            DownloadView.this.vsOperations.setVisibility(0);
            this.b = ((RelativeLayout)DownloadView.this.vsOperations.findViewById(DId.getIdInt(DownloadView.this.mContext, "rl_menu_delete")));
            this.c = ((RelativeLayout)DownloadView.this.vsOperations.findViewById(DId.getIdInt(DownloadView.this.mContext, "rl_menu_detail")));
            this.b.setOnClickListener(locala);
            this.c.setOnClickListener(locala);
            DownloadView.this.viewStubMap.put(paramAnonymousView, DownloadView.this.vsOperations);
          }
        }
        for (;;)
        {
          return false;
          DownloadView.this.vsOperations.setVisibility(8);
          continue;
          Iterator localIterator = DownloadView.this.viewStubMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            paramAnonymousExpandableListView = (int[])localEntry.getKey();
            DownloadView.this.viewStub = ((View)localEntry.getValue());
          }
          if (DownloadView.this.arrayEquals(paramAnonymousExpandableListView, paramAnonymousView))
          {
            if (DownloadView.this.viewStub.getVisibility() == 8) {
              DownloadView.this.viewStub.setVisibility(0);
            } else {
              DownloadView.this.viewStub.setVisibility(8);
            }
          }
          else
          {
            DownloadView.this.viewStub.setVisibility(8);
            DownloadView.this.viewStubMap.clear();
            if (DownloadView.this.vsOperations.getVisibility() == 8)
            {
              DownloadView.this.vsOperations.setVisibility(0);
              this.b = ((RelativeLayout)DownloadView.this.vsOperations.findViewById(DId.getIdInt(DownloadView.this.mContext, "rl_menu_delete")));
              this.b.setOnClickListener(locala);
              this.c = ((RelativeLayout)DownloadView.this.vsOperations.findViewById(DId.getIdInt(DownloadView.this.mContext, "rl_menu_detail")));
              this.c.setOnClickListener(locala);
              DownloadView.this.viewStubMap.put(paramAnonymousView, DownloadView.this.vsOperations);
            }
            else
            {
              DownloadView.this.vsOperations.setVisibility(8);
            }
          }
        }
      }
    });
    return localLinearLayout;
  }
  
  public void onAppItemDownloadStatusChanged(Constants.DownloadStatus paramDownloadStatus)
  {
    mLogger.debugLog("onAppItemDownloadStatusChanged, do nothing");
  }
  
  public void onDMItemDownloadStatusChanged(Constants.DownloadStatus paramDownloadStatus)
  {
    mLogger.debugLog("onDMItemDownloadStatusChanged");
    this.handler.sendEmptyMessage(0);
  }
  
  private class a
    implements View.OnClickListener
  {
    private int b;
    private int c;
    private ProgressDialog d;
    
    public a(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    public void onClick(View paramView)
    {
      if (paramView.getId() == DId.getIdInt(DownloadView.this.mContext, "rl_menu_delete"))
      {
        paramView = new AlertDialog.Builder(DownloadView.this.mContext);
        paramView.setTitle("温馨提示");
        paramView.setIcon(17301659);
        paramView.setMessage("您确定要删除该条下载吗？");
        paramView.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.dismiss();
            DownloadView.mLogger.debugLog("confirmdialog clicked, groupPosition:" + DownloadView.a.a(DownloadView.a.this));
            if (DownloadView.a.a(DownloadView.a.this) == 1)
            {
              paramAnonymousDialogInterface = (DownLoadListItem)((List)DownloadView.this.childList.get(DownloadView.a.a(DownloadView.a.this))).remove(DownloadView.a.b(DownloadView.a.this));
              DownloadView.this.mDownLoadManager.excuteDelete(paramAnonymousDialogInterface.getDownloadAppInfo());
              DownloadView.this.downloadedItemList.remove(paramAnonymousDialogInterface);
              if (DownloadView.this.downloadedItemList.size() == 0)
              {
                DownloadView.this.groupList.remove(DownloadView.a.a(DownloadView.a.this));
                DownloadView.this.childList.remove(DownloadView.a.a(DownloadView.a.this));
              }
            }
            for (;;)
            {
              if (DownloadView.this.viewStub != null)
              {
                DownloadView.this.vsOperations.setVisibility(8);
                DownloadView.this.viewStub.setVisibility(8);
                DownloadView.this.viewStubMap.clear();
              }
              DownloadView.this.adapter.setGroupList(DownloadView.this.groupList);
              DownloadView.this.adapter.setChildList(DownloadView.this.childList);
              DownloadView.this.adapter.notifyDataSetChanged();
              return;
              if (DownloadView.a.a(DownloadView.a.this) == 0)
              {
                paramAnonymousDialogInterface = (DownLoadListItem)((List)DownloadView.this.childList.get(DownloadView.a.a(DownloadView.a.this))).remove(DownloadView.a.b(DownloadView.a.this));
                if (((String)DownloadView.this.adapter.getGroupList().get(DownloadView.a.a(DownloadView.a.this))).toString().equals("下载中"))
                {
                  DownloadView.this.mDownLoadManager.excuteDelete(paramAnonymousDialogInterface.getDownloadAppInfo());
                  DownloadView.this.downloadingItemList.remove(paramAnonymousDialogInterface);
                  if (DownloadView.this.downloadingItemList.size() == 0)
                  {
                    DownloadView.this.groupList.remove(DownloadView.a.a(DownloadView.a.this));
                    DownloadView.this.childList.remove(DownloadView.a.a(DownloadView.a.this));
                  }
                }
                else if (((String)DownloadView.this.adapter.getGroupList().get(DownloadView.a.a(DownloadView.a.this))).toString().equals("已下载"))
                {
                  DownloadView.this.mDownLoadManager.excuteDelete(paramAnonymousDialogInterface.getDownloadAppInfo());
                  DownloadView.this.downloadedItemList.remove(paramAnonymousDialogInterface);
                  if (DownloadView.this.downloadedItemList.size() == 0)
                  {
                    DownloadView.this.groupList.remove(DownloadView.a.a(DownloadView.a.this));
                    DownloadView.this.childList.remove(DownloadView.a.a(DownloadView.a.this));
                  }
                }
              }
            }
          }
        }).setNegativeButton("取消", null);
        paramView.show();
      }
      for (;;)
      {
        return;
        if (paramView.getId() == DId.getIdInt(DownloadView.this.mContext, "rl_menu_detail"))
        {
          paramView = ((DownLoadListItem)((List)DownloadView.this.adapter.getChildList().get(this.b)).get(this.c)).getDownloadAppInfo();
          this.d = new ProgressDialog(DownloadView.this.mContext);
          this.d.setMessage("数据加载中...");
          this.d.show();
          DownloadView.this.mDService.setReceiveDetailsDataListener(new DService.ReceiveDetailsDataListener()
          {
            private Dialog b;
            
            public void onFailReceiveData(DService.ErrorCode paramAnonymousErrorCode, String paramAnonymousString)
            {
              DownloadView.a.c(DownloadView.a.this).dismiss();
              DownloadView.mLogger.errorLog("fail to receive detail data.");
            }
            
            public void onSuccessReceiveData(List<AdInfo> paramAnonymousList)
            {
              DownloadView.a.c(DownloadView.a.this).dismiss();
              Looper.prepare();
              if ((paramAnonymousList.size() > 0) && (paramAnonymousList != null))
              {
                paramAnonymousList = (AdInfo)paramAnonymousList.get(0);
                paramAnonymousList = new AppListItem(DownloadView.this.mContext, DownloadView.this, paramAnonymousList, DownloadView.this.mDService, DownloadView.this.mDownLoadManager, DownloadView.this.mControlInfo, DownloadView.this.listenerName);
                this.b = new Dialog(DownloadView.this.mContext);
                paramAnonymousList = paramAnonymousList.bindDetailsView(this.b);
                this.b.requestWindowFeature(1);
                this.b.setContentView(paramAnonymousList);
                this.b.show();
              }
              Looper.loop();
            }
          });
          paramView = Long.toString(paramView.getAppId());
          DownloadView.this.mDService.requestDetailsDataAsyn(paramView);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\DownloadView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */