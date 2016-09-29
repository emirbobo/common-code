package com.arrownock.im;

import com.bangcle.andjni.JniLib;
import java.util.Map;

public class AnIMMessage
{
  private byte[] content;
  private Map<String, String> customData;
  private String fileType;
  private String from;
  private String message;
  private String msgId;
  private long timestamp;
  private String topicId;
  private AnIMMessageType type;
  
  static
  {
    JniLib.a(AnIMMessage.class, 152);
  }
  
  public AnIMMessage(AnIMMessageType paramAnIMMessageType, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4, String paramString5, long paramLong, Map<String, String> paramMap)
  {
    this.type = paramAnIMMessageType;
    this.msgId = paramString1;
    this.topicId = paramString2;
    this.message = paramString3;
    this.content = paramArrayOfByte;
    this.fileType = paramString4;
    this.from = paramString5;
    this.timestamp = paramLong;
    this.customData = paramMap;
  }
  
  public native byte[] getContent();
  
  public native Map<String, String> getCustomData();
  
  public native String getFileType();
  
  public native String getFrom();
  
  public native String getMessage();
  
  public native String getMsgId();
  
  public native long getTimestamp();
  
  public native String getTopicId();
  
  public native AnIMMessageType getType();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\AnIMMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */