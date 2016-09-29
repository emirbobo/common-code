package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;

public abstract class AnIMBaseRequestCallbackData
{
  private boolean error = false;
  private ArrownockException exception = null;
  
  public AnIMBaseRequestCallbackData(boolean paramBoolean, ArrownockException paramArrownockException)
  {
    this.error = paramBoolean;
    this.exception = paramArrownockException;
  }
  
  public ArrownockException getException()
  {
    return this.exception;
  }
  
  public boolean isError()
  {
    return this.error;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMBaseRequestCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */