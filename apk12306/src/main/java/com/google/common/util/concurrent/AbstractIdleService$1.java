package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;

class AbstractIdleService$1
  extends AbstractService
{
  static
  {
    JniLib.a(1.class, 883);
  }
  
  AbstractIdleService$1(AbstractIdleService paramAbstractIdleService) {}
  
  protected final native void doStart();
  
  protected final native void doStop();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractIdleService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */