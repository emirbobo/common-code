package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable=true)
final class UsingToStringOrdering
  extends Ordering<Object>
  implements Serializable
{
  static final UsingToStringOrdering INSTANCE = new UsingToStringOrdering();
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(UsingToStringOrdering.class, 812);
  }
  
  private native Object readResolve();
  
  public native int compare(Object paramObject1, Object paramObject2);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\UsingToStringOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */