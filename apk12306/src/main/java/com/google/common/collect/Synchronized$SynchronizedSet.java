package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSet<E>
  extends Synchronized.SynchronizedCollection<E>
  implements Set<E>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SynchronizedSet.class, 783);
  }
  
  Synchronized$SynchronizedSet(Set<E> paramSet, @Nullable Object paramObject)
  {
    super(paramSet, paramObject, null);
  }
  
  native Set<E> delegate();
  
  public native boolean equals(Object paramObject);
  
  public native int hashCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */