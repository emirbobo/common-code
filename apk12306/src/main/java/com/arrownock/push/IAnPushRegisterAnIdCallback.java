package com.arrownock.push;

import com.arrownock.exception.ArrownockException;

public abstract interface IAnPushRegisterAnIdCallback
{
  public abstract void onError(ArrownockException paramArrownockException, int paramInt, String paramString);
  
  public abstract void onSuccess();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\push\IAnPushRegisterAnIdCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */