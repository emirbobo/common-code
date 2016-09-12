package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.WLRequestListener;

class WLClient$InvokeProcedureRequestListener
  implements WLRequestListener
{
  static
  {
    JniLib.a(InvokeProcedureRequestListener.class, 1290);
  }
  
  WLClient$InvokeProcedureRequestListener(WLClient paramWLClient) {}
  
  public native void onFailure(WLFailResponse paramWLFailResponse);
  
  public native void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLClient$InvokeProcedureRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */