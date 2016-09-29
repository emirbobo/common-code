package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;
import java.util.Date;
import java.util.Set;

public class AnIMGetSessionInfoCallbackData
  extends AnIMBaseRequestCallbackData
{
  private Date createdAt = null;
  private Set<String> parties = null;
  private String sessionId = null;
  
  static
  {
    JniLib.a(AnIMGetSessionInfoCallbackData.class, 158);
  }
  
  public AnIMGetSessionInfoCallbackData(boolean paramBoolean, ArrownockException paramArrownockException, String paramString, Set<String> paramSet, Date paramDate)
  {
    super(paramBoolean, paramArrownockException);
    this.sessionId = paramString;
    this.parties = paramSet;
    this.createdAt = paramDate;
  }
  
  public native Date getCreatedAt();
  
  public native Set<String> getParties();
  
  public native String getSessionId();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMGetSessionInfoCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */