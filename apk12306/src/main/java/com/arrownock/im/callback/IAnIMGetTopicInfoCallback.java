package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;

public abstract interface IAnIMGetTopicInfoCallback
{
  public abstract void onError(ArrownockException paramArrownockException);
  
  public abstract void onSuccess(AnIMGetTopicInfoCallbackData paramAnIMGetTopicInfoCallbackData);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\IAnIMGetTopicInfoCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */