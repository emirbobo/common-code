package com.arrownock.social;

import android.content.Context;
import android.util.Log;
import be;
import ch;
import cm;
import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;
import java.util.Map;

public class AnSocial
{
  private ch a = null;
  
  static
  {
    JniLib.a(AnSocial.class, 178);
  }
  
  public AnSocial(Context paramContext, String paramString)
    throws ArrownockException
  {
    if ((paramString == null) || ("".equals(paramString.trim()))) {
      throw new ArrownockException("Invalid value of com.arrownock.APP_KEY", -200000);
    }
    this.a = new ch(paramString, paramContext);
    this.a.a(60000);
    if (cm.a.booleanValue()) {}
    try
    {
      be.a(paramContext, paramString).a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.w("DeviceManager", paramContext.getMessage());
      }
    }
  }
  
  public native void sendRequest(String paramString, AnSocialMethod paramAnSocialMethod, Map<String, Object> paramMap, IAnSocialCallback paramIAnSocialCallback)
    throws ArrownockException;
  
  public native void setHost(String paramString)
    throws ArrownockException;
  
  public native void setSecureConnection(Boolean paramBoolean);
  
  public native void setTimeout(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\social\AnSocial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */