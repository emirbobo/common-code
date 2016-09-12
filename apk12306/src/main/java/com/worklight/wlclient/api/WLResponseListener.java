package com.worklight.wlclient.api;

public abstract interface WLResponseListener
{
  public abstract void onFailure(WLFailResponse paramWLFailResponse);
  
  public abstract void onSuccess(WLResponse paramWLResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLResponseListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */