package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;

@Deprecated
public class AnIMUpdateTopicCallbackData
  extends AnIMBaseRequestCallbackData
{
  @Deprecated
  private String topic = null;
  
  static
  {
    JniLib.a(AnIMUpdateTopicCallbackData.class, 168);
  }
  
  @Deprecated
  public AnIMUpdateTopicCallbackData(boolean paramBoolean, ArrownockException paramArrownockException, String paramString)
  {
    super(paramBoolean, paramArrownockException);
    this.topic = paramString;
  }
  
  @Deprecated
  public native String getTopic();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMUpdateTopicCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */