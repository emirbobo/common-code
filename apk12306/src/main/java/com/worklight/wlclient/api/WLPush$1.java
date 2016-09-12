package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;

class WLPush$1
  implements WLResponseListener
{
  static
  {
    JniLib.a(1.class, 1299);
  }
  
  WLPush$1(WLPush paramWLPush) {}
  
  public native void onFailure(WLFailResponse paramWLFailResponse);
  
  public native void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */