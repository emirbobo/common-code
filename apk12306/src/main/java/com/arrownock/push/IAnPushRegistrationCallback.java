package com.arrownock.push;

import com.arrownock.exception.ArrownockException;

public abstract interface IAnPushRegistrationCallback
{
  public abstract void onError(ArrownockException paramArrownockException);
  
  public abstract void onSuccess(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\push\IAnPushRegistrationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */