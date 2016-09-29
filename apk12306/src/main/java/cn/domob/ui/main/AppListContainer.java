package cn.domob.ui.main;

import android.content.Context;
import cn.dm.download.DownLoadManager;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.item.AppListItem.AppItemStatusChangeListener;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.AdInfo.AdType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppListContainer
{
  private static Logger mLogger = new Logger(AppListContainer.class.getSimpleName());
  private DownLoadManager dlm;
  private AdResp mAdResp;
  private List<AppListItem> mAllList = new ArrayList();
  private List<AppListItem> mAppList = new ArrayList();
  private List<AppListItem> mBannerList = new ArrayList();
  private Context mContext;
  private DService mDService;
  private List<AppListItem> mGameList = new ArrayList();
  private AppListItem.AppItemStatusChangeListener mListener;
  private String mListenerName = "APPItem";
  
  public AppListContainer(Context paramContext, DService paramDService, AppListItem.AppItemStatusChangeListener paramAppItemStatusChangeListener, DownLoadManager paramDownLoadManager)
  {
    this.mContext = paramContext;
    this.mDService = paramDService;
    this.mListener = paramAppItemStatusChangeListener;
    this.dlm = paramDownLoadManager;
  }
  
  public void clearAll()
  {
    this.mAllList.clear();
    this.mGameList.clear();
    this.mAppList.clear();
    this.mBannerList.clear();
  }
  
  public void doRefresh(AdResp paramAdResp)
  {
    mLogger.ptLog("Start convert adresp to applistitem");
    this.mAdResp = paramAdResp;
    clearAll();
    if (this.mAdResp != null)
    {
      Object localObject = this.mAdResp.getItemList().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramAdResp = (AdInfo)((Iterator)localObject).next();
        AppListItem localAppListItem = new AppListItem(this.mContext, this.mListener, paramAdResp, this.mDService, this.dlm, this.mAdResp.getControlInfo(), this.mListenerName);
        this.mAllList.add(localAppListItem);
        if (paramAdResp.getAdType().equals(AdInfo.AdType.GAME)) {
          this.mGameList.add(localAppListItem);
        } else if (paramAdResp.getAdType().equals(AdInfo.AdType.APPLICATION)) {
          this.mAppList.add(localAppListItem);
        }
      }
      paramAdResp = this.mAdResp.getBannerList().iterator();
      while (paramAdResp.hasNext())
      {
        localObject = (AdInfo)paramAdResp.next();
        localObject = new AppListItem(this.mContext, this.mListener, (AdInfo)localObject, this.mDService, this.dlm, this.mAdResp.getControlInfo(), this.mListenerName);
        this.mBannerList.add(localObject);
      }
    }
    mLogger.ptLog("Finish convert adresp to applistitem");
  }
  
  public List<AppListItem> getAllList()
  {
    return this.mAllList;
  }
  
  public List<AppListItem> getAppList()
  {
    return this.mAppList;
  }
  
  public List<AppListItem> getBannerList()
  {
    return this.mBannerList;
  }
  
  public List<AppListItem> getGameList()
  {
    return this.mGameList;
  }
  
  public void setAllList(List<AppListItem> paramList)
  {
    this.mAllList = paramList;
  }
  
  public void setAppList(List<AppListItem> paramList)
  {
    this.mAppList = paramList;
  }
  
  public void setBannerList(List<AppListItem> paramList)
  {
    this.mBannerList = paramList;
  }
  
  public void setGameList(List<AppListItem> paramList)
  {
    this.mGameList = paramList;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\AppListContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */