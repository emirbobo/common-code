package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;

public class AnIMGetClientIdCallbackData
  extends AnIMBaseRequestCallbackData
{
  private String clientId = null;
  
  static
  {
    JniLib.a(AnIMGetClientIdCallbackData.class, 156);
  }
  
  public AnIMGetClientIdCallbackData(boolean paramBoolean, ArrownockException paramArrownockException, String paramString)
  {
    super(paramBoolean, paramArrownockException);
    this.clientId = paramString;
  }
  
  public native String getClientId();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMGetClientIdCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */