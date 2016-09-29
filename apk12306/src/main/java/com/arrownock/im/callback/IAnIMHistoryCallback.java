package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.arrownock.im.AnIMMessage;
import java.util.List;

public abstract interface IAnIMHistoryCallback
{
  public abstract void onError(ArrownockException paramArrownockException);
  
  public abstract void onSuccess(List<AnIMMessage> paramList, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\IAnIMHistoryCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */