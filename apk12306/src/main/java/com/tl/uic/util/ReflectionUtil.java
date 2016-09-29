package com.tl.uic.util;

import com.bangcle.andjni.JniLib;
import java.lang.reflect.Method;

public final class ReflectionUtil
{
  private static volatile ReflectionUtil _myInstance;
  
  static
  {
    JniLib.a(ReflectionUtil.class, 1124);
  }
  
  public static native Object getField(Object paramObject, String paramString);
  
  public static native ReflectionUtil getInstance();
  
  public static Method getMethod(Object paramObject, String paramString, Class... paramVarArgs)
  {
    localObject = null;
    try
    {
      paramObject = paramObject.getClass().getDeclaredMethod(paramString, paramVarArgs);
      localObject = paramObject;
      ((Method)paramObject).setAccessible(true);
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        LogInternal.logException((Throwable)paramObject);
        paramObject = localObject;
      }
    }
    return (Method)paramObject;
  }
  
  public static Method getStaticMethod(Class paramClass, String paramString, Class... paramVarArgs)
  {
    Object localObject = null;
    if ((paramClass == null) || (paramString == null) || (paramVarArgs == null)) {
      localObject = null;
    }
    for (;;)
    {
      return (Method)localObject;
      try
      {
        paramClass = paramClass.getClass().getDeclaredMethod(paramString, paramVarArgs);
        localObject = paramClass;
        paramClass.setAccessible(true);
        localObject = paramClass;
      }
      catch (Exception paramClass)
      {
        for (;;)
        {
          LogInternal.logException(paramClass);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\ReflectionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */