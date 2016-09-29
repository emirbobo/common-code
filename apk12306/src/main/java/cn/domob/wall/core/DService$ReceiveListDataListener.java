package cn.domob.wall.core;

import cn.domob.wall.core.bean.AdExtend;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import java.util.List;

public abstract interface DService$ReceiveListDataListener
{
  public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
  
  public abstract void onSuccessReceiveData(List<AdInfo> paramList1, List<AdInfo> paramList2, ControlInfo paramControlInfo, List<AdExtend> paramList);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\DService$ReceiveListDataListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */