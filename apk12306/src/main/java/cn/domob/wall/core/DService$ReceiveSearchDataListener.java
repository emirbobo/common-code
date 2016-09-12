package cn.domob.wall.core;

import cn.domob.wall.core.bean.AdInfo;
import java.util.List;

public abstract interface DService$ReceiveSearchDataListener
{
  public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
  
  public abstract void onSuccessReceiveData(List<AdInfo> paramList1, List<AdInfo> paramList2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\DService$ReceiveSearchDataListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */