package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.arrownock.im.AnIMStatus;
import com.bangcle.andjni.JniLib;

public class AnIMStatusUpdateCallbackData
{
  private ArrownockException exception = null;
  private AnIMStatus status = AnIMStatus.OFFLINE;
  
  static
  {
    JniLib.a(AnIMStatusUpdateCallbackData.class, 165);
  }
  
  public AnIMStatusUpdateCallbackData(AnIMStatus paramAnIMStatus, ArrownockException paramArrownockException)
  {
    this.status = paramAnIMStatus;
    this.exception = paramArrownockException;
  }
  
  public native ArrownockException getException();
  
  public native AnIMStatus getStatus();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMStatusUpdateCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */