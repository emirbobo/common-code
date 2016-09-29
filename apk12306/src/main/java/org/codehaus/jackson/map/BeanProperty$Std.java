package org.codehaus.jackson.map;

import java.lang.annotation.Annotation;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

public class BeanProperty$Std
  implements BeanProperty
{
  protected final Annotations _contextAnnotations;
  protected final AnnotatedMember _member;
  protected final String _name;
  protected final JavaType _type;
  
  public BeanProperty$Std(String paramString, JavaType paramJavaType, Annotations paramAnnotations, AnnotatedMember paramAnnotatedMember)
  {
    this._name = paramString;
    this._type = paramJavaType;
    this._member = paramAnnotatedMember;
    this._contextAnnotations = paramAnnotations;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return this._member.getAnnotation(paramClass);
  }
  
  public <A extends Annotation> A getContextAnnotation(Class<A> paramClass)
  {
    if (this._contextAnnotations == null) {}
    for (paramClass = null;; paramClass = this._contextAnnotations.get(paramClass)) {
      return paramClass;
    }
  }
  
  public AnnotatedMember getMember()
  {
    return this._member;
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public JavaType getType()
  {
    return this._type;
  }
  
  public Std withType(JavaType paramJavaType)
  {
    return new Std(this._name, paramJavaType, this._contextAnnotations, this._member);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\BeanProperty$Std.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */