package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.WLRequestListener;

class WLPush$UpdateTokenListener
  implements WLRequestListener
{
  static
  {
    JniLib.a(UpdateTokenListener.class, 1307);
  }
  
  public WLPush$UpdateTokenListener(WLPush paramWLPush) {}
  
  public native void onFailure(WLFailResponse paramWLFailResponse);
  
  public native void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush$UpdateTokenListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */