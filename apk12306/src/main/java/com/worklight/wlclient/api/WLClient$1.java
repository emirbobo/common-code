package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.WLRequestListener;

class WLClient$1
  implements WLRequestListener
{
  static
  {
    JniLib.a(1.class, 1286);
  }
  
  WLClient$1(WLClient paramWLClient) {}
  
  public native void onFailure(WLFailResponse paramWLFailResponse);
  
  public native void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */