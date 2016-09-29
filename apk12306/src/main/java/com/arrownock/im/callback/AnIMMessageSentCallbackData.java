package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;

public class AnIMMessageSentCallbackData
{
  private boolean error = true;
  private ArrownockException exception = null;
  private String msgId = null;
  private long timestamp = -1L;
  
  static
  {
    JniLib.a(AnIMMessageSentCallbackData.class, 162);
  }
  
  public AnIMMessageSentCallbackData(boolean paramBoolean, ArrownockException paramArrownockException, String paramString, long paramLong)
  {
    this.error = paramBoolean;
    this.msgId = paramString;
    this.timestamp = paramLong;
    this.exception = paramArrownockException;
  }
  
  public native ArrownockException getException();
  
  public native String getMsgId();
  
  public native long getTimestamp();
  
  public native boolean isError();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMMessageSentCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */