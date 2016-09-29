package com.arrownock.im.callback;

import com.bangcle.andjni.JniLib;
import java.util.Map;

public class AnIMTopicBinaryCallbackData
  extends AnIMBaseMessageCallbackData
{
  private byte[] content = null;
  private Map<String, String> customData = null;
  private String fileType = null;
  private long timestamp = -1L;
  private String topic = null;
  
  static
  {
    JniLib.a(AnIMTopicBinaryCallbackData.class, 166);
  }
  
  public AnIMTopicBinaryCallbackData(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, Map<String, String> paramMap, long paramLong)
  {
    super(paramString1, paramString2);
    this.topic = paramString3;
    this.content = paramArrayOfByte;
    this.fileType = paramString4;
    this.customData = paramMap;
    this.timestamp = paramLong;
  }
  
  public native byte[] getContent();
  
  public native Map<String, String> getCustomData();
  
  public native String getFileType();
  
  public native long getTimestamp();
  
  public native String getTopic();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMTopicBinaryCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */