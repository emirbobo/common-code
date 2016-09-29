package com.arrownock.im.callback;

import com.bangcle.andjni.JniLib;
import java.util.Map;
import java.util.Set;

public class AnIMBinaryCallbackData
  extends AnIMBaseMessageCallbackData
{
  private byte[] content = null;
  private Map<String, String> customData = null;
  private String fileType = null;
  private Set<String> parties = null;
  private long timestamp = -1L;
  
  static
  {
    JniLib.a(AnIMBinaryCallbackData.class, 153);
  }
  
  public AnIMBinaryCallbackData(String paramString1, String paramString2, Set<String> paramSet, byte[] paramArrayOfByte, String paramString3, Map<String, String> paramMap, long paramLong)
  {
    super(paramString1, paramString2);
    this.parties = paramSet;
    this.content = paramArrayOfByte;
    this.fileType = paramString3;
    this.customData = paramMap;
    this.timestamp = paramLong;
  }
  
  public native byte[] getContent();
  
  public native Map<String, String> getCustomData();
  
  public native String getFileType();
  
  public native Set<String> getParties();
  
  public native long getTimestamp();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMBinaryCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */