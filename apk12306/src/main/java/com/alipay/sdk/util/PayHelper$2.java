package com.alipay.sdk.util;

import android.os.Bundle;
import android.os.RemoteException;
import com.alipay.android.app.IRemoteServiceCallback.Stub;
import com.bangcle.andjni.JniLib;

class PayHelper$2
  extends IRemoteServiceCallback.Stub
{
  static
  {
    JniLib.a(2.class, 137);
  }
  
  PayHelper$2(PayHelper paramPayHelper) {}
  
  public native boolean isHideLoadingScreen()
    throws RemoteException;
  
  public native void payEnd(boolean paramBoolean, String paramString)
    throws RemoteException;
  
  public native void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
    throws RemoteException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\PayHelper$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */