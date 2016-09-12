package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.map.util.ClassUtil;

public final class BasicClassIntrospector$SetterAndGetterMethodFilter
  extends BasicClassIntrospector.SetterMethodFilter
{
  public boolean includeMethod(Method paramMethod)
  {
    boolean bool2 = true;
    boolean bool1;
    if (super.includeMethod(paramMethod)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (!ClassUtil.hasGetterSignature(paramMethod))
      {
        bool1 = false;
      }
      else
      {
        paramMethod = paramMethod.getReturnType();
        bool1 = bool2;
        if (!Collection.class.isAssignableFrom(paramMethod))
        {
          bool1 = bool2;
          if (!Map.class.isAssignableFrom(paramMethod)) {
            bool1 = false;
          }
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\BasicClassIntrospector$SetterAndGetterMethodFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */