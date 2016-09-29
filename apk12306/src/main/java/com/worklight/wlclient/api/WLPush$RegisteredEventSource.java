package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;

class WLPush$RegisteredEventSource
{
  private String adapter;
  private String eventSource;
  private WLEventSourceListener eventSourceListener;
  
  static
  {
    JniLib.a(RegisteredEventSource.class, 1304);
  }
  
  WLPush$RegisteredEventSource(WLPush paramWLPush) {}
  
  public native String getAdapter();
  
  public native String getEventSource();
  
  public native WLEventSourceListener getEventSourceListener();
  
  public native void setAdapter(String paramString);
  
  public native void setEventSource(String paramString);
  
  public native void setEventSourceListener(WLEventSourceListener paramWLEventSourceListener);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLPush$RegisteredEventSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */