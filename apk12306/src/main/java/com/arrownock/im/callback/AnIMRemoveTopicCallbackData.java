package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;

@Deprecated
public class AnIMRemoveTopicCallbackData
  extends AnIMBaseRequestCallbackData
{
  @Deprecated
  private String topic = null;
  
  static
  {
    JniLib.a(AnIMRemoveTopicCallbackData.class, 164);
  }
  
  @Deprecated
  public AnIMRemoveTopicCallbackData(boolean paramBoolean, ArrownockException paramArrownockException, String paramString)
  {
    super(paramBoolean, paramArrownockException);
    this.topic = paramString;
  }
  
  @Deprecated
  public native String getTopic();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMRemoveTopicCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */