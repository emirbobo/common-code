package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;

class AbstractExecutionThreadService$1
  extends AbstractService
{
  static
  {
    JniLib.a(1.class, 878);
  }
  
  AbstractExecutionThreadService$1(AbstractExecutionThreadService paramAbstractExecutionThreadService) {}
  
  protected final native void doStart();
  
  protected native void doStop();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractExecutionThreadService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */