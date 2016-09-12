package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;

class WLPush$2
  implements WLResponseListener
{
  static
  {
    JniLib.a(2.class, 1300);
  }
  
  WLPush$2(WLPush paramWLPush) {}
  
  public native void onFailure(WLFailResponse paramWLFailResponse);
  
  public native void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */