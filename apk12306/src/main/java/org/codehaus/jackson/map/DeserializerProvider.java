package org.codehaus.jackson.map;

import org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import org.codehaus.jackson.type.JavaType;

public abstract class DeserializerProvider
{
  public abstract int cachedDeserializersCount();
  
  @Deprecated
  public final KeyDeserializer findKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException
  {
    return findKeyDeserializer(paramDeserializationConfig, paramJavaType, null);
  }
  
  public abstract KeyDeserializer findKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  @Deprecated
  public final JsonDeserializer<Object> findTypedValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException
  {
    return findTypedValueDeserializer(paramDeserializationConfig, paramJavaType, null);
  }
  
  public abstract JsonDeserializer<Object> findTypedValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<Object> findValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  @Deprecated
  public final JsonDeserializer<Object> findValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType1, JavaType paramJavaType2, String paramString)
    throws JsonMappingException
  {
    return findValueDeserializer(paramDeserializationConfig, paramJavaType1, (BeanProperty)null);
  }
  
  public abstract void flushCachedDeserializers();
  
  public abstract boolean hasValueDeserializerFor(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType);
  
  public abstract DeserializerProvider withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver);
  
  public abstract DeserializerProvider withAdditionalDeserializers(Deserializers paramDeserializers);
  
  public abstract DeserializerProvider withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers);
  
  public abstract DeserializerProvider withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\DeserializerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */