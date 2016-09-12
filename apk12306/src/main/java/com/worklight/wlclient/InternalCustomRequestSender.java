package com.worklight.wlclient;

import com.bangcle.andjni.JniLib;
import com.worklight.wlclient.api.WLResponseListener;
import org.apache.http.client.methods.HttpRequestBase;

class InternalCustomRequestSender
  implements Runnable
{
  HttpRequestBase httpRequest;
  WLResponseListener listener;
  int requestTimeoutInMilliseconds;
  
  static
  {
    JniLib.a(InternalCustomRequestSender.class, 1282);
  }
  
  protected InternalCustomRequestSender(HttpRequestBase paramHttpRequestBase, int paramInt, WLResponseListener paramWLResponseListener)
  {
    this.httpRequest = paramHttpRequestBase;
    this.requestTimeoutInMilliseconds = paramInt;
    this.listener = paramWLResponseListener;
  }
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\InternalCustomRequestSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */