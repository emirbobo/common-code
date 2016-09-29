package net.sqlcipher;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract class BulkCursorNative
  extends Binder
  implements IBulkCursor
{
  public BulkCursorNative()
  {
    attachInterface(this, "android.content.IBulkCursor");
  }
  
  public static IBulkCursor asInterface(IBinder paramIBinder)
  {
    Object localObject;
    if (paramIBinder == null) {
      localObject = null;
    }
    for (;;)
    {
      return (IBulkCursor)localObject;
      IBulkCursor localIBulkCursor = (IBulkCursor)paramIBinder.queryLocalInterface("android.content.IBulkCursor");
      localObject = localIBulkCursor;
      if (localIBulkCursor == null) {
        localObject = new BulkCursorProxy(paramIBinder);
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
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    for (;;)
    {
      return bool;
      try
      {
        paramParcel1.enforceInterface("android.content.IBulkCursor");
        paramParcel1 = getWindow(paramParcel1.readInt());
        if (paramParcel1 == null)
        {
          paramParcel2.writeInt(0);
          bool = true;
          continue;
        }
        paramParcel2.writeNoException();
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 0);
        bool = true;
      }
      catch (Exception paramParcel1)
      {
        DatabaseUtils.writeExceptionToParcel(paramParcel2, paramParcel1);
        bool = true;
      }
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramInt1 = count();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      bool = true;
      continue;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = getColumnNames();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramParcel1.length);
      paramInt2 = paramParcel1.length;
      for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
        paramParcel2.writeString(paramParcel1[paramInt1]);
      }
      bool = true;
      continue;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      deactivate();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      close();
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramInt1 = requery(IContentObserver.Stub.asInterface(paramParcel1.readStrongBinder()), (CursorWindow)CursorWindow.CREATOR.createFromParcel(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      paramParcel2.writeBundle(getExtras());
      bool = true;
      continue;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      bool = updateRows(paramParcel1.readHashMap(null));
      paramParcel2.writeNoException();
      if (bool == true) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      bool = deleteRow(paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (bool == true) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      onMove(paramParcel1.readInt());
      paramParcel2.writeNoException();
      bool = true;
      continue;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      bool = getWantsAllOnMoveCalls();
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        bool = true;
        break;
      }
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = getExtras();
      paramParcel2.writeNoException();
      paramParcel2.writeBundle(paramParcel1);
      bool = true;
      continue;
      paramParcel1.enforceInterface("android.content.IBulkCursor");
      paramParcel1 = respond(paramParcel1.readBundle());
      paramParcel2.writeNoException();
      paramParcel2.writeBundle(paramParcel1);
      bool = true;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\BulkCursorNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */