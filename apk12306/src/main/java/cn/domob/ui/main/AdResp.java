package cn.domob.ui.main;

import cn.domob.wall.core.bean.AdExtend;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.AdInfo.AdType;
import cn.domob.wall.core.bean.ControlInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdResp
{
  private List<AdExtend> mAdExtend;
  private List<AdInfo> mAppList = new ArrayList();
  private List<AdInfo> mBannerList;
  private ControlInfo mControlInfo;
  private List<AdInfo> mGameList = new ArrayList();
  private List<AdInfo> mItemList;
  
  public AdResp()
  {
    this.mControlInfo = new ControlInfo();
    this.mBannerList = new ArrayList();
    this.mItemList = new ArrayList();
    this.mAdExtend = new ArrayList();
  }
  
  public AdResp(List<AdInfo> paramList1, List<AdInfo> paramList2, ControlInfo paramControlInfo, List<AdExtend> paramList)
  {
    this.mBannerList = paramList1;
    this.mItemList = paramList2;
    this.mControlInfo = paramControlInfo;
    this.mAdExtend = paramList;
    parseAdResp(this.mItemList);
  }
  
  private void parseAdResp(List<AdInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (AdInfo)localIterator.next();
      if (paramList.getAdType().equals(AdInfo.AdType.GAME)) {
        this.mGameList.add(paramList);
      } else if (paramList.getAdType().equals(AdInfo.AdType.APPLICATION)) {
        this.mAppList.add(paramList);
      }
    }
  }
  
  public List<AdExtend> getAdExtend()
  {
    return this.mAdExtend;
  }
  
  public List<AdInfo> getAppList()
  {
    return this.mAppList;
  }
  
  public List<AdInfo> getBannerList()
  {
    return this.mBannerList;
  }
  
  public ControlInfo getControlInfo()
  {
    return this.mControlInfo;
  }
  
  public List<AdInfo> getGameList()
  {
    return this.mGameList;
  }
  
  public List<AdInfo> getItemList()
  {
    return this.mItemList;
  }
  
  public void setAdExtend(List<AdExtend> paramList)
  {
    this.mAdExtend = paramList;
  }
  
  public void setAppList(List<AdInfo> paramList)
  {
    this.mAppList = paramList;
  }
  
  public void setBannerList(List<AdInfo> paramList)
  {
    this.mBannerList = paramList;
  }
  
  public void setControlInfo(ControlInfo paramControlInfo)
  {
    this.mControlInfo = paramControlInfo;
  }
  
  public void setGameList(List<AdInfo> paramList)
  {
    this.mGameList = paramList;
  }
  
  public void setItemList(List<AdInfo> paramList)
  {
    this.mItemList = paramList;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\AdResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */