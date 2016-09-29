package com.alipay.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;

class PayTask$5
  extends BroadcastReceiver
{
  static
  {
    JniLib.a(5.class, 68);
  }
  
  PayTask$5(PayTask paramPayTask) {}
  
  public native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\PayTask$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */