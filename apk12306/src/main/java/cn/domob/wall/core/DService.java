package cn.domob.wall.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import cn.domob.wall.core.bean.AdExtend;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import cn.domob.wall.core.download.k;
import java.util.ArrayList;
import java.util.List;

public class DService
{
  private static String d = "online";
  private b a;
  private a b;
  private k c;
  
  public DService(Context paramContext, String paramString1, String paramString2)
  {
    this.a = new b(paramContext, paramString1, paramString2);
    this.b = new a(paramContext, this.a);
    this.c = k.a(paramContext);
  }
  
  public static String getEndpoint()
  {
    return d;
  }
  
  public static void setEndpoint(String paramString)
  {
    d = paramString;
  }
  
  public void doClickDetailsPageButtonReport(AdInfo paramAdInfo)
  {
    this.b.d(paramAdInfo);
  }
  
  public void doClickWallItemButtonReport(AdInfo paramAdInfo)
  {
    this.b.e(paramAdInfo);
  }
  
  public void doClickWallItemReport(AdInfo paramAdInfo)
  {
    this.b.f(paramAdInfo);
  }
  
  public void doDownLoadReport(AdInfo paramAdInfo, ReportDownLoadType paramReportDownLoadType)
  {
    this.b.a(paramAdInfo, paramReportDownLoadType);
  }
  
  public void doEWallReport(EWallReportType paramEWallReportType)
  {
    this.b.a(paramEWallReportType);
  }
  
  public void doImpReports(ArrayList<AdInfo> paramArrayList)
  {
    this.b.a(paramArrayList);
  }
  
  public void doUserActionReport(ReportUserActionType paramReportUserActionType)
  {
    this.b.a(paramReportUserActionType);
  }
  
  public View getEView(Context paramContext)
  {
    return this.a.a(paramContext);
  }
  
  public void onClickDetailsPageButton(AdInfo paramAdInfo)
  {
    this.b.a(paramAdInfo);
  }
  
  public void onClickWallItem(AdInfo paramAdInfo)
  {
    this.b.c(paramAdInfo);
  }
  
  public void onClickWallItemButton(AdInfo paramAdInfo)
  {
    this.b.b(paramAdInfo);
  }
  
  public void requestDataAsyn()
  {
    this.a.a();
  }
  
  public void requestDetailsDataAsyn(String paramString)
  {
    this.a.b(paramString);
  }
  
  public void requestHotSearchDataAsyn()
  {
    this.a.c();
  }
  
  public void requestImage(String paramString, ImageView paramImageView, OnImageDownload paramOnImageDownload)
  {
    this.c.a(paramString, paramImageView, paramOnImageDownload);
  }
  
  public void requestListsDataAsyn()
  {
    this.a.b();
  }
  
  public void requestSearchDataAsyn(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void setReceiveDataListener(ReceiveDataListener paramReceiveDataListener)
  {
    this.a.a(paramReceiveDataListener);
  }
  
  public void setReceiveDetailsDataListener(ReceiveDetailsDataListener paramReceiveDetailsDataListener)
  {
    this.a.a(paramReceiveDetailsDataListener);
  }
  
  public void setReceiveHotSearchDataListener(ReceiveHotSearchDataListener paramReceiveHotSearchDataListener)
  {
    this.a.a(paramReceiveHotSearchDataListener);
  }
  
  public void setReceiveListDataListener(ReceiveListDataListener paramReceiveListDataListener)
  {
    this.a.a(paramReceiveListDataListener);
  }
  
  public void setReceiveSearchDataListener(ReceiveSearchDataListener paramReceiveSearchDataListener)
  {
    this.a.a(paramReceiveSearchDataListener);
  }
  
  public void setloadImgLock()
  {
    this.c.b();
  }
  
  public void setloadImgUnLock()
  {
    this.c.c();
  }
  
  public static enum EWallReportType
  {
    static
    {
      E_ENTRY_SHOW = new EWallReportType("E_ENTRY_SHOW", 1);
      E_ENTRY_CLICK = new EWallReportType("E_ENTRY_CLICK", 2);
      E_PAGE_REQ = new EWallReportType("E_PAGE_REQ", 3);
      E_PAGE_SHOW = new EWallReportType("E_PAGE_SHOW", 4);
    }
    
    private EWallReportType() {}
  }
  
  public static enum ErrorCode
  {
    private ErrorCode() {}
  }
  
  public static abstract interface OnImageDownload
  {
    public abstract void onDownloadFail(String paramString, ImageView paramImageView);
    
    public abstract void onDownloadSuc(Bitmap paramBitmap, String paramString, ImageView paramImageView);
  }
  
  public static abstract interface ReceiveDataListener
  {
    public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void onSuccessReceiveData(List<AdInfo> paramList1, List<AdInfo> paramList2, ControlInfo paramControlInfo, List<AdExtend> paramList);
  }
  
  public static abstract interface ReceiveDetailsDataListener
  {
    public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void onSuccessReceiveData(List<AdInfo> paramList);
  }
  
  public static abstract interface ReceiveHotSearchDataListener
  {
    public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void onSuccessReceiveData(List<String> paramList);
  }
  
  public static abstract interface ReceiveListDataListener
  {
    public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void onSuccessReceiveData(List<AdInfo> paramList1, List<AdInfo> paramList2, ControlInfo paramControlInfo, List<AdExtend> paramList);
  }
  
  public static abstract interface ReceiveSearchDataListener
  {
    public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
    
    public abstract void onSuccessReceiveData(List<AdInfo> paramList1, List<AdInfo> paramList2);
  }
  
  public static enum ReportDownLoadType
  {
    static
    {
      DL_START = new ReportDownLoadType("DL_START", 1);
      DL_REPEAT = new ReportDownLoadType("DL_REPEAT", 2);
      DL_FINISH = new ReportDownLoadType("DL_FINISH", 3);
      DL_FAILED = new ReportDownLoadType("DL_FAILED", 4);
      DL_CANCEL = new ReportDownLoadType("DL_CANCEL", 5);
      INSTALL_SUCCESS = new ReportDownLoadType("INSTALL_SUCCESS", 6);
    }
    
    private ReportDownLoadType() {}
  }
  
  public static enum ReportUserActionType
  {
    private ReportUserActionType() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\DService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */