package cn.domob.ui.main;

import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveDataListener;
import cn.domob.wall.core.bean.AdExtend;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import java.util.List;

class DViewAdModel$1
  implements DService.ReceiveDataListener
{
  DViewAdModel$1(DViewAdModel paramDViewAdModel) {}
  
  public void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString)
  {
    if (DViewAdModel.access$000(this.a) != null) {
      DViewAdModel.access$000(this.a).onFailReceiveData(paramErrorCode, paramString);
    }
  }
  
  public void onSuccessReceiveData(List<AdInfo> paramList1, List<AdInfo> paramList2, ControlInfo paramControlInfo, List<AdExtend> paramList)
  {
    if (DViewAdModel.access$000(this.a) != null)
    {
      paramList1 = new AdResp(paramList1, paramList2, paramControlInfo, paramList);
      DViewAdModel.access$000(this.a).onSuccessReceiveData(paramList1);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewAdModel$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */