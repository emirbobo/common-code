package com.worklight.wlclient;

import com.bangcle.andjni.JniLib;
import org.apache.http.client.HttpClient;

class InternalRequestSender
  implements Runnable
{
  WLRequest request;
  
  static
  {
    JniLib.a(InternalRequestSender.class, 1283);
  }
  
  protected InternalRequestSender(WLRequest paramWLRequest)
  {
    this.request = paramWLRequest;
  }
  
  private native void addInstanceAuthHeader();
  
  private native void setConnectionTimeout(HttpClient paramHttpClient);
  
  private native void setUserAgentHeader(HttpClient paramHttpClient);
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\InternalRequestSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */