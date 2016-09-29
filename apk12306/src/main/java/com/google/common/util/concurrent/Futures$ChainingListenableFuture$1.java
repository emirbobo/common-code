package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;

class Futures$ChainingListenableFuture$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 896);
  }
  
  Futures$ChainingListenableFuture$1(Futures.ChainingListenableFuture paramChainingListenableFuture, ListenableFuture paramListenableFuture) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures$ChainingListenableFuture$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */