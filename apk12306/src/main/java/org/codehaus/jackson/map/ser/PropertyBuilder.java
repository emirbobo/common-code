package org.codehaus.jackson.map.ser;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

public class PropertyBuilder
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final BasicBeanDescription _beanDesc;
  protected final SerializationConfig _config;
  protected Object _defaultBean;
  protected final JsonSerialize.Inclusion _outputProps;
  
  public PropertyBuilder(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    this._config = paramSerializationConfig;
    this._beanDesc = paramBasicBeanDescription;
    this._outputProps = paramBasicBeanDescription.findSerializationInclusion(paramSerializationConfig.getSerializationInclusion());
    this._annotationIntrospector = this._config.getAnnotationIntrospector();
  }
  
  protected Object _throwWrapped(Exception paramException, String paramString, Object paramObject)
  {
    while (paramException.getCause() != null) {
      paramException = paramException.getCause();
    }
    if ((paramException instanceof Error)) {
      throw ((Error)paramException);
    }
    if ((paramException instanceof RuntimeException)) {
      throw ((RuntimeException)paramException);
    }
    throw new IllegalArgumentException("Failed to get property '" + paramString + "' of default " + paramObject.getClass().getName() + " instance");
  }
  
  protected BeanPropertyWriter buildWriter(String paramString, JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer, TypeSerializer paramTypeSerializer1, TypeSerializer paramTypeSerializer2, AnnotatedMember paramAnnotatedMember, boolean paramBoolean)
  {
    Method localMethod;
    if ((paramAnnotatedMember instanceof AnnotatedField)) {
      localMethod = null;
    }
    for (Field localField = ((AnnotatedField)paramAnnotatedMember).getAnnotated();; localField = null)
    {
      localObject2 = findSerializationType(paramAnnotatedMember, paramBoolean, paramJavaType);
      localObject1 = localObject2;
      if (paramTypeSerializer2 == null) {
        break label149;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramJavaType;
      }
      if (((JavaType)localObject1).getContentType() != null) {
        break;
      }
      throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + paramString + "' (of type " + this._beanDesc.getType() + "); serialization type " + localObject1 + " has no content");
      localMethod = ((AnnotatedMethod)paramAnnotatedMember).getAnnotated();
    }
    Object localObject1 = ((JavaType)localObject1).withContentTypeHandler(paramTypeSerializer2);
    ((JavaType)localObject1).getContentType();
    label149:
    Object localObject2 = null;
    boolean bool = false;
    JsonSerialize.Inclusion localInclusion = this._annotationIntrospector.findSerializationInclusion(paramAnnotatedMember, this._outputProps);
    paramBoolean = bool;
    paramTypeSerializer2 = (TypeSerializer)localObject2;
    if (localInclusion != null) {
      switch (localInclusion)
      {
      default: 
        paramTypeSerializer2 = (TypeSerializer)localObject2;
        paramBoolean = bool;
      }
    }
    for (;;)
    {
      return new BeanPropertyWriter(paramAnnotatedMember, this._beanDesc.getClassAnnotations(), paramString, paramJavaType, paramJsonSerializer, paramTypeSerializer1, (JavaType)localObject1, localMethod, localField, paramBoolean, paramTypeSerializer2);
      localObject2 = getDefaultValue(paramString, localMethod, localField);
      paramBoolean = bool;
      paramTypeSerializer2 = (TypeSerializer)localObject2;
      if (localObject2 == null)
      {
        paramBoolean = true;
        paramTypeSerializer2 = (TypeSerializer)localObject2;
        continue;
        paramBoolean = true;
        paramTypeSerializer2 = (TypeSerializer)localObject2;
      }
    }
  }
  
  protected JavaType findSerializationType(Annotated paramAnnotated, boolean paramBoolean, JavaType paramJavaType)
  {
    Object localObject2 = this._annotationIntrospector.findSerializationType(paramAnnotated);
    Object localObject1 = paramJavaType;
    boolean bool;
    if (localObject2 != null)
    {
      localObject1 = paramJavaType.getRawClass();
      if (((Class)localObject2).isAssignableFrom((Class)localObject1))
      {
        localObject1 = paramJavaType.widenBy((Class)localObject2);
        paramBoolean = true;
      }
    }
    else
    {
      localObject2 = BeanSerializerFactory.modifySecondaryTypesByAnnotation(this._config, paramAnnotated, (JavaType)localObject1);
      paramJavaType = (JavaType)localObject1;
      if (localObject2 != localObject1)
      {
        paramBoolean = true;
        paramJavaType = (JavaType)localObject2;
      }
      bool = paramBoolean;
      if (!paramBoolean)
      {
        paramAnnotated = this._annotationIntrospector.findSerializationTyping(paramAnnotated);
        bool = paramBoolean;
        if (paramAnnotated != null)
        {
          if (paramAnnotated != JsonSerialize.Typing.STATIC) {
            break label188;
          }
          bool = true;
        }
      }
      label104:
      if (!bool) {
        break label194;
      }
    }
    for (;;)
    {
      return paramJavaType;
      if (!((Class)localObject1).isAssignableFrom((Class)localObject2)) {
        throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + paramAnnotated.getName() + "': class " + ((Class)localObject2).getName() + " not a super-type of (declared) class " + ((Class)localObject1).getName());
      }
      localObject1 = paramJavaType.forcedNarrowBy((Class)localObject2);
      break;
      label188:
      bool = false;
      break label104;
      label194:
      paramJavaType = null;
    }
  }
  
  public Annotations getClassAnnotations()
  {
    return this._beanDesc.getClassAnnotations();
  }
  
  protected Object getDefaultBean()
  {
    if (this._defaultBean == null)
    {
      this._defaultBean = this._beanDesc.instantiateBean(this._config.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS));
      if (this._defaultBean == null)
      {
        Class localClass = this._beanDesc.getClassInfo().getAnnotated();
        throw new IllegalArgumentException("Class " + localClass.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
      }
    }
    return this._defaultBean;
  }
  
  protected Object getDefaultValue(String paramString, Method paramMethod, Field paramField)
  {
    localObject = getDefaultBean();
    if (paramMethod != null) {}
    for (;;)
    {
      try
      {
        paramMethod = paramMethod.invoke(localObject, new Object[0]);
        paramString = paramMethod;
      }
      catch (Exception paramMethod)
      {
        paramString = _throwWrapped(paramMethod, paramString, localObject);
        continue;
      }
      return paramString;
      paramMethod = paramField.get(localObject);
      paramString = paramMethod;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\PropertyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */