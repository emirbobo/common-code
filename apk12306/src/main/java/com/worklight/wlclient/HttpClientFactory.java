package com.worklight.wlclient;

import com.bangcle.andjni.JniLib;
import com.worklight.common.WLConfig;
import org.apache.http.impl.client.DefaultHttpClient;

class HttpClientFactory
{
  private static final int SOCKET_OPERATION_TIMEOUT = 60000;
  private static DefaultHttpClient client;
  
  static
  {
    JniLib.a(HttpClientFactory.class, 1281);
  }
  
  public static native DefaultHttpClient getInstance(WLConfig paramWLConfig)
    throws RuntimeException;
  
  static native void releaseInstance();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\HttpClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */