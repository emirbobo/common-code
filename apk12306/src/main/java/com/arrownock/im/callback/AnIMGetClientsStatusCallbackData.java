package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;
import java.util.Map;

public class AnIMGetClientsStatusCallbackData
  extends AnIMBaseRequestCallbackData
{
  Map<String, Boolean> clientsStatus = null;
  
  static
  {
    JniLib.a(AnIMGetClientsStatusCallbackData.class, 157);
  }
  
  public AnIMGetClientsStatusCallbackData(boolean paramBoolean, ArrownockException paramArrownockException, Map<String, Boolean> paramMap)
  {
    super(paramBoolean, paramArrownockException);
    this.clientsStatus = paramMap;
  }
  
  public native Map<String, Boolean> getClientsStatus();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMGetClientsStatusCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */