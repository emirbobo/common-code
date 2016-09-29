package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMapValues<V>
  extends Synchronized.SynchronizedCollection<Collection<V>>
{
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(SynchronizedAsMapValues.class, 786);
  }
  
  Synchronized$SynchronizedAsMapValues(Collection<Collection<V>> paramCollection, @Nullable Object paramObject)
  {
    super(paramCollection, paramObject, null);
  }
  
  public native Iterator<Collection<V>> iterator();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedAsMapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */