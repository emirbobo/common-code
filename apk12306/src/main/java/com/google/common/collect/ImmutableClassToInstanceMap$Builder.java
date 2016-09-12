package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map;

public final class ImmutableClassToInstanceMap$Builder<B>
{
  private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();
  
  static
  {
    JniLib.a(Builder.class, 463);
  }
  
  private static native <B, T extends B> T cast(Class<T> paramClass, B paramB);
  
  public native ImmutableClassToInstanceMap<B> build();
  
  public native <T extends B> Builder<B> put(Class<T> paramClass, T paramT);
  
  public native <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> paramMap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableClassToInstanceMap$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */