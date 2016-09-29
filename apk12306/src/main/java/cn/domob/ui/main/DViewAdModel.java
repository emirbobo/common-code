package cn.domob.ui.main;

import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveDataListener;
import cn.domob.wall.core.DService.ReceiveSearchDataListener;
import cn.domob.wall.core.bean.AdExtend;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import java.util.List;

public class DViewAdModel
{
  private AdDataListener mAdDataListener;
  private DService mDService;
  private SearchDataListener searchDataListener;
  
  public DViewAdModel(DService paramDService)
  {
    this.mDService = paramDService;
    setListener();
  }
  
  private void setListener()
  {
    this.mDService.setReceiveDataListener(new DService.ReceiveDataListener()
    {
      public void onFailReceiveData(DService.ErrorCode paramAnonymousErrorCode, String paramAnonymousString)
      {
        if (DViewAdModel.this.mAdDataListener != null) {
          DViewAdModel.this.mAdDataListener.onFailReceiveData(paramAnonymousErrorCode, paramAnonymousString);
        }
      }
      
      public void onSuccessReceiveData(List<AdInfo> paramAnonymousList1, List<AdInfo> paramAnonymousList2, ControlInfo paramAnonymousControlInfo, List<AdExtend> paramAnonymousList)
      {
        if (DViewAdModel.this.mAdDataListener != null)
        {
          paramAnonymousList1 = new AdResp(paramAnonymousList1, paramAnonymousList2, paramAnonymousControlInfo, paramAnonymousList);
          DViewAdModel.this.mAdDataListener.onSuccessReceiveData(paramAnonymousList1);
        }
      }
    });
    this.mDService.setReceiveSearchDataListener(new DService.ReceiveSearchDataListener()
    {
      public void onFailReceiveData(DService.ErrorCode paramAnonymousErrorCode, String paramAnonymousString)
      {
        if (DViewAdModel.this.searchDataListener != null) {
          DViewAdModel.this.searchDataListener.onFailReceiveData(paramAnonymousErrorCode, paramAnonymousString);
        }
      }
      
      public void onSuccessReceiveData(List<AdInfo> paramAnonymousList1, List<AdInfo> paramAnonymousList2)
      {
        if (DViewAdModel.this.searchDataListener != null)
        {
          paramAnonymousList1 = new SearchResp(paramAnonymousList2, paramAnonymousList2);
          DViewAdModel.this.searchDataListener.onSuccessReceiveData(paramAnonymousList1);
        }
      }
    });
  }
  
  public void requestAdData()
  {
    this.mDService.requestDataAsyn();
  }
  
  public void requestSearchData(String paramString)
  {
    this.mDService.requestSearchDataAsyn(paramString);
  }
  
  public void setReceiveAdDataListener(AdDataListener paramAdDataListener)
  {
    this.mAdDataListener = paramAdDataListener;
  }
  
  public void setReceiveSearchDataListener(SearchDataListener paramSearchDataListener)
  {
    this.searchDataListener = paramSearchDataListener;
  }
  
  public static abstract interface AdDataListener
  {
    public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void onSuccessReceiveData(AdResp paramAdResp);
  }
  
  public static abstract interface SearchDataListener
  {
    public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void onSuccessReceiveData(SearchResp paramSearchResp);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewAdModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */