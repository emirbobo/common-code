package com.alipay.mobilesecuritysdk;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.util.List;

public class MainHandler
{
  static
  {
    JniLib.a(MainHandler.class, 23);
  }
  
  public native int mainhandler(Context paramContext, List<String> paramList, boolean paramBoolean);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\MainHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */