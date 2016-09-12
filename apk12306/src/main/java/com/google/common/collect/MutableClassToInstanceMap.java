package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Map;

public final class MutableClassToInstanceMap<B>
  extends MapConstraints.ConstrainedMap<Class<? extends B>, B>
  implements ClassToInstanceMap<B>
{
  private static final MapConstraint<Class<?>, Object> VALUE_CAN_BE_CAST_TO_KEY = new MapConstraint()
  {
    static
    {
      JniLib.a(1.class, 693);
    }
    
    public native void checkKeyValue(Class<?> paramAnonymousClass, Object paramAnonymousObject);
  };
  private static final long serialVersionUID = 0L;
  
  static
  {
    JniLib.a(MutableClassToInstanceMap.class, 694);
  }
  
  private MutableClassToInstanceMap(Map<Class<? extends B>, B> paramMap)
  {
    super(paramMap, VALUE_CAN_BE_CAST_TO_KEY);
  }
  
  private static native <B, T extends B> T cast(Class<T> paramClass, B paramB);
  
  public static native <B> MutableClassToInstanceMap<B> create();
  
  public static native <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> paramMap);
  
  public native <T extends B> T getInstance(Class<T> paramClass);
  
  public native <T extends B> T putInstance(Class<T> paramClass, T paramT);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MutableClassToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */