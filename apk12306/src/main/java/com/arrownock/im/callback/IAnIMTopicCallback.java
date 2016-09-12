package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;

public abstract interface IAnIMTopicCallback
{
  public abstract void onError(ArrownockException paramArrownockException);
  
  public abstract void onSuccess(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\IAnIMTopicCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */