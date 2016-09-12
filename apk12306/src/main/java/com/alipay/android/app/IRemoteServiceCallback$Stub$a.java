package com.alipay.android.app;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.bangcle.andjni.JniLib;

class IRemoteServiceCallback$Stub$a
  implements IRemoteServiceCallback
{
  private IBinder a;
  
  static
  {
    JniLib.a(a.class, 22);
  }
  
  IRemoteServiceCallback$Stub$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public native String a();
  
  public native IBinder asBinder();
  
  public native boolean isHideLoadingScreen()
    throws RemoteException;
  
  public native void payEnd(boolean paramBoolean, String paramString)
    throws RemoteException;
  
  public native void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
    throws RemoteException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\android\app\IRemoteServiceCallback$Stub$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */