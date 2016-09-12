package com.worklight.wlclient;

import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResponse;

public abstract interface WLRequestListener
{
  public abstract void onFailure(WLFailResponse paramWLFailResponse);
  
  public abstract void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\WLRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */