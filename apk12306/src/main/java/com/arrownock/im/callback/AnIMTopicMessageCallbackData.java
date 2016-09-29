package com.arrownock.im.callback;

import com.bangcle.andjni.JniLib;
import java.util.Map;

public class AnIMTopicMessageCallbackData
  extends AnIMBaseMessageCallbackData
{
  private Map<String, String> customData = null;
  private String message = null;
  private long timestamp = -1L;
  private String topic = null;
  
  static
  {
    JniLib.a(AnIMTopicMessageCallbackData.class, 167);
  }
  
  public AnIMTopicMessageCallbackData(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, long paramLong)
  {
    super(paramString1, paramString2);
    this.topic = paramString3;
    this.message = paramString4;
    this.customData = paramMap;
    this.timestamp = paramLong;
  }
  
  public native Map<String, String> getCustomData();
  
  public native String getMessage();
  
  public native long getTimestamp();
  
  public native String getTopic();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMTopicMessageCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */