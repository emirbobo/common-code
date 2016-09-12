package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Executor;

final class MapMaker$1
  implements Executor
{
  static
  {
    JniLib.a(1.class, 609);
  }
  
  public native void execute(Runnable paramRunnable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MapMaker$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */