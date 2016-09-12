package org.codehaus.jackson.map;

import org.codehaus.jackson.type.JavaType;

public abstract class ClassIntrospector<T extends BeanDescription>
{
  public abstract T forClassAnnotations(MapperConfig<?> paramMapperConfig, Class<?> paramClass, MixInResolver paramMixInResolver);
  
  public abstract T forCreation(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, MixInResolver paramMixInResolver);
  
  public abstract T forDeserialization(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, MixInResolver paramMixInResolver);
  
  public abstract T forDirectClassAnnotations(MapperConfig<?> paramMapperConfig, Class<?> paramClass, MixInResolver paramMixInResolver);
  
  public abstract T forSerialization(SerializationConfig paramSerializationConfig, JavaType paramJavaType, MixInResolver paramMixInResolver);
  
  public static abstract interface MixInResolver
  {
    public abstract Class<?> findMixInClassFor(Class<?> paramClass);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ClassIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */