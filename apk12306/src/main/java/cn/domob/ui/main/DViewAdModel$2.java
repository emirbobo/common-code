package cn.domob.ui.main;

import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveSearchDataListener;
import cn.domob.wall.core.bean.AdInfo;
import java.util.List;

class DViewAdModel$2
  implements DService.ReceiveSearchDataListener
{
  DViewAdModel$2(DViewAdModel paramDViewAdModel) {}
  
  public void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString)
  {
    if (DViewAdModel.access$100(this.a) != null) {
      DViewAdModel.access$100(this.a).onFailReceiveData(paramErrorCode, paramString);
    }
  }
  
  public void onSuccessReceiveData(List<AdInfo> paramList1, List<AdInfo> paramList2)
  {
    if (DViewAdModel.access$100(this.a) != null)
    {
      paramList1 = new SearchResp(paramList2, paramList2);
      DViewAdModel.access$100(this.a).onSuccessReceiveData(paramList1);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewAdModel$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */