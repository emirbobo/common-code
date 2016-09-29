package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class ObjectArrays
{
  static
  {
    JniLib.a(ObjectArrays.class, 698);
  }
  
  private static native <T> T[] arraysCopyOf(T[] paramArrayOfT, int paramInt);
  
  public static native <T> T[] concat(@Nullable T paramT, T[] paramArrayOfT);
  
  public static native <T> T[] concat(T[] paramArrayOfT, @Nullable T paramT);
  
  @GwtIncompatible("Array.newInstance(Class, int)")
  public static native <T> T[] concat(T[] paramArrayOfT1, T[] paramArrayOfT2, Class<T> paramClass);
  
  private static native Object[] fillArray(Iterable<?> paramIterable, Object[] paramArrayOfObject);
  
  @GwtIncompatible("Array.newInstance(Class, int)")
  public static native <T> T[] newArray(Class<T> paramClass, int paramInt);
  
  public static native <T> T[] newArray(T[] paramArrayOfT, int paramInt);
  
  static native void swap(Object[] paramArrayOfObject, int paramInt1, int paramInt2);
  
  static native Object[] toArrayImpl(Collection<?> paramCollection);
  
  static native <T> T[] toArrayImpl(Collection<?> paramCollection, T[] paramArrayOfT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ObjectArrays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */