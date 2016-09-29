package com.alipay.android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.bangcle.andjni.JniLib;

public abstract interface IRemoteServiceCallback
  extends IInterface
{
  public abstract boolean isHideLoadingScreen()
    throws RemoteException;
  
  public abstract void payEnd(boolean paramBoolean, String paramString)
    throws RemoteException;
  
  public abstract void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IRemoteServiceCallback
  {
    private static final String DESCRIPTOR = "com.alipay.android.app.IRemoteServiceCallback";
    static final int TRANSACTION_isHideLoadingScreen = 3;
    static final int TRANSACTION_payEnd = 2;
    static final int TRANSACTION_startActivity = 1;
    
    public Stub()
    {
      attachInterface(this, "com.alipay.android.app.IRemoteServiceCallback");
    }
    
    public static IRemoteServiceCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.alipay.android.app.IRemoteServiceCallback");
        if ((localIInterface != null) && ((localIInterface instanceof IRemoteServiceCallback))) {
          paramIBinder = (IRemoteServiceCallback)localIInterface;
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
      int i = 0;
      boolean bool1 = false;
      boolean bool2 = true;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      for (;;)
      {
        return bool1;
        paramParcel2.writeString("com.alipay.android.app.IRemoteServiceCallback");
        bool1 = bool2;
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
        String str2 = paramParcel1.readString();
        String str1 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          startActivity(str2, str1, paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          bool1 = bool2;
          break;
        }
        paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        payEnd(bool1, paramParcel1.readString());
        paramParcel2.writeNoException();
        bool1 = bool2;
        continue;
        paramParcel1.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
        bool1 = isHideLoadingScreen();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        bool1 = bool2;
      }
    }
    
    private static class a
      implements IRemoteServiceCallback
    {
      private IBinder a;
      
      static
      {
        JniLib.a(a.class, 22);
      }
      
      a(IBinder paramIBinder)
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
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\android\app\IRemoteServiceCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */