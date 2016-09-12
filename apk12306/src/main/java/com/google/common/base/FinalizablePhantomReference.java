package com.google.common.base;

import java.lang.ref.PhantomReference;

public abstract class FinalizablePhantomReference<T>
  extends PhantomReference<T>
  implements FinalizableReference
{
  protected FinalizablePhantomReference(T paramT, FinalizableReferenceQueue paramFinalizableReferenceQueue)
  {
    super(paramT, paramFinalizableReferenceQueue.queue);
    paramFinalizableReferenceQueue.cleanUp();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\FinalizablePhantomReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */