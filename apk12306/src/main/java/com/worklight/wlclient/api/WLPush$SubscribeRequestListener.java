package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.WLRequestListener;

class WLPush$SubscribeRequestListener
  implements WLRequestListener
{
  private String alias;
  
  static
  {
    JniLib.a(SubscribeRequestListener.class, 1305);
  }
  
  public WLPush$SubscribeRequestListener(WLPush paramWLPush, String paramString)
  {
    this.alias = paramString;
  }
  
  public native void onFailure(WLFailResponse paramWLFailResponse);
  
  public native void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush$SubscribeRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */