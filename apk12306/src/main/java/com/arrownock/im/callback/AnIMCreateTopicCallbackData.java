package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;

@Deprecated
public class AnIMCreateTopicCallbackData
  extends AnIMBaseRequestCallbackData
{
  @Deprecated
  private String topic = null;
  
  static
  {
    JniLib.a(AnIMCreateTopicCallbackData.class, 155);
  }
  
  @Deprecated
  public AnIMCreateTopicCallbackData(boolean paramBoolean, ArrownockException paramArrownockException, String paramString)
  {
    super(paramBoolean, paramArrownockException);
    this.topic = paramString;
  }
  
  @Deprecated
  public native String getTopic();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMCreateTopicCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */