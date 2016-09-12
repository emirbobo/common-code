package com.google.common.base;

import java.lang.ref.SoftReference;

public abstract class FinalizableSoftReference<T>
  extends SoftReference<T>
  implements FinalizableReference
{
  protected FinalizableSoftReference(T paramT, FinalizableReferenceQueue paramFinalizableReferenceQueue)
  {
    super(paramT, paramFinalizableReferenceQueue.queue);
    paramFinalizableReferenceQueue.cleanUp();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\FinalizableSoftReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */