package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ClassIntrospector;
import org.codehaus.jackson.map.ClassIntrospector.MixInResolver;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BasicClassIntrospector
  extends ClassIntrospector<BasicBeanDescription>
{
  public static final GetterMethodFilter DEFAULT_GETTER_FILTER = new GetterMethodFilter(null);
  public static final SetterAndGetterMethodFilter DEFAULT_SETTER_AND_GETTER_FILTER = new SetterAndGetterMethodFilter();
  public static final SetterMethodFilter DEFAULT_SETTER_FILTER = new SetterMethodFilter();
  public static final BasicClassIntrospector instance = new BasicClassIntrospector();
  
  public BasicBeanDescription forClassAnnotations(MapperConfig<?> paramMapperConfig, Class<?> paramClass, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    boolean bool = paramMapperConfig.isAnnotationProcessingEnabled();
    AnnotationIntrospector localAnnotationIntrospector = paramMapperConfig.getAnnotationIntrospector();
    if (bool) {}
    for (;;)
    {
      paramMixInResolver = AnnotatedClass.construct(paramClass, localAnnotationIntrospector, paramMixInResolver);
      return new BasicBeanDescription(paramMapperConfig, paramMapperConfig.constructType(paramClass), paramMixInResolver);
      localAnnotationIntrospector = null;
    }
  }
  
  public BasicBeanDescription forCreation(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    boolean bool = paramDeserializationConfig.isAnnotationProcessingEnabled();
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationConfig.getAnnotationIntrospector();
    Class localClass = paramJavaType.getRawClass();
    if (bool) {}
    for (;;)
    {
      paramMixInResolver = AnnotatedClass.construct(localClass, localAnnotationIntrospector, paramMixInResolver);
      paramMixInResolver.resolveCreators(true);
      return new BasicBeanDescription(paramDeserializationConfig, paramJavaType, paramMixInResolver);
      localAnnotationIntrospector = null;
    }
  }
  
  public BasicBeanDescription forDeserialization(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    boolean bool = paramDeserializationConfig.isAnnotationProcessingEnabled();
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationConfig.getAnnotationIntrospector();
    Class localClass = paramJavaType.getRawClass();
    if (bool) {}
    for (;;)
    {
      paramMixInResolver = AnnotatedClass.construct(localClass, localAnnotationIntrospector, paramMixInResolver);
      paramMixInResolver.resolveMemberMethods(getDeserializationMethodFilter(paramDeserializationConfig), true);
      paramMixInResolver.resolveCreators(true);
      paramMixInResolver.resolveFields(true);
      return new BasicBeanDescription(paramDeserializationConfig, paramJavaType, paramMixInResolver);
      localAnnotationIntrospector = null;
    }
  }
  
  public BasicBeanDescription forDirectClassAnnotations(MapperConfig<?> paramMapperConfig, Class<?> paramClass, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    boolean bool = paramMapperConfig.isAnnotationProcessingEnabled();
    AnnotationIntrospector localAnnotationIntrospector = paramMapperConfig.getAnnotationIntrospector();
    if (bool) {}
    for (;;)
    {
      paramMixInResolver = AnnotatedClass.constructWithoutSuperTypes(paramClass, localAnnotationIntrospector, paramMixInResolver);
      return new BasicBeanDescription(paramMapperConfig, paramMapperConfig.constructType(paramClass), paramMixInResolver);
      localAnnotationIntrospector = null;
    }
  }
  
  public BasicBeanDescription forSerialization(SerializationConfig paramSerializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    paramMixInResolver = AnnotatedClass.construct(paramJavaType.getRawClass(), localAnnotationIntrospector, paramMixInResolver);
    paramMixInResolver.resolveMemberMethods(getSerializationMethodFilter(paramSerializationConfig), false);
    paramMixInResolver.resolveCreators(true);
    paramMixInResolver.resolveFields(false);
    return new BasicBeanDescription(paramSerializationConfig, paramJavaType, paramMixInResolver);
  }
  
  protected MethodFilter getDeserializationMethodFilter(DeserializationConfig paramDeserializationConfig)
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.USE_GETTERS_AS_SETTERS)) {}
    for (paramDeserializationConfig = DEFAULT_SETTER_AND_GETTER_FILTER;; paramDeserializationConfig = DEFAULT_SETTER_FILTER) {
      return paramDeserializationConfig;
    }
  }
  
  protected MethodFilter getSerializationMethodFilter(SerializationConfig paramSerializationConfig)
  {
    return DEFAULT_GETTER_FILTER;
  }
  
  public static class GetterMethodFilter
    implements MethodFilter
  {
    public boolean includeMethod(Method paramMethod)
    {
      return ClassUtil.hasGetterSignature(paramMethod);
    }
  }
  
  public static final class SetterAndGetterMethodFilter
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
  
  public static class SetterMethodFilter
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\BasicClassIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */