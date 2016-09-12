package net.sqlcipher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

final class BulkCursorProxy
  implements IBulkCursor
{
  private Bundle mExtras;
  private IBinder mRemote;
  
  public BulkCursorProxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
    this.mExtras = null;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void close()
    throws RemoteException
  {
    Parcel localParcel2 = Parcel.obtain();
    Parcel localParcel1 = Parcel.obtain();
    localParcel2.writeInterfaceToken("android.content.IBulkCursor");
    this.mRemote.transact(12, localParcel2, localParcel1, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel1);
    localParcel2.recycle();
    localParcel1.recycle();
  }
  
  public int count()
    throws RemoteException
  {
    Parcel localParcel2 = Parcel.obtain();
    Parcel localParcel1 = Parcel.obtain();
    localParcel2.writeInterfaceToken("android.content.IBulkCursor");
    boolean bool = this.mRemote.transact(2, localParcel2, localParcel1, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel1);
    if (!bool) {}
    for (int i = -1;; i = localParcel1.readInt())
    {
      localParcel2.recycle();
      localParcel1.recycle();
      return i;
    }
  }
  
  public void deactivate()
    throws RemoteException
  {
    Parcel localParcel2 = Parcel.obtain();
    Parcel localParcel1 = Parcel.obtain();
    localParcel2.writeInterfaceToken("android.content.IBulkCursor");
    this.mRemote.transact(6, localParcel2, localParcel1, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel1);
    localParcel2.recycle();
    localParcel1.recycle();
  }
  
  public boolean deleteRow(int paramInt)
    throws RemoteException
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeInt(paramInt);
    this.mRemote.transact(5, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    if (localParcel2.readInt() == 1) {}
    for (;;)
    {
      localParcel1.recycle();
      localParcel2.recycle();
      return bool;
      bool = false;
    }
  }
  
  public String[] getColumnNames()
    throws RemoteException
  {
    Parcel localParcel2 = Parcel.obtain();
    Parcel localParcel1 = Parcel.obtain();
    localParcel2.writeInterfaceToken("android.content.IBulkCursor");
    this.mRemote.transact(3, localParcel2, localParcel1, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel1);
    int j = localParcel1.readInt();
    String[] arrayOfString = new String[j];
    for (int i = 0; i < j; i++) {
      arrayOfString[i] = localParcel1.readString();
    }
    localParcel2.recycle();
    localParcel1.recycle();
    return arrayOfString;
  }
  
  public Bundle getExtras()
    throws RemoteException
  {
    if (this.mExtras == null)
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(10, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      this.mExtras = localParcel2.readBundle();
      localParcel1.recycle();
      localParcel2.recycle();
    }
    return this.mExtras;
  }
  
  public boolean getWantsAllOnMoveCalls()
    throws RemoteException
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    this.mRemote.transact(9, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int i = localParcel2.readInt();
    localParcel1.recycle();
    localParcel2.recycle();
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  public CursorWindow getWindow(int paramInt)
    throws RemoteException
  {
    Parcel localParcel2 = Parcel.obtain();
    Parcel localParcel1 = Parcel.obtain();
    localParcel2.writeInterfaceToken("android.content.IBulkCursor");
    localParcel2.writeInt(paramInt);
    this.mRemote.transact(1, localParcel2, localParcel1, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel1);
    CursorWindow localCursorWindow = null;
    if (localParcel1.readInt() == 1) {
      localCursorWindow = CursorWindow.newFromParcel(localParcel1);
    }
    localParcel2.recycle();
    localParcel1.recycle();
    return localCursorWindow;
  }
  
  public void onMove(int paramInt)
    throws RemoteException
  {
    Parcel localParcel2 = Parcel.obtain();
    Parcel localParcel1 = Parcel.obtain();
    localParcel2.writeInterfaceToken("android.content.IBulkCursor");
    localParcel2.writeInt(paramInt);
    this.mRemote.transact(8, localParcel2, localParcel1, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel1);
    localParcel2.recycle();
    localParcel1.recycle();
  }
  
  public int requery(IContentObserver paramIContentObserver, CursorWindow paramCursorWindow)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeStrongInterface(paramIContentObserver);
    paramCursorWindow.writeToParcel(localParcel1, 0);
    boolean bool = this.mRemote.transact(7, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int i;
    if (!bool) {
      i = -1;
    }
    for (;;)
    {
      localParcel1.recycle();
      localParcel2.recycle();
      return i;
      i = localParcel2.readInt();
      this.mExtras = localParcel2.readBundle();
    }
  }
  
  public Bundle respond(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeBundle(paramBundle);
    this.mRemote.transact(11, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    paramBundle = localParcel2.readBundle();
    localParcel1.recycle();
    localParcel2.recycle();
    return paramBundle;
  }
  
  public boolean updateRows(Map paramMap)
    throws RemoteException
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeMap(paramMap);
    this.mRemote.transact(4, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    if (localParcel2.readInt() == 1) {}
    for (;;)
    {
      localParcel1.recycle();
      localParcel2.recycle();
      return bool;
      bool = false;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\BulkCursorProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */