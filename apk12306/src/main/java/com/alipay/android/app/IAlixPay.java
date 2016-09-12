package com.alipay.android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bangcle.andjni.JniLib;

public abstract interface IAlixPay
  extends IInterface
{
  public abstract String Pay(String paramString)
    throws RemoteException;
  
  public abstract String prePay(String paramString)
    throws RemoteException;
  
  public abstract void registerCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
    throws RemoteException;
  
  public abstract String test()
    throws RemoteException;
  
  public abstract void unregisterCallback(IRemoteServiceCallback paramIRemoteServiceCallback)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IAlixPay
  {
    private static final String DESCRIPTOR = "com.alipay.android.app.IAlixPay";
    static final int TRANSACTION_Pay = 1;
    static final int TRANSACTION_prePay = 5;
    static final int TRANSACTION_registerCallback = 3;
    static final int TRANSACTION_test = 2;
    static final int TRANSACTION_unregisterCallback = 4;
    
    public Stub()
    {
      attachInterface(this, "com.alipay.android.app.IAlixPay");
    }
    
    public static IAlixPay asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.alipay.android.app.IAlixPay");
        if ((localIInterface != null) && ((localIInterface instanceof IAlixPay))) {
          paramIBinder = (IAlixPay)localIInterface;
        } else {
          paramIBinder = new a(paramIBinder);
        }
      }
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool = true;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      for (;;)
      {
        return bool;
        paramParcel2.writeString("com.alipay.android.app.IAlixPay");
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        paramParcel1 = Pay(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        paramParcel1 = test();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        registerCallback(IRemoteServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        unregisterCallback(IRemoteServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IAlixPay");
        paramParcel1 = prePay(paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
      }
    }
    
    private static class a
      implements IAlixPay
    {
      private IBinder a;
      
      static
      {
        JniLib.a(a.class, 21);
      }
      
      a(IBinder paramIBinder)
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
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\android\app\IAlixPay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */