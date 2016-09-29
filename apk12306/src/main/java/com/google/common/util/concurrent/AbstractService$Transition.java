package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class AbstractService$Transition
  extends AbstractListenableFuture<Service.State>
{
  static
  {
    JniLib.a(Transition.class, 885);
  }
  
  private AbstractService$Transition(AbstractService paramAbstractService) {}
  
  public native Service.State get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException, ExecutionException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\AbstractService$Transition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */