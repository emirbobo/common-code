package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

public final class AnnotatedParameter
  extends AnnotatedMember
{
  protected final AnnotationMap _annotations;
  protected final AnnotatedMember _owner;
  protected final Type _type;
  
  public AnnotatedParameter(AnnotatedMember paramAnnotatedMember, Type paramType, AnnotationMap paramAnnotationMap)
  {
    this._owner = paramAnnotatedMember;
    this._type = paramType;
    this._annotations = paramAnnotationMap;
  }
  
  public void addOrOverride(Annotation paramAnnotation)
  {
    this._annotations.add(paramAnnotation);
  }
  
  public AnnotatedElement getAnnotated()
  {
    return null;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return this._annotations.get(paramClass);
  }
  
  public Class<?> getDeclaringClass()
  {
    return this._owner.getDeclaringClass();
  }
  
  public Type getGenericType()
  {
    return this._type;
  }
  
  public Member getMember()
  {
    return this._owner.getMember();
  }
  
  public int getModifiers()
  {
    return this._owner.getModifiers();
  }
  
  public String getName()
  {
    return "";
  }
  
  public Type getParameterType()
  {
    return this._type;
  }
  
  public Class<?> getRawType()
  {
    if ((this._type instanceof Class)) {}
    for (Class localClass = (Class)this._type;; localClass = TypeFactory.defaultInstance().constructType(this._type).getRawClass()) {
      return localClass;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\AnnotatedParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */