package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.annotation.Nullable;

class Synchronized$SynchronizedObject
  implements Serializable
{
  @GwtIncompatible("not needed in emulated source")
  private static final long serialVersionUID = 0L;
  final Object delegate;
  final Object mutex;
  
  static
  {
    JniLib.a(SynchronizedObject.class, 777);
  }
  
  Synchronized$SynchronizedObject(Object paramObject1, @Nullable Object paramObject2)
  {
    this.delegate = Preconditions.checkNotNull(paramObject1);
    paramObject1 = paramObject2;
    if (paramObject2 == null) {
      paramObject1 = this;
    }
    this.mutex = paramObject1;
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private native void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException;
  
  native Object delegate();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Synchronized$SynchronizedObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */