package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map;

public final class ImmutableClassToInstanceMap<B>
  extends ForwardingMap<Class<? extends B>, B>
  implements ClassToInstanceMap<B>
{
  private final ImmutableMap<Class<? extends B>, B> delegate;
  
  static
  {
    JniLib.a(ImmutableClassToInstanceMap.class, 464);
  }
  
  private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> paramImmutableMap)
  {
    this.delegate = paramImmutableMap;
  }
  
  public static native <B> Builder<B> builder();
  
  public static native <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> paramMap);
  
  protected native Map<Class<? extends B>, B> delegate();
  
  public native <T extends B> T getInstance(Class<T> paramClass);
  
  public native <T extends B> T putInstance(Class<T> paramClass, T paramT);
  
  public static final class Builder<B>
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ImmutableClassToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */