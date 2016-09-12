package cn.domob.ui.main;

import cn.domob.wall.core.DService.ErrorCode;

public abstract interface DViewManager$GetDataListener
{
  public abstract void onCloseWall();
  
  public abstract void onFailReceiveData(DService.ErrorCode paramErrorCode, String paramString);
  
  public abstract void onSuccessReceiveData(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewManager$GetDataListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */