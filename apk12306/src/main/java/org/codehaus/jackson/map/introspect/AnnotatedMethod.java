package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.type.JavaType;

public final class AnnotatedMethod
  extends AnnotatedWithParams
{
  protected final Method _method;
  protected Class<?>[] _paramTypes;
  
  public AnnotatedMethod(Method paramMethod, AnnotationMap paramAnnotationMap, AnnotationMap[] paramArrayOfAnnotationMap)
  {
    super(paramAnnotationMap, paramArrayOfAnnotationMap);
    this._method = paramMethod;
  }
  
  public Method getAnnotated()
  {
    return this._method;
  }
  
  public Class<?> getDeclaringClass()
  {
    return this._method.getDeclaringClass();
  }
  
  public String getFullName()
  {
    return getDeclaringClass().getName() + "#" + getName() + "(" + getParameterCount() + " params)";
  }
  
  public Type getGenericType()
  {
    return this._method.getGenericReturnType();
  }
  
  public Member getMember()
  {
    return this._method;
  }
  
  public int getModifiers()
  {
    return this._method.getModifiers();
  }
  
  public String getName()
  {
    return this._method.getName();
  }
  
  public AnnotatedParameter getParameter(int paramInt)
  {
    return new AnnotatedParameter(this, getParameterType(paramInt), this._paramAnnotations[paramInt]);
  }
  
  public Class<?> getParameterClass(int paramInt)
  {
    Object localObject = this._method.getParameterTypes();
    if (paramInt >= localObject.length) {}
    for (localObject = null;; localObject = localObject[paramInt]) {
      return (Class<?>)localObject;
    }
  }
  
  public Class<?>[] getParameterClasses()
  {
    if (this._paramTypes == null) {
      this._paramTypes = this._method.getParameterTypes();
    }
    return this._paramTypes;
  }
  
  public int getParameterCount()
  {
    return getParameterTypes().length;
  }
  
  public Type getParameterType(int paramInt)
  {
    Object localObject = this._method.getGenericParameterTypes();
    if (paramInt >= localObject.length) {}
    for (localObject = null;; localObject = localObject[paramInt]) {
      return (Type)localObject;
    }
  }
  
  public Type[] getParameterTypes()
  {
    return this._method.getGenericParameterTypes();
  }
  
  public Class<?> getRawType()
  {
    return this._method.getReturnType();
  }
  
  public JavaType getType(TypeBindings paramTypeBindings)
  {
    return getType(paramTypeBindings, this._method.getTypeParameters());
  }
  
  public String toString()
  {
    return "[method " + getName() + ", annotations: " + this._annotations + "]";
  }
  
  public AnnotatedMethod withMethod(Method paramMethod)
  {
    return new AnnotatedMethod(paramMethod, this._annotations, this._paramAnnotations);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\AnnotatedMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */