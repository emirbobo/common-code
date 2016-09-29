package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.WLRequestListener;

class WLClient$HeartbeatListener
  implements WLRequestListener
{
  static
  {
    JniLib.a(HeartbeatListener.class, 1288);
  }
  
  WLClient$HeartbeatListener(WLClient paramWLClient) {}
  
  public native void onFailure(WLFailResponse paramWLFailResponse);
  
  public native void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLClient$HeartbeatListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */