package com.arrownock.push;

import com.arrownock.exception.ArrownockException;

public abstract interface IAnPushSettingsCallback
{
  public abstract void onError(ArrownockException paramArrownockException);
  
  public abstract void onSuccess();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\push\IAnPushSettingsCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */