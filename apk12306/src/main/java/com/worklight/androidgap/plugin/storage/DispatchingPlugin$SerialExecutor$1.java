package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;

class DispatchingPlugin$SerialExecutor$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 1221);
  }
  
  DispatchingPlugin$SerialExecutor$1(DispatchingPlugin.SerialExecutor paramSerialExecutor, Runnable paramRunnable) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\DispatchingPlugin$SerialExecutor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */