package cn.domob.wall.core;

import java.util.List;

public abstract interface DService$ReceiveHotSearchDataListener
{
  public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
  
  public abstract void onSuccessReceiveData(List<String> paramList);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\DService$ReceiveHotSearchDataListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */