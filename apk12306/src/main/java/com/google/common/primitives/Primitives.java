package com.google.common.primitives;

import com.bangcle.andjni.JniLib;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Primitives
{
  private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;
  private static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;
  
  static
  {
    JniLib.a(Primitives.class, 870);
    HashMap localHashMap1 = new HashMap(16);
    HashMap localHashMap2 = new HashMap(16);
    add(localHashMap1, localHashMap2, Boolean.TYPE, Boolean.class);
    add(localHashMap1, localHashMap2, Byte.TYPE, Byte.class);
    add(localHashMap1, localHashMap2, Character.TYPE, Character.class);
    add(localHashMap1, localHashMap2, Double.TYPE, Double.class);
    add(localHashMap1, localHashMap2, Float.TYPE, Float.class);
    add(localHashMap1, localHashMap2, Integer.TYPE, Integer.class);
    add(localHashMap1, localHashMap2, Long.TYPE, Long.class);
    add(localHashMap1, localHashMap2, Short.TYPE, Short.class);
    add(localHashMap1, localHashMap2, Void.TYPE, Void.class);
    PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(localHashMap1);
    WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(localHashMap2);
  }
  
  private static native void add(Map<Class<?>, Class<?>> paramMap1, Map<Class<?>, Class<?>> paramMap2, Class<?> paramClass1, Class<?> paramClass2);
  
  public static native Set<Class<?>> allPrimitiveTypes();
  
  public static native Set<Class<?>> allWrapperTypes();
  
  public static native boolean isWrapperType(Class<?> paramClass);
  
  public static native <T> Class<T> unwrap(Class<T> paramClass);
  
  public static native <T> Class<T> wrap(Class<T> paramClass);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Primitives.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */