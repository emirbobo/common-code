package com.alipay.sdk.app;

import com.alipay.sdk.protocol.ActionType;
import com.bangcle.andjni.JniLib;

class PayTask$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 61);
  }
  
  PayTask$1(PayTask paramPayTask, ActionType[] paramArrayOfActionType1, ActionType[] paramArrayOfActionType2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\PayTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */