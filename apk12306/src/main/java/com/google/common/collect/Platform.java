package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.logging.Logger;

@GwtCompatible(emulated=true)
class Platform
{
  private static final Logger logger = Logger.getLogger(Platform.class.getCanonicalName());
  
  static
  {
    JniLib.a(Platform.class, 701);
  }
  
  static native <T> T[] clone(T[] paramArrayOfT);
  
  @GwtIncompatible("Array.newInstance(Class, int)")
  static native <T> T[] newArray(Class<T> paramClass, int paramInt);
  
  static native <T> T[] newArray(T[] paramArrayOfT, int paramInt);
  
  static native MapMaker tryWeakKeys(MapMaker paramMapMaker);
  
  static native void unsafeArrayCopy(Object[] paramArrayOfObject1, int paramInt1, Object[] paramArrayOfObject2, int paramInt2, int paramInt3);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */