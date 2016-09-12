package net.sqlcipher;

import android.os.IBinder;

class IContentObserver$Stub$Proxy
  implements IContentObserver
{
  private IBinder mRemote;
  
  IContentObserver$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "net.sqlcipher.IContentObserver";
  }
  
  /* Error */
  public void onChange(boolean paramBoolean)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: aload_3
    //   7: ldc 26
    //   9: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: ifeq +27 -> 40
    //   16: aload_3
    //   17: iload_2
    //   18: invokevirtual 44	android/os/Parcel:writeInt	(I)V
    //   21: aload_0
    //   22: getfield 19	net/sqlcipher/IContentObserver$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   25: iconst_1
    //   26: aload_3
    //   27: aconst_null
    //   28: iconst_1
    //   29: invokeinterface 50 5 0
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 53	android/os/Parcel:recycle	()V
    //   39: return
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -26 -> 16
    //   45: astore 4
    //   47: aload_3
    //   48: invokevirtual 53	android/os/Parcel:recycle	()V
    //   51: aload 4
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	Proxy
    //   0	54	1	paramBoolean	boolean
    //   1	41	2	i	int
    //   5	43	3	localParcel	android.os.Parcel
    //   45	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	45	finally
    //   16	35	45	finally
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\IContentObserver$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */