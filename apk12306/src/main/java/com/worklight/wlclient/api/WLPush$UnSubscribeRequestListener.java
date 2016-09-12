package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.WLRequestListener;

class WLPush$UnSubscribeRequestListener
  implements WLRequestListener
{
  private String alias;
  
  static
  {
    JniLib.a(UnSubscribeRequestListener.class, 1306);
  }
  
  public WLPush$UnSubscribeRequestListener(WLPush paramWLPush, String paramString)
  {
    this.alias = paramString;
  }
  
  public native void onFailure(WLFailResponse paramWLFailResponse);
  
  public native void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush$UnSubscribeRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */