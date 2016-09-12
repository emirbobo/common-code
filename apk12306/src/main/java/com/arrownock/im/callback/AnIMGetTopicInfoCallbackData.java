package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;
import java.util.Date;
import java.util.Set;

public class AnIMGetTopicInfoCallbackData
  extends AnIMBaseRequestCallbackData
{
  private Date createdAt = null;
  private String owner = null;
  private Set<String> parties = null;
  private String topicId = null;
  private String topicName = null;
  
  static
  {
    JniLib.a(AnIMGetTopicInfoCallbackData.class, 159);
  }
  
  public AnIMGetTopicInfoCallbackData(boolean paramBoolean, ArrownockException paramArrownockException, String paramString1, String paramString2, String paramString3, Set<String> paramSet, Date paramDate)
  {
    super(paramBoolean, paramArrownockException);
    this.topicId = paramString1;
    this.topicName = paramString2;
    this.parties = paramSet;
    this.createdAt = paramDate;
    this.owner = paramString3;
  }
  
  public native Date getCreatedAt();
  
  public native String getOwner();
  
  public native Set<String> getParties();
  
  public native String getTopicId();
  
  public native String getTopicName();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMGetTopicInfoCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */