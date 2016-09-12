package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.util.ClassUtil;

final class Creator$NumberBased
{
  protected final Constructor<?> _intCtor;
  protected final Method _intFactoryMethod;
  protected final Constructor<?> _longCtor;
  protected final Method _longFactoryMethod;
  protected final Class<?> _valueClass;
  
  public Creator$NumberBased(Class<?> paramClass, AnnotatedConstructor paramAnnotatedConstructor1, AnnotatedMethod paramAnnotatedMethod1, AnnotatedConstructor paramAnnotatedConstructor2, AnnotatedMethod paramAnnotatedMethod2)
  {
    this._valueClass = paramClass;
    if (paramAnnotatedConstructor1 == null)
    {
      paramClass = null;
      this._intCtor = paramClass;
      if (paramAnnotatedConstructor2 != null) {
        break label68;
      }
      paramClass = null;
      label30:
      this._longCtor = paramClass;
      if (paramAnnotatedMethod1 != null) {
        break label77;
      }
      paramClass = null;
      label41:
      this._intFactoryMethod = paramClass;
      if (paramAnnotatedMethod2 != null) {
        break label85;
      }
    }
    label68:
    label77:
    label85:
    for (paramClass = (Class<?>)localObject;; paramClass = paramAnnotatedMethod2.getAnnotated())
    {
      this._longFactoryMethod = paramClass;
      return;
      paramClass = paramAnnotatedConstructor1.getAnnotated();
      break;
      paramClass = paramAnnotatedConstructor2.getAnnotated();
      break label30;
      paramClass = paramAnnotatedMethod1.getAnnotated();
      break label41;
    }
  }
  
  public Object construct(int paramInt)
  {
    try
    {
      if (this._intCtor != null) {}
      for (Object localObject1 = this._intCtor.newInstance(new Object[] { Integer.valueOf(paramInt) });; localObject1 = this._intFactoryMethod.invoke(this._valueClass, new Object[] { Integer.valueOf(paramInt) }))
      {
        return localObject1;
        if (this._intFactoryMethod == null) {
          break;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ClassUtil.unwrapAndThrowAsIAE(localException);
        Object localObject2 = construct(paramInt);
      }
    }
  }
  
  public Object construct(long paramLong)
  {
    try
    {
      if (this._longCtor != null) {}
      for (Object localObject1 = this._longCtor.newInstance(new Object[] { Long.valueOf(paramLong) });; localObject1 = this._longFactoryMethod.invoke(this._valueClass, new Object[] { Long.valueOf(paramLong) }))
      {
        return localObject1;
        if (this._longFactoryMethod == null) {
          break;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ClassUtil.unwrapAndThrowAsIAE(localException);
        Object localObject2 = null;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\Creator$NumberBased.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */