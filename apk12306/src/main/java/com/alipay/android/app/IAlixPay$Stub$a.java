package com.alipay.android.app;

import android.os.IBinder;
import android.os.RemoteException;
import com.bangcle.andjni.JniLib;

class IAlixPay$Stub$a
  implements IAlixPay
{
  private IBinder a;
  
  static
  {
    JniLib.a(a.class, 21);
  }
  
  IAlixPay$Stub$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public native String Pay(String paramString)
    throws RemoteException;
  
  public native String a();
  
  public native IBinder asBinder();
  
  public native String prePay(String paramString)
    throws RemoteException;
  
  public native void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
    throws RemoteException;
  
  public native String test()
    throws RemoteException;
  
  public native void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
    throws RemoteException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\android\app\IAlixPay$Stub$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */