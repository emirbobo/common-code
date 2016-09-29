package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.util.ClassUtil;

final class Creator$StringBased
{
  protected final Constructor<?> _ctor;
  protected final Method _factoryMethod;
  protected final Class<?> _valueClass;
  
  public Creator$StringBased(Class<?> paramClass, AnnotatedConstructor paramAnnotatedConstructor, AnnotatedMethod paramAnnotatedMethod)
  {
    this._valueClass = paramClass;
    if (paramAnnotatedConstructor == null)
    {
      paramClass = null;
      this._ctor = paramClass;
      if (paramAnnotatedMethod != null) {
        break label44;
      }
    }
    label44:
    for (paramClass = (Class<?>)localObject;; paramClass = paramAnnotatedMethod.getAnnotated())
    {
      this._factoryMethod = paramClass;
      return;
      paramClass = paramAnnotatedConstructor.getAnnotated();
      break;
    }
  }
  
  public Object construct(String paramString)
  {
    try
    {
      if (this._ctor != null) {}
      for (paramString = this._ctor.newInstance(new Object[] { paramString });; paramString = this._factoryMethod.invoke(this._valueClass, new Object[] { paramString }))
      {
        return paramString;
        if (this._factoryMethod == null) {
          break;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ClassUtil.unwrapAndThrowAsIAE(paramString);
        paramString = null;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\Creator$StringBased.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */