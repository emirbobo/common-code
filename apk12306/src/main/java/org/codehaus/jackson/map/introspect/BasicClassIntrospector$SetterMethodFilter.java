package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BasicClassIntrospector$SetterMethodFilter
  implements MethodFilter
{
  public boolean includeMethod(Method paramMethod)
  {
    boolean bool = false;
    if (Modifier.isStatic(paramMethod.getModifiers())) {}
    for (;;)
    {
      return bool;
      switch (paramMethod.getParameterTypes().length)
      {
      default: 
        break;
      case 1: 
        bool = true;
        break;
      case 2: 
        bool = true;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\BasicClassIntrospector$SetterMethodFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */