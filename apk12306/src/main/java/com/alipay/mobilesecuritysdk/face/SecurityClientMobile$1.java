package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.util.List;

class SecurityClientMobile$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 41);
  }
  
  SecurityClientMobile$1(Context paramContext, List paramList, boolean paramBoolean) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\face\SecurityClientMobile$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */