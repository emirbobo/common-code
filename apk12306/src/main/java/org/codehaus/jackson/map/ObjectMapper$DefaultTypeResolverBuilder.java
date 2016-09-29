package org.codehaus.jackson.map;

import java.util.Collection;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;

public class ObjectMapper$DefaultTypeResolverBuilder
  extends StdTypeResolverBuilder
{
  protected final ObjectMapper.DefaultTyping _appliesFor;
  
  public ObjectMapper$DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping paramDefaultTyping)
  {
    this._appliesFor = paramDefaultTyping;
  }
  
  public TypeDeserializer buildTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Collection<NamedType> paramCollection, BeanProperty paramBeanProperty)
  {
    if (useForType(paramJavaType)) {}
    for (paramDeserializationConfig = super.buildTypeDeserializer(paramDeserializationConfig, paramJavaType, paramCollection, paramBeanProperty);; paramDeserializationConfig = null) {
      return paramDeserializationConfig;
    }
  }
  
  public TypeSerializer buildTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, Collection<NamedType> paramCollection, BeanProperty paramBeanProperty)
  {
    if (useForType(paramJavaType)) {}
    for (paramSerializationConfig = super.buildTypeSerializer(paramSerializationConfig, paramJavaType, paramCollection, paramBeanProperty);; paramSerializationConfig = null) {
      return paramSerializationConfig;
    }
  }
  
  public boolean useForType(JavaType paramJavaType)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    JavaType localJavaType = paramJavaType;
    switch (ObjectMapper.2.$SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping[this._appliesFor.ordinal()])
    {
    default: 
      if (paramJavaType.getRawClass() == Object.class) {
        bool1 = bool2;
      }
      break;
    }
    for (;;)
    {
      return bool1;
      localJavaType = paramJavaType;
      if (paramJavaType.isArrayType()) {
        localJavaType = paramJavaType.getContentType();
      }
      if ((localJavaType.getRawClass() == Object.class) || (!localJavaType.isConcrete())) {
        bool1 = true;
      }
      continue;
      localJavaType = paramJavaType;
      if (paramJavaType.isArrayType()) {
        localJavaType = paramJavaType.getContentType();
      }
      bool1 = bool2;
      if (localJavaType.isFinal())
      {
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ObjectMapper$DefaultTypeResolverBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */