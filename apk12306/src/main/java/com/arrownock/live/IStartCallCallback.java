package com.arrownock.live;

import com.arrownock.exception.ArrownockException;

public abstract interface IStartCallCallback
{
  public abstract void onFailure(ArrownockException paramArrownockException);
  
  public abstract void onReady(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\live\IStartCallCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */