package cn.domob.ui.main;

import cn.domob.wall.core.DService.ErrorCode;

public abstract interface DViewAdModel$AdDataListener
{
  public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
  
  public abstract void onSuccessReceiveData(AdResp paramAdResp);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewAdModel$AdDataListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */